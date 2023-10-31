import Contact from "./Contact.js";

const BASE_URL = "http://localhost:8080/api/v1/contacts"
let mesContacts: Contact[] = []
let mode = 'add'

const deleteContact = async (contact: Contact) => {
    try {
        const response = await fetch(BASE_URL + `/${contact.id}`, {
            method: "DELETE"
        })

        if (response.status === 200) {
            afficheContact()
        }

    } catch (err) {
        console.error(err);
    }
}

const editContact = async (contact: Contact) => {
    const { id, ...contactDetails } = contact

    try {
        const response = await fetch(BASE_URL + `/${id}`, {
            method: "PATCH",
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                ...contactDetails,
                birthDate: contactDetails.birthDate.toISOString()
            })
        })

        if (response.status === 200) {
            afficheContact()
        }

    } catch (err) {
        console.error(err);
    }
}

const addContact = async (contact: Contact) => {
    
    try {
        const response = await fetch(BASE_URL, {
            method: "POST",
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                ...contact,
                birthDate: contact.birthDate.toISOString()
            })
        })

        if (response.status === 200) {
            afficheContact()
        }

    } catch (err) {
        console.error(err);
    }
}

const getContacts = async () => {
    try {
        const response = await fetch(BASE_URL)
        const data = await response.json() as Contact[]

        return data
    } catch (err) {
        console.error(err);
        return []
        
    }
}

const triContacts = async () => {
    mesContacts = await getContacts()

}

const afficheContact = async () => {
    document.querySelector('div#result')!.innerHTML = ""

    await triContacts()
    
    mesContacts.forEach((c, i) => {
        const divElement = document.createElement('div')

        const spanId = document.createElement('span')
        spanId.textContent = (i+1).toString()
        divElement.appendChild(spanId)

        const spanFullname = document.createElement('span')
        spanFullname.textContent = c.firstname + " " + c.lastname
        divElement.appendChild(spanFullname)

        const spanEmail = document.createElement('span')
        spanEmail.textContent = c.email
        divElement.appendChild(spanEmail)

        const spanPhoneNumber = document.createElement('span')
        spanPhoneNumber.textContent = c.phoneNumber
        divElement.appendChild(spanPhoneNumber)

        const btnDelete = document.createElement('button')
        btnDelete.textContent = 'Delete'
        btnDelete.addEventListener('click', () => {
            deleteContact(c)
        })
        divElement.appendChild(btnDelete)

        document.querySelector('div#result')?.appendChild(divElement)
    })
}

document.querySelector('#submit-contact')?.addEventListener('submit', async (event) => {
    event.preventDefault()
    
    const contactInfos = new Contact(
        undefined,
        (document.querySelector('input#firstname') as HTMLInputElement).value,
        (document.querySelector('input#lastname') as HTMLInputElement).value,
        (document.querySelector('input#email') as HTMLInputElement).value,
        new Date((document.querySelector('input#birthDate') as HTMLInputElement).value),
        (document.querySelector('input#phoneNumber') as HTMLInputElement).value
    )

    if (mode === 'add') {
        await addContact(contactInfos)
    } else if (mode === 'edit') {
        await editContact(contactInfos)
    }
})

document.querySelector('select#sort-type')?.addEventListener('change', () => {
    afficheContact()
})