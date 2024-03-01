import { apiClient } from "./ApiClient";

export const retrieveAllTodosForUsernameApi = (username) =>
  apiClient.get(`/users/${username}/todos`);

export const deleteSingleTodoApi = (username, id) =>
  apiClient.delete(`/users/${username}/todos/${id}`);

export const retrieveSingleTodoApi = (username, id) =>
  apiClient.get(`/users/${username}/todos/${id}`);
