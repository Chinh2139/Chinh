// Rest param: khi số lượng tham số không được xác định

// function getHelloRailway63(name1: string, name2: string, name3: string) {
//   console.log(`hello ${name1}`);
//   console.log(`hello ${name2}`);
//   console.log(`hello ${name3}`);
// }
function getHelloRailway63(...names) {
  //names = mảng
  console.log("names: ", names);
  names.forEach((names) => {
    console.log(`Hello ${names}`);
  });
}
//
getHelloRailway63("cat", "quyen", "dien");
// hello cat
// hello quyen
// hello dien
getHelloRailway63("cat", "quyen", "dien", "tien");
getHelloRailway63("cat", "quyen", "dien", "tien", "duong");
