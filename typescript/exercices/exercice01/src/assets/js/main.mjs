const myForm = document.querySelector('form#form-hello');
myForm.addEventListener('submit', (event) => {
    event.preventDefault();
    const firstnameInput = document.querySelector('form#form-hello input#firstname');
    const lastnameInput = document.querySelector('form#form-hello input#lastname');
    const paragraphElement = document.querySelector('p#result');
    paragraphElement.textContent = `Hello ${firstnameInput.value} ${lastnameInput.value}!`;
});
export {};
