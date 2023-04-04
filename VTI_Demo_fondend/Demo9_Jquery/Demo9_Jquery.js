// Thao tác DOM
// Lấy thành phần trên DOM theo tên thẻ
// document.getElementsByTagName
var v_h1 = $("h1").text();
console.log(v_h1);

var v_h2 = $("#h2_id").text();
console.log("v_h2", v_h2);

var v_h3 = $(".h3_class").text();
console.log("v_h3", v_h3);

// Băt event trong Jquery
$("#Button1_Id").click(function () {
  console.log("Bạn vừa click vào nút button1!!!");
});

$(".Button_class").dbclick(function () {
console.log("Bạn vừa click vào nút Button2!!!");


});
//AJAX
