import { useState } from 'react';
// import { useNavigate } from 'react-router-dom';
import '../css/SignUp.css';
import { Link ,useNavigate} from 'react-router-dom';
import axios from 'axios';

export default function RegisterPage() {
  const navigate = useNavigate();
  const [name, setName] = useState('');
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [confirmPassword, setConfirmPassword] = useState('');
  const [role, setRole] = useState('');
  const [error, setError] = useState('');
  

  const handleNameChange = (e) => {
    setName(e.target.value);
  };

  const handleEmailChange = (e) => {
    setEmail(e.target.value);
  };

  const handlePasswordChange = (e) => {
    setPassword(e.target.value);
  };

  const handleConfirmPasswordChange = (e) => {
    setConfirmPassword(e.target.value);
  };

  const handleRoleChange = (e) => {
    setRole(e.target.value);
  };

  const handleRegister = async (event) => {
    event.preventDefault();
    try {
      if (!name || !email || !password || !confirmPassword || !role) {
        setError('Please fill in all fields.');
        return;
      }
      if (password !== confirmPassword) {
        setError('Passwords do not match.');
        return;
      }
      
      const response = await axios.post('http://localhost:8080/add', {
        name: name,
        email: email,
        password: password,
        role: role,
      });

      console.log('Registration successful:', response.data);
      navigate('/');

    } catch (error) {
      console.error('Registration failed:', error);
      setError('Registration failed. Please try again later.');
    }
  };

  return (
    <div className="register">
      <div className="wrapper">
        <form onSubmit={handleRegister}>
          <h1>Register</h1>
          <div className="input-box">
            <input type="text" name="name" placeholder="Username" value={name} onChange={handleNameChange} required />
          </div>
          <div className="input-box">
            <input type="email" name="email" placeholder="Email" value={email} onChange={handleEmailChange} required />
          </div>
          <div className="input-box">
            <input type="password" name="password" placeholder="Password" value={password} onChange={handlePasswordChange} required />
          </div>
          <div className="input-box">
            <input type="password" name="confirmPassword" placeholder="Confirm Password" value={confirmPassword} onChange={handleConfirmPasswordChange} required />
          </div>
          <div className="input-box">
            <select name="role" value={role} onChange={handleRoleChange}>
              <option value="">Select Role</option>
              <option value="admin">Admin</option>
              <option value="user">User</option>
            </select>
          </div>
          {error && <p className="error">{error}</p>}
          <button type="submit" className="btn">Register</button>
          <div className="register-link">
            <p>Already have an account? <Link to="/login">Login</Link></p>
          </div>
        </form>
      </div>
    </div>
  );
}
