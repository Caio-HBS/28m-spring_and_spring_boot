import React from "react";
import { createBrowserRouter, RouterProvider } from "react-router-dom";

import "./App.css";

import LoginComponent from "./components/todo/LoginComponent.jsx";
import WelcomeComponent from "./components/todo/WelcomeComponent.jsx";
import ErrorComponent from "./components/todo/ErrorComponent.jsx";

const router = createBrowserRouter([
  {
    path: "/login",
    element: <LoginComponent />,
  },
  {
    path: "/welcome/:username",
    element: <WelcomeComponent />,
  },
  {
    path: "*",
    element: <ErrorComponent />,
  },
]);

export default function App() {
  return (
    <div className="App">
      <RouterProvider router={router} />
    </div>
  );
}
