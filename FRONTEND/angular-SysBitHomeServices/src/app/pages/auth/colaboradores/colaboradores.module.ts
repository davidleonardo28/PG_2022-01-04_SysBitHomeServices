import { ColaboradoresComponent } from './colaboradores.component';
import { ColaboradoresRoutingModule } from './colaboradores-routing.module';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';



@NgModule({
  declarations: [
    ColaboradoresComponent
  ],
  imports: [
    CommonModule,
    ColaboradoresRoutingModule
  ]
})
export class ColaboradoresModule { }
