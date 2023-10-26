abstract class Mammal {
    public static count = 0

    protected _name: string
    protected _breed: string
    protected _age: number

    constructor(name: string, breed: string, age: number) {
        ++Mammal.count
        this._name = name
        this._breed = breed
        this._age = age
    }

    
    public get name() : string {
        return this._name
    }

    
    public set name(v : string) {
        this._name = v;
    }

    public set age(v: number) {
        if (v > 0) {
            this._age = v
        }
    }
    
    
    
}

export default Mammal