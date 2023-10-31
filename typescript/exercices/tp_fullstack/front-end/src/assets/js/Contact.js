class Contact {
    firstname;
    lastname;
    email;
    birthDate;
    phoneNumber;
    id;
    constructor(id, firstname, lastname, email, birthDate, phoneNumber) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.id = id;
    }
}
export default Contact;
