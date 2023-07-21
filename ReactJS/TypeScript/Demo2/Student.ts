import { Person } from "./Person";

class Student extends Person {
  private classVTI: string;
  private testcore: number;

  public getClassVTI(): string {
    return this.classVTI;
  }

  public getTestcore(): number {
    return this.testcore;
  }

  public setClassVTI(value: string) {
    this.classVTI = value;
  }

  public setTestcore(value: number) {
    this.testcore = value;
  }

  constructor(
    id: number,
    name: string,
    address: string,
    classVTI: string,
    testcore: number
  ) {
    super(id, name, address);
    this.classVTI = classVTI;
    this.testcore = testcore;
  }
}
export { Student };
