import { ColaboradoresComponent } from './colaboradores.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FormColaboradoresComponent } from '@auth/registro-general/components/pages/colaboradores/formcolaboradores.component';


const routes: Routes = 
[{ path: '', component: ColaboradoresComponent },
{ path: 'colaboradores/editar/:id', component: FormColaboradoresComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ColaboradoresRoutingModule { }
