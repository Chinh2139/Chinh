import { Route, Routes } from "react-router-dom";
import Home from "../Page/Home";
import Survey from "../Page/Survey";
import CustomerManagement from "../Page/CustomerManagement";
import ProductManagement from "../Page/ProductManagement";
import Login from "../Page/Login";
import SignUp from "../Page/Signup";
import ProductDetail from "../Component/Product/ProductDetail";

// import Error from "../Page/";
export let route = (
    <Routes>

        <Route path="/" element={<Home />} exact />
        <Route path="/home" element={<Home />} exact />
        <Route path="/Survey" element={<Survey />} exact />
        <Route path="/CustomerManagement" element={<CustomerManagement />} />
        <Route path="/ProductManagement" element={<ProductManagement />} />
        <Route path="/Login" element={<Login />} />
        <Route path="/Sign_Up" element={<SignUp />} />
        <Route path="/ProductDetail/:ID" element={<ProductDetail />} exact />
        {/* <Route path="*" element={<Error />} /> */}

    </Routes>

);