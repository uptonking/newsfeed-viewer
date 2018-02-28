import React from 'react';
import { Link } from 'react-router';
import { t } from 'localizify';

import declOfNum from '../../utils/number-dec';
import timeAgo from '../../utils/time-ago';

import '../../assets/css/general.css';
import '../../assets/css/bulma-timeline.css';

class TrendNewsItem extends React.Component {

  constructor() {
    super();
    this.state = {
      val: ""
    }
  }

  render() {

    const {id, articleTitle, articleUrl, articleSummary, articleAuthor, articleAuthorUrl, sourceName, gmtCreate, tag} = this.props.data;

    const summary=(articleSummary==null || articleSummary==undefined)?'':articleSummary.substring(0, 128);

    return (
      <article className="media">

          <div className="media-content">
              <div className="content">
                  <p>
                      { /* <strong >{articleTitle}</strong> */ }
                      <strong><a href={articleUrl} className="has-text-black-ter " target="_blank">{articleTitle}</a></strong>
                      <small className="has-text-grey font-size50 pad-left-8" >{articleAuthor}</small>
                      <small style={{
                          float: 'right'
                      }} className="has-text-grey-light">{timeAgo(gmtCreate)}</small>
                      <br />
                      <span className="has-text-grey">
                          {summary}<a href={articleUrl} className="pad-left-8 "> ... </a>
                      </span>
                  </p>
              </div>
              <nav className="level">
                  <div className="level-left">
                      <a className="level-item">
                          <span className="icon is-small"><i className="fa fa-thumbs-o-up"></i></span>
                      </a>
                      <a className="level-item">
                          <span className="icon is-small"><i className="fa fa-star-o"></i></span>
                      </a>

                        <a className="level-item">
                            <span className="icon is-small"><i className="fa fa-share-square-o "></i></span>
                        </a>

                    </div>
                    <div className="level-right">
                        <span className="level-item"><a>{tag}</a></span>
                        { /* <span className="level-item"><a>{sourceName}</a></span> */ }
                        <span className="level-item"><a href={articleUrl} className="button is-small" target="_blank">{sourceName}</a></span>
                    </div>
                </nav>
            </div>
        </article>
    )
  }


}

export default TrendNewsItem;
