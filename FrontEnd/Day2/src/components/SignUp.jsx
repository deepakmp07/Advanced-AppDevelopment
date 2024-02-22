import '../css/SignUp.css';
import { Link } from 'react-router-dom';

export default function RegisterPage() {
  return (
    <div className = "register">
    <div className='wrapper'>

      <form action="">
        <h1>Register</h1>
        <div className='input-box'>
          <input type="text" placeholder="Username" required />
        </div>
        <div className='input-box'>
          <input type="email" placeholder="Email" required />
        </div>
        <div className='input-box'>
          <input type="password" placeholder="Password" required />
        </div>
        <div className='input-box'>
          <input type="password" placeholder="Confirm Password" required />
        </div>
        <button type='submit' className='btn'>Register</button>
        <div className='register-link'>
          <p>Already have an account? <Link to='/'>Login</Link></p>
        </div>
      </form>
    </div>
    </div>
  );
}
