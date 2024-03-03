// import React from 'react'
// import React, { useState } from 'react';
import PropTypes from 'prop-types';

import 
 {BsFillBellFill, BsFillEnvelopeFill, BsPersonCircle, BsSearch, BsJustify}
 from 'react-icons/bs'

 export default function AdminHeader({ OpenSidebar }) {
    return (
      <header className='header'>
          <div className='menu-icon'>
              <BsJustify className='icon' onClick={OpenSidebar}/>
          </div>
          <div className='header-left'>
              <BsSearch  className='icon'/>
          </div>
          <div className='header-right'>
              <BsFillBellFill className='icon'/>
              <BsFillEnvelopeFill className='icon'/>
              <BsPersonCircle className='icon'/>
          </div>
      </header>
    )
  }
  
  AdminHeader.propTypes = {
    OpenSidebar: PropTypes.func.isRequired
  };
