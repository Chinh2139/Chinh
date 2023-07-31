import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import {
    Form,
    Row,
    Col,
    Label,
    Input,
    FormGroup,
    Button,
    Container,
} from "reactstrap";
function Signup(props) {
    // Khai báo các state để lưu trữ dữ liệu cho các ô nhập liệu
    let [FullName, SetFullName] = useState("");
    let [Email, SetEmail] = useState("");
    let [Password, SetPassword] = useState("");
    let [RePassword, SetRePassword] = useState("");
    let [Birthday, SetBirthday] = useState("");
    let navigate = useNavigate();
    let handleRegister = () => {
        let user = {
            FullName: FullName,
            Email: Email,
            Password: Password,
            RePassword: RePassword,
            Birthday: Birthday,
        };
        if (user.Email === "") {
            alert("Mời nhập Email")
        } else if (user.Password === "") {
            alert("Mời nhập Password")
        } else if (user.Password !== user.RePassword) {
            alert("Mật khẩu xác nhận không khớp")
        }
        else {
            localStorage.setItem("user_new", JSON.stringify(user));
            navigate("/Login");
        }
    };
    return (
        <Container>
            <Form>
                <Row
                    className="row-cols-lg-auto g-3 align-items-center"
                    style={{ display: "block", width: "25rem" }}
                >
                    <Col>
                        <FormGroup>
                            <Label>FullName</Label>
                            <Input
                                id="exampleEmail"
                                name="email"
                                placeholder="Input FullName"
                                type="text"
                                value={FullName}
                                onChange={(e) => SetFullName(e.target.value)}
                            />
                        </FormGroup>
                    </Col>
                    <Col>
                        <Label>Email</Label>
                        <Input
                            id="exampleEmail"
                            name="email"
                            placeholder="Input Email"
                            type="email"
                            value={Email}
                            onChange={(e) => SetEmail(e.target.value)}
                        />
                    </Col>
                    <Col>
                        <Label>Password</Label>
                        <Input
                            id="examplePassword"
                            name="password"
                            placeholder="Input PassWord"
                            type="password"
                            value={Password}
                            onChange={(e) => SetPassword(e.target.value)}
                        />
                    </Col>
                    <Col>
                        <Label>Confirm PassWord</Label>
                        <Input
                            id="examplePassword"
                            name="password"
                            placeholder="Input PassWord"
                            type="password"
                            value={RePassword}
                            onChange={(e) => SetRePassword(e.target.value)}
                        />
                    </Col>
                    <Col>
                        <Label>DOB</Label>
                        <Input
                            id="examplePassword"
                            name="password"
                            placeholder="Input PassWord"
                            type="date"
                            value={Birthday}
                            onChange={(e) => SetBirthday(e.target.value)}
                        />
                    </Col>
                    <Col>
                        <Button color="success" onClick={handleRegister}>
                            Register
                        </Button>
                    </Col>
                </Row>
            </Form>
        </Container>
    );
}

export default Signup;
