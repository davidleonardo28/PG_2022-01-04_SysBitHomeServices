import { PagosComponent } from './pagos.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { Pagos2Component } from './pagos2/pagos2.component';
import { Pagos3Component } from './pagos3/pagos3.component';
import { Pagos4Component } from './pagos4/pagos4.component';



const routes: Routes = [
  { path: 'enfermeria', component: PagosComponent },
  { path: 'veterinaria', component: Pagos2Component },
  { path: 'cuidadopersonal', component: Pagos3Component },
  { path: 'alimentacion', component: Pagos4Component }
];


@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PagosRoutingModule { }
