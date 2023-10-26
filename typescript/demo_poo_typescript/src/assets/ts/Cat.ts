import Mammal from "./Mammal.js";

class Cat extends Mammal {
    public static count = 0

    private drinksMilk: boolean

    constructor(name: string, breed: string, age: number, drinksMilk: boolean) {
        super(name, breed, age)
        this.drinksMilk = drinksMilk
    }

}

export default Cat