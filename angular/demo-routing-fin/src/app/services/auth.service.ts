import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import User from '../models/user.model';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  user$ = new BehaviorSubject<User | null>(null)

  constructor(
    private router: Router
  ) {
    const token = localStorage.getItem('jwt')
    if (token) {
      console.log('Auto Login...');
  
      // Requête 
      const requestWorks = true
  
      if (requestWorks) {
        this.user$.next({
          name: 'Admin',
          email: 'admin@example.com'
        })
      }
    }
    
  }

  logIn() {
    // Requête 
    const requestWorks = true
  
    if (requestWorks) {
      this.user$.next({
        name: 'Admin',
        email: 'admin@example.com'
      })
      localStorage.setItem('jwt', 'abc')
    }
  }

  getToken() {
    return localStorage.getItem('jwt')
  }

  logOut() {
    this.user$.next(null)
    localStorage.removeItem('jwt')
    this.router.navigate(['/'])
  }
}
