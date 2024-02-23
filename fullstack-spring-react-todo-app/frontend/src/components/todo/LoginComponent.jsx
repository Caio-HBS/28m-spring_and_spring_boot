import React, { useState } from "react";

export default function LoginComponent() {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [submitError, setSubmitError] = useState(false);
  const [submitSuccess, setSubmitSuccess] = useState(false);

  function handleUsernameChange(value) {
    setUsername(value);
  }

  function handlePasswordChange(value) {
    setPassword(value);
  }

  function handleSubmit() {
    if (username === "Caio-HBS" && password === "123") {
      setSubmitSuccess(true);
    } else {
      setSubmitError(true);
    }
  }

  return (
    <div className="Login">
      {submitSuccess && (
        <div className="successMessage">Authenticated successfully!</div>
      )}
      {submitError && (
        <div className="errorMessage">Error while trying to authenticate.</div>
      )}
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
          <button type="button" name="login" onClick={handleSubmit}>
            Login
          </button>
        </div>
      </div>
    </div>
  );
}
