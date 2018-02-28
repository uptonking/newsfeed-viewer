import React from 'react';
import { t } from 'localizify';
import LanguageSwitcher from '../utils/language-switcher';

import 'font-awesome/css/font-awesome.css';
import 'bulma/css/bulma.css';
import '../../assets/css/general.css';

//页脚
var Footer = React.createClass({
  render() {
    return (
      <footer className="footer footer-body" id="footer">

          <div className="columns">
              <div className="column"></div>
              <div className="column is-half">
                  <div className="copyright  text-align-center">
                      Built with <i className="fa fa-heart" style={{color:"#ff9999"}}></i> using <a className="copyright" href="https://docs.spring.io/spring/docs/current/spring-framework-reference/html/mvc.html" target="_blank">Spring MVC</a> &amp; <a className="copyright" href="https://facebook.github.io/react/" target="_blank">ReactJS</a>  By yaooxx |   <span className="js-now-year">2017</span>
                  </div>
              </div>
              <div className="column text-align-right">
                  <LanguageSwitcher />
              </div>
          </div>

      </footer>
    );
  }
});

export default Footer;
