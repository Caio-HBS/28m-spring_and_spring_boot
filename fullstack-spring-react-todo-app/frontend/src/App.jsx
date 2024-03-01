import React from "react";
import { BrowserRouter, Routes, Route, Navigate } from "react-router-dom";

import { useAuth } from "./components/todo/security/AuthContext.jsx";

import "bootstrap/dist/css/bootstrap.min.css";
import "./App.css";

import AuthProvider from "./components/todo/security/AuthContext.jsx";
import TodoComponent from "./components/todo/TodoComponent.jsx";
import LoginComponent from "./components/todo/LoginComponent.jsx";
import ErrorComponent from "./components/todo/ErrorComponent.jsx";
import HeaderComponent from "./components/todo/HeaderComponent.jsx";
import LogoutComponent from "./components/todo/LogoutComponent.jsx";
import WelcomeComponent from "./components/todo/WelcomeComponent.jsx";
import ListTodosComponent from "./components/todo/ListTodosComponent.jsx";

function AuthenticatedRoute({ children }) {
  const authContext = useAuth();

  if (authContext.isAuthenticated) {
    return children;
  }

  return <Navigate to="/login" />;
}

export default function App() {
  return (
    <div className="App">
      <AuthProvider>
        <BrowserRouter>
          <HeaderComponent />
          <Routes>
            <Route path="/" element={<LoginComponent />} />
            <Route path="/login" element={<LoginComponent />} />
            <Route
              path="/welcome/:username"
              element={
                <AuthenticatedRoute>
                  <WelcomeComponent />
                </AuthenticatedRoute>
              }
            />
            <Route
              path="/todos"
              element={
                <AuthenticatedRoute>
                  <ListTodosComponent />
                </AuthenticatedRoute>
              }
            />
            <Route
              path="/todo/:id"
              element={
                <AuthenticatedRoute>
                  <TodoComponent />
                </AuthenticatedRoute>
              }
            />
            <Route
              path="/logout"
              element={
                <AuthenticatedRoute>
                  <LogoutComponent />
                </AuthenticatedRoute>
              }
            />
            <Route path="*" element={<ErrorComponent />} />
          </Routes>
        </BrowserRouter>
      </AuthProvider>
    </div>
  );
}
