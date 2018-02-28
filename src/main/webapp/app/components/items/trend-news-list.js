import React from 'react';
import $ from 'jquery';
import { t } from 'localizify';

import Loader from '../utils/loader';

import TrendNewsItem from './trend-news-item';

import LatestArticleService from '../../services/dao/latest-article';

class TrendNewsList extends React.Component {

  constructor() {
    super();
    this.state = {
      list: [],
      loading: true
    }
  }

  componentDidMount() {
    //   const tag = this.props.tag || false;
    const service = new LatestArticleService();

    service.getLatest().then(list => {
      // console.log("========获取文章列表");
      // console.log(list);
      this.setState({
        list,
        loading: false
      });
    });

  }

  render() {

    if (this.state.loading) {
      return ( <Loader isActive="true" /> );
    }

    const data = this.state.list;
    //   const tag = this.props.tag;

    if (!data || !data.length) {
      return (<div>{t('News hasn\'t exist yet')}</div>);
    }

    return (

      <div className="box">
          {data.map(
              (item, index) =>
                  <TrendNewsItem data={item} key={index} />
          )
          }
      </div>
      );
  }

}

export default TrendNewsList;
