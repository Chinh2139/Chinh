import React from 'react';
import {
    Button,
    Modal,
    ModalHeader,
    ModalBody,
    ModalFooter,
} from "reactstrap";
import InputForm from "./InputForm";
function ModalCreate(props) {
    let { showModal, handleCloseModal } = props;

    let CloseModal = () => {
        handleCloseModal()
    }
    return (
        <Modal isOpen={showModal} >
            <ModalHeader>
                Create New Customer
            </ModalHeader>
            <ModalBody>
                <InputForm />
            </ModalBody>
            <ModalFooter>
                <Button color="danger" onClick={CloseModal}>Close</Button>
            </ModalFooter>
        </Modal>
    );
}

export default ModalCreate;