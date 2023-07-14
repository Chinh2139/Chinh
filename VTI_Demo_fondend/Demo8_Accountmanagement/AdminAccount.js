// Khai báo mảng
var listAccount = [];
var listDepartment = [];
var listPosition = [];
var indexAccountUpdate = 0;
//Khai báo các biến page và size hiện tại
var currentPage = 1;
var currentSize = 2;

// Hàm thực thi khi load đầy đủ các thành phần html
getlistAccount();
getlistDepartment();
getlistPosition();
//Khai báo hàm hiển thị danh sách Account
function getlistAccount(params) {
  //1. Laấy được danh sách Account từ API
  $.ajax({
    type: "GET",
    url: `http://localhost:8080/ap1/v1/RequestToAccount?page=${currentPage}&size=${currentSize}`,
    // data: "data",
    dataType: "json",
    beforeSend: function (xhr) {
      xhr.setRequestHeader("Authorization", "Basic " + btoa("Username1:123456"));
    },
    success: function (response) {
      //response: Dữ liệu nhận được từ backend API
      console.log("response Account: ", response);
      listAccount = response.content;
      $("#table_ID").empty();
      for (let index = 0; index < listAccount.length; index++) {

        $("#table_ID").append(`<tr>
        <td>${listAccount[index].id}</td>
        <td>${listAccount[index].email}</td>
        <td>${listAccount[index].username}</td>
        <td>${listAccount[index].fullname}</td>
        <td>${listAccount[index].department}</td>
        <td>${listAccount[index].position}</td>   
        <td>${listAccount[index].createDate}</td>
        <td><button class="btn btn-warning" onclick="editAccount(${index})">Edit</button></td> 
        <td><button class="btn btn-danger" onclick="deleteAccount(${index})">Delete</button></td>
        </tr>
        `);
      }
      // Lấy ra totalpage
      var totalPages = response.totalPages;
      pagingTable(totalPages);
    },
  });
}
//   //Hiển thị nút previous


// Viết hàm tạo các nút phân trang
function pagingTable(totalPages_Param) {
  
  $("#pagination_ID").empty();
  if (currentPage > 1) {
    $("#pagination_ID").append(`<li onclick ="handlePrevious()"><a href="#">&laquo;</a></li>`);
  }
  for (let index = 1; index <= totalPages_Param; index++) {
    if (index == currentPage) {
      $("#pagination_ID").append(`
    <li class ="active"><a href="#" onclick = "handleChangePage(${index})">${index}</a></li>
 `);
    } else {
      $("#pagination_ID").append(`<li><a href="#" onclick = "handleChangePage(${index})">${index}</a></li>`)
    }

  }
  // Hiển thị nút next
  if (currentPage < totalPages_Param) {
    $("#pagination_ID").append(`<li onclick="handleNext()"><a href="#">&raquo;</a></li>`);
  }

}


// Viết hàm xử lý cho nút Previous
function handlePrevious(params) {
  curentPage = curentPage - 1;
  getListAccount();
}

// Viết hàm xử lý cho nút Next
function handleNext(params) {
  curentPage = curentPage + 1;
  getListAccount();
}

// function pagingTable(totalPages_Param) {



//   for (let index = 1; index <= totalPages_Param.length; index++) {
//     if (index == currentPage) {
// $("#pagination_ID").append(`<li class ="active"><a href="#" onclick = "handleChangePage(${index})">${index}</a></li>`);
//     } else {
//       $("#pagination_ID").append(`<li><a href="#">&raquo;</a></li>`);
//     }
//   }



// Viết hàm khi xử lý thay đổi trang
function handleChangePage(pageParam) {
  if (pageParam === currentPage) {
    return;

  } else {
    currentPage = pageParam;

  }
  getlistAccount();
}

function getlistDepartment(params) {
  $.ajax({
    type: "GET",
    url: "http://localhost:8080/ap1/v1/departments",
    // data: "data",
    dataType: "json",
    beforeSend: function (xhr) {
      xhr.setRequestHeader("Authorization", "Basic " + btoa("Username1:123456"));
    },
    success: function (response) {
      console.log("response Department: ", response);
      listDepartment = response;
      // $("#Department_ID").empty();
      for (let index = 0; index < listDepartment.length; index++) {
        $("#Department_ID").append(
          `<option value = "${listDepartment[index].id}">${listDepartment[index].name}</option>`
        );
      }
    },
  });
}

//Khai bao hàm hiển thị danh sách position
function getlistPosition(params) {
  $.ajax({
    type: "GET",
    url: "http://localhost:8080/ap1/v1/position",
    // data: "data",
    dataType: "json",
    success: function (response) {
      console.log("response position: ", response);
      listPosition = response;
      // $("#Department_ID").empty();
      for (let index = 0; index < listPosition.length; index++) {
        $("#Position_ID").append(
          `<option value = "${listPosition[index].id}">${listPosition[index].name}</option>`
        );
      }
    },
  });
}

$("#reset_btn").click(function () {
  // Xử lý sự kiện cho nút reset, Sử dụng JQuery để lấy các giá trị các trường theo ID, sau đó Set về rỗng
  $("#ID_ID").val("");
  $("#Email_ID").val("");
  $("#Username_ID").val("");
  $("#Fullname_ID").val("");
  $("#Department_ID").val("");
  $("#Position_ID").val("");
  $("#Cretate_Date_ID").val("");
});


// Add account vào array
// listAccount.push(account);
// Hàm này để hiển thị thông tin account ở table
// showAccount();
// return false;
// Sử dụng return false để không redirect tới 1 trang khác.
// });

// Thực hiện chức năng thêm mới  Account
// Disabled các trường id, createdate
$("#ID_ID").attr("disabled", "disabled");
$("#Create_Date_ID").attr("disabled", "disabled");
// Xử lý cho nút thêm mới
$("#save_btn").click(function (e) {
  // console.log("click!");
  // Lấy dữ liệu người dùng nhập vào
  // var v_ID_ID = $("#ID_ID").val();
  var v_Email_ID = $("#Email_ID").val();
  var v_Username_ID = $("#Username_ID").val();
  var v_Fullname_ID = $("#Fullname_ID").val();
  var v_Department_ID = $("#Department_ID").val();
  var v_Position_ID = $("#Position_ID").val();

  var account_new = {
    email: v_Email_ID,
    username: v_Username_ID,
    fullname: v_Fullname_ID,
    departmentId: v_Department_ID, //Bán hàng  ==> 11
    positionId: v_Position_ID, //Scrum_Master  ==> 4
  };

  // Call API để tạo mới Account
  $.ajax({
    type: "POST",
    url: "http://localhost:8080/ap1/v1/RequestToAccount",
    data: JSON.stringify(account_new),
    contentType: "application/json; charset=UTF-8",
    beforeSend: function (xhr) {
      xhr.setRequestHeader("Authorization", "Basic " + btoa("Username1:123456"));
    },
    success: function (response) {
      getlistAccount();// Hiển thị lại danh sách Account

    }
  });
});

// Viết hàm xóa account
function deleteAccount(IndexDel) {
  // Hiển thị 1 Confim Popup, chọn Có = True
  var confirm_del = confirm("Bạn có chắc chắn muốn xóa Account này không");
  if (confirm_del) {
    //   listAccount.splice(Index, 1);
    //   showAccount();
    // } else {
    //   return;
    var v_id_delete = listAccount[IndexDel].id;
    $.ajax({
      type: "DELETE",
      url: "http://localhost:8080/ap1/v1/RequestToAccount/" + v_id_delete,
      // data: "data",
      // dataType: "dataType",
      success: function (response) {
        getlistAccount();
      }
    });
  } else {
    return;
  }
}

// Viết hàm để Edit các account
function editAccount(IndexEdit) {
  // Dữ liệu trả về API dạng:s
  //   {
  //     "id": 6,
  //     "email": "Email6@gmail.com",
  //     "username": "Username6",
  //     "fullname": "Fullname6",
  //     "department": "Tài chính",
  //     "position": "Scrum_Master",
  //     "createDate": "2023-04-04"
  // }
  // Tìm ra id của Department
  var v_DepId;
  var v_PosId;
  for (let index = 0; index < listDepartment.length; index++) {
    if (listDepartment[index].name === listAccount[indexEdit].department) {
      v_DepId = listDepartment[index].id;
    }
  }
  // Tìm ra id của Position
  var v_PosId;
  for (let index = 0; index < listPosition.length; index++) {
    if (listPosition[index].name === listAccount[indexEdit].position) {
      v_PosId = listPosition[index].id;
    }
  }
  // Thưc hiện disabled các trường không cho người dùng cập nhật dữ liệu
  $("#ID_ID").attr("disabled", "disabled");
  $("#Email_ID").attr("disabled", "disabled");
  $("#Username_IDs").attr("disabled", "disabled");

  // thực hiện đổ các dữ liệu lên các ô nhập liệu


  $("#ID_ID").val(listAccount[IndexEdit].id);
  $("#Email_ID").val(listAccount[IndexEdit].email);
  $("#Username_ID").val(listAccount[IndexEdit].username);
  $("#Fullname_ID").val(listAccount[IndexEdit].fullname);
  $("#Department_ID").val(listAccount[IndexEdit].v_DepId);
  $("#Position_ID").val(listAccount[IndexEdit].v_PosId);
  $("#Cretate_Date_ID").val(listAccount[IndexEdit].createDate);
}


//  Xử lý sự kiện khi click vào nút Update
$("#update_btn").click(function () {
  // var v_ID_ID = $("#ID_ID").val(); // không cho người dùng sửa
  // var v_Email_ID = $("#Email_ID").val();
  // var v_Username_ID = $("#Username_ID").val();
  var v_Fullname_ID = $("#Fullname_ID").val();
  var v_Department_ID = $("#Department_ID").val();
  var v_Position_ID = $("#Position_ID").val();
  // var v_Cretate_Date_ID = $("#Cretate_Date_ID").val();

  // Tạo Account_update để truyền về backend (dữ liệu truyền về ở dạng json như trong API)
  var account_Update = {
    fullname: v_Fullname_ID,
    departmentId: v_Department_ID,
    positionId: v_Position_ID,
  };

  // Call API để update dữ liệu
  $.ajax({
    type: "PUT",
    url: "http://localhost:8080/ap1/v1/RequestToAccount/" + v_ID_ID,
    data: JSON.stringify(account_Update),
    contentType: "application/json; charset=UTF-8",
    success: function (response) {
      getlistAccount();

    },
  });
});

