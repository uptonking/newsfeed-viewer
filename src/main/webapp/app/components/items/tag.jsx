import React from 'react';
import $ from 'jquery';
import { Link } from 'react-router';
import { t } from 'localizify';

//单个标签
const Tag = React.createClass({
  render() {
    const { name } = this.props.data;

    return (
      <Link to={`/questions/tagged/${name}`}
        className="post-tag"
        title={t('Show question with tag «{name}»', { name })}
        rel="tag">
        {name}
      </Link>
    );
  }
});

export default Tag;
