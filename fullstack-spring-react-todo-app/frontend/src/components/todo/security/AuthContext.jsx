import { createContext, useContext, useState } from "react";
import { Outlet } from "react-router-dom";

import FooterComponent from "../FooterComponent.jsx";
import HeaderComponent from "../HeaderComponent.jsx";

export const AuthContext = createContext();

export const useAuth = () => useContext(AuthContext);

export default function AuthProvider() {
  const [isAuthenticated, setAuthenticated] = useState(false);

  return (
    <AuthContext.Provider value={{ isAuthenticated, setAuthenticated }}>
      <HeaderComponent />
      <Outlet />
      <FooterComponent />
    </AuthContext.Provider>
  );
}
