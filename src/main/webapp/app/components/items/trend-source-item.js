import React from 'react';
import { Link } from 'react-router';
import { t } from 'localizify';

import declOfNum from '../../utils/number-dec';
import timeAgo from '../../utils/time-ago';

import APICONFIG from '../../utils/config/api-config' ;

import '../../assets/css/general.css';
import '../../assets/css/bulma-timeline.css';

class TrendSourceItem extends React.Component {

  constructor() {
    super();
    this.state = {
      sourceName: ""
    }
  }


  render() {

const {sourceName,sourceCount}=this.props.data;

const sourceImgBaseUrl=`${APICONFIG.LOCAL_SERVER_STATIC}/sources`;

return(
    <div className="columns">

        <div className="column is-9 text-align-left ">
            <p>
                <Link to={`/cat/source/:${sourceName}`}>
                    <strong className="has-text-grey">{sourceName}</strong>
                </Link>
            </p>
        </div>
        <div className="column is-3 text-align-right ">
            <p>
                <a href="#" className="has-text-grey-light">
                    {sourceCount}
                </a>
            </p>
        </div>

    </div>
)

  }

}

export default TrendSourceItem;
