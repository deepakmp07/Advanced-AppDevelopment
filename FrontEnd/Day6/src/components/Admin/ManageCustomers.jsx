import { useState, useEffect } from "react";
import axios from "axios";
import "/Users/deepak/Desktop/AdvancedAppDevelopment/aquavoyage/src/css/ManageCustomer.css"; // Import CSS file

const ManageCustomers = () => {
  const [customers, setCustomers] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    // Fetch customer data from the backend
    axios
      .get("http://localhost:8080/api/registration/customer")
      .then((response) => {
        // console.log(response.data);
        setCustomers(response.data);
        setLoading(false);
      })
      .catch((error) => {
        console.error("Error fetching customer data: ", error);
        setLoading(false);
      });
  }, []);

  return (
    <div>
      <h2 className="title">Customer List</h2>
      {loading ? (
        <div>Loading...</div>
      ) : (
        <ul className="customer-list">
          {customers.map((customer, index) => (
            <li key={index} className="customer-item">
              <div className="info">
                <span>Name: {customer.customerName}</span>
                <span>Email: {customer.email}</span>
                <span>Address: {customer.address}</span>
                <span>Phone: {customer.mobileNumber}</span>
              </div>
            </li>
          ))}
        </ul>
      )}
    </div>
  );
};

export default ManageCustomers;
