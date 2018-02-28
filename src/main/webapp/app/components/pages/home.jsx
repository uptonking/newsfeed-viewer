import React from 'react';
import Questions from '../items/questions';

//默认主页-旧的
var HomePage = React.createClass({
  render() {
    return (
      <div>
          <Questions fetched="false" />
      </div>
    );
  }
});

export default HomePage;
