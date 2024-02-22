import '../css/Content.css';
import image1 from '../assets/image/boat1.jpeg'
export default function Content(){
   return(
    <>
    <h1 style={{marginTop:'20px'}}>Showing Properties in alleypey</h1>
        <div className="box">
          <div className="first-box">
            <div className='box-image'>
            <img src = {image1} width= '400px' height='280px'/>
            <div>one bedrom|4 guests</div> 

            </div>
            <div className='main-content'>
                <div className='main'>
                <h1>Best kerala houseboat</h1>
                </div>
            </div>
          </div>
          <div className="second-box">
            second box
          </div>
        </div>
        </>
   )
}