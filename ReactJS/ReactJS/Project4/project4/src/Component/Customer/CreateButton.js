import React from 'react';
import { Container, Button } from "reactstrap";
function CreateButton(props) {
    let { handleClickButton } = props;
    let handClick = () => {
        handleClickButton()
    }
    return (
        <Container>
            <Button color="success" onClick={handClick}>
                CreateNewCustomer
            </Button>
        </Container>
    );
}

export default CreateButton;