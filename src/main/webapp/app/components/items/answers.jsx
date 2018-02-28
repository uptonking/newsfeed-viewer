import React from 'react';
import $ from 'jquery';

import Answer from './answer';
import Loader from '../utils/loader';

//回答列表
const Answers = React.createClass({
  // getInitialState() {
  //   return {
  //     questions: [],
  //     loading: true
  //   };
  // },
  componentDidMount() {},

  render() {
    // if (this.state.loading) {
    //   return ( <Loader isActive="true" /> );
    // }

    const data = this.props.data;

    return (
      <div className="answer-list">
        {data.map((item, index) =>
          <div key={index}>
            <Answer data={item} />
          </div>
        )}
      </div>
    );
  }
});

export default Answers;
