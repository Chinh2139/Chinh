import React from "react";
import {
    Button,
    Input,
    Nav,
    NavItem,
    Container,
    Row,
    Col,
    UncontrolledDropdown,
    DropdownToggle,
    DropdownItem,
    DropdownMenu,
} from "reactstrap";
import { NavLink } from "react-router-dom";
function Menu(props) {
    return (
        <Container>
            <Row style={{ display: "flex" }}>
                <Col xs={3}>
                    <NavLink to={"/Home"}>
                        <Button>Xem phim Anime</Button>
                    </NavLink>
                </Col>
                <Col xs={4} style={{ display: "flex" }}>
                    {/* <NavLink> */}
                    <Input
                        placeholder="Nhập phim cần tìm kiếm"
                        style={{ borderRadius: "50px" }}
                    ></Input>
                    <Button
                        style={{
                            position: "relative",
                            left: "-42px",
                            borderRadius: "50px",
                        }}
                    >
                        <i class="fa fa-search"></i>
                    </Button>
                    {/* </NavLink> */}
                </Col>
                <Col xs={2} style={{ display: "flex", justifyItems: "flex-end", alignItems: "flex-end" }}>
                    <UncontrolledDropdown>
                        <DropdownToggle caret color="dark">
                            Danh sách phim yêu thích
                        </DropdownToggle>
                        <DropdownMenu dark>
                            <DropdownItem header>Header</DropdownItem>
                            <DropdownItem>Some Action</DropdownItem>
                            <DropdownItem text>Dropdown Item Text</DropdownItem>
                            <DropdownItem disabled>Action (disabled)</DropdownItem>
                            <DropdownItem divider />
                            <DropdownItem>Foo Action</DropdownItem>
                            <DropdownItem>Bar Action</DropdownItem>
                            <DropdownItem>Quo Action</DropdownItem>
                        </DropdownMenu>
                    </UncontrolledDropdown>
                </Col>
            </Row>
            <Row style={{ backgroundColor: "Black", color: "white", height: "5rem", margin: "1rem 0" }}>
                <Nav style={{ margin: "20px 5px" }}>
                    <NavItem style={{ margin: "0 20px" }}>
                        <NavLink active to="#">
                            Tu Tiên
                        </NavLink>
                    </NavItem>
                    <NavItem style={{ margin: "0 20px" }}>
                        <NavLink active to="#">
                            Luyện Cấp
                        </NavLink>
                    </NavItem>
                    <NavItem style={{ margin: "0 20px" }}>
                        <NavLink active to="#">
                            Trùng sinh
                        </NavLink>
                    </NavItem>
                    <NavItem style={{ margin: "0 20px" }}>
                        <NavLink active to="#">
                            Kiếm Hiệp
                        </NavLink>
                    </NavItem>
                    <NavItem style={{ margin: "0 20px" }}>
                        <NavLink active to="#">
                            Xuyên Không
                        </NavLink>
                    </NavItem>
                    <NavItem style={{ margin: "0 20px" }}>
                        <NavLink active to="#">Hiện Đại</NavLink>
                    </NavItem>
                    <NavItem style={{ margin: "0 20px" }}>
                        <NavLink to="#">Hài Hước</NavLink>
                    </NavItem>

                </Nav>
                {/* <NavLink to="/Signup">
                <Button>
                    Register
                </Button>
            </NavLink> */}

                {/* {route} */}
            </Row>
        </Container>
    );
}

export default Menu;
