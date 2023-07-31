import React from 'react';
// import Star from "../../Asset/uploadImage/star.png";
import { NavLink } from 'react-router-dom';
import { Col } from 'reactstrap';
function HomeFormItem(props) {
    let { listProduct } = props;
    let homeItems = "";
    if (listProduct) {
        homeItems = listProduct.map((product, key) => {
            let url = "/ProductDetail/" + product.id;
            return (
                <Col md={3}>
                    <img src={"Asset/uploadImage/" + product.imageName} alt="" style={{ width: "190px", height: "190px" }} />
                    <h3 style={{ fontWeight: "bold" }} >{product.name}</h3>
                    <h5>Hãng sản xuất: {product.manufacturerName}</h5>
                    <div >
                        <ul className="rating" style={{ listStyle: "none", display: "flex", fontSize: "20px" }}>
                            <div>
                                RatingStar: {product.ratingStar} <i class="fa fa-light fa-star" style={{ color: "yellow" }}></i>
                            </div>
                        </ul>
                    </div>
                    <h4>{product.price}</h4>
                    <div >
                        <button type="button" className="btn btn-default" style={{ border: "0px" }}>
                            <i className="fa fa-shopping-cart" style={{ color: "black", fontSize: "30px" }}>
                            </i>
                        </button>
                    </div>
                    <div className='row'>
                        <NavLink to={url}>
                            Xem chi tiết
                        </NavLink>
                    </div>
                    <br />
                    <br />
                </Col>
            )
        });

    }
    return homeItems;
}

export default HomeFormItem;