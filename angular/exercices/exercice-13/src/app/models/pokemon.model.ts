interface Pokemon {
    id: number
    name: string
    weight: number
    height: number
    pictureURL: URL
    types: {slot: number, name: string}[]
    abilities: {slot: number, name: string}[]
}

export default Pokemon