import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css']
})
export class FooterComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  
  goToUrl(): void {
    // window.location.href = 'https://mpago.li/1dFnchx';
    window.open('https://wa.me/message/PT7ESJEIP55UE1', '_blank');
  }
}
