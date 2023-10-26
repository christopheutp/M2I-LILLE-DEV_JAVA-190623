class Mammal {
    static count = 0;
    _name;
    _breed;
    _age;
    constructor(name, breed, age) {
        ++Mammal.count;
        this._name = name;
        this._breed = breed;
        this._age = age;
    }
    get name() {
        return this._name;
    }
    set name(v) {
        this._name = v;
    }
    set age(v) {
        if (v > 0) {
            this._age = v;
        }
    }
}
export default Mammal;
