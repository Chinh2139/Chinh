// tạo class 
class Person {
  // Thuộc tính
  private id:number;
  private name:string;
  private address: string;
  // phương thức
  go():void {
    console.log(`${this.id}I can go!!!`);
    
  }
  showInfo():void{
    console.log(`ID: ${this.id}, name: ${this.name}, Address: ${this.address}`);
  }
  // Khai baso getter setter
  public getId(): number{
    return this.id;
  }
  public setId(id: number){
    return this.id = id;
  }

  public getName(): string{
    return this.name;
  }
  public setName(name: string){
    return this.name = name;
  }

  public getAddress(): string{
    return this.address;
  }
  public setAddress(address: string){
    return this.address= address;
  }
  // Tạo contructoer k tham số
  // constructor(){}
  // Tạo 1 contructor có 3 tham số
  constructor(id:number, name:string, address:string){
    this.id = id;
    this.name=name;
    this.address = address;
  }
}
let myName = "ken"
export {Person, myName};



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