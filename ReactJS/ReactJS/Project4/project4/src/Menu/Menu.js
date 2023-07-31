import React from 'react';
import { NavLink } from "react-router-dom";
import {
    Container,
    Nav,
    NavItem,
    InputGroup,
    Input,
    Button,
} from 'reactstrap';
import './Menu.css';
// import { Image1 } from "../Asset/upload Image/ImgTV1.png";
function Menu(props) {
    return (
        <Container className='Menu'>
            <header className='header'><h3>Survey.vn</h3>
                <InputGroup className='searchHeader'>
                    <Input placeholder='Bạn muốn tìm gì?' className='inputHeader' /><br></br>
                    <Button className='buttonHeader'>
                        Search
                    </Button>
                </InputGroup>
            </header>
            <Nav className='nav'>
                <div className='nav1'>
                    <NavItem className='navItem'>
                        <NavLink to={"/"}>
                            Home
                        </NavLink>
                    </NavItem>
                    <NavItem className='navItem'>
                        <NavLink
                            active
                            to={"/ProductManagement"}>
                            ProductManagement
                        </NavLink>
                    </NavItem>
                    <NavItem className='navItem'>
                        <NavLink to={"/CustomerManagement"}>
                            CustomerManagement
                        </NavLink>
                    </NavItem>
                    <NavItem className='navItem'>
                        <NavLink to={"/Survey"}>
                            Survey
                        </NavLink>
                    </NavItem>
                </div>
                <div className='nav2'>
                    <NavItem style={{ display: "flex" }}>
                        <NavLink to={"/Login"} style={{ padding: " 0 40px" }}>
                            Login
                        </NavLink>
                        <NavLink to={"/Sign_Up"}>
                            Signup
                        </NavLink>
                    </NavItem>
                </div>
            </Nav>
        </Container >
    );
}

export default Menu;