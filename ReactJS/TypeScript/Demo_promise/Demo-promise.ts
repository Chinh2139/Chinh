// let promiseCheckEmail = new Promise((resolve,reject)=>{
//     if (condition) {
//         resolve(val);
//     } else {
//         reject(err);
//     }
// })
//   .then(step2)
//   .then(step3)
//   .catch((err)=>{console.log(err)});

// Khai báo ra Promise
let promiseCheckEmail = new Promise(function (resolve, reject) {
  //   $.ajax({
  //     type: "GET",
  //     url: "url",
  //     data: "data",
  //     dataType: "dataType",
  //     success: function (data) {
  let resultCheckEmail = true;
  if (true) {
    resolve(" Check email thành công, chưa có email này trên hệ thống!");
  } else {
    reject(" Email đã có, hãy lựa chọn email khác!");
  }
  //     },
  //   });
});

// Sử dụng
promiseCheckEmail.then(
  // Trong Th trả về Resolve
  function () {
    // check username
    console.log(" Email chưa tồn tại!");
  },
  // Th trả về reject
  function () {
    console.log("Email đã tồn tại!");
  }
);
