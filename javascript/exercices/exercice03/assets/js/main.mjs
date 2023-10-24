import Todo from "./Todo.js";

let mesTodos = []

document.querySelector('form#todo-form').addEventListener('submit', (event) => {
    event.preventDefault()

    const newTodo = new Todo(
        document.querySelector('form#todo-form input#description').value,
        new Date(document.querySelector('form#todo-form input#dueDate').value)
    )

    mesTodos = [...mesTodos, newTodo]
    
    const divElement = document.createElement('div')
    const descSpanElement = document.createElement('span')
    const dateSpanElement = document.createElement('span')
    const buttonElement = document.createElement('button')

    descSpanElement.textContent = newTodo.description
    dateSpanElement.textContent = newTodo.dueDate.toLocaleDateString()
    buttonElement.textContent = 'Complete'
    buttonElement.addEventListener('click', () => {
        mesTodos = mesTodos.filter(todo => todo != newTodo)
        divElement.remove()
    })

    divElement.appendChild(descSpanElement)    
    divElement.appendChild(dateSpanElement)    
    divElement.appendChild(buttonElement)
    
    document.querySelector('div#todo-display').appendChild(divElement)

    
})