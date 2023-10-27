class Contact {
    _firstname;
    _lastname;
    _email;
    _phoneNumber;
    static count = 0;
    _id;
    constructor(_firstname, _lastname, _email, _phoneNumber) {
        this._firstname = _firstname;
        this._lastname = _lastname;
        this._email = _email;
        this._phoneNumber = _phoneNumber;
        this._id = ++Contact.count;
    }
    get id() {
        return this._id;
    }
    get firstname() {
        return this._firstname;
    }
    get lastname() {
        return this._lastname;
    }
    get email() {
        return this._email;
    }
    get phoneNumber() {
        return this._phoneNumber;
    }
}
export default Contact;
