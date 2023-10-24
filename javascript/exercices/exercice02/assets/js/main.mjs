import User from "./User.js";

const users = []

document.querySelector("form#form-users").addEventListener('submit', (event) => {
    event.preventDefault()

    const newUser = new User(
        document.querySelector('input#firstname').value,
        document.querySelector('input#lastname').value,
        document.querySelector('input#email').value,
        document.querySelector('input#password').value
    )

    users.push(newUser)

    console.log(users);

    document.querySelector('span#nb-users').textContent = users.length + " user(s)"
})