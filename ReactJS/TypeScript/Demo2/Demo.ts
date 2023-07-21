// import { Person, myName } from "./Person";

import { Mentor } from "./Mentor";
import { Person } from "./Person";

// var person1 = new Person();
// person1.setId(1);
// person1.setName("person 1");
// person1.setAddress("HN");

console.log("--------------Person1-----------");
// console.log(`ID: ${person1.id}, name: ${person1.name}, Address: ${person1.address}`);
// person1.showInfo();

console.log("------------------------------------------------------");
// Tạo ra các intance mentor và student
var mentor1 = new Mentor(1, "mentor1", "HN", "10");
var mentor2 = new Mentor(1, "mentor2", "HCM", "8");
var mentor3 = new Mentor(1, "mentor3", "DN", "15");

// mentor1.showInfoMentor();
// mentor2.showInfoMentor();
// mentor3.showInfoMentor();

// Tạo ra 1 mảng dữ liệu để quản lý mentor
var mentorArray: Mentor[];
mentorArray = [mentor1, mentor2, mentor3];
mentorArray.forEach((mentor) => {
  mentor.showInfoMentor();
});
// tạo vòng lặp, lặp qua từng phần tử
