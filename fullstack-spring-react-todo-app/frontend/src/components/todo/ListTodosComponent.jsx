import React, { useEffect, useState } from "react";

import {
  retrieveAllTodosForUsernameApi,
  deleteSingleTodoApi,
} from "./api/TodoApiService";
import { useAuth } from "./security/AuthContext.jsx";
import { useNavigate } from "react-router-dom";

export default function ListTodosComponent() {
  const [todos, setTodos] = useState([]);
  const [message, setMessage] = useState(null);

  const navigate = useNavigate();

  const authContext = useAuth();

  useEffect(() => refreshTodos(), []);

  function refreshTodos() {
    retrieveAllTodosForUsernameApi(authContext.username)
      .then((response) => {
        setTodos(response.data);
      })
      .catch((error) => console.log(error));
  }

  function handleDeleteTodo(id) {
    deleteSingleTodoApi(authContext.username, id)
      .then(() => {
        setMessage(`TODO with ID ${id} successfully deleted.`);
        refreshTodos();
      })
      .catch((error) => console.log(error));
  }

  function handleUpdateTodo(id) {
    navigate(`/todo/${id}`);
  }

  function handleAddNewTodo() {
    navigate("/todo/-1");
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
              <th>Update TODO</th>
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
                    className="btn btn-danger"
                    onClick={() => handleDeleteTodo(todo.id)}
                  >
                    Delete
                  </button>
                </td>
                <td>
                  <button
                    className="btn btn-warning"
                    onClick={() => handleUpdateTodo(todo.id)}
                  >
                    Update
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
      <div className="btn btn-success m-5" onClick={handleAddNewTodo}>
        New TODO
      </div>
    </div>
  );
}
