// curyring function: đây là 1 kỹ thuật giúp cho chuyển đổi 1 function có nhiều tham số thành nhiều function có 1 tham số
function multiply(a, b, c) {
    return a * b * c;
}
var resultMultiply = multiply(1, 2, 3);
console.log("resultMultiply: ", resultMultiply);
// tạo ra 3 hàm có 1 tham số
function multiply_curring(a) {
    return function (b) {
        return function (c) {
            return a * b * c;
        };
    };
}
// Sử dụng
var multiply_curring_1 = multiply_curring(1);
var multiply_curring_2 = multiply_curring_1(2);
var result_123 = multiply_curring_2(3);
