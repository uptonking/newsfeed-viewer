import React from 'react';
import { Route, IndexRoute } from 'react-router';
import App from '../components/app.jsx';
import auth from '../auth';

import {
  HomePage,
  LoginPage,
  LogoutPage,
  AddQuestionPage,
  ContactPage,
  DashboardPage,
  QuestionPage,
  QuestionsByTagPage,
  SignupPage,
  UserPage,
  ChangePasswordPage,
  TagsPage,
  NewsByCategory,
  IndexHome,
  UserStar,
} from '../components/index.jsx';

// import IndexHome from '../components/pages/index-home';


function requireAuth(nextState, replace) {
  if (!auth.loggedIn()) {
    replace({
      pathname: '/login',
      state: { nextPathname: nextState.location.pathname }
    })
  }
}

export default (
  <Route path="/" component={App}>
      <IndexRoute component={IndexHome}/>
      {/* <IndexRoute component={HomePage}/> */}

      <Route path="/login" component={LoginPage} />
      <Route path="/logout" component={LogoutPage} onEnter={requireAuth} />
      <Route path="/signup" component={SignupPage} />

      <Route path="/questions/:id" component={QuestionPage} />
      <Route path="/questions/tagged/:name" component={QuestionsByTagPage} />
      <Route path="/add" component={AddQuestionPage} onEnter={requireAuth} />

      <Route path="/users/:name" component={UserPage} />

      <Route path="/tags" component={TagsPage} />
      <Route path="/tags/all" component={TagsPage} />
      <Route path="/cat/all" component={NewsByCategory} />
      <Route path="/cat/sources/all" component={NewsByCategory} />
      <Route path="/cat/tags/all" component={NewsByCategory} />
      <Route path="/cat/source/:sourceName" component={NewsByCategory} />
      <Route path="/cat/tag/:tagName" component={NewsByCategory} />

      <Route path="/star/:userName" component={UserStar} />

      <Route path="/dashboard" component={DashboardPage} onEnter={requireAuth} />

    <Route path="/changepassword" component={ChangePasswordPage} onEnter={requireAuth} />
  </Route>
);
