import React from 'react';
import { Button, Form, FormGroup, Label, Input } from "reactstrap";
function InputForm(props) {

    return (
        <>
            <Form>
                {/* Email */}
                <FormGroup>
                    <Label for="Email">Email: </Label>
                    <Input
                        id="Email"
                        name="Email"
                        placeholder="Input Email"
                        type="email"
                    />
                </FormGroup>
                {/* Username */}
                <FormGroup>
                    <Label for="Username">Username: </Label>
                    <Input
                        id="Username"
                        name="Username"
                        placeholder="Input Username"
                        type="text"
                    />
                </FormGroup>


                {/* Fullname */}
                <FormGroup>
                    <Label for="Fullname">Fullname: </Label>
                    <Input
                        id="Fullname"
                        name="Fullname"
                        placeholder="Input Fullname"
                        type="text"
                    />
                </FormGroup>
                {/* mobile */}
                <FormGroup>
                    <Label for="Fullname">Mobile: </Label>
                    <Input
                        id="Mobile"
                        name="Mobile"
                        placeholder="Input Mobile"
                        type="text"
                    />
                </FormGroup>
                {/* Fullname */}
                <FormGroup>
                    <Label for="Address">Address: </Label>
                    <Input
                        id="Address"
                        name="Address"
                        placeholder="Input Address"
                        type="text"
                    />
                </FormGroup>


            </Form>
            {/* Nút xử lý */}
            <Button color="primary">Create</Button>
            <Button color="danger">Reset</Button>
        </>



    );
}

export default InputForm;