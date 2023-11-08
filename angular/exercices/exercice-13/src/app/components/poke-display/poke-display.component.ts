import { Component, Input, OnChanges, SimpleChanges } from '@angular/core';
import Pokemon from 'src/app/models/pokemon.model';
import { PokemonService } from 'src/app/services/pokemon.service';

@Component({
  selector: 'app-poke-display',
  templateUrl: './poke-display.component.html',
  styleUrls: ['./poke-display.component.css']
})
export class PokeDisplayComponent implements OnChanges {
  @Input() pokeNameOrId: string | number = Math.ceil(Math.random() * 1017)

  currentPokemon: Pokemon | null = null

  constructor(
    private pokemonService: PokemonService
  ) { }

  ngOnChanges(changes: SimpleChanges): void {
    const that = this

    this.pokemonService
    .getPokemonByNameOrId(this.pokeNameOrId)
    .subscribe({
      next(value) {
        that.currentPokemon = value
      },
      error(err) {
        console.error(err);
        that.currentPokemon = null
      },
    })
  }

  nextPokemon() {
    if (this.currentPokemon) {
      this.pokeNameOrId = +this.currentPokemon.id + 1
    }
  }

  prevPokemon() {
    if (this.currentPokemon) {
      this.pokeNameOrId = +this.currentPokemon.id - 1
    }
  }

}
