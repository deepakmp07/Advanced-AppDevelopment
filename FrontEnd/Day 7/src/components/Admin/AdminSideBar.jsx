import PropTypes from 'prop-types';
import { Link } from 'react-router-dom';
import 
{BsCart3, BsGrid1X2Fill, BsFillArchiveFill, BsPeopleFill,  BsMenuButtonWideFill, BsFillGearFill}
 from 'react-icons/bs'

function AdminSidebar({openSidebarToggle, OpenSidebar}) {
  return (
    <aside id="sidebar" className={openSidebarToggle ? "sidebar-responsive": ""}>
        <div className='sidebar-title'>
            <div className='sidebar-brand'>
                <BsCart3  className='icon_header'/> SHOP
            </div>
            <span className='icon close_icon' onClick={OpenSidebar}>X</span>
        </div>

        <ul className='sidebar-list'>
            <li className='sidebar-list-item'>
                <a href="">
                    <BsGrid1X2Fill className='icon'/> Dashboard
                </a>
            </li>
            <li className='sidebar-list-item'>
                <a href="">
                    <Link to ='/boat'><BsFillArchiveFill className='icon'/> Manage HouseBoats</Link>
                </a>
            </li>
            {/* <li className='sidebar-list-item'>
                <a href="">
                    <BsFillGrid3X3GapFill className='icon'/> View Customers
                </a>
            </li> */}
            <li className='sidebar-list-item'>
                <a href="">
                    <BsPeopleFill className='icon'/> Customers
                </a>
            </li>
            <li className='sidebar-list-item'>
                <a href="">
                    <BsPeopleFill className='icon'/> Bookings
                </a>
            </li>
            {/* <li className='sidebar-list-item'>
                <a href="">
                    <BsListCheck className='icon'/> Inventory
                </a>
            </li> */}
            <li className='sidebar-list-item'>
                <a href="">
                    <BsMenuButtonWideFill className='icon'/> FeedBack
                </a>
            </li>
            <li className='sidebar-list-item'>
                <a href="">
                    <BsFillGearFill className='icon'/> Setting
                </a>
            </li>
        </ul>
    </aside>
  )
}

AdminSidebar.propTypes = {
    openSidebarToggle: PropTypes.bool.isRequired,
    OpenSidebar: PropTypes.func.isRequired
  };

export default AdminSidebar
