import { Component, Input, ViewChild, ElementRef, OnChanges, SimpleChanges, AfterViewInit, OnDestroy, OnInit, ContentChild, AfterContentInit } from '@angular/core';

@Component({
  selector: 'app-first',
  templateUrl: './first.component.html',
  styleUrls: ['./first.component.css']
})

/*
  Cycle de vie d'un composant: 
    * constructor
    * ngOnChanges (puis à chaque changement d'un @Input())
    * ngOnInit
    * ngAfterContentInit
    * ngAfterViewInit
    * ngOnDestroy
*/

export class FirstComponent implements OnChanges, 
AfterViewInit, 
OnDestroy,
OnInit,
AfterContentInit {
  @Input() text = "Texte par défaut"

  @ViewChild('firstname') firstnameRef!: ElementRef<HTMLInputElement>
  @ViewChild('lastname') lastnameRef!: ElementRef<HTMLInputElement>
  @ContentChild('age') ageElementRef!: ElementRef<HTMLInputElement>

  counter = 0
  interval: any

  constructor() {
    this.interval = setInterval(() => {
      console.log(++this.counter);
      
    }, 1000)

    console.log('Constructor called!');
    console.log('text: ' + this.text);
    console.log('firstnameRef: ' + this.firstnameRef);
    console.log('ageRef: ' + this.ageElementRef);
  }

  ngOnChanges(changes: SimpleChanges): void {
    console.log('ngOnChanges called!');
    console.log(changes);
    console.log('text: ' + this.text);
    console.log('firstnameRef: ' + this.firstnameRef);
    console.log('ageRef: ' + this.ageElementRef);

  }

  ngOnInit(): void {
    console.log('ngOnInit called!');
    console.log('text: ' + this.text);
    console.log('firstnameRef: ' + this.firstnameRef);
    console.log('ageRef: ' + this.ageElementRef);

  }

  ngAfterContentInit(): void {
    console.log('ngAfterContentInit called!');
    console.log('text: ' + this.text);
    console.log('firstnameRef: ' + this.firstnameRef);
    console.log('ageRef: ' + this.ageElementRef);
  }

  ngAfterViewInit(): void {
    console.log('ngAfterViewInit called!');
    console.log('text: ' + this.text);
    console.log('firstnameRef: ' + this.firstnameRef);
    console.log('ageRef: ' + this.ageElementRef);
  }

  ngOnDestroy(): void {
    console.log('ngOnDestroy called!');
    console.log('text: ' + this.text);
    console.log('firstnameRef: ' + this.firstnameRef);
    console.log('ageRef: ' + this.ageElementRef);

    clearInterval(this.interval)
  }

  logForm() {
    const user = {
      firstname: this.firstnameRef.nativeElement.value,
      lastname: this.lastnameRef.nativeElement.value
    }

    console.log(user);

    this.firstnameRef.nativeElement.value = ""
    this.lastnameRef.nativeElement.value = ""
    
  }
}
