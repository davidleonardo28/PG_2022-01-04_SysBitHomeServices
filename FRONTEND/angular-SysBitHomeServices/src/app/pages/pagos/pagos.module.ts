
import { PagosComponent } from './pagos.component';
import { PagosRoutingModule } from './pagos-routing.module';
import { NgModule  } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MapasModule } from "../mapas/mapas.module";
import { YouTubePlayerModule } from '@angular/youtube-player';

// import { NgxYoutubePlayerModule } from 'ngx-youtube-player';
@NgModule({
    declarations: [
        PagosComponent,
    ],
    imports: [
        CommonModule,
        PagosRoutingModule,
        MapasModule,
        YouTubePlayerModule
    ],
})
export class PagosModule { }
