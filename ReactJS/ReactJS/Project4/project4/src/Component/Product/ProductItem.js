import React from "react";
import { Button } from "reactstrap";
function ProductItem(props) {
    let { listProduct, deleteProduct, onHandleClickEdit } = props;
    // Hàm xử lý khi nhấn delete product
    let handleDeleteProduct = (product) => {
        alert("bạn chắc chắn muốn xóa sản phẩm này???")
        deleteProduct(product.id);
    };
    // Hàm xử lý khi nhấn Edit
    let handleClickEdit = (product) => {
        onHandleClickEdit(product);
    };

    let items = "";
    if (listProduct) {
        items = listProduct.map((product, index) => {
            return (
                <tr key={index}>
                    <td>{product.id}</td>
                    <td>{product.name}</td>
                    <td>{product.info}</td>
                    <td>
                        <img
                            src={"Asset/uploadImage/" + product.imageName}
                            alt="NoImage"
                            style={{ width: "100px", heigh: "100px" }}
                        />
                    </td>
                    <td style={{ textAlign: "center" }}>{product.manufacturerName}</td>
                    <td>{product.price}</td>
                    <td style={{ textAlign: "center" }}>{product.ratingStar}</td>
                    <td>
                        <Button color="warning" onClick={() => handleClickEdit(product)}>
                            Edit
                        </Button>
                    </td>

                    <td>
                        <Button color="danger" onClick={() => handleDeleteProduct(product)}>
                            Delete
                        </Button>
                    </td>
                </tr>
            );
        });
    }
    return items;
}

export default ProductItem;
