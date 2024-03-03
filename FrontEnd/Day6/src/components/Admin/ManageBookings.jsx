import React, { useState, useEffect } from 'react';
import axios from 'axios';
import "/Users/deepak/Desktop/AdvancedAppDevelopment/aquavoyage/src/css/ManageBookings.css";

const BookingPage = () => {
  const [bookings, setBookings] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    axios.get('http://localhost:8080/api/user/booking/all')
      .then(response => {
        setBookings(response.data);
        setLoading(false);
      })
      .catch(error => {
        console.error('Error fetching booking data: ', error);
        setLoading(false);
      });
  }, []);

  return (
    <div>
      <nav>
        <h1>Booking List</h1>
      </nav>
      <div className="container">
        {loading ? (
          <div>Loading...</div>
        ) : (
          <table className="booking-table">
            <thead>
              <tr>
                <th>Booking ID</th>
                <th>Customer Name</th>
                <th>Email</th>
                <th>Number of Persons</th>
                <th>From Date</th>
                <th>To Date</th>
                <th>Total Price</th>
              </tr>
            </thead>
            <tbody>
              {bookings.map(booking => (
                <tr key={booking.bookingId}>
                  <td>{booking.bookingId}</td>
                  <td>{booking.firstname} {booking.lastname}</td>
                  <td>{booking.email}</td>
                  <td>{booking.noOfPersons}</td>
                  <td>{booking.fromDate}</td>
                  <td>{booking.toDate}</td>
                  <td>{booking.totalPrice}</td>
                </tr>
              ))}
            </tbody>
          </table>
        )}
      </div>
    </div>
  );
};

export default BookingPage;
