// Destruturing với Object
let student1 = {
  id: 1,
  name: "daonq",
  age: 18,
};

// Cách thường
// let v_id = studen1.id;

// Sử dụng destructuring
// let { id: v_id } = studen1;
// console.log("v_id: ", v_id);

let { id: v_id, name: v_name, age: v_age } = studen1;

// Destruturing với array
let railway64Names = ["quyen", "phong", "vy"];

// let v_name1 = railway64Names[0];
// let v_name2 = railway64Names[1];
// let v_name3 = railway64Names[2];

let [v_name1, v_name2, v_name3] = railway64Names;
// Toán tử spread ... Operator
// let studen1 = {
//     id: 1,
//     name: "daonq",
//     age: 18,
//   };

// Bạn hãy tạo ra đối tượng student2
// id: 1,
// name: "daonq",
// age: 18,
// addresss: "HN",
// gender: "Male",

// let student2 = {
//   id: 1,
//   name: "daonq",
//   age: 18,
//   addresss: "HN",
//   gender: "Male",
// };

let student2 = {
  ...student1,
  addresss: "HN",
  gender: "Male",
};

// let railway64Names = ["quyen", "phong", "vy"];

let railway64Names_update = [...railway64Names, "tien", "thanh"];
