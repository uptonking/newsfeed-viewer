import React from 'react';
import $ from 'jquery';
import localizify, {t} from 'localizify';

//语言切换器
const LanguageSwitcher = React.createClass({

  getClass(locale) {
    return localizify.getLocale() === locale ? 'active' : '';
  },

  onChangeLocale(event) {
    if (!$(event.target).hasClass('active')) {
      const locale = $(event.target).data('locale');
      localStorage.locale = locale;
      location.reload();
    }
  },

  render() {
    return (
      <div className="language-switcher">
          <span data-locale="zh" onClick={this.onChangeLocale} className={this.getClass('zh')}>ZH</span>
          <span data-locale="en" onClick={this.onChangeLocale} className={this.getClass('en')}>EN</span>

      </div>

    );
  }
});

export default LanguageSwitcher;
