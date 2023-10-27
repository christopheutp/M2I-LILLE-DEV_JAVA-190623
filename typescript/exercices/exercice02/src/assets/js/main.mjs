import Contact from "./Contact.js";
const mesContacts = [];
// const mesContactsBis  = [] as Contact[]
const deleteContact = (contact) => {
    const index = mesContacts.findIndex(c => c === contact);
    mesContacts.splice(index, 1);
    afficheContact();
};
const triContacts = () => {
    // const selectElement = document.querySelector('select#sort-type') as HTMLSelectElement
    // const sortType = selectElement.value
    const sortType = document.querySelector('select#sort-type').value;
    switch (sortType) {
        case 'firstname':
            return mesContacts.sort((a, b) => {
                if (a.firstname > b.firstname)
                    return 1;
                else if (a.firstname < b.firstname)
                    return -1;
                else
                    return 0;
            });
        case 'lastname':
            return mesContacts.sort((a, b) => {
                if (a.lastname > b.lastname)
                    return 1;
                else if (a.lastname < b.lastname)
                    return -1;
                else
                    return 0;
            });
        case 'email':
            return mesContacts.sort((a, b) => {
                if (a.email > b.email)
                    return 1;
                else if (a.email < b.email)
                    return -1;
                else
                    return 0;
            });
        case 'phoneNumber':
            return mesContacts.sort((a, b) => {
                if (a.phoneNumber > b.phoneNumber)
                    return 1;
                else if (a.phoneNumber < b.phoneNumber)
                    return -1;
                else
                    return 0;
            });
        default:
            return mesContacts.sort((a, b) => a.id - b.id);
    }
};
const afficheContact = () => {
    document.querySelector('div#result').innerHTML = "";
    const contactsTries = triContacts();
    contactsTries.forEach(c => {
        const divElement = document.createElement('div');
        const spanId = document.createElement('span');
        spanId.textContent = c.id.toString();
        divElement.appendChild(spanId);
        const spanFullname = document.createElement('span');
        spanFullname.textContent = c.firstname + " " + c.lastname;
        divElement.appendChild(spanFullname);
        const spanEmail = document.createElement('span');
        spanEmail.textContent = c.email;
        divElement.appendChild(spanEmail);
        const spanPhoneNumber = document.createElement('span');
        spanPhoneNumber.textContent = c.phoneNumber;
        divElement.appendChild(spanPhoneNumber);
        const btnDelete = document.createElement('button');
        btnDelete.textContent = 'Delete';
        btnDelete.addEventListener('click', () => {
            deleteContact(c);
        });
        divElement.appendChild(btnDelete);
        document.querySelector('div#result')?.appendChild(divElement);
    });
};
document.querySelector('#submit-contact')?.addEventListener('submit', (event) => {
    event.preventDefault();
    const newContact = new Contact(document.querySelector('input#firstname').value, document.querySelector('input#lastname').value, document.querySelector('input#email').value, document.querySelector('input#phoneNumber').value);
    mesContacts.push(newContact);
    afficheContact();
});
document.querySelector('select#sort-type')?.addEventListener('change', () => {
    afficheContact();
});
