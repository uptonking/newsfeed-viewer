import React from 'react';
import { Link } from 'react-router' ;
import { t } from 'localizify';

import LatestArticleService from '../../services/dao/latest-article';

import TrendTagItem from './trend-tag-item';

class TrendTagList extends React.Component {

  constructor() {
    super();
    this.state = {
      list: []
    }
  }

  componentDidMount() {
    const service = new LatestArticleService();
    service.getAllTagCount(1, 6).then((list) => {
      this.setState({
        list
      })
    })
  }

  render() {
    const data = this.state.list;

    return (
      <div className="box">
          <p >
              <span className="title is-5">{t('Tags')}</span> ·
              <a href="#" className="has-text-grey">{t('Hottest')}</a>
          </p>
          <hr />
          {data.map(
              (item, index) => <TrendTagItem data={item} key={index} />
          )
          }
      </div>
    )
  }

}

export default TrendTagList;
