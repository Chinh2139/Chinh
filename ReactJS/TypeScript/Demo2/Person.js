"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.myName = exports.Person = void 0;
// tạo class 
var Person = /** @class */ (function () {
    // Tạo contructoer k tham số
    // constructor(){}
    // Tạo 1 contructor có 3 tham số
    function Person(id, name, address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }
    // phương thức
    Person.prototype.go = function () {
        console.log("".concat(this.id, "I can go!!!"));
    };
    Person.prototype.showInfo = function () {
        console.log("ID: ".concat(this.id, ", name: ").concat(this.name, ", Address: ").concat(this.address));
    };
    // Khai baso getter setter
    Person.prototype.getId = function () {
        return this.id;
    };
    Person.prototype.setId = function (id) {
        return this.id = id;
    };
    Person.prototype.getName = function () {
        return this.name;
    };
    Person.prototype.setName = function (name) {
        return this.name = name;
    };
    Person.prototype.getAddress = function () {
        return this.address;
    };
    Person.prototype.setAddress = function (address) {
        return this.address = address;
    };
    return Person;
}());
exports.Person = Person;
var myName = "ken";
exports.myName = myName;
// Demo
// var person1 = new Person();
// person1.id = 1;
// person1.name = "person 1";
// person1.address = "HN";
// var person2 = new Person();
// person2.id = 1;
// person2.name = "person 1";
// person2.address = "HCm";
// var person3 = new Person();
// person3.id = 1;
// person3.name = "person 1";
// person3.address = "Dn";
// console.log("--------------Person1-----------");
// console.log(`ID: ${person1.id}, name: ${person1.name}, Address: ${person1.address}`);
// console.log("--------------Person1-----------");
// console.log(`ID: ${person2.id}, name: ${person2.name}, Address: ${person2.address}`);
// console.log("--------------Person1-----------");
// console.log(`ID: ${person3.id}, name: ${person3.name}, Address: ${person3.address}`);
