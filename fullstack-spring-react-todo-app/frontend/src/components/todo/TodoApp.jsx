import React from "react";

import "./TodoApp.css";

import LoginComponent from "./LoginComponent.jsx";
import WelcomeComponent from "./WelcomeComponent.jsx";


export default function () {
  return (
  <div className="TodoApp">
    <LoginComponent />
    <WelcomeComponent />
  </div>);
}
