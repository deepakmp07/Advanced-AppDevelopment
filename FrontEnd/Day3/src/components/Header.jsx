import '../css/Header.css';
import { Link } from 'react-router-dom';

function Header() {
    return (
        <div className="app-header">
            <div className="logo">
                <h1>AQUAVOYAGE</h1>
            </div>
            <nav className="nav-links">
                <div style={{display:'flex',justifyContent:'space-between'}}>
                  <ul>
                    <Link to='/'><li>Login/Register</li></Link>
                    <li>Profile</li>
                </ul>
                </div>
            </nav>
        </div>
    );
}

export default Header;