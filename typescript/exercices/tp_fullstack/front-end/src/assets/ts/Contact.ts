class Contact {
    public id?: string

    constructor(
        id: string | undefined,
        public firstname: string,
        public lastname: string,
        public email: string,
        public birthDate: Date,
        public phoneNumber: string
    ) {
        this.id = id
    }    
}

export default Contact