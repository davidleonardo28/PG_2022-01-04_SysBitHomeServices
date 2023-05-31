
import { PagosComponent } from './pagos.component';
import { PagosRoutingModule } from './pagos-routing.module';
import { NgModule  } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MapasModule } from "../mapas/mapas.module";
import { YouTubePlayerModule } from '@angular/youtube-player';
import { Pagos2Component } from './pagos2/pagos2.component';
import { Pagos3Component } from './pagos3/pagos3.component';
import { Pagos4Component } from './pagos4/pagos4.component';

// import { NgxYoutubePlayerModule } from 'ngx-youtube-player';
@NgModule({
    declarations: [
        PagosComponent,
        Pagos2Component,
        Pagos3Component,
        Pagos4Component
    ],
    imports: [
        CommonModule,
        PagosRoutingModule,
        MapasModule,
        YouTubePlayerModule
    ],
})
export class PagosModule { }
