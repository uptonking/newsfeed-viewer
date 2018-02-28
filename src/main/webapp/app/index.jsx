import React from 'react';
import ReactDOM from 'react-dom';
import $ from 'jquery';
import { Router, useRouterHistory  } from 'react-router';
//导入browserHistory就重复了
// import {  browserHistory } from 'react-router';
import { createHistory } from 'history';

import localizify from 'localizify';
import en from './messages/en-US.json';
import zh from './messages/zh-Hans-CN.json';

import routes from 'routers/routers.jsx';

localizify
  .add('en', en)
  .add('zh', zh)
  .setLocale(localStorage.locale || 'zh');

// console.log('========加载的语言是  ',localizify.getLocale());

//给路由添加公共前缀，此处为空
const browserHistory = useRouterHistory(createHistory)({
  basename: window.config.basename
});

//div渲染
ReactDOM.render(
  <Router routes={routes} history={browserHistory}></Router>,
  document.getElementById('app')
);
