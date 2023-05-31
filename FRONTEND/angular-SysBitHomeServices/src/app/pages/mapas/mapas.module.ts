import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MapasRoutingModule } from './mapas-routing.module';
import { MiniMapaComponent } from './components/mini-mapa/mini-mapa.component';
import { MarcadoresComponent } from './pages/Mapa1/marcadores/marcadores.component';
import { MenuComponent } from '../../shared/menu/menu.component';
import { FullScreenComponent } from './pages/Mapa1/full-screen/full-screen.component';
import { Marcadores2Component } from './pages/Mapa2/marcadores/marcadores2.component';
import { Marcadores3Component } from './pages/Mapa3/marcadores/marcadores3.component';
import { Marcadores4Component } from './pages/Mapa4/marcadores/marcadores4.component';
import { FullScreen2Component } from './pages/Mapa2/full-screen/full-screen2.component';
import { FullScreen3Component } from './pages/Mapa3/full-screen/full-screen3.component';
import { FullScreen4Component } from './pages/Mapa4/full-screen/full-screen4.component';


@NgModule({
  declarations: [
    MiniMapaComponent,
    FullScreenComponent,
    FullScreen2Component,
    FullScreen3Component,
    FullScreen4Component,
    MenuComponent,
    MarcadoresComponent,
    Marcadores2Component,
    Marcadores3Component,
    Marcadores4Component,
  ],
  imports: [
    CommonModule,
    MapasRoutingModule,
  ],
  exports:[
    MarcadoresComponent,
    Marcadores2Component,
    Marcadores3Component,
    Marcadores4Component,
  ]
})
export class MapasModule { }
