import React from "react";
import {
    Form,
    Row,
    Col,
    FormGroup,
    Label,
    Input,
    Button,
    Container,
} from "reactstrap";
import { NavLink } from "react-router-dom";
function Login(props) {
    return (
        <Container>
            <Form>
                <Row style={{ display: "block" }}>
                    <Col md={6}>
                        <FormGroup>
                            <Label for="exampleEmail">Email</Label>
                            <Input
                                id="exampleEmail"
                                name="email"
                                placeholder="with a placeholder"
                                type="email"
                            />
                        </FormGroup>
                    </Col>
                    <Col md={6}>
                        <FormGroup>
                            <Label for="examplePassword">Password</Label>
                            <Input
                                id="examplePassword"
                                name="password"
                                placeholder="password placeholder"
                                type="password"
                            />
                        </FormGroup>
                    </Col>
                </Row>
                <FormGroup check>
                    <Input id="exampleCheck" name="check" type="checkbox" />
                    <Label check for="exampleCheck">
                        Remember me
                    </Label>
                </FormGroup>
                <NavLink to={"/Home"}>
                    <Button>Sign in</Button>
                </NavLink>
                <br></br>
                {/* <NavLink to={"/SignUp"}>
                    <Button>Sign up</Button>
                </NavLink> */}
            </Form>
        </Container>
    );
}

export default Login;
