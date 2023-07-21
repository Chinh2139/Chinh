import { Person } from "./Person";

class Mentor extends Person {
  private yearOfExperience: string;
  public getyearOfExperience(): string {
    return this.yearOfExperience;
  }
  public setyearOfExperience(yearOfExperience: string) {
    return (this.yearOfExperience = yearOfExperience);
  }
  constructor(
    id: number,
    name: string,
    address: string,
    yearOfExperience: string
  ) {
    super(id, name, address);
    this.yearOfExperience = yearOfExperience;
  }
  public showInfoMentor(): void {
    console.log(
      `id: ${this.getId()}, name: ${this.getName()}, address: ${this.getAddress()}, YearOfExpencise: ${this.getyearOfExperience()}`
    );
  }
}
export { Mentor };
