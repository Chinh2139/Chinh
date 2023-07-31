import React, { useState } from 'react';
import { Button, Form, FormGroup, Label, Input } from "reactstrap";
// import { generateID } from "../../../Utils/Helpers/generateId";
// import { getNowDate } from "../../../Utils/Helpers/getNowDate";
function InputForm(props) {
    let { handleCreateInModal, listManufacturer } = props;
    // Hàm xử lý khi click vào Create, tạo 1 account new từ dữ liệu người dùng
    //  nhập vào
    let rowManufacturer = listManufacturer.map((manufacturer, index) => {
        return (
            <option value={manufacturer.id} key={index}>{manufacturer.name}</option>
        )
    })
    // hàm xử lý khi nhấn Create
    let handleCreate = () => {
        let productNew = {
            // id: generateID(),
            name: Name,
            price: Price,
            info: Info,
            manufacturerId: ManufacturerName,
            imageName: ImageName,
            ratingStar: ratingStar,
            detail: Detail,
            // createDate: getNowDate(),
        }
        handleCreateInModal(productNew)
    }
    //  Khai báo State lưu trữ giá trị của các ô input
    let [Name, setName] = useState("");
    let [Price, setPrice] = useState("");
    let [Info, setInfo] = useState("");
    let [Detail, setDetail] = useState("");
    let [ManufacturerName, setManufacturerName] = useState("");
    let [ImageName, setImageName] = useState("");
    let [ratingStar, setRatingStar] = useState("");

    // Hàm xử lý khi ấn Reset
    let handleReset = () => {
        setName("");
        setPrice("");
        setInfo("");
        setManufacturerName("");
        setRatingStar("");
        setDetail("");
    }
    return (
        <>
            <Form>
                {/* Email */}
                <FormGroup>
                    <Label >Product Name </Label>
                    <Input
                        id="Name"
                        name="Name"
                        placeholder="Input Product Name"
                        type="text"
                        value={Name}
                        onChange={(event) => {
                            setName(event.target.value);
                        }}
                    />
                </FormGroup>


                {/* Username */}
                <FormGroup>
                    <Label for="Price">Price </Label>
                    <Input
                        id="Price"
                        name="Price"
                        placeholder="Input Price"
                        type="text"
                        value={Price}
                        onChange={(event) => {
                            setPrice(event.target.value);
                        }}
                    />
                </FormGroup>


                {/* info */}
                <FormGroup>
                    <Label for="Info">Info: </Label>
                    <Input
                        id="Info"
                        name="Info"
                        placeholder="Input Info"
                        type="text"
                        value={Info}
                        onChange={(event) => {
                            setInfo(event.target.value);
                        }}
                    />
                </FormGroup>
                {/* detail */}
                <FormGroup>
                    <Label for="Detail">Detail: </Label>
                    <Input
                        id="Detail"
                        name="Detail"
                        placeholder="Input Detail"
                        type="text"
                        value={Detail}
                        onChange={(event) => {
                            setDetail(event.target.value);
                        }}
                    />
                </FormGroup>
                {/* ratingStar */}
                <FormGroup>
                    <Label for="ratingStar">Info: </Label>
                    <Input
                        id="ratingStar"
                        name="ratingStar"
                        placeholder="Input ratingStar"
                        type="text"
                        value={ratingStar}
                        onChange={(event) => {
                            setRatingStar(event.target.value);
                        }}
                    />
                </FormGroup>


                {/* ManufacturerName */}
                <FormGroup>
                    <Label for="ManufacturerName">ManufacturerName: </Label>
                    <Input id="ManufacturerName" name="ManufacturerName" type="select"
                        value={ManufacturerName}
                        onChange={(event) => {
                            setManufacturerName(event.target.value);
                        }}>
                        {rowManufacturer}
                    </Input>
                </FormGroup>
                {/* ImageName */}
                <FormGroup>
                    <Label for="ImageName">ImageName: </Label>
                    <Input id="ImageName" name="ImageName" type="file"
                        value={ImageName}
                        onChange={(event) => {
                            setImageName(event.target.value);
                        }}>
                    </Input>
                </FormGroup>
            </Form >
            {/* Nút xử lý */}
            < Button color="primary" onClick={handleCreate} > Create</Button >
            <Button color="danger" onClick={handleReset}>Reset</Button>

        </>
    );
}

export default InputForm;