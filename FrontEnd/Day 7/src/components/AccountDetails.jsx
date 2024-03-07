import { useState } from 'react';
import '../css/AccountDetails.css';
import { Avatar, Card, Button, Container, TextField, Typography, Grid } from '@mui/material';
import boatImage from '../assets/image/boat2.jpeg'; // Importing the boat image

export default function AccountDetails() {
  const [isEditing, setIsEditing] = useState(false);
  const [name, setName] = useState('Deepak');
  const [email, setEmail] = useState('xyz@gmail.com');
  const [phoneNumber, setPhoneNumber] = useState('2933232XXXX');

  const handleEdit = () => {
    setIsEditing(true);
  };

  const handleSave = () => {
    setIsEditing(false);
    // You can add logic here to save the changes
  };

  return (
    <Container maxWidth="20px" className="account-details" sx={{height:'200px',marginTop:'200px'}}>
      <Card className="details-card">
        <Grid container spacing={2} alignItems="center">
          <Grid item xs={4}>
          <Avatar
  alt="Boat Image"
  src={boatImage}
  className="avatar"
  style={{ width: '100%', height: '100%' }} // Apply inline styles for full width and height
/>
          </Grid>
          <Grid item xs={8}>
            <div className="details-content">
              <Typography variant="h5" gutterBottom>
                {isEditing ? 'Edit Profile' : 'Account Details'}
              </Typography>
              {isEditing ? (
                <>
                  <TextField
                    label="Name"
                    value={name}
                    onChange={(e) => setName(e.target.value)}
                    fullWidth
                    margin="normal"
                  />
                  <TextField
                    label="Email"
                    value={email}
                    onChange={(e) => setEmail(e.target.value)}
                    fullWidth
                    margin="normal"
                  />
                  <TextField
                    label="Phone Number"
                    value={phoneNumber}
                    onChange={(e) => setPhoneNumber(e.target.value)}
                    fullWidth
                    margin="normal"
                  />
                  <Button variant="contained" onClick={handleSave}>Save</Button>
                </>
              ) : (
                <>
                  <Typography variant="body1" gutterBottom>
                    Name: {name}
                  </Typography>
                  <Typography variant="body1" gutterBottom>
                    Email: {email}
                  </Typography>
                  <Typography variant="body1" gutterBottom>
                    Phone Number: {phoneNumber}
                  </Typography>
                  <Button variant="contained" onClick={handleEdit} sx={{ marginLeft: 'auto' }}>Edit</Button>
                </>
              )}
            </div>
          </Grid>
        </Grid>
      </Card>
    </Container>
  );
}
