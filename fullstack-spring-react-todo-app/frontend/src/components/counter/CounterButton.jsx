import React from "react";
import { PropTypes } from "prop-types";

import "./Counter.css";

export default function CounterButton({
  decrementValue,
  incrementValue,
  onDecrement,
  onIncrement,
}) {
  return (
    <div className="Counter">
      <div>
        <button
          className="counterButton"
          onClick={() => {
            onDecrement(decrementValue);
          }}
        >
          -{decrementValue}
        </button>
        <button
          className="counterButton"
          onClick={() => {
            onIncrement(incrementValue);
          }}
        >
          +{incrementValue}
        </button>
      </div>
    </div>
  );
}

CounterButton.propTypes = {
  decrementValue: PropTypes.number,
  incrementValue: PropTypes.number,
};
