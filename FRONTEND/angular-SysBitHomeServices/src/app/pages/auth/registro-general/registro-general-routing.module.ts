import { RegistroComponent } from './components/registro/registro.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FormContratantesComponent } from './components/pages/Contratantes/formcontratantes.component';
import { FormColaboradoresComponent } from './components/pages/colaboradores/formcolaboradores.component';
import { ContratantesComponent } from './../contratantes/contratantes.component';
import { ColaboradoresComponent } from './../colaboradores/colaboradores.component';

const routes: Routes = [

  {
    path: '' ,
    children: [
      { path: 'registro', component: RegistroComponent },
      { path: 'contratantes/registro', component: FormContratantesComponent },
      { path: 'colaboradores/registro', component: FormColaboradoresComponent },
      { path: 'colaboradores/editar/:id', component: FormColaboradoresComponent },
      { path: 'contratantes/editar/:id', component: FormContratantesComponent },

    ]
  }

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class RegistroGeneralRoutingModule { }

