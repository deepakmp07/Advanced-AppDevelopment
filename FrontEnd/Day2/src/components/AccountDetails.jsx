import '../css/AccountDetails.css';
import image2 from '../assets/image/boat2.jpeg';

export default function AccountDetails() {
    return (
        <div className='accountdetails'>
            <div className='details'>
            <img src={image2} alt="Boat" height={30} width={30} />
                <h1>hi everyone</h1>
            </div>
        </div>
    );
}
