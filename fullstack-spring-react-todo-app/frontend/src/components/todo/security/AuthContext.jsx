import { createContext, useContext, useState } from "react";
import { Outlet } from "react-router-dom";

export const AuthContext = createContext();

export default function AuthProvider() {
  return (
    <AuthContext.Provider value={{ number }}>
      <Outlet />
    </AuthContext.Provider>
  );
}
