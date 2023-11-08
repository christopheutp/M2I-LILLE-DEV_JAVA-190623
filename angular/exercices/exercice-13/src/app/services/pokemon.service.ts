import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { of } from 'rxjs'
import { map, catchError } from 'rxjs/operators'
import Pokemon from '../models/pokemon.model';

const BASE_URL = "https://pokeapi.co/api/v2/"

@Injectable({
  providedIn: 'root'
})
export class PokemonService {

  constructor(
    private http: HttpClient
  ) { }

  getPokemonByNameOrId(value: number | string) {
    return this.http.get<any>(`${BASE_URL}pokemon/${value}`)
    .pipe(
      catchError(err => of(err)),
      map(data => ({
        id: data.id,
        name: data.name,
        weight: data.weight,
        height: data.height,
        pictureURL: new URL(data.sprites.front_default),
        types: data.types.map((t: any) => ({slot: t.slot, name: t.type.name})),
        abilities: data.abilities.map((a: any) => ({slot: a.slot, name: a.ability.name}))
      } as Pokemon))
    )
  }
}
