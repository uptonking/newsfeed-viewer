import React  from 'react';
import {Link} from 'react-router' ;
import {t} from 'localizify';

import StarNewsList from '../items/star-news-list';
// import CategoryStatsList from '../items/category-stats-list';

import 'bulma/css/bulma.css';
import '../../assets/css/bulma-projects.css';
import '../../assets/css/general.css';

class UserStar extends React.Component{

constructor() {
  super();
  this.state = {
      userName: "",
    sourceName: ""
  }
}

componentDidMount() {

  const uname = this.props.params.userName.substring(1);
  console.log('========source页接收到的参数是',uname);
  this.setState({
      userName:uname
  })


}

render(){

    return(
        <div className="section">
            <div className="container">

                <p className="title is-2">{this.state.userName}</p>

                {/* ======总宽度为10 */}
                <div className="column is-10 is-offset-1">
                    <div className="columns">

                        {/* ========列表占9/12 */}
                        <div className="column is-9">
                            <StarNewsList sourceName={this.state.sourceName} />

                        </div>

                        {/* ========统计信息占3/12，数量、收藏量 */}
                        <div className="column is-3">
                            {/* <CategoryStatsList /> */}

                        </div>

                    </div>

                </div>
            </div>
        </div>
    )
}

}

export default UserStar;
