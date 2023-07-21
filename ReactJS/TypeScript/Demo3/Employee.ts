import { Staff } from "./Staff";

export class Employee extends Staff {
  private job: string;

  public getJob(): string {
    return this.job;
  }

  public setJob(value: string) {
    this.job = value;
  }

  constructor(
    name: string,
    age: number,
    gender: boolean,
    address: string,
    job: string
  ) {
    super(name, age, gender, address);
    this.job = job;
  }
}
