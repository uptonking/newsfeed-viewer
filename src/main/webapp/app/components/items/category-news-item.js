import React from 'react';
import {Link} from 'react-router';
import {t} from 'localizify';

import declOfNum from '../../utils/number-dec';
import timeAgo from '../../utils/time-ago';

import APICONFIG from '../../utils/config/api-config';

import '../../assets/css/general.css';
import '../../assets/css/bulma-timeline.css';

class CategoryNewsItem extends React.Component {

  constructor() {
    super();
    this.state = {
      val: ""
    }
  }

  render() {

    const {articleTitle, articleUrl, gmtCreate} = this.props.data;

    // const sourceImgBaseUrl=`${APICONFIG.LOCAL_SERVER_STATIC}/sources`;

    return (
      <p className="event-item">
        <span className="icon-item-type">
          <i className="fa fa-star-o"></i>
        </span>
        {/* <a href="#">joe</a> starred */}
        <a href={articleUrl} className="has-text-grey-dark" target="_blank">{articleTitle.substring(0, 192)}</a>
        <small className="has-text-grey-light pad-left-8">{timeAgo(gmtCreate)}</small>
      </p>
    )

  }

}

export default CategoryNewsItem;
