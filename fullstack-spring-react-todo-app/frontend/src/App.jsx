import React from "react";
import { createBrowserRouter, RouterProvider } from "react-router-dom";

import "./App.css";

import LoginComponent from "./components/todo/LoginComponent.jsx";
import WelcomeComponent from "./components/todo/WelcomeComponent.jsx";

const router = createBrowserRouter([
  {
    path: "/login",
    element: <LoginComponent />,
  },
  {
    path: "/welcome",
    element: <WelcomeComponent />,
  },
]);

export default function App() {
  return (
    <div className="App">
      <RouterProvider router={router} />
    </div>
  );
}
