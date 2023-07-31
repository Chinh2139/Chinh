import React, { useEffect, useState } from "react";
import { NavLink, useParams } from "react-router-dom";
import {
    Container,
    ButtonGroup,
    Col,
    Input,
    Row,
    Button,
    Nav,
    NavItem,
} from "reactstrap";
import { getListProductAPI } from "../../API/productAPI";
import Home from "../../Page/Home";
import ProductSame from "./ProductSame";
import ModalCart from "./ProductContainer/ModalCart";
function ProductDetail(props) {
    let [listProduct, setListProduct] = useState([]);
    let [count, setCount] = useState(1);
    let [countStar, setCountStar] = useState(0);
    let [countStar2, setCountStar2] = useState(0);
    let [countStar3, setCountStar3] = useState(0);
    let [countStar4, setCountStar4] = useState(0);
    let [countStar5, setCountStar5] = useState(0);
    let [ClickCart, setClickCart] = useState("");
    let [ModalOpenCart, setModalOpenCart] = useState("");
    let fetchListPoductToHome = () => {
        getListProductAPI().then((res) => {
            setListProduct(res);
        });
    };
    //  Hàm xử lý khi đánh giá số sao
    let handleClickStar = () => {
        setCountStar((countStar = countStar + 1));
    };
    let handleClickStar2 = () => {
        setCountStar2((countStar2 = countStar2 + 1));
    };
    let handleClickStar3 = () => {
        setCountStar3((countStar3 = countStar3 + 1));
    };
    let handleClickStar4 = () => {
        setCountStar4((countStar4 = countStar4 + 1));
    };
    let handleClickStar5 = () => {
        setCountStar5((countStar5 = countStar5 + 1));
    };
    // Hàm xử lý khi tăng giảm số lượng
    const handleClickPlus = () => {
        setCount((count = count + 1));
    };
    const handleClickMinasus = () => {
        if (count > 1) {
            setCount((count = count - 1));
        } else {
            alert("Sản phẩm này phải đặt từ 1 sản phẩm trở lên! ");
        }
    };
    // Hàm xử lý khi cho vào giỏ hàng
    let handleClickCart = () => {
        setClickCart(count);
    };
    // Hàm xử lý open modal giỏ hàng
    let handleOpenModal = () => {
        setModalOpenCart(true);
    };
    let onhandleCloseModalCart = () => {
        setModalOpenCart(false);
    };
    useEffect(() => {
        fetchListPoductToHome();
    }, []);

    let param = useParams();
    let idparam = param.ID;
    const row_Item = listProduct.map((product, index) => {
        if (product.id == idparam) {
            return (
                <Container>
                    <Row>
                        <Col md={4}>
                            <img
                                src={"/Asset/uploadImage/" + product.imageName}
                                alt="NoImage"
                                style={{ width: "400px", heigh: "400px" }}
                            />
                        </Col>
                        <Col md={5}>
                            <h3>{product.name}</h3>
                            <h6>Thương hiệu: {product.manufacturerName}</h6>
                            <h4 style={{ color: "red" }}>{product.price}</h4>
                            <h6>
                                Chọn miền:
                                <Button color="primary" style={{ margin: "0 5px" }}>
                                    Bắc
                                </Button>
                                <Button color="success">Nam</Button>
                            </h6>
                            <h6>Trạng thái: Còn hàng</h6>
                            <div style={{ display: "flex" }}>
                                <h6>
                                    Chọn số lượng:
                                    <ButtonGroup>
                                        <Button color="danger" onClick={handleClickMinasus}>
                                            -
                                        </Button>
                                        <div>
                                            <Input
                                                value={count}
                                                style={{ textAlign: "center", width: "3rem" }}
                                            />
                                        </div>
                                        <Button color="success" onClick={handleClickPlus}>
                                            +
                                        </Button>
                                    </ButtonGroup>
                                </h6>
                                <h6 style={{ margin: "0 10px" }}>
                                    Cho vào giỏ hàng:
                                    <button
                                        type="button"
                                        className="btn btn-default"
                                        style={{ border: "0px" }}
                                    >
                                        <i
                                            className="fa fa-shopping-cart"
                                            style={{ color: "black", fontSize: "30px" }}
                                            onClick={handleClickCart}
                                        ></i>
                                    </button>
                                </h6>
                                <br></br>
                            </div>
                            <Row style={{ display: "flex" }}>
                                <Col>
                                    <div>
                                        <Button
                                            style={{ width: "100%", height: "60px" }}
                                            color="danger"
                                        >
                                            <i className="fa fa-shopping-cart"></i>
                                            <span style={{ margin: "0 10px" }}>Đặt mua</span>
                                            <br></br>
                                            <span>Giao hàng tận nơi</span>
                                        </Button>
                                    </div>
                                </Col>
                                <Col>
                                    <div>
                                        <Button
                                            style={{ width: "100%", height: "60px" }}
                                            color="success"
                                        >
                                            <i class="fa fa-headphones"></i>
                                            <span style={{ margin: "0 10px" }}>Tư vấn</span>
                                            <br></br>
                                            <span>Chúng tôi sẽ liên lạc với bạn</span>
                                        </Button>
                                    </div>
                                </Col>
                            </Row>
                        </Col>
                        <Col md={3}>
                            {/* <Button style={{ width: "100%" }}>3</Button> */}
                            <div style={{ display: "flex" }}>
                                <span>Giỏ hàng</span>
                                <i
                                    className="fa fa-shopping-cart"
                                    style={{ color: "black", fontSize: "30px" }}
                                    onClick={handleOpenModal}
                                ></i>
                                <div
                                    style={{
                                        position: "relative",
                                        left: "-4px",
                                        top: "-15px",
                                        color: "red",
                                    }}
                                >
                                    <h6>{ClickCart}</h6>
                                </div>
                            </div>
                            <h5>Thông tin hữu ích</h5>
                            <Nav style={{ display: "block" }}>
                                <NavItem>
                                    <NavLink>Trung tâm bảo hành</NavLink>
                                </NavItem>
                                <NavItem>
                                    <NavLink>Thông tin vận chuyển</NavLink>
                                </NavItem>
                                <NavItem>
                                    <NavLink>Hướng dẫn thanh toán</NavLink>
                                </NavItem>
                            </Nav>
                        </Col>
                    </Row>
                    <Row>
                        <h4>Đánh giá sản phẩm</h4>
                        <Row>
                            <Col md={2}>
                                <div style={{ color: "yellow" }} onClick={handleClickStar}>
                                    <i class="fa fa-star"></i>
                                </div>
                            </Col>
                            <Col md={2}>
                                <h6>{countStar} (Đánh giá)</h6>
                            </Col>
                        </Row>

                        <Row>
                            <Col md={2}>
                                <div style={{ color: "yellow" }} onClick={handleClickStar2}>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                </div>
                            </Col>
                            <Col md={2}>
                                <h6>{countStar2} (Đánh giá)</h6>
                            </Col>
                        </Row>

                        <Row>
                            <Col md={2}>
                                <div style={{ color: "yellow" }} onClick={handleClickStar3}>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                </div>
                            </Col>
                            <Col md={2}>
                                <h6>{countStar3} (Đánh giá)</h6>
                            </Col>
                        </Row>

                        <Row>
                            <Col md={2}>
                                <div style={{ color: "yellow" }} onClick={handleClickStar4}>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                </div>
                            </Col>
                            <Col md={2}>
                                <h6>{countStar4} (Đánh giá)</h6>
                            </Col>
                        </Row>
                        <Row>
                            <Col md={2}>
                                <div style={{ color: "yellow" }} onClick={handleClickStar5}>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                </div>
                            </Col>
                            <Col md={2}>
                                <h6>{countStar5} (Đánh giá)</h6>
                            </Col>
                        </Row>
                    </Row>
                    <Row>
                        <h3>Sản phẩm tương tự</h3>
                        <ProductSame listProduct={listProduct} />
                    </Row>
                    <ModalCart
                        ModalOpenCart={ModalOpenCart}
                        onhandleCloseModalCart={onhandleCloseModalCart}
                        ClickCart={ClickCart}
                    />
                </Container>
            );
        }
    });

    return row_Item;
}
export default ProductDetail;
