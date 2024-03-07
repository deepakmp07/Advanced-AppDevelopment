import { useState } from "react";
import "../css/LoginPage.css";
import { Link } from "react-router-dom";
import axios from "axios";

export default function LoginPage() {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  const handleLogin = async () => {
    try {
      const response = await axios.post("http://localhost:8080/api/login", {
        email: email,
        password: password,
      });

      // Assuming your backend returns some token upon successful login
      const token = response.data.token;
      // Store the token in local storage or in application state
      window.localStorage.setItem("token", token);
      console.log(window.localStorage.getItem(token));
      // Redirect the user to another page or update the application state
    } catch (error) {
      console.error("Login failed:", error);
      // Handle login failure, show error message, etc.
    }
  };

  return (
    <div className="login">
      <div className="wrapper">
        <form action="">
          <h1>Login</h1>
          <i className="bx bx-user-pin"></i>
          <div className="input-box">
            <input
              type="text"
              placeholder="username"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
              required
            />
          </div>

          <div className="input-box">
            <input
              type="password"
              placeholder="password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
              required
            />
          </div>

          <div className="remember-forgot">
            <label>
              <input type="checkbox" />
              Remember me
            </label>
            <p>
              <a href="#">Forget password</a>
            </p>
          </div>

          <button type="button" onClick={handleLogin} className="btn">
            Login
          </button>
          <div className="register-link">
            <p>
              Dont have an account? <Link to="/register">Register</Link>
            </p>
          </div>
        </form>
      </div>
    </div>
  );
}
