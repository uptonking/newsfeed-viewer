import React  from 'react';
import {Link} from 'react-router' ;
import {t} from 'localizify';

import CategoryNewsList from '../items/category-news-list';
import CategoryStatsList from '../items/category-stats-list';

import 'bulma/css/bulma.css';
import '../../assets/css/bulma-projects.css';
import '../../assets/css/general.css';

class NewsByCategory extends React.Component{

constructor() {
  super();
  this.state = {
    sourceName: ""
  }
}

componentDidMount() {

  const sourceName1 = this.props.params.sourceName.substring(1);
  console.log('========source页接收到的参数是',sourceName1);
  this.setState({
      sourceName:sourceName1
  })


}

render(){

    return(
        <div className="section">
            <div className="container">
                {/* ======总宽度为10 */}
                <div className="column is-10 is-offset-1">
                    <div className="columns">

                        {/* ========列表占9/12 */}
                        <div className="column is-9">
                            <CategoryNewsList sourceName={this.state.sourceName} />

                        </div>

                        {/* ========统计信息占3/12，数量、收藏量 */}
                        <div className="column is-3">
                            <CategoryStatsList />

                        </div>

                    </div>

                </div>
            </div>
        </div>
    )
}

}

export default NewsByCategory;
