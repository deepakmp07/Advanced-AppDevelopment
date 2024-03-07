import React, { useState, useEffect } from 'react';
import axios from 'axios';
import "/Users/deepak/Desktop/AdvancedAppDevelopment/aquavoyage/src/css/ManageBookings.css";

const BookingPage = () => {
  const [bookings, setBookings] = useState([]);
  const [loading, setLoading] = useState(true);
  const [selectedBooking, setSelectedBooking] = useState(null);

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

  const handleViewDetails = (booking) => {
    setSelectedBooking(booking);
  };

  return (
    <div>
      <h1>Booking List</h1>
      <div className="container">
        {loading ? (
          <div>Loading...</div>
        ) : (
          <>
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
                  <th>Action</th>
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
                    <td>
                      <button onClick={() => handleViewDetails(booking)}>View</button>
                    </td>
                  </tr>
                ))}
              </tbody>
            </table>
            {selectedBooking && (
              <div className="booking-details">
                <h2>Booking Details</h2>
                <p><strong>Booking ID:</strong> {selectedBooking.bookingId}</p>
                <p><strong>Customer Name:</strong> {selectedBooking.firstname} {selectedBooking.lastname}</p>
                <p><strong>Email:</strong> {selectedBooking.email}</p>
                <p><strong>Number of Persons:</strong> {selectedBooking.noOfPersons}</p>
                <p><strong>From Date:</strong> {selectedBooking.fromDate}</p>
                <p><strong>To Date:</strong> {selectedBooking.toDate}</p>
                <p><strong>Total Price:</strong> {selectedBooking.totalPrice}</p>
              </div>
            )}
          </>
        )}
      </div>
    </div>
  );
};

export default BookingPage;
