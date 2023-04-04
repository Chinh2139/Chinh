// Hàm xử lý khi nhấn Register
//function registerclick() {
// console.log("Nhập các thông tin sau đây");
// window.open("Register.html", "_self");
//Window.open("Register.html");
//}
// Hàm xử lý khi nhấn nút reset
function handleReset() {
  //console.log("reset");
  document.getElementById("fullname").value = "";
  document.getElementById("email").value = "";
  document.getElementById("password").value = "";
  document.getElementById("confirm").value = "";
  document.getElementById("Birthday").value = "";
}
// Hàm xử lý khi nhấn Register
function registerclick() {
  var v_fullname = document.getElementById("fullname").value;
  var v_email = document.getElementById("email").value;
  var v_password = document.getElementById("password");
  var v_birthday = document.getElementById("Birthday").value;
  console.log("fullname: ", v_fullname);
  console.log("Email:", v_email);
  console.log("password:", v_password);
  console.log("birthday:", v_birthday);

  // Kiểm tra dữ liệu
  var user = {
    full_name: v_fullname,
    email: v_email,
    password: v_password,
    birthday: v_birthday,
  };
  // Lưu trữ dữ liệu vào localstorage
  localStorage.setItem("user", JSON.stringify(user));
  handleReset();
  alert("Chúc mừng bạn đăng kí thành công");
  window.open("login.html", "_self");
}

function loginhandle() {
  var v_username = document.getElementById("Username_ID").value;
  var v_passwordlogin = document.getElementById("Password_ID").value;
  console.log("username;", v_username);
  console.log("password_login:", v_passwordlogin);
  // So sánh thoog tin người dùng nhập với DB
 var user_DB =  JSON.parse(localStorage.getItem("user"));
 if (v_username == user_DB.v_email&& v_passwordlogin== user_DB.v_password) {
    
 }
 else{
    alert("thông tin chưa chính xác");
    return;
 }
}
