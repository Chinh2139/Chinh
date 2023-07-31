import React from 'react';
import { Container } from 'reactstrap';
import CustomerContainer from '../Container/CustomerContainer';

function CustomerManagement(props) {
    return (
        <Container>
            <h1 style={{ textAlign: "center", color: "green" }}>Danh sách khách hàng</h1>
            <CustomerContainer />
        </Container>
    );
}

export default CustomerManagement;