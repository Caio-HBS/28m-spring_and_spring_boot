import React, { useEffect, useState } from "react";
import {
  retrieveAllTodosForUsernameApi,
  deleteSingleTodoApi,
} from "./api/TodoApiService";

export default function ListTodosComponent() {
  const [todos, setTodos] = useState([]);
  const [message, setMessage] = useState(null);

  useEffect(() => refreshTodos(), []);

  function refreshTodos() {
    retrieveAllTodosForUsernameApi("in28minutes")
      .then((response) => {
        setTodos(response.data);
      })
      .catch((error) => console.log(error));
  }

  function handleDeleteTodo(id) {
    deleteSingleTodoApi("in28minutes", id)
      .then(() => {
        setMessage(`TODO with ID ${id} successfully deleted.`);
        refreshTodos();
      })
      .catch((error) => console.log(error));
  }

  return (
    <div className="container">
      <h1>Your TODOs</h1>
      {message && <div className="alert alert-warning">{message}</div>}
      <div>
        <table className="table">
          <thead>
            <tr>
              <th>Description</th>
              <th>Status</th>
              <th>Target date</th>
              <th>Delete TODO</th>
            </tr>
          </thead>
          <tbody>
            {todos.map((todo) => (
              <tr key={todo.id}>
                <td>{todo.description}</td>
                {todo.done && <td>✅</td>}
                {!todo.done && <td>❌</td>}
                <td>{todo.targetDate.toString()}</td>
                <td>
                  <button
                    className="btn btn-warning"
                    onClick={() => handleDeleteTodo(todo.id)}
                  >
                    Delete
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}
