var numberArray = [2, 4, 6, 8];
var numberArray_new: number[] = [];

// for each
numberArray.forEach((number) => {
  var number_new = number * 2;
  numberArray_new.push(number_new);
});

// cach 2
var numberArray_new_map = numberArray.map(function (number, index) {
  return number * 2;
});

console.log("numberArray_new_map: ", numberArray_new_map);
