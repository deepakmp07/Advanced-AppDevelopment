import '../css/Profile.css'
import AccountDetails from './AccountDetails'
export default function Profile(){
   return(
       <>
       <div className="header" >
        <h1>Profile</h1>
        </div>
        <AccountDetails/>
        <div className="sidebar">
  <a className="active" href="#home">Account Details</a>
  {/* <a className="active" href="#home">ME</a> */}
  <a href="#news">Status</a>
  <a href="#contact">Address</a>
  <a href="#about">Log Out</a>
</div>
       </>
   )
}