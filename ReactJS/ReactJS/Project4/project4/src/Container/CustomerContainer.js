import React from 'react';
import { Container } from "reactstrap";
import CreateButton from '../Component/Customer/CreateButton';
import ModalCreate from '../Component/Customer/CreateNewAccount/ModalCreate';
import ResultForm from '../Component/Customer/ResultForm';
import { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
function CustomerContainer(props) {
    // Khai báo hàm khi nhấn vào Click Button sẽ hiện ra Modal
    let [showModal, setshowModal] = useState(false)
    let handleClickButton = () => {
        // console.log("clicked");
        setshowModal(true)
    }
    // Khai báo hàm khi nhấn close Modal và đóng Modal
    let handleCloseModal = () => {
        setshowModal(false)
    }
    let fetchListCustomer = () => {

    }
    let navigate = useNavigate();
    useEffect(() => {
        let user_login = JSON.parse(localStorage.getItem("user_login"));
        if (!user_login) {
            return navigate("/Login");
        }

    }, []);
    return (
        <Container>
            {/* Nút thêm mới */}
            <CreateButton handleClickButton={handleClickButton} /><br />
            {/* Form thêm mới */}
            <ModalCreate showModal={showModal} handleCloseModal={handleCloseModal} />
            {/* Form kết quả */}
            <ResultForm />
        </Container>


    );
}

export default CustomerContainer;