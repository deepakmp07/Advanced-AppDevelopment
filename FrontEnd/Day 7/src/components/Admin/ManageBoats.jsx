import React, { useState, useEffect } from "react";
import axios from "axios";
import Button from "@mui/material/Button";
import TextField from "@mui/material/TextField";
import Box from "@mui/material/Box";
import Grid from "@mui/material/Grid";
import Paper from "@mui/material/Paper";
import IconButton from "@mui/material/IconButton";
import DeleteIcon from "@mui/icons-material/Delete";

function BoatList({ boats, onDelete }) {
  return (
    <div>
      <h2>Boat List</h2>
      {boats.map((boat,Index) => (
        <Paper
          key={Index}
          elevation={3}
          style={{ padding: "10px", marginBottom: "10px" }}
        >
          <Grid container spacing={2}>
            <Grid item xs={12}>
              <div>
                <strong>Boat Name:</strong> {boat.boatName}
              </div>
            </Grid>
            <Grid item xs={12}>
              <div>
                <strong>Image URL:</strong> {boat.imageUrl}
              </div>
            </Grid>
            <Grid item xs={12}>
              <div>
                <strong>Location:</strong> {boat.boatLocation}
              </div>
            </Grid>
            <Grid item xs={12}>
              <div>
                <strong>Category:</strong> {boat.boatCategory}
              </div>
            </Grid>
            <Grid item xs={12}>
              <div>
                <strong>Available:</strong> {boat.boatAvailable ? "Yes" : "No"}
              </div>
            </Grid>
            <Grid item xs={12}>
              <div>
                <strong>Price:</strong> {boat.price}
              </div>
            </Grid>
            <Grid item xs={12}>
              <div>
                <strong>Capacity:</strong> {boat.capacity}
              </div>
            </Grid>
            <Grid item xs={12}>
              <IconButton
                onClick={() => onDelete(boat.boatId)}
                color="secondary"
              >
                <DeleteIcon />
              </IconButton>
            </Grid>
          </Grid>
        </Paper>
      ))}
    </div>
  );
}

function AddBoatForm({ onAdd }) {
  const [boatDetails, setBoatDetails] = useState({
    // boatId: 0,
    imageUrl: "",
    boatLocation: "",
    boatCategory: "",
    boatAvailable: false,
    price: 0,
    capacity: 0,
  });

  const handleChange = (event) => {
    const { name, value, checked } = event.target;
    setBoatDetails({
      ...boatDetails,
      [name]: name === "boatAvailable" ? checked : value,
    });
  };

  const handleSubmit = (event) => {
    console.log("submitted");
    event.preventDefault();
    // if (!boatDetails.boatName) return;
    onAdd(boatDetails);
    setBoatDetails({
      boatName: "",
      imageUrl: "",
      boatLocation: "",
      boatCategory: "",
      boatAvailable: false,
      price: 0,
      capacity: 0,
    });
  };

  return (
    <Box sx={{ marginTop: "20px" }}>
      <h2>Add Boat</h2>
      <form onSubmit={handleSubmit}>
        <Grid container spacing={2}>
          <Grid item xs={12}>
            <TextField
              fullWidth
              label="Boat Name"
              name="boatName"
              value={boatDetails.boatName}
              onChange={handleChange}
            />
          </Grid>
          <Grid item xs={12}>
            <TextField
              fullWidth
              label="Image URL"
              name="imageUrl"
              value={boatDetails.imageUrl}
              onChange={handleChange}
            />
          </Grid>
          <Grid item xs={12}>
            <TextField
              fullWidth
              label="Location"
              name="boatLocation"
              value={boatDetails.boatLocation}
              onChange={handleChange}
            />
          </Grid>
          <Grid item xs={12}>
            <TextField
              fullWidth
              label="Category"
              name="boatCategory"
              value={boatDetails.boatCategory}
              onChange={handleChange}
            />
          </Grid>
          <Grid item xs={12}>
            <TextField
              fullWidth
              label="Available"
              name="boatAvailable"
              type="checkbox"
              checked={boatDetails.boatAvailable}
              onChange={handleChange}
            />
          </Grid>
          <Grid item xs={12}>
            <TextField
              fullWidth
              label="Price"
              name="price"
              value={boatDetails.price}
              onChange={handleChange}
            />
          </Grid>
          <Grid item xs={12}>
            <TextField
              fullWidth
              label="Capacity"
              name="capacity"
              value={boatDetails.capacity}
              onChange={handleChange}
            />
          </Grid>
          <Grid item xs={12}>
            <Button variant="contained" type="submit" color="primary">
              Add
            </Button>
          </Grid>
        </Grid>
      </form>
    </Box>
  );
}

export default function BoatManagement() {
  const [boats, setBoats] = useState([]);

  useEffect(() => {
    fetchBoats();
  }, []);

  const fetchBoats = async () => {
    try {
      const response = await axios.get("http://localhost:8080/api/user/boat");
      console.log(response.data);
      setBoats(response.data);
    } catch (error) {
      console.error("Error fetching boats:", error);
    }
  };

  const addBoat = async (boatDetails) => {
    try {
        // console.log(boatDetails);
      const response = await axios.post(
        "http://localhost:8080/api/boat",
        boatDetails
      );
      setBoats([...boats, response.data]);
    fetchBoats();
    } catch (error) {
      console.error("Error adding boat:", error);
    }
  };

  const deleteBoat = async (boatId) => {
    try {
      await axios.delete(`http://localhost:8080/api/boat/${boatId}`);
      setBoats(boats.filter((boat) => boat.boatId !== boatId));
    } catch (error) {
      console.error("Error deleting boat:", error);
    }
  };

  return (
    <div style={{ padding: "20px" }}>
      <BoatList boats={boats} onDelete={deleteBoat} />
      <AddBoatForm onAdd={addBoat} />
    </div>
  );
}
