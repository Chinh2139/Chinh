// higher order function HOF
// 1 hàm có thể nhận 1 hàm khác làm tham số và sau khi xử lỹ xong thì có thể trả ra 1 hàm khác
// Viết 1 chương trình tính toán
function sum(a, b) {
    return a + b;
}
function minus(a, b) {
    return a - b;
}
function multiply(a, b) {
    return a * b;
}
var sumResult = sum(12, 41);
console.log("sum(a,b): ", sumResult);
// HOF
// js cho phép truyền số, chuỗi, object, hàm (function) làm tham số đầu vào
function calculate(a_param, b_param, function_operator) {
    var result = function_operator(a_param, b_param);
    return result;
}
// Sử dụng HÒ
console.log("---------------------------------");
// Tổng của 10 và 20
var v_result = calculate(10, 20, sum);
