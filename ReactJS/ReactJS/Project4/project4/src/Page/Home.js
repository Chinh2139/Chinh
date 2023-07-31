import React, { useEffect, useState } from "react";
import {
    UncontrolledDropdown,
    Col,
    Container,
    Row,
    DropdownToggle,
    DropdownMenu,
    DropdownItem,
} from "reactstrap";
import "../Component/Home/Home.css";
import { getListProductAPI } from "../API/productAPI";
import HomeFormItem from "../Component/Home/HomeFormItem";
import Footer from "../Component/Footer/Footer";
import Banner from "../Menu/Banner";
function Home(props) {
    let [listProduct, setListProduct] = useState([]);
    let fetchListPoductToHome = () => {
        getListProductAPI().then((res) => {
            setListProduct(res);
        });
    };
    useEffect(() => {
        fetchListPoductToHome();
    }, []);
    return (
        <Container style={{ display: "block" }}>
            <Row>
                <Col md={3}>
                    <UncontrolledDropdown style={{}}>
                        <DropdownToggle caret color="aqua">
                            <h5>Danh mục sản phẩm</h5>
                        </DropdownToggle>
                        <DropdownMenu flip style={{ textAlign: "center" }}>
                            <DropdownItem >LG</DropdownItem>
                            <DropdownItem>SamSung</DropdownItem>
                            <DropdownItem >Sony</DropdownItem>
                            <DropdownItem >Xiaomi</DropdownItem>
                            <DropdownItem divider />
                            <DropdownItem>Đánh giá</DropdownItem>
                        </DropdownMenu>
                    </UncontrolledDropdown>
                </Col>
                <Col md={6}>
                    <Banner />
                </Col>
                <Col md={3}>
                    <div style={{ display: "block" }}>
                        <img src="/Asset/uploadImage/banner_right1.png" style={{ width: "300px", height: "200px" }} /><br>
                        </br>
                        <img src="/Asset/uploadImage/banner_right2.png" style={{ width: "300px", height: "200px" }} />
                    </div>
                </Col>
            </Row>
            <Row>
                <HomeFormItem listProduct={listProduct} />
            </Row>
            <Row>
                <Footer />
            </Row>
        </Container>
    );
}

export default Home;
