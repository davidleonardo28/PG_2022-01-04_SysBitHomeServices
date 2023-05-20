import { FormContratantesComponent } from './components/pages/Contratantes/formcontratantes.component';
import { FormColaboradoresComponent } from './components/pages/colaboradores/formcolaboradores.component';
import { ContratantesComponent } from './../contratantes/contratantes.component';
import { ColaboradoresComponent } from './../colaboradores/colaboradores.component';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RegistroGeneralRoutingModule } from './registro-general-routing.module';
import {ReactiveFormsModule, FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { RegistroComponent } from './components/registro/registro.component';



@NgModule({
  declarations: [
    FormColaboradoresComponent,
    FormContratantesComponent,
    RegistroComponent
  ],
  imports: [
    CommonModule,
    RegistroGeneralRoutingModule,
    FormsModule,
    RouterModule,
    ReactiveFormsModule
  ]
})
export class RegistroGeneralModule { }
