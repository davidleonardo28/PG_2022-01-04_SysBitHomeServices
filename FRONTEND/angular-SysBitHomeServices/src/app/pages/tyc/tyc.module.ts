import { TycComponent } from './tyc.component';
import { TycRoutingModule } from './tyc-routing.module';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';



@NgModule({
  declarations: [
    TycComponent
  ],
  imports: [
    CommonModule,
    TycRoutingModule
  ]
})
export class TycModule { }
