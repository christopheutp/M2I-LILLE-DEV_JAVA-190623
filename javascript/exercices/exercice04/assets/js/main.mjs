const secondLine = document.querySelector('#result-display > span:last-child')
const firstLine = document.querySelector('#result-display > span:first-child')

document.querySelector('#ac').addEventListener('click', () => {
    for (const child of document.querySelector('#result-display').children) {
        child.textContent = ""
    }
})

document.querySelectorAll('.number-btn').forEach(node => node.addEventListener('click', () => {
    

    secondLine.textContent += node.textContent

    secondLine.style.fontSize = (8 - secondLine.textContent.length * 0.2) + "ch"
}))

const putToFirstLine = () => {
    firstLine.textContent += secondLine.textContent
    secondLine.textContent = ""
}

document.querySelectorAll('.operation-btn').forEach(node => node.addEventListener('click', () => {
    secondLine.textContent += node.textContent
    putToFirstLine()
}))

document.querySelector('#equal').addEventListener('click', () => {
    putToFirstLine()
    try {
        const result = eval(firstLine.textContent)
        secondLine.textContent = result
    } catch (error) {
        console.error(error);
        secondLine.textContent = "Err"
    }
})

document.querySelector('#dot').addEventListener('click', () => {
    if (!secondLine.textContent.endsWith('.')) {
        secondLine.textContent += "."
    } else {
        secondLine.textContent = secondLine.textContent.slice(0, secondLine.textContent.length - 1)
    }
})

document.querySelectorAll('.parenthesis').forEach(node => node.addEventListener('click', () => {
    secondLine.textContent += node.textContent
}))