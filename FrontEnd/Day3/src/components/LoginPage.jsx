// LoginPage.jsx
// import React from 'react';
import '../css/LoginPage.css';
// import loginImg from '../assets/image/loginImg.jpeg';
// import 'https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css';
import { Link } from 'react-router-dom';

export default function LoginPage() {
    return (
      <div className='login'>
        <div className='wrapper'>
          <form action="">
             <h1>Login</h1>
             <i className='bx bx-user-pin'></i>
             <div className='input-box'>
             <input type="text" placeholder="username" required/>
             </div>

             <div className='input-box'>
             <input type="password" placeholder="password" required/></div>

             <div className='remember-forgot'>
              <label><input type='checkbox'/>Remember me</label>
              <p><a href = "#">Forget password</a></p>
             </div>

             <Link to='/home'><button type='submit' className='btn'>Login</button></Link>
             <div className='register-link'><p>Dont have an account? <Link to='/register'>Register</Link></p>
             </div>
          </form>
          </div>
        </div>
    );
}
