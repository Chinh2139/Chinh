import { Staff } from "./Staff";

export class Engineer extends Staff {
  private traning: string;

  public getTraning(): string {
    return this.traning;
  }

  public setTraning(value: string) {
    this.traning = value;
  }

  constructor(
    name: string,
    age: number,
    gender: boolean,
    address: string,
    traning: string
  ) {
    super(name, age, gender, address);
    this.traning = traning;
  }
}
