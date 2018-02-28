import React  from 'react';
import {Link} from 'react-router' ;
import {t} from 'localizify';

import LatestArticleService from '../../services/dao/latest-article';

import CategoryStatsItem from './category-stats-item';

import APICONFIG from '../../utils/config/api-config' ;

class CategoryStatsList extends React.Component{


        constructor(){
            super();
            this.state={
                list:[]
            }
        }

    componentDidMount(){
        const service = new LatestArticleService();
        service.getAllSourceCount(1,APICONFIG.PAGE_SIZE_12).then((list) => {
            this.setState({
                list
            })
        })
    }

    render(){
        const data = this.state.list;

        return(
            <nav className="panel">
                <p className="panel-heading">
                    {t('收录数量')}
                </p>

                {data.map(
                    (item, index) =>
                        <CategoryStatsItem data={item} key={index} />
                )
                }

            </nav>
        )
    }

}

export default CategoryStatsList;
