import React from 'react';
import { Button, Container } from 'reactstrap';

function CreateNewProduct(props) {
    let { clickCreatNewProduct } = props;
    let handeClick = () => {
        clickCreatNewProduct()
    }
    return (
        <Container>
            <Button color='success' onClick={handeClick}>
                Create New Product
            </Button>
        </Container>
    );
}

export default CreateNewProduct;