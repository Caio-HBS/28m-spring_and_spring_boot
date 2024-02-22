import React, { useState } from "react";
import { PropTypes } from "prop-types";

import "./Counter.css";

export default function Counter({ decrementValue, incrementValue }) {
  const [number, setNumber] = useState(0);

  function incrementCounter() {
    setNumber(number + incrementValue);
  }

  function decrementCounter() {
    setNumber(number - decrementValue);
  }

  return (
    <div className="Counter">
      <span className="count">{number}</span>
      <div>
        <button className="counterButton" onClick={decrementCounter}>
          -{decrementValue}
        </button>
        <button className="counterButton" onClick={incrementCounter}>
          +{incrementValue}
        </button>
      </div>
    </div>
  );
}

Counter.propTypes = {
  decrementValue: PropTypes.number,
  incrementValue: PropTypes.number,
};
