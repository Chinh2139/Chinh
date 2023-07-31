import React from 'react';
import ProductItem from '../Product/ProductItem';
import { Container, Table } from 'reactstrap';

function ProductForm(props) {
    let { listProduct, deleteProduct, onHandleClickEdit } = props;
    return (
        <Container>
            {/* <Button color='success'>Create New Product</Button> */}
            <br />
            <h3>Danh sách Product</h3>
            <Table hover>
                <br />
                <thead style={{ textAlign: "center" }}>
                    <tr >
                        <th>ID</th>
                        <th>Name</th>
                        <th>Info</th>
                        <th>ImageName</th>
                        <th>ManufacturerName</th>
                        <th>Price</th>
                        <th >RatingStar</th>
                        <th >Edit</th>
                        <th>Delete</th>
                    </tr>
                </thead>
                <tbody>
                    <ProductItem listProduct={listProduct} deleteProduct={deleteProduct} onHandleClickEdit={onHandleClickEdit} />
                </tbody>
            </Table>
        </Container>
    );
}

export default ProductForm;