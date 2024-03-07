import { useState } from "react";
import axios from "axios";
import "/Users/deepak/Desktop/AdvancedAppDevelopment/aquavoyage/src/css/Bookingform.css"; // Make sure to adjust the path to your CSS file

const BookingForm = () => {
  const [bookingData, setBookingData] = useState({
    firstname: "",
    lastname: "",
    noOfPersons: 0,
    fromDate: "",
    email: "",
    phoneNumber: 0,
    toDate: "",
    totalPrice: 0,
    customer: {
      customerId: 1,
    },
    boat: {
      boatId: 1,
    },
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setBookingData({
      ...bookingData,
      [name]: value,
    });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post(
        "http://localhost:8080/api/user/booking",
        bookingData
      );
      console.log("Form submitted successfully:", response.data);
    } catch (error) {
      console.error("Error submitting form:", error);
    }
  };

  return (
    <div>
      <h2>Booking Form</h2>
      <form onSubmit={handleSubmit} className="booking-form">
        <label>
          First Name:
          <input
            type="text"
            name="firstname"
            value={bookingData.firstname}
            onChange={handleChange}
            required
          />
        </label>
        <label>
          Last Name:
          <input
            type="text"
            name="lastname"
            value={bookingData.lastname}
            onChange={handleChange}
            required
          />
        </label>
        <label>
          Number of Persons:
          <input
            type="number"
            name="noOfPersons"
            value={bookingData.noOfPersons}
            onChange={handleChange}
            required
          />
        </label>
        <label>
          From Date:
          <input
            type="date"
            name="fromDate"
            value={bookingData.fromDate}
            onChange={handleChange}
            // required
          />
        </label>
        <label>
          Email:
          <input
            type="email"
            name="email"
            value={bookingData.email}
            onChange={handleChange}
            // required
          />
        </label>
        <label>
          Phone Number:
          <input
            type="tel"
            name="phoneNumber"
            value={bookingData.phoneNumber}
            onChange={handleChange}
            required
          />
        </label>
        <label>
          To Date:
          <input
            type="date"
            name="toDate"
            value={bookingData.toDate}
            onChange={handleChange}
            required
          />
        </label>
        <label>
          Total Price:
          <input
            type="number"
            name="totalPrice"
            value={bookingData.totalPrice}
            onChange={handleChange}
            required
          />
        </label>
        {/* <label>
          Customer ID:
          <input
            type="number"
            name="customer.customerId"
            value={bookingData.customer.customerId}
            onChange={handleChange}
            required
            // disabled // Disabling editing of customer ID
          />
        </label> */}
        {/* <label>
          Boat ID:
          <input
            type="number"
            name="boat.boatId"
            value={bookingData.boat.boatId}
            onChange={handleChange}
            required
            // disabled // Disabling editing of boat ID
          />
        </label> */}
        <button type="submit">Submit</button>
      </form>
    </div>
  );
};

export default BookingForm;
