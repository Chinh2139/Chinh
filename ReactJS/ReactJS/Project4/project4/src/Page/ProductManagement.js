import React, { useEffect, useState } from "react";
import { Container } from "reactstrap";
import ProductForm from "../Component/Product/ProductForm";
import CreateNewProduct from "../Component/Product/ProductContainer/CreateNewProduct";
import NewProductModal from "../Component/Product/ProductContainer/NewProductModal";
import {
    addNewProductAPI,
    deleteProductAPI,
    getListProductAPI,
    updateProductAPI,
} from "../API/productAPI";
import { getListManufacturerAPI } from "../API/manufacturerAPI";
import ModalEdit from "../Component/Product/ProductContainer/ModalEdit";
import { useNavigate } from "react-router-dom";
function ProductManagement(props) {
    // Khai báo các State
    let [listProduct, setListProduct] = useState([]);
    let [showForm, setShowForm] = useState();
    let [listManufacturer, setlistManufacturer] = useState([]);
    let [showEditModal, setShowEditModal] = useState();
    let [selectedProduct, setSelectedProduct] = useState({});

    // Click Edit proudct hiện modal Edit
    let onHandleClickEdit = (product) => {
        setSelectedProduct(product);
        setShowEditModal(true);
    };
    // Click close ẩn Modal Edit
    let onHandleCloseEdit = () => {
        setShowEditModal(false);
    };

    // Click Create new Product Button hiện modal addProduct
    let clickCreatNewProduct = () => {
        setShowForm(true);
    };

    // Click close ẩn Modal addProduct
    let clickClose = () => {
        setShowForm(false);
    };

    // hàm list danh sách Manufacturer
    let fetchlistManufacturer = () => {
        getListManufacturerAPI().then((res) => {
            setlistManufacturer(res);
        });
    };

    // hàm list danh sách Product
    let fetchListProduct = () => {
        getListProductAPI().then((res) => {
            setListProduct(res);
        });
    };

    // Hàm xử lý tạo New product
    let fetchCreateNewProduct = (productNew) => {
        addNewProductAPI(productNew).then((res) => {
            setShowForm(false);
            fetchListProduct();
        });
    };
    //  Hàm xử lý khi update Product
    let UpdateProduct = (productUpdate) => {
        updateProductAPI(productUpdate).then((res) => {
            setShowEditModal(false);
            fetchListProduct();
            // console.log("productUpdate_productmanagement: ", productUpdate);
        })

    }
    // Hàm xử lý delete product
    let deleteProduct = (IdDelete) => {
        // console.log("IdDelete: ", IdDelete);
        deleteProductAPI(IdDelete).then((res) => {
            fetchListProduct();
        });
    };
    let navigate = useNavigate();
    useEffect(() => {
        let user_login = JSON.parse(localStorage.getItem("user_login"));
        if (!user_login) {
            return navigate("/Login");
        }
        fetchListProduct();
        fetchlistManufacturer();
    }, []);

    return (
        <Container>
            <CreateNewProduct clickCreatNewProduct={clickCreatNewProduct} />
            <NewProductModal
                showForm={showForm}
                clickClose={clickClose}
                listProduct={listProduct}
                fetchCreateNewProduct={fetchCreateNewProduct}
                listManufacturer={listManufacturer}
            />
            <ProductForm
                listProduct={listProduct}
                deleteProduct={deleteProduct}
                onHandleClickEdit={onHandleClickEdit}
            />
            <ModalEdit
                showEditModal={showEditModal}
                onHandleCloseEdit={onHandleCloseEdit}
                listManufacturer={listManufacturer}
                listProduct={listProduct}
                selectedProduct={selectedProduct}
                UpdateProduct={UpdateProduct}
            />
        </Container>
    );
}

export default ProductManagement;
