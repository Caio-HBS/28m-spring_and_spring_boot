import React from "react";

import Counter from "./components/counter/Counter.jsx";

import "./App.css";

export default function App() {
  return (
    <>
      <Counter decrementValue={1} incrementValue={1} />
      <Counter decrementValue={10} incrementValue={10} />
      <Counter decrementValue={100} incrementValue={100} />
    </>
  );
}
