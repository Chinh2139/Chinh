import { api } from "./api";
//  get Manufacturer API
const getListManufacturerAPI = () => {
    return api("GET", "manufacturer", null);
};

export { getListManufacturerAPI };