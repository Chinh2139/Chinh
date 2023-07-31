import { api } from "./api";
//  get listProduct API
const getListCustomerAPI = () => {
    return api("GET", "customer", null);
};

//  add new product
const addNewCustomerAPI = (customerNew) => {
    return api("POST", "customer", customerNew);
};

// Delete Product
const deleteCustomerAPI = () => {
    let url = "customer/" + IdleDeadline;
    return api("DELETE", url, null);
};

//  Update Product
const updateCustomerAPI = (customerUpdate) => {
    let url = "customer/" + customerUpdate.id;
    return api("PUT", "customer/" + customerUpdate);
};

export {
    getListCustomerAPI,
    addNewCustomerAPI,
    deleteCustomerAPI,
    updateCustomerAPI,
};