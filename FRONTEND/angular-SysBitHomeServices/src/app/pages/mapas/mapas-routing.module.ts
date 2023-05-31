import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FullScreenComponent } from './pages/Mapa1/full-screen/full-screen.component';
import { MarcadoresComponent } from './pages/Mapa1/marcadores/marcadores.component';
import { Marcadores2Component } from './pages/Mapa2/marcadores/marcadores2.component';
import { FullScreen2Component } from './pages/Mapa2/full-screen/full-screen2.component';
import { FullScreen3Component } from './pages/Mapa3/full-screen/full-screen3.component';
import { Marcadores3Component } from './pages/Mapa3/marcadores/marcadores3.component';
import { FullScreen4Component } from './pages/Mapa4/full-screen/full-screen4.component';
import { Marcadores4Component } from './pages/Mapa4/marcadores/marcadores4.component';

const routes: Routes = [

  {
    path: '',
    children: [
      { path: 'fullscreen/enfermeria', component: FullScreenComponent },
      { path: 'marcadores/enfermeria', component: MarcadoresComponent },
      { path: 'fullscreen/veterinaria', component: FullScreen2Component },
      { path: 'marcadores/veterinaria', component: Marcadores2Component },
      { path: 'fullscreen/cuidadopersonal', component: FullScreen3Component },
      { path: 'marcadores/cuidadopersonal', component: Marcadores3Component },
      { path: 'fullscreen/alimentacion', component: FullScreen4Component },
      { path: 'marcadores/alimentacion', component: Marcadores4Component },
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

