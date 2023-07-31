import axios from "axios";
const axiosClient = axios.create({
    baseURL: "http://localhost:8080/api/v3/",
    headers: {
        "Content-Type": "application/json"
    },
});

export const api = (method, endpoint, payload) => {
    return axiosClient(endpoint, { method: method, data: payload }).then((res) => {
        return res.data;
    }).catch((error) => {
        console.log(error);
    })

}
