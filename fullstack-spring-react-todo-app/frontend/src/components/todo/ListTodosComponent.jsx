import React from "react";

export default function ListTodosComponent() {
  const today = new Date();
  const target = new Date(
    today.getFullYear() + 1,
    today.getMonth(),
    today.getDay()
  );

  const todos = [
    {
      id: 1,
      description: "Graduate",
      done: false,
      targetDate: target,
    },
    {
      id: 2,
      description: "Graduate me",
      done: false,
      targetDate: target,
    },
    {
      id: 3,
      description: "Graduate now",
      done: false,
      targetDate: target,
    },
  ];

  return (
    <div className="container">
      <h1>Your TODOs</h1>
      <div>
        <table className="table">
          <thead>
            <tr>
              <td>ID</td>
              <td>Description</td>
              <td>Status</td>
              <td>Target date</td>
            </tr>
          </thead>
          <tbody>
            {todos.map((todo) => (
              <tr key={todo.id}>
                <td>{todo.id}</td>
                <td>{todo.description}</td>
                {todo.done && <td>✅</td>}
                {!todo.done && <td>❌</td>}
                <td>{todo.targetDate.toDateString()}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}
