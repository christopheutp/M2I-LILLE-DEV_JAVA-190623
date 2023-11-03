import { Injectable } from '@angular/core'

import DataService from "./data.service";

@Injectable({
    providedIn: 'root'
})
class LogService {

    constructor(private dataService: DataService) { }

    sayHi() {
        console.log('Hello world!');
    }
}

export default LogService