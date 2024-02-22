import '../css/Header.css';
import { Link } from 'react-router-dom';

function Header() {
    return (
        <div className="app-header">
            <div className="logo">
                <h1>AQUAVOYAGE</h1>
            </div>
            <nav className="nav-links">
                <ul>
                    <Link to='/'><li><a href="#">Login/Register</a></li></Link>
                    <li><a href="#">Profile</a></li>
                </ul>
            </nav>
        </div>
    );
}

export default Header;