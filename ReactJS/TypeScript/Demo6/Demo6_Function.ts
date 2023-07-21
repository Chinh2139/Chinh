// Tìm hiểu các cacsh khai báo 1 function
// Cách 1
function sum(a_param, b_param) {
  return a_param + b_param;
}
let result = sum(1, 2);
console.log("result: ", result);

// Cách 2: cho 1 biến tham chiếu tới 1 hàm
let v_sum = function (a_param, b_param) {
  return a_param + b_param;
};
let result1 = v_sum(3, 4);

// Cách 3: sử dụng Arror (=>) Function
// let v_sum_arror = (a_param, b_param) => {
//   return a_param + b_param;
// };

let v_sum_arror = (a_param, b_param) => a_param + b_param; // rút gọn

let result2 = v_sum_arror(10, 20);
console.log("result2: ", result2);
