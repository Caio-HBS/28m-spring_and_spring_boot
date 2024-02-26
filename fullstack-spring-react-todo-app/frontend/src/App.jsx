import React from "react";
import { createBrowserRouter, RouterProvider } from "react-router-dom";

import "bootstrap/dist/css/bootstrap.min.css";
import "./App.css";

import LoginComponent from "./components/todo/LoginComponent.jsx";
import ErrorComponent from "./components/todo/ErrorComponent.jsx";
import FooterComponent from "./components/todo/FooterComponent.jsx";
import HeaderComponent from "./components/todo/HeaderComponent.jsx";
import LogoutComponent from "./components/todo/LogoutComponent.jsx";
import WelcomeComponent from "./components/todo/WelcomeComponent.jsx";
import ListTodosComponent from "./components/todo/ListTodosComponent.jsx";

const router = createBrowserRouter([
  {
    path: "/login",
    element: <LoginComponent />,
  },
  {
    path: "/logout",
    element: <LogoutComponent />,
  },
  {
    path: "/welcome/:username",
    element: <WelcomeComponent />,
  },
  {
    path: "/todos",
    element: <ListTodosComponent />,
  },
  {
    path: "*",
    element: <ErrorComponent />,
  },
]);

export default function App() {
  return (
    <div className="App">
      <HeaderComponent />
      <RouterProvider router={router} />
      <FooterComponent />
    </div>
  );
}
