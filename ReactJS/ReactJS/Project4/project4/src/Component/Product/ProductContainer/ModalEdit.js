import React from "react";
import {
    Container,
    Button,
    Modal,
    ModalHeader,
    ModalBody,
    ModalFooter,
} from "reactstrap";
import EditForm from "./EditForm";
function ModalEdit(props) {
    let {
        showEditModal,
        onHandleCloseEdit,
        listManufacturer,
        selectedProduct,
        UpdateProduct,
    } = props;
    let handleClose = () => {
        onHandleCloseEdit();
    };

    return (
        <Container>
            <br />
            <Modal isOpen={showEditModal}>
                <ModalHeader>
                    <h3>Update product</h3>
                </ModalHeader>
                <ModalBody>
                    <EditForm
                        listManufacturer={listManufacturer}
                        selectedProduct={selectedProduct}
                        UpdateProduct={UpdateProduct}
                    />
                </ModalBody>
                <ModalFooter>
                    <Button color="danger" onClick={handleClose}>
                        Close
                    </Button>
                </ModalFooter>
            </Modal>
        </Container>
    );
}

export default ModalEdit;
