import Post from "./Post.js"

const url = "https://jsonplaceholder.typicode.com/posts"

// fetch(url)
// .then(result => {
//     return result.json()
// })
// .then(data => {
//     console.log(data[4].body);
// })

const oneLiner = await (await fetch(url)).json()

let response
let data

try {
    response = await fetch(url)
    console.log(response);
} catch(err) {
    console.error(err);
}

try {
    data = await response.json()
} catch(err) {
    console.error(err);
}

console.log(data[4].body);
console.log(oneLiner[4].body);

const newPost = new Post(
    2,
    47,
    "Title A",
    "Body A"
)

try {
    response = await fetch(url, {
        method: "POST",
        headers: {
            "Authorization": "Bearer " + JWT ?? ""
        },
        body: JSON.stringify(newPost)
    })

    console.log(await response.json());
} catch (err) {
    console.error(err);
}


try {
    response = await fetch("http://localhost:8080/api/v1/demo")
    const data = await response.json()
    console.log(data);
} catch (err) {
    console.error(err);
}

try {
    response = await fetch("http://localhost:8080/api/v1/demo/other")
    const data = await response.json()
    console.log(data);
} catch (err) {
    console.error(err);
}