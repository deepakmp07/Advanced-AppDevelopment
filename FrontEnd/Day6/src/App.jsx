// import React from 'react';
import { Routes, Route } from "react-router-dom";
import LoginPage from "./components/LoginPage";
import Home from "./components/Home";
import Profile from "./components/Profile";
import SignUp from "./components/SignUp";
// import { ErrorBoundary } from 'react-error-boundary';
// import { Login } from '@mui/icons-material';
import AdminPage from "./components/Admin/AdminPage";
import BookingForm from "./components/BookingForm";
import AddBoatForm from "./components/Admin/ManageBoats";
import UserListPage from "./components/Admin/ManageCustomers";
import BookingPage from "./components/Admin/ManageBookings";
// import AdminLayout from './components/';
// import LargeData from './components/LargeData';
// const LargeData = lazy(() =>import('./components/LargeData'))
function App() {
  return (
    <>
      <Routes>
        <Route path="/boat" element={<AddBoatForm />} />
        <Route path="/manageUsers" element={<UserListPage />} />
        <Route path="/booking" element={<BookingPage />} />
        <Route path="/user" element={<Home />} />
        <Route index element={<Home />} />
        <Route path="/admin" element={<AdminPage />}></Route>
        {/* <Route path="/adminHome" element={<AdminLayout />}/> */}
        <Route path="/book" element={<BookingForm />}></Route>
        <Route path="/profile" element={<Profile />} />
        <Route path="/register" element={<SignUp />} />
        <Route path="/login" element={<LoginPage />} />
        {/* <Route path="largedata" element={<Suspense fallback={<p>loading.........................................</p>}><LargeData /></Suspense>}/> */}
      </Routes>
    </>
  );
}

export default App;
