
import { useState } from 'react'
import AdminHeader from './AdminHeader'
import AdminSidebar from './AdminSideBar';
import AdminHome from './AdminHome'
import './Admin.css';

function AdminPage() {
  const [openSidebarToggle, setOpenSidebarToggle] = useState(false)

  const OpenSidebar = () => {
    setOpenSidebarToggle(!openSidebarToggle)
  }

  return (
    <div className='grid-container'>
<AdminHeader OpenSidebar={OpenSidebar} />
      <AdminSidebar openSidebarToggle={openSidebarToggle} OpenSidebar={OpenSidebar}/>
      <AdminHome />
    </div>
  )
}

export default AdminPage