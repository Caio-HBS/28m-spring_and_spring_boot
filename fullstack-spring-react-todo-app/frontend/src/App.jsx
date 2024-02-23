import React from "react";

import "./App.css";

import Counter from "./components/counter/Counter.jsx";
import TodoApp from "./components/todo/TodoApp.jsx";

export default function App() {
  return (
    <div className="App">
      <TodoApp />
      {/* <Counter /> */}
    </div>
  );
}
