import { Component, ElementRef, ViewChild } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  @ViewChild('pokeNameOrIdRef') pokeNameOrIdRef: ElementRef<HTMLInputElement> | undefined

  title = 'exercice-13';
  pokeNameOrId: string | number = 1

  submitHandler(event: Event) {
    event.preventDefault()

    
    if (this.pokeNameOrIdRef) {
      if (!isNaN(+this.pokeNameOrIdRef.nativeElement.value.trim())) {
        this.pokeNameOrId = +this.pokeNameOrIdRef.nativeElement.value.trim()
      } else {
        
        this.pokeNameOrId = this.pokeNameOrIdRef.nativeElement.value.trim()
      }
    }


  }
}
