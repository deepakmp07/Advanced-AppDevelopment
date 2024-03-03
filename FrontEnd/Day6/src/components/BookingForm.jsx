import { useState } from 'react';
import '../components/../css/Bookingform.css';

export default function BookingForm() {
  const [firstName, setFirstName] = useState('');
  const [lastName, setLastName] = useState('');
  const [address, setAddress] = useState('');
  const [numberOfGuests, setNumberOfGuests] = useState('');
  const [fromDate, setFromDate] = useState('');
  const [toDate, setToDate] = useState('');
  const [email, setEmail] = useState('');
  const [phoneNumber, setPhoneNumber] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    // Here you can handle the form submission, for example, sending the data to the backend
    console.log('Form submitted:', { firstName, lastName, address, numberOfGuests, fromDate, toDate, email, phoneNumber });
  };

  return (
    <>
      <div style={{ marginBottom: '30px', textAlign: 'center', marginTop: '20px', backgroundColor: 'blue', padding: '20px' }}>BookingForm</div>
      <form onSubmit={handleSubmit} className="booking-form">
        <div className="form-column">
          <div className="form-group">
            <label htmlFor="firstName">First Name:</label>
            <input
              type="text"
              id="firstName"
              value={firstName}
              onChange={(e) => setFirstName(e.target.value)}
              required
              className="input-field"
            />
          </div>
          <div className="form-group">
            <label htmlFor="lastName">Last Name:</label>
            <input
              type="text"
              id="lastName"
              value={lastName}
              onChange={(e) => setLastName(e.target.value)}
              required
              className="input-field"
            />
          </div>
          <div className="form-group">
            <label htmlFor="address">Address:</label>
            <input
              type="text"
              id="address"
              value={address}
              onChange={(e) => setAddress(e.target.value)}
              required
              className="input-field"
            />
          </div>
          <div className="form-group">
            <label htmlFor="numberOfGuests">Number of Guests:</label>
            <input
              type="number"
              id="numberOfGuests"
              value={numberOfGuests}
              onChange={(e) => setNumberOfGuests(e.target.value)}
              required
              className="input-field"
            />
          </div>
        </div>
        <div className="form-column">
          <div className="form-group">
            <label htmlFor="fromDate">From Date:</label>
            <input
              type="date"
              id="fromDate"
              value={fromDate}
              onChange={(e) => setFromDate(e.target.value)}
              required
              className="input-field"
            />
          </div>
          <div className="form-group">
            <label htmlFor="toDate">To Date:</label>
            <input
              type="date"
              id="toDate"
              value={toDate}
              onChange={(e) => setToDate(e.target.value)}
              required
              className="input-field"
            />
          </div>
          <div className="form-group">
            <label htmlFor="email">Email:</label>
            <input
              type="email"
              id="email"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
              required
              className="input-field"
            />
          </div>
          <div className="form-group">
            <label htmlFor="phoneNumber">Phone Number:</label>
            <input
              type="tel"
              id="phoneNumber"
              value={phoneNumber}
              onChange={(e) => setPhoneNumber(e.target.value)}
              required
              className="input-field"
            />
          </div>
        </div>
        <button type="submit" className="submit-button">Book now</button>
      </form>
    </>
  );
}
