import React from 'react';
import { t } from 'localizify';

import TrendSourceList from '../items/trend-source-list';
import TrendNewsList from '../items/trend-news-list';
import TrendTagList from '../items/trend-tag-list';

import 'font-awesome/css/font-awesome.css';
import '../../assets/css/general.css';
import 'bulma/css/bulma.css';
import '../../assets/css/bulma-timeline.css';

class IndexHome extends React.Component {

  constructor() {
    super();
    this.state = {
      val: ""
    }
  }

  render() {

    return (
      <section className="section main section-list">
          <div className="container">
              <div className="columns">

                  { /* ========news sources 热门来源 */ }
                  <div className="column is-3">
                      <TrendSourceList />
                  </div>

                  { /* ========news list 最新列表 */ }
                  <div className="column is-6">
                      <TrendNewsList />
                  </div>

                  { /* ========hot tags 热门标签 */ }
                  <div className="column is-3">
                      <TrendTagList />
                  </div>

              </div>
          </div>
      </section>
      )
  }

}

export default IndexHome;
