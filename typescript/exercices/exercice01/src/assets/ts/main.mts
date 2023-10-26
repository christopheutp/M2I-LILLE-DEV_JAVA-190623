const myForm = document.querySelector('form#form-hello') as HTMLFormElement

myForm.addEventListener('submit', (event) => {
    event.preventDefault()

    const firstnameInput = document.querySelector('form#form-hello input#firstname') as HTMLInputElement
    const lastnameInput = document.querySelector('form#form-hello input#lastname') as HTMLInputElement

    const paragraphElement = document.querySelector('p#result') as HTMLParagraphElement

    paragraphElement.textContent = `Hello ${firstnameInput.value} ${lastnameInput.value}!`
})