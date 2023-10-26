const previousBtn = document.querySelector("#btn-prev")
const nextBtn = document.querySelector("#btn-next")

let currentPokemonId = 1

const toCapitilized = (text) => text.substring(0,1).toUpperCase() + text.substring(1).toLowerCase()

const getPokemonInfos = async (pokemonIdOrName) => {
    const url = `https://pokeapi.co/api/v2/pokemon/${pokemonIdOrName}`
    try {
        const response = await fetch(url)
        const data = await response.json()


        const {
            id,
            name,
            height,
            weight,
            types,
            abilities
        } = data

        currentPokemonId = id
        document.querySelector("#pokemon-name").textContent = toCapitilized(name)
        document.querySelector("#pokemon-weight").textContent = weight + "lbs"
        document.querySelector("#pokemon-height").textContent = height + '"'

        document.querySelector("#pokemon-types").innerHTML = ""


        types.forEach(type => {
            const liElement = document.createElement('li')
            liElement.textContent = toCapitilized(type.type.name)
            document.querySelector("#pokemon-types").appendChild(liElement)
        })

        document.querySelector("#pokemon-abilities").innerHTML = ""


        abilities.forEach(ability => {
            const liElement = document.createElement('li')
            liElement.textContent = toCapitilized(ability.ability.name)
            document.querySelector("#pokemon-abilities").appendChild(liElement)
        })

        document.querySelector('#pokemon-picture').src = `https://assets.pokemon.com/assets/cms2/img/pokedex/full/${id.toString().padStart(3, "0")}.png`

        getButtonsState()
    } catch (err) {
        console.error(err);
    }
}

nextBtn.addEventListener('click', () => {
    if (currentPokemonId < 1_017) {
        getPokemonInfos(++currentPokemonId)
    }
})

previousBtn.addEventListener('click', () => {
    if (currentPokemonId > 1) {
        getPokemonInfos(--currentPokemonId)
    }
})

document.querySelector('#search-form').addEventListener('submit', (e) => {
    e.preventDefault()

    const searchValue = document.querySelector('#search-form > input').value.trim()
    getPokemonInfos(searchValue)
})

const getButtonsState = () => {
    previousBtn.removeAttribute('disabled')
    nextBtn.removeAttribute('disabled')

    if (currentPokemonId === 1 && !previousBtn.getAttribute('disabled')) {
        previousBtn.setAttribute('disabled', "")
    }

    if (currentPokemonId === 1_017 && !nextBtn.getAttribute('disabled')) {
        nextBtn.setAttribute('disabled', "")
    }
}


getPokemonInfos(Math.ceil(Math.random() * 1_017))