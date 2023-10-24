let counter = 0

class Todo {
    constructor(description, dueDate) {
        this.id = ++counter
        this.description = description
        this.dueDate = dueDate
    }
}

export default Todo