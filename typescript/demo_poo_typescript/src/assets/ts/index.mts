import Cat from "./Cat.js";
import Dog from "./Dog.js"

const bernie = new Dog("Bernie", "Labrador", 7)
const rex = new Dog("Rex", "Doberman", 4)
const berlioz = new Cat("Berlioz", "Angora", 2, false)

bernie.age = -14

console.log(bernie);


console.log(Dog.count);

console.log(bernie.name);


console.log(bernie);