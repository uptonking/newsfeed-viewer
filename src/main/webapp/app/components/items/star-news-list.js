import React from 'react';
import { Link } from 'react-router' ;
import { t } from 'localizify';

import LatestArticleService from '../../services/dao/latest-article';

import StarNewsItem from './star-news-item';

import APICONFIG from '../../utils/config/api-config' ;

class StarNewsList extends React.Component {

  constructor(props) {
    super(props);
    console.log('========CategoryNewsList取到的source1是：');
    console.log(this.props);

    this.state = {
      sourceName: props.sourceName,
      list: []
    }
  }

  componentWillReceiveProps(nextProps) {

    console.log('========next props', nextProps.sourceName);
    if (nextProps.sourceName != this.props.sourceName) {

        const service = new LatestArticleService();

        service.getAllArticleBySourceName(nextProps.sourceName, 1, APICONFIG.PAGE_SIZE_12).then(
          (list) => {
            this.setState({
                sourceName:nextProps.sourceName,
              list
            })
          }
      );

      console.log('========this props', this.state);
    }

  }

  shouldComponentUpdate (nextProps, nextState) {
      console.log('========判断should update：',this.state !== nextState || this.props !== nextProps);
    //   console.log(this.state);
    //   console.log(nextState);
    //   console.log(this.props);
    //   console.log(nextProps);
      return this.state !== nextState || this.props !== nextProps;
  }

  componentDidMount() {
    console.log('========CategoryNewsList取到的source2是：');
    console.log(this.props);
    const service = new LatestArticleService();

    service.getAllArticleBySourceName(this.state.sourceName, 1, APICONFIG.PAGE_SIZE_12).then(
      (list) => {
        this.setState({
          list
        })
      }
  );

  }



  render() {
    const data = this.state.list;
    const source = this.state.sourceName;
    console.log(this.sate);

    if (!data || !data.length) {
      return (<div>{t('news of CategoryNewsList hasn\'t exist yet')}</div>);
    }

    return (
      <div className=" event-timeline ">

          <div className="level">
              <p className="title is-6 level-left">{t(source)}</p>
              <div className="title is-6 level-right">
              <div className="dropdown is-hoverable">
                      <div className="dropdown-trigger">
                          <button className="button is-primary" aria-haspopup="true" aria-controls="dropdown-menu4">
                              <span>综合排序</span>
                              <span className="icon is-small">
                                  <i className="fa fa-angle-down" aria-hidden="true"></i>
                              </span>
                          </button>
                      </div>
                      <div className="dropdown-menu" id="dropdown-menu4" role="menu">
                          <div className="dropdown-content">
                              <div className="dropdown-item">
                                  <p>按最近时间</p>
                                  <p>按热度</p>
                              </div>
                          </div>
                      </div>
                  </div>
              </div>

          </div>

          <hr />

          { /* ========该类别的新闻列表 */ }
          {data.map(
              (item, index) => <CategoryNewsItem data={item} key={index} />
          )
          }

      </div>

    )
  }

}

export default StarNewsList;
