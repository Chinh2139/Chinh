import { Staff } from "./Staff";

export class Worker extends Staff {
  private rank: number;

  public getRank(): number {
    return this.rank;
  }

  public setRank(value: number) {
    this.rank = value;
  }

  constructor(
    name: string,
    age: number,
    gender: boolean,
    address: string,
    rank: number
  ) {
    super(name, age, gender, address);
    this.rank = rank;
  }
}
