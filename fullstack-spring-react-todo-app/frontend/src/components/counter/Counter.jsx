import React, { useState } from "react";

import CounterButton from "./CounterButton.jsx";

export default function Counter() {
  const [number, setNumber] = useState(0);

  function IncrementCounterParent(inValue) {
    setNumber(number + inValue);
  }

  function DecrementCounterParent(deValue) {
    setNumber(number - deValue);
  }

  function resetCounter() {
    setNumber(0);
  }

  return (
    <>
      <span className="totalCount">{number}</span>
      <CounterButton
        decrementValue={1}
        incrementValue={1}
        onIncrement={IncrementCounterParent}
        onDecrement={DecrementCounterParent}
      />
      <CounterButton
        decrementValue={10}
        incrementValue={10}
        onIncrement={IncrementCounterParent}
        onDecrement={DecrementCounterParent}
      />
      <CounterButton
        decrementValue={100}
        incrementValue={100}
        onIncrement={IncrementCounterParent}
        onDecrement={DecrementCounterParent}
      />
      <button className="resetButton" onClick={resetCounter}>
        Reset count
      </button>
    </>
  );
}
