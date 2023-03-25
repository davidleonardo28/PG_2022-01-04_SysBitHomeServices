import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FullScreenComponent } from './pages/full-screen/full-screen.component';
import { MarcadoresComponent } from './pages/marcadores/marcadores.component';
import { PropiedadesComponent } from './pages/propiedades/propiedades.component';

const routes: Routes = [

  {
    path: '',
    children: [
      { path: 'fullscreen', component: FullScreenComponent },
      { path: 'marcadores', component: MarcadoresComponent },
      { path: 'propiedades', component: PropiedadesComponent },
      { path: '', redirectTo: '/marcadores', pathMatch: 'full' },
      // { path: '**', redirectTo: 'marcadores' },
    ]
  }

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class MapasRoutingModule { }

