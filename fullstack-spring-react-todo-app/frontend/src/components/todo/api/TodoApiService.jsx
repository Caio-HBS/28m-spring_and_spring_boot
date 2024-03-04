import { apiClient } from "./ApiClient";

export const retrieveAllTodosForUsernameApi = (username) =>
  apiClient.get(`/users/${username}/todos`);

export const deleteSingleTodoApi = (username, id) =>
  apiClient.delete(`/users/${username}/todos/${id}`);

export const retrieveSingleTodoApi = (username, id) =>
  apiClient.get(`/users/${username}/todos/${id}`);

export const updateTodoApi = (username, id, todoDetails) =>
  apiClient.put(`/users/${username}/todos/${id}`, todoDetails);

export const createTodoApi = (username, todo) =>
  apiClient.post(`/users/${username}/todos`, todo);
