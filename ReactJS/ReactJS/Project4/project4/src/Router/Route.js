import { Route, Routes } from "react-router-dom";
import Signup from "../Page/Signup";
import Home from "../Page/Home";
import Login from "../Page/Login";

export let route = (
    <Routes>
        <Route path="/" element={< Home />} />
        <Route path="/SignUp" element={<Signup />} exact />
        <Route path="/Login" element={<Login />} exact />
        <Route path="/Home" element={<Home />} exact />
    </Routes>
);