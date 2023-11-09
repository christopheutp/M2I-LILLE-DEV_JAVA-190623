import { Component, OnDestroy } from '@angular/core';
import { AuthService } from './services/auth.service';
import User from './models/user.model';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnDestroy {
  title = 'demo-routing-fin';
  user: User | null = null
  userSub: Subscription | undefined

  constructor(
    private authService: AuthService
  ) {
    this.userSub = this.authService.user$.subscribe(user => this.user = user)
  }

  ngOnDestroy(): void {
    this.userSub?.unsubscribe()
    this.authService.logOut()
  }

  signIn() {
    this.authService.logIn()
  }

  signOut() {
    this.authService.logOut()
  }
}
