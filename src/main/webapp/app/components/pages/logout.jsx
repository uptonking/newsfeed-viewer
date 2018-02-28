import React from 'react';
import auth from '../../auth';
import { t } from 'localizify';

//退出登录成功页
const LogoutPage = React.createClass({
  componentDidMount() {
    auth.logout()
  },

  render() {
    return (
      <p>{t('You logout succesfully')}</p>
    );
  }
});

export default LogoutPage;
