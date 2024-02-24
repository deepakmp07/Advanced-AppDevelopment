import * as React from 'react';
import PropTypes from 'prop-types';
import AppBar from '@mui/material/AppBar';
import Box from '@mui/material/Box';
import CssBaseline from '@mui/material/CssBaseline';
import Divider from '@mui/material/Divider';
import Drawer from '@mui/material/Drawer';
import IconButton from '@mui/material/IconButton';
import InboxIcon from '@mui/icons-material/MoveToInbox';
import List from '@mui/material/List';
import ListItem from '@mui/material/ListItem';
import ListItemButton from '@mui/material/ListItemButton';
import ListItemIcon from '@mui/material/ListItemIcon';
import ListItemText from '@mui/material/ListItemText';
import MailIcon from '@mui/icons-material/Mail';
import MenuIcon from '@mui/icons-material/Menu';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';
import AccountDetails from './AccountDetails';
export default function Profile() {
  const [selectedIndex, setSelectedIndex] = React.useState(0);

  const handleListItemClick = (index) => {
    setSelectedIndex(index);
  };
  return (
    <>
    <div style={{ display: 'flex', justifyContent: 'center', height: '100vh', alignItems: 'center'}}>
      <AppBar component="nav" sx={{ height: '100px' ,backgroundColor: '#0074D9'}}>
        <Toolbar sx={{ width: '33%', margin: '0 auto' }}>
          <IconButton
            color="#FFDC00"
            aria-label="open drawer"
            edge="start"
            sx={{ mr: 2, display: { sm: 'none' } }}
          >
            {/* Icon/Button component */}
          </IconButton>
          <Typography variant="h3" component="div" sx={{ flexGrow: 1, textAlign: 'right', fontWeight: 900 ,paddingTop:'25px'}}>
            PROFILE
          </Typography>
          <Box sx={{ flexGrow: 1 }} /> {/* This will push the content to the right */}
        </Toolbar>
      </AppBar>
    </div>
    <Drawer
        sx={{
          width: 240,
          flexShrink: 0,
          '& .MuiDrawer-paper': {
            width: 240,
            boxSizing: 'border-box',
          },
        }}
        variant="permanent"
        anchor="left"
      >
        <Toolbar />
        <Divider sx = {{paddingTop:'24px'}}/>
        <List>
          {['Account Details', 'Bookings', 'Payment', 'History'].map((text, index) => (
            <ListItem key={text} disablePadding
            selected={selectedIndex === index}
              onClick={() => handleListItemClick(index)} 
              sx={{
                '&.Mui-selected': {
                  backgroundColor: '#2ECC40', // Set the background color for selected item
                },
              }}>
              <ListItemButton>
                <ListItemIcon>
                  {index % 2 === 0 ? <InboxIcon /> : <MailIcon />}
                </ListItemIcon>
                <ListItemText primary={text} />
              </ListItemButton>
            </ListItem>
          ))}
        </List>
      </Drawer>
      <div style={{ position: 'absolute', top: '100px', left: 0, right: 0, bottom: 0, backgroundColor: 'blue' }}>
        <AccountDetails></AccountDetails>
        {/* This div covers the remaining page */}
      </div>
      {/* <Toolbar>
      <Box sx = {{backgroundColor:'black' , height:'100px',marginBottom:'300px'}}>ewewewewew</Box>
      </Toolbar> */}
    </>
  );
}
