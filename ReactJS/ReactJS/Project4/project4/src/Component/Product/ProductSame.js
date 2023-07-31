import React from "react";
import {
    Container,
    Card,
    Col,
    CardBody,
    CardTitle,
    CardSubtitle,
    CardText,
    Button,
} from "reactstrap";

function ProductSame(props) {
    let { listProduct } = props;
    // console.log("listProduct_same: ", listProduct);
    let SameProduct = "";
    if (listProduct) {
        SameProduct = listProduct.map((product, index) => {
            return (

                <Col md={3}>
                    <Card
                        style={{
                            width: "18rem",
                        }}>
                        <img alt="Sample" src={"/Asset/uploadImage/" + product.imageName} />
                        <CardBody>
                            <CardTitle tag="h5">{product.name}</CardTitle>
                            <CardSubtitle className="mb-2 text-muted" tag="h6">
                                {product.price}
                            </CardSubtitle>
                            <CardText>
                                {product.info}
                            </CardText>
                            <Button color="success">Buy</Button>
                        </CardBody>
                    </Card>
                </Col>
            );
        });
    }
    return SameProduct;
}

export default ProductSame;
