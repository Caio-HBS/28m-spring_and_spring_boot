import React from "react";

import { useAuth } from "./security/AuthContext.jsx";

export default function HeaderComponent() {
  const authContext = useAuth();

  return (
    <header className="border-bottom border-light border-5 mb-5 p-2">
      <div className="container">
        <div className="row">
          <nav className="navbar navbar-expand-lg">
            <a
              className="navbar-brand ms-2 fs-2 fw-bold text-black"
              href="https://github.com/Caio-HBS"
            >
              Caio-HBS
            </a>
            <div className="collapse navbar-collapse">
              <ul className="navbar-nav">
                <li className="nav-item fs-5">
                  <a className="nav-link" href="/welcome/Caio-HBS">
                    Home
                  </a>
                </li>
                <li className="nav-item fs-5">
                  <a className="nav-link" href="/todos">
                    Todos
                  </a>
                </li>
              </ul>
            </div>
            <ul className="navbar-nav">
              {!authContext.isAuthenticated && (
                <li className="nav-item fs-5">
                  <a className="nav-link" href="/">
                    Login
                  </a>
                </li>
              )}
              {authContext.isAuthenticated && (
                <li className="nav-item fs-5">
                  <a className="nav-link" href="/logout">
                    Logout
                  </a>
                </li>
              )}
            </ul>
          </nav>
        </div>
      </div>
    </header>
  );
}
