import Mammal from "./Mammal.js"

class Dog extends Mammal {
    public static count = 0

    private id: number

    constructor(name: string, breed: string, age: number) {
        super(name, breed, age)
        this.id = ++Dog.count
    }
}

export default Dog


