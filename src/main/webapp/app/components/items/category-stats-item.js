import React from 'react';
import { Link } from 'react-router';
import { t } from 'localizify';

import declOfNum from '../../utils/number-dec';
import timeAgo from '../../utils/time-ago';

import APICONFIG from '../../utils/config/api-config' ;

import '../../assets/css/general.css';
import '../../assets/css/bulma-timeline.css';

class CategoryStatsItem extends React.Component {

  constructor() {
    super();
    this.state = {
      val: ""
    }
  }

  render() {

const {sourceName,sourceCount}=this.props.data;

// const sourceImgBaseUrl=`${APICONFIG.LOCAL_SERVER_STATIC}/sources`;

return(
    <a className="panel-block " href="#">
        <span className="panel-icon">
            <i className="fa fa-star-o"></i>
        </span>
        {sourceName}
        <span className="has-text-grey-light pad-left-16">{sourceCount}</span>
    </a>
)

  }

}

export default CategoryStatsItem;
