import { createContext, useContext, useState } from "react";
import { Outlet } from "react-router-dom";

import FooterComponent from "../FooterComponent.jsx";
import HeaderComponent from "../HeaderComponent.jsx";

export const AuthContext = createContext();

export const useAuth = () => useContext(AuthContext);

export default function AuthProvider() {
  const [isAuthenticated, setAuthenticated] = useState(false);

  function login() {
    setAuthenticated(true);
  }
  function logout() {
    setAuthenticated(false);
  }

  return (
    <AuthContext.Provider value={{ isAuthenticated, login, logout }}>
      <HeaderComponent />
      <Outlet />
      <FooterComponent />
    </AuthContext.Provider>
  );
}
