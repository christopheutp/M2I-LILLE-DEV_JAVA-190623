import Mammal from "./Mammal.js";
class Dog extends Mammal {
    static count = 0;
    id;
    constructor(name, breed, age) {
        super(name, breed, age);
        this.id = ++Dog.count;
    }
}
export default Dog;
