// hàm ghi log
console.log("Hello");
console.log("Chào bạn");

// Khai báo biến
var name = "Meme";
var age = 18;
var salary = 3000.0;
var gender = false;

console.log("tên của tôi là: ", name);
console.log("tên của tôi là: ", age);
console.log("tên của tôi là: ", salary);
console.log("tên của tôi là: ", gender);

// Hàm kiểm tra khai báo biến
// typeof
console.log("kiểu dữ liệu của biến name: ", typeof name);
console.log("kiểu dữ liệu của biến name: ", typeof age);
console.log("kiểu dữ liệu của biến name: ", typeof salary);
console.log("kiểu dữ liệu của biến name: ", typeof gender);

var numberA = 100;
var numberB = "10";
// 1 số hàm hay sử dụng
// Hàm chuyển đổi: parseInt, parseFloat

var sumAB = numberA + parseInt(numberB);
console.log("sumAB: ", sumAB);

//Hàm chuyển đổi sang kiểu chuối toString()
var numberC = numberA.toString();
console.log("Kiểu dữ liệu của biến numberC: ", typeof numberC);
// Hàm xử lý chuỗi
//Function
var num1 = 100;
var num2 = 50;
var sumresult = num1 + num2;
console.log("sumresult: ", sumresult);
// Khai báo 1 hàm trong js
function sum(num1, num2) {
  var sum = num1 + num2;
  return sum;
}

//Hàm xử lý click vào nút button
function handeleclickbutton1() {
  console.log("bạn vừa click vào button1");
}
//DOM
var h3tagdata = document.getElementsByTagName("h3")[0].innerHTML;
console.log("nội dung thẻ h3 là", h3tagdata);
function clicklogin() {
  var usename = document.getElementById("input_username").value;
  var password = document.getElementById("input_password").value;
  console.log("username", usename);
  console.log("password", password);
}
