import { ContratantesComponent } from './contratantes.component';
import { ContratantesRoutingModule } from './contratantes-routing.module';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';



@NgModule({
  declarations: [
    ContratantesComponent
  ],
  imports: [
    CommonModule,
    ContratantesRoutingModule
  ]
})
export class ContratantesModule { }
