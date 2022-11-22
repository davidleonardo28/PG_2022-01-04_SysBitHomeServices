import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { GeoserverComponent } from './geoserver.component';
import { GeoserverRoutingModule } from './geoserver-routing.module';



@NgModule({
  declarations: [
    GeoserverComponent
  ],
  imports: [
    CommonModule, GeoserverRoutingModule
  ]
})
export class GeoserverModule { }
