import React from "react";
import "/Users/deepak/Desktop/AdvancedAppDevelopment/aquavoyage/src/css/Navbar.css"; // Make sure to adjust the path to your CSS file

const Navbar = () => {
  return (
    <nav className="navbar">
      <div className="logo">
        <h1></h1>
        <h1 style={{ color: "white" }}>AquaVoyage</h1>
      </div>
      <div className="menu-icon">
        <i className="fas fa-bars"></i>
      </div>
    </nav>
  );
};

export default Navbar;
