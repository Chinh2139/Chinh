import React from 'react';
import {
    Container,
    Button,
    Modal,
    ModalHeader,
    ModalBody,
    ModalFooter,
} from "reactstrap";
import InputForm from './InputForm';
function NewProductModal(props) {
    let { showForm, clickClose, listProduct, fetchCreateNewProduct, listManufacturer } = props;
    // 
    // console.log("NewProductModal", listProduct);
    let handleClose = () => {
        clickClose()
    }
    let handleCreateInModal = (productNew) => {
        fetchCreateNewProduct(productNew)

    }
    return (
        <Container>
            <br />
            <Modal isOpen={showForm}>
                <ModalHeader>
                    <h3>Create New Product</h3>
                </ModalHeader>
                <ModalBody>
                    <InputForm handleCreateInModal={handleCreateInModal} listManufacturer={listManufacturer} />
                </ModalBody>
                <ModalFooter>
                    <Button color="danger" onClick={handleClose}>Close</Button>
                </ModalFooter>
            </Modal>
        </Container>
    );
}

export default NewProductModal;