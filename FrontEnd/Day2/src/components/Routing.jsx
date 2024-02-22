import { BrowserRouter, Routes, Route } from "react-router-dom";
import LoginPage from "./LoginPage.jsx";
import Home from "./Home";
import SignUp from "./SignUp";
import { Link } from "react-router-dom";

export default function Routing(){
return(
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<LoginPage />}>
          <Route index element={<LoginPage />} />
          <Route path="home" element={<Home />} />
          <Route path="register" element={<SignUp />} />
          <Link to="/">Home</Link>
            <Link to="/home">Blogs</Link>
            <Link to="/contact">Contact</Link>
          {/* <Route path="*" element={<NoPage />} /> */}
        </Route>
      </Routes>
    </BrowserRouter>
)
}