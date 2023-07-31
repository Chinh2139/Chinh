import React from "react";
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
import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
function Login(props) {
    // Khai báo các state để lưu trữ dữ liệu cho các ô nhập liệu
    let [Email, setEmail] = useState("");
    let [Password, setPassword] = useState("");
    // Hàm hook xử lý khi login đúng
    let navigate = useNavigate();
    // Hàm xử lý khi nhấn nút login
    let handleLogin = () => {
        let user_localStorage = JSON.parse(localStorage.getItem("user_new"));
        if (
            user_localStorage.Email === Email &&
            user_localStorage.Password === Password
        ) {
            alert("Đăng nhập thành công");
            let user_login = {
                Email: Email,
                Password: Password,
            };
            localStorage.setItem("user_login", JSON.stringify(user_login));
            navigate("/Home");
        } else {
            navigate("/Sign_up");
        };
    };
    // useEffect(() => {
    //     let user_login = JSON.parse(localStorage.getItem("user_login"));
    //     if (user_login) {
    //         // TH này khi User đã login sẽ chuyển tới trang home
    //         return navigate("/ProductManagement");
    //     }
    // }, []);

    return (
        <Container>
            <Form>
                <Row
                    className="row-cols-lg-auto g-3 align-items-center"
                    style={{ display: "block", width: "25rem" }}
                >
                    <Col>
                        <FormGroup>
                            <Label>Email</Label>
                            <Input
                                id="exampleEmail"
                                name="email"
                                placeholder="Input Email"
                                type="email"
                                value={Email}
                                onChange={(e) => setEmail(e.target.value)}
                            />
                        </FormGroup>
                    </Col>
                    <Col>
                        <FormGroup>
                            <Label>Password</Label>
                            <Input
                                id="examplePassword"
                                name="password"
                                placeholder="Input PassWord"
                                type="password"
                                value={Password}
                                onChange={(e) => setPassword(e.target.value)}
                            />
                        </FormGroup>
                    </Col>
                    <Col>
                        <FormGroup check>
                            <Input id="exampleCheckbox" name="checkbox" type="checkbox" />
                            <Label check for="exampleCheckbox">
                                Remember Me
                            </Label>
                        </FormGroup>
                    </Col>
                    <Col>
                        <Button color="success" onClick={handleLogin}>
                            Login
                        </Button>
                    </Col>
                </Row>
            </Form>
        </Container>
    );
}

export default Login;
