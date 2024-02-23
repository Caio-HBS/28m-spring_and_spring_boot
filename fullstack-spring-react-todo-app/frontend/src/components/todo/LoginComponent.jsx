import React, { useState } from "react";

export default function LoginComponent() {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");

  function handleUsernameChange(value) {
    setUsername(value);
  }

  function handlePasswordChange(value) {
    setPassword(value);
  }

  return (
    <div className="Login">
      <div className="LoginForm">
        <div>
          <input
            type="text"
            name="username"
            placeholder="Your username"
            value={username}
            onChange={(e) => handleUsernameChange(e.target.value)}
          />
        </div>
        <div>
          <input
            type="password"
            name="password"
            placeholder="Your password"
            value={password}
            onChange={(e) => handlePasswordChange(e.target.value)}
          />
        </div>
        <div>
          <button type="button" name="login">
            Login
          </button>
        </div>
      </div>
    </div>
  );
}
