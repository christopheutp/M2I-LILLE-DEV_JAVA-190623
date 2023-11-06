import { Component, OnInit, OnDestroy } from '@angular/core';
import { NameService } from 'src/app/services/name.service';
import { Subscription } from 'rxjs'

@Component({
  selector: 'app-name-display',
  templateUrl: './name-display.component.html',
  styleUrls: ['./name-display.component.css']
})
export class NameDisplayComponent implements OnInit, OnDestroy {
  names: string[] = []
  namesSub: Subscription | undefined

  constructor(
    private nameService: NameService
  ) {
    // this.names = this.nameService.names
  }

  ngOnInit(): void {
    this.namesSub = this.nameService.$names
    .subscribe({
      next: (names) => {
        this.names = names
      }
    })
  }

  ngOnDestroy(): void {
    if (this.namesSub) this.namesSub.unsubscribe()
  }

  
}
