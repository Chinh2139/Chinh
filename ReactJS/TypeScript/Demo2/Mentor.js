"use strict";
var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (Object.prototype.hasOwnProperty.call(b, p)) d[p] = b[p]; };
        return extendStatics(d, b);
    };
    return function (d, b) {
        if (typeof b !== "function" && b !== null)
            throw new TypeError("Class extends value " + String(b) + " is not a constructor or null");
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
Object.defineProperty(exports, "__esModule", { value: true });
exports.Mentor = void 0;
var Person_1 = require("./Person");
var Mentor = /** @class */ (function (_super) {
    __extends(Mentor, _super);
    function Mentor(id, name, address, yearOfExperience) {
        var _this = _super.call(this, id, name, address) || this;
        _this.yearOfExperience = yearOfExperience;
        return _this;
    }
    Mentor.prototype.getyearOfExperience = function () {
        return this.yearOfExperience;
    };
    Mentor.prototype.setyearOfExperience = function (yearOfExperience) {
        return (this.yearOfExperience = yearOfExperience);
    };
    Mentor.prototype.showInfoMentor = function () {
        console.log("id: ".concat(this.getId(), ", name: ").concat(this.getName(), ", address: ").concat(this.getAddress(), ", YearOfExpencise: ").concat(this.getyearOfExperience()));
    };
    return Mentor;
}(Person_1.Person));
exports.Mentor = Mentor;
