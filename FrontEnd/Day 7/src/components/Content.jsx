import { useState } from 'react';
import PropTypes from 'prop-types';
import { Link } from 'react-router-dom';
import FavoriteBorderIcon from '@mui/icons-material/FavoriteBorder';
import { Card, CardMedia, CardActionArea, CardContent, Typography, Container } from '@mui/material';

export default function Content(props) {
  const [isLiked, setIsLiked] = useState(false);
  const [heartCount, setHeartCount] = useState(props.likes);

  const handleHeartCount = () => {
    if (isLiked) {
      setHeartCount(heartCount - 1);
    } else {
      setHeartCount(heartCount + 1);
    }
  };

  const handleLikeClick = () => {
    setIsLiked(!isLiked);
    handleHeartCount();
  };

  return (
    <Card className='c1' sx={{ maxWidth: 345 ,justifyContent:'center' , display:'flex' , flexDirection:'row',marginLeft:'30px'}}>
    <CardActionArea>
      <CardMedia
        component="img"
        height="200"
        image="https://res.cloudinary.com/dcc7xkmex/image/upload/v1708520856/jcthouseboat_ghforl.jpg"
        alt="jct"
      />
      <CardContent>
        <Typography gutterBottom variant="h5" component="div">
          <h1 style={{fontSize:'18px',fontWeight:700}}>{props.name}</h1>
        </Typography>
            <p style={{ fontSize: '12px' }}>{props.location}</p>
            <div style={{ display: 'flex', alignItems: 'center' }}>
              <div style={{ backgroundColor: 'blue', width: '20px', height: '20px', color: 'white', borderRadius: '20%', display: 'flex', alignItems: 'center', justifyContent: 'center', marginRight: '10px' }}>{props.ratings}</div>
              <div style={{ paddingLeft: '10px' }}>Fabulous</div>
              <div onClick={handleLikeClick} style={{ cursor: 'pointer', display: 'flex', alignItems: 'center', marginLeft: 'auto' }}>
                <FavoriteBorderIcon sx={{ color: isLiked ? 'red' : 'inherit', backgroundColor: isLiked ? 'red' : 'transparent', borderRadius: '50%' }} />
              </div>
              <span style={{ marginLeft: '5px' }}>{heartCount} Likes</span>
            </div>
            <div style={{ display: 'flex', justifyContent: 'flex-end', marginTop: '20px' }}>
           <Link to='/info' ><button style={{ marginRight:'60px' }}>Book now</button></Link>
              <p style={{ marginTop: '3px', marginRight: '10px' }}>Starting from</p>
              <p style={{ fontSize: '15px', fontWeight: 'bold' }}>${props.price}</p>
            </div>
          </CardContent>
        </CardActionArea>
      </Card>
  );
}

Content.propTypes = {
  price: PropTypes.number,
  name: PropTypes.string,
  ratings: PropTypes.number,
  likes: PropTypes.number,
  location: PropTypes.string,
};
