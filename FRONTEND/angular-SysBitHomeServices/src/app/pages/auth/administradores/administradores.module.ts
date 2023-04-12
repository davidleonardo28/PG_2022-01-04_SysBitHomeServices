import { AdministradoresComponent } from './administradores.component';
import { AdministradoresRoutingModule } from './administradores-routing.module';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';



@NgModule({
  declarations: [
    AdministradoresComponent
  ],
  imports: [
    CommonModule,
    AdministradoresRoutingModule
  ]
})
export class AdministradoresModule { }
