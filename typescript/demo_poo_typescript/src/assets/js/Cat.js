import Mammal from "./Mammal.js";
class Cat extends Mammal {
    static count = 0;
    drinksMilk;
    constructor(name, breed, age, drinksMilk) {
        super(name, breed, age);
        this.drinksMilk = drinksMilk;
    }
}
export default Cat;
