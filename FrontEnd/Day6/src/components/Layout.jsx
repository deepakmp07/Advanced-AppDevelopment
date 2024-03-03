import { useState, useEffect } from 'react';
import PropTypes from 'prop-types';
import { Box } from '@mui/material';
import Drawer from '@mui/material/Drawer';
import AppBar from '@mui/material/AppBar';
import CssBaseline from '@mui/material/CssBaseline';
import Toolbar from '@mui/material/Toolbar';
import List from '@mui/material/List';
import Divider from '@mui/material/Divider';
import ListItem from '@mui/material/ListItem';
import ListItemButton from '@mui/material/ListItemButton';
import ListItemIcon from '@mui/material/ListItemIcon';
import ListItemText from '@mui/material/ListItemText';
import InboxIcon from '@mui/icons-material/MoveToInbox';
import MailIcon from '@mui/icons-material/Mail';
import Header from './Header';
import Content from './Content';
import Footer from './Footer';
import axios from 'axios'; // Import axios for making HTTP requests
// import { userhomeData } from '../data/data';

const drawerWidth = 240;

const styles = {
  root: {
    display: 'flex',
    flexDirection: 'column',
    minHeight: '100vh',
  },
  main: {
    flexGrow: 1,
    padding: '0px',
    marginLeft: `${drawerWidth}px`, // Add margin to push content away from the sidebar
  },
};

function Layout() {
  const [BoatDetails, setBoatDetails] = useState([]);

  useEffect(() => {
    // Fetch boat details from the backend
    axios.get('http://localhost:8080/api/user/boat')
      .then(response => {
        // Set the fetched boat data in state
        setBoatDetails(response.data);
      })
      .catch(error => {
        console.error('Error fetching BoatDetails data: ', error);
      });
  }, []); // Empty dependency array ensures this effect runs only once after the initial render

  return (
    <Box sx={styles.root}>
      <CssBaseline />
      <AppBar position="fixed" sx={{ zIndex: (theme) => theme.zIndex.drawer + 1 }}>
        <Toolbar>
          <Header />
        </Toolbar>
      </AppBar>
      <Drawer
        variant="permanent"
        sx={{
          width: drawerWidth,
          flexShrink: 0,
          [`& .MuiDrawer-paper`]: { width: drawerWidth, boxSizing: 'border-box' },
        }}
      >
        <Toolbar />
        <Box sx={{ overflow: 'auto' }}>
          <List>
            {['Bookings', 'Payments'].map((text, index) => (
              <ListItem key={text} disablePadding>
                <ListItemButton>
                  <ListItemIcon>
                    {index % 2 === 0 ? <InboxIcon /> : <MailIcon />}
                  </ListItemIcon>
                  <ListItemText primary={text} />
                </ListItemButton>
              </ListItem>
            ))}
          </List>
          <Divider />
        </Box>
      </Drawer>
      <Box component="main" sx={styles.main}>
        <Toolbar />
        <br></br>
        <div style={{ display: 'flex', flexWrap: 'wrap', gap: '20px' }}>
          {BoatDetails.map((data, index) => (
            <Content
              key={index}
              name={data.name}
              price={data.price}
              ratings={data.ratings}
              likes={data.likes}
              location={data.location}
            />
          ))}
        </div>
        <br></br>
      </Box>
      <Footer />
    </Box>
  );
}

// PropTypes for Layout component
Layout.propTypes = {
  name: PropTypes.string,
  price: PropTypes.number,
  ratings: PropTypes.number,
  likes: PropTypes.number,
  location: PropTypes.string
};

export default Layout;
