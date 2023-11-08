import { Component } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { catchError, map } from 'rxjs'

interface Pokemon {
  name: string,
  id: number
}

interface PostAPIResponse {
  userId: number,
  id: number,
  title: string,
  body: string
}

type PokemonType = [
  name: string,
  id: number
]

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'demo-http';

  constructor (
    private http: HttpClient
  ) {
    let headers = {
      'Authorization': `Bearer ${this.getToken()}`
    }

    // let headersBis = new HttpHeaders()
    // headersBis = headersBis.append('Authorization', `Bearer ${this.getToken()}`)

    this.http.get<Pokemon>("https://pokeapi.co/api/v2/pokemon/ditto", {
      headers: new HttpHeaders()
      .set('Authorization', `Bearer ${this.getToken()}`)
    })
    // .pipe(
    //   map(data => {
    //     return {
    //       id: data.id,
    //       name: data.name
    //     }
    //   })
    // )
    .subscribe(data => {
      console.log(data.name);
      console.log(data);
            
    })

    this.http.post<PostAPIResponse>("https://jsonplaceholder.typicode.com/posts", {
      userId: 1,
      id: 22,
      title: "Mon Title",
      body: "Mon Body"
    },{
      params: new HttpParams()
      .set('limit', 20)
    }).subscribe({
      next: result => {
        console.log(result);
        localStorage.setItem('jwt', result.title)
      },
      error: error => {
        console.error(error);
        
      }
    })
  }

  storeToken(token: string) {
    const monChien = {
      name: "Bernie",
      age: 7,
      breed: "Labrador"
    }

    localStorage.setItem('jwtToken', token)
    localStorage.setItem('monChien', JSON.stringify(monChien))
  }

  getPokemon(value: string | number) {
    return this.http.get<Pokemon>("https://pokeapi.co/api/v2/pokemon/" + value, {
      headers: new HttpHeaders()
      .set('Authorization', `Bearer ${this.getToken()}`)
    })
  }

  logPokemon(value: string | number) {
    this.getPokemon(value)
    .subscribe(pokemon => console.log(pokemon));
  }

  getToken() {
    const token = localStorage.getItem('jwtToken')
    const leChien = localStorage.getItem('monChien') ?? "{}"
    const chienObj = JSON.parse(leChien)
    console.log("Token: " + token);
    console.log("Chien: ");
    console.log(chienObj);

    return token
  }

  removeToken() {
    localStorage.removeItem('jwtToken')
    localStorage.removeItem('monChien')
    localStorage.removeItem('jwt')
  }
}
