import React, { useEffect, useState } from "react";
import { Button, Form, FormGroup, Label, Input } from "reactstrap";
function EditForm(props) {
    let { listManufacturer, selectedProduct, UpdateProduct } = props;
    //  Khai báo State lưu trữ giá trị của các ô input
    let [Name, setName] = useState("");
    let [Price, setPrice] = useState("");
    let [Info, setInfo] = useState("");
    let [Detail, setDetail] = useState("");
    let [ManufacturerName, setManufacturerName] = useState("");
    let [ImageName, setImageName] = useState("");
    let [ratingStar, setRatingStar] = useState("");

    let rowManufacturer = listManufacturer.map((manufacturer, index) => {
        return (
            <option value={manufacturer.id} key={index}>
                {manufacturer.name}
            </option>
        );
    });
    console.log("rowManufacturer: ", rowManufacturer);
    // Hàm xử lý lấy lại thông tin id của product cần update
    useEffect(() => {
        setName(selectedProduct.name);
        setPrice(selectedProduct.price);
        setInfo(selectedProduct.info);
        setManufacturerName(selectedProduct.manufacturerName);
        setRatingStar(selectedProduct.ratingStar);
        setDetail(selectedProduct.detail);
    }, []);

    // Hàm xử lý khi nhấn Update
    let handleUpdate = (selectedProduct) => {
        let productUpdate = {
            id: selectedProduct.id,
            name: Name,
            price: Price,
            info: Info,
            manufacturerId: ManufacturerName,
            imageName: ImageName,
            ratingStar: ratingStar,
            detail: Detail,
        };
        // console.log("productUpdate_editform: ", productUpdate);
        UpdateProduct(productUpdate);
    };

    // Hàm xử lý khi ấn Reset
    let handleReset = () => {
        setName("");
        setPrice("");
        setInfo("");
        setManufacturerName("");
        setRatingStar("");
        setDetail("");
    };
    return (
        <>
            <Form>
                {/* Email */}
                <FormGroup>
                    <Label>Product Name </Label>
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
                    <Input
                        id="ManufacturerName"
                        name="ManufacturerName"
                        type="select"
                        // value={ManufacturerName}
                        onChange={(event) => {
                            setManufacturerName(event.target.value);
                        }}>
                        <option>{ManufacturerName}</option>
                        {rowManufacturer}
                    </Input>

                </FormGroup>
                {/* ImageName */}
                <FormGroup>
                    <Label for="ImageName">ImageName: </Label>
                    <Input
                        id="ImageName"
                        name="ImageName"
                        type="file"
                        value={ImageName}
                        onChange={(event) => {
                            setImageName(event.target.value);
                        }}
                    ></Input>
                </FormGroup>
            </Form>
            {/* Nút xử lý */}
            <Button color="primary" onClick={() => handleUpdate(selectedProduct)}> Update</Button>
            <Button color="danger" onClick={handleReset}>Reset</Button>
        </>
    );
}

export default EditForm;
