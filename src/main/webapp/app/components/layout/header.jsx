import React from 'react';
import { Link } from 'react-router';
import { t } from 'localizify';

import 'font-awesome/css/font-awesome.css'
import 'bulma/css/bulma.css';
import '../../assets/css/bulma-timeline.css';


//顶部导航栏
var Header = React.createClass({
  render() {
    return (

          <nav className="nav ">
              <div className="container">
                  <div className="nav-left">
                      <Link to="/" className="nav-item is-tab"><i className="fa fa-home"></i> &nbsp; {t('News Feeds')}</Link>
                      {/* <Link to="/add" className="nav-item is-tab"><i className="fa fa-bolt"></i> &nbsp; {t('Add')}</Link> */}
                      <Link to="/cat/sources/all" className="nav-item is-tab"><i className="fa fa-th"></i> &nbsp; {t('Sources')}</Link>
                      <Link to="/cat/tags/all" className="nav-item is-tab"><i className="fa fa-bookmark"></i> &nbsp; {t('Tags')}</Link>
                      {/* <Link to="/dashboard" className="nav-item is-tab"><i className="fa fa-user"></i> &nbsp; {t('Profile')}</Link> */}
                      <Link to={`/star/:${localStorage.name}`} className="nav-item is-tab"><i className="fa fa-star"></i> &nbsp; {t('Stars')}</Link>

                  </div>

                  <span className="nav-toggle">
                      <span>主页</span>
                      <span></span>
                      <span></span>
                  </span>

                  <div className="nav-right nav-menu">
                      <span className="nav-item">
                          <div title={"You are " + (this.props.loggedIn ? '' : 'not') + " logged in."} className="li right">
                              {this.props.loggedIn ? (
                                  <span> {t('Hi')}, <b> {localStorage.name} </b> <Link to="/logout">{t('Logout')} </Link></span>
                              ) : (
                                  <span>
                                      <Link to="/login" activeClassName="active">{t('Login')}</Link>
                                      <Link to="/signup" activeClassName="active">{t('Sign up')}</Link>
                                  </span>
                              )}
                          </div>
                      </span>

                  </div>
              </div>
          </nav>

    );
  }
});

export default Header;
