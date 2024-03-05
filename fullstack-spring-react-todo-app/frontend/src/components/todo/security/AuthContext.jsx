import { createContext, useContext, useState } from "react";
import { executeBasicAuthenticationService } from "../api/AuthenticationApiService";


import { apiClient } from "../api/ApiClient";

export const AuthContext = createContext();

export const useAuth = () => useContext(AuthContext);

export default function AuthProvider({ children }) {
  const [isAuthenticated, setAuthenticated] = useState(false);
  const [username, setUsername] = useState(null);
  const [token, setToken] = useState(null);

  async function login(user, password) {
    const basicToken = "Basic " + window.btoa(user + ":" + password);

    try {
      const response = await executeBasicAuthenticationService(basicToken);

      if (response.status == 200) {
        setAuthenticated(true);
        setUsername(user);
        setToken(basicToken);

        apiClient.interceptors.request.use((config) => {
          config.headers.Authorization = basicToken;
          return config;
        });

        return true;
      } else {
        logout();
        return false;
      }
    } catch (error) {
      logout();
      return false;
    }
  }
  function logout() {
    setAuthenticated(false);
    setUsername(null);
    setToken(null);
  }

  return (
    <AuthContext.Provider
      value={{ isAuthenticated, username, token, login, logout }}
    >
      {children}
    </AuthContext.Provider>
  );
}
