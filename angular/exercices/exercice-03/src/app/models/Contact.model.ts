class Contact {
    public static count = 0

    id: number

    constructor(
        public firstname: string,
        public lastname: string,
        public email: string,
        public phoneNumber: string,
        public age: number
    ) {
        this.id = ++Contact.count
    }
}

export default Contact