import '../css/AccountDetails.css';
// import image2 from '../assets/image/boat2.jpeg';
import { Avatar ,Card} from '@mui/material';

export default function AccountDetails() {
    return (
        <div className='accountdetails' style={{display:'flex',justifyContent:'center',alignContent:'center'}}>
            <div className='details' style={{marginBottom:'200px' , backgroundColor:'green' , width:'400px' , height:'500px'}}>
            <Avatar
  alt="Remy Sharp"
  src="../assets/image/boat2.jpeg"
  sx={{ width: 120, height: 120,marginTop:'-250px' }}
/>
<div style={{ paddingTop: '20px', textAlign: 'center' }}>
          <p>Name: Deepak</p>
          <p>Email: xyz@gmail.com</p>
          <p>Phone Number: 2933232XXXX</p>
        </div>
        </div>
        </div>
    );
}
