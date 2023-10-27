class Contact {
    public static count = 0

    private _id: number

    constructor(
        private _firstname: string,
        private _lastname: string,
        private _email: string,
        private _phoneNumber: string
    ) {
        this._id = ++Contact.count
    }

    
    public get id() : number {
        return this._id
    }

    public get firstname() : string {
        return this._firstname
    }

    public get lastname() : string {
        return this._lastname
    }

    public get email() : string {
        return this._email
    }

    public get phoneNumber() : string {
        return this._phoneNumber
    }
    
}

export default Contact