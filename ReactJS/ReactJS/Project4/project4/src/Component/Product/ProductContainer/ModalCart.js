import React from 'react';
import {
    Container,
    Button,
    Modal,
    ModalHeader,
    ModalBody,
    ModalFooter,
} from "reactstrap";
function ModalCart(props) {
    let { ModalOpenCart, onhandleCloseModalCart, ClickCart } = props;
    let handleCloseModalCart = () => {
        onhandleCloseModalCart();
    };
    return (
        <Container>
            <br />
            <Modal isOpen={ModalOpenCart}>
                <ModalHeader>
                    <h3>Giỏ hàng (có {ClickCart} sản phẩm)</h3>
                </ModalHeader>
                <ModalBody>
                    <h1>hello</h1>
                </ModalBody>
                <ModalFooter>
                    <Button color="danger" onClick={handleCloseModalCart}>
                        Close
                    </Button>
                </ModalFooter>
            </Modal>
        </Container>
    );
}

export default ModalCart;