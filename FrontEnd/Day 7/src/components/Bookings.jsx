import React, { useState, useEffect } from "react";
import axios from "axios";

const BookingDetails = ({ bookingId }) => {
  const [booking, setBooking] = useState(null);
  const [editedBooking, setEditedBooking] = useState(null);
  const [isEditing, setIsEditing] = useState(false);

  useEffect(() => {
    const fetchBookingDetails = async () => {
      try {
        const response = await axios.get(
          `http://localhost:8080/api/user/booking/all`
        );
        // Assuming response.data is an array, set editedBooking to the first item
        setBooking(response.data);
        setEditedBooking(response.data[0]); // Set to the first item
        console.log(booking);
      } catch (error) {
        console.error("Error fetching booking details:", error);
      }
    };
  
    fetchBookingDetails();
  }, [bookingId]);
  
  const handleCancel = async () => {
    try {
      await axios.delete(`http://localhost:8080/api/user/booking/8`);
      console.log("Booking canceled successfully");
      // Optionally, you can update the state or perform other actions after cancellation
    } catch (error) {
      console.error("Error canceling booking:", error);
    }
  };

  const handleEdit = () => {
    setIsEditing(true);
  };

  const handleSave = async () => {
    try {
      await axios.put(
        `http://localhost:8080/api/user/booking/${bookingId}`,
        editedBooking
      );
      console.log("Booking edited successfully:", editedBooking);
      // Optionally, you can update the state or perform other actions after editing
      setIsEditing(false);
    } catch (error) {
      console.error("Error editing booking:", error);
    }
  };

  const handleChange = (e) => {
    const { name, value } = e.target;
    setEditedBooking({
      ...editedBooking,
      [name]: value,
    });
  };

  if (!booking) {
    return <div>Loading...</div>;
  }

  return (
    <div>
      {booking.map((bookingItem) => (
        <div key={bookingItem.bookingId} className="booking-details">
          <h2>Booking Details</h2>
          <p>
            <strong>Name:</strong> {bookingItem.firstname} {bookingItem.lastname} 
          </p>
          <p>
            <strong>Number of Persons:</strong> {bookingItem.noOfPersons}
          </p>
          <p>
            <strong>From Date:</strong> {bookingItem.fromDate}
          </p>
          <p>
            <strong>To Date:</strong> {bookingItem.toDate}
          </p>
          <p>
            <strong>Email:</strong> {bookingItem.email}
          </p>
          <p>
            <strong>Phone Number:</strong> {bookingItem.phoneNumber}
          </p>
          {/* <p>
            <strong>Total Price:</strong> ${bookingItem.totalPrice.toFixed(2)}
          </p> */}
          {!isEditing ? (
            <div className="action-buttons">
              <button onClick={handleCancel}>Cancel</button>
              <button onClick={handleEdit}>Edit</button>
            </div>
          ) : (
            <div className="edit-form">
              <h3>Edit Booking</h3>
              <label>
                First Name:
                <input
                  type="text"
                  name="firstname"
                  value={editedBooking.firstname}
                  onChange={handleChange}
                />
              </label>
              {/* Rest of the input fields */}
              <button onClick={handleSave}>Save</button>
            </div>
          )}
        </div>
      ))}
    </div>
  );
  
};

export default BookingDetails;
