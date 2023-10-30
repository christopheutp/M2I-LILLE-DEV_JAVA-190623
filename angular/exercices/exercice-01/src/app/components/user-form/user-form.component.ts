import { Component } from '@angular/core';

@Component({
  selector: 'app-user-form',
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.css']
})
export class UserFormComponent {
  firstname = ""
  lastname = ""
  age = 0


  changeFirstnameHandler(event: Event) {
    const inputValue = (event.target as HTMLInputElement).value
    this.firstname = inputValue
  }

  changeLastnameHandler(event: Event) {
    const inputValue = (event.target as HTMLInputElement).value
    this.lastname = inputValue
  }

  changeAgeHandler(event: Event) {
    const inputValue = +(event.target as HTMLInputElement).value
    this.age = inputValue
  }

  submitFormHandler (event: Event) {
    event.preventDefault()

    const newUser = {
      firstname: this.firstname,
      lastname: this.lastname,
      age: this.age
    }

    console.log(newUser);

    this.firstname = ""
    this.lastname = ""
    this.age = 0
    
  }
}
