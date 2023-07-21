export class Staff {
  private name: string;
  private age: number;
  private gender: boolean;
  private address: string;

  // Khai báo getter, setter
  public getName(): string {
    return this.name;
  }

  public getAge(): number {
    return this.age;
  }

  public getGender(): boolean {
    return this.gender;
  }

  public getAddress(): string {
    return this.address;
  }

  public setName(value: string) {
    this.name = value;
  }

  public setAge(value: number) {
    this.age = value;
  }

  public setGender(value: boolean) {
    this.gender = value;
  }

  public setAddress(value: string) {
    this.address = value;
  }
  // contructor
  constructor(name: string, age: number, gender: boolean, address: string) {
    this.name = name;
    this.age = age;
    this.gender = gender;
    this.address = address;
  }
  // Phương thức
  // Chức năng thêm mới

  addStaff(): void {
    console.log("---------Bạn muốn thêm vị trí nào---------------");
    console.log("---------1. Thêm mới nhân viên------------------");
    console.log("---------2. Thêm mới công nhân------------------");
    console.log("---------3. Thêm mới kỹ sư----------------------");
    console.log("---------4. Thêm mới cán bộ---------------------");
    EmployeeArray: [];
    var key = document.getElementById("");
    switch (key) {
      case 1:
        console.log("Thêm mới nhân viên");
        console.log(" Mời bạn nhập vào tên nhân viên");

        break;
      case 2:
        console.log("Thêm mới công nhân");

        break;
      case 3:
        console.log("Thêm mới kỹ sư");

        break;
      case 4:
        console.log("Thêm mới cán bộ");

        break;

      default:
        break;
    }
  }
}
