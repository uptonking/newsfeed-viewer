import React from 'react';
import { Link } from 'react-router';
import { t } from 'localizify';

import declOfNum from '../../utils/number-dec';
import timeAgo from '../../utils/time-ago';

import APICONFIG from '../../utils/config/api-config' ;

import '../../assets/css/general.css';
import '../../assets/css/bulma-timeline.css';

class TrendTagItem extends React.Component {

  constructor() {
    super();
    this.state = {
      val: ""
    }
  }

  render() {

const {tagName,tagCount}=this.props.data;

// const sourceImgBaseUrl=`${APICONFIG.LOCAL_SERVER_STATIC}/sources`;

return(
    <p className="trend-hashtag">
        <a href="#" className="has-text-grey">#{tagName}</a>
        <span className="has-text-grey-light pad-left-16">{tagCount}</span>
    </p>
)

  }

}

export default TrendTagItem;
