import { api } from "./api";
//  get listProduct API
const getListProductAPI = () => {
    return api("GET", "RequestToProducts", null);
};

//  add new product
const addNewProductAPI = (productNew) => {
    return api("POST", "RequestToProducts", productNew);
};

// Delete Product
const deleteProductAPI = (IdDelete) => {
    let url = "RequestToProducts/" + IdDelete;
    return api("DELETE", url, null);
};

//  Update Product
const updateProductAPI = (productUpdate) => {
    let url = "RequestToProducts/" + productUpdate.id;
    return api("PUT", url, productUpdate);
};

export {
    getListProductAPI,
    addNewProductAPI,
    deleteProductAPI,
    updateProductAPI,
};