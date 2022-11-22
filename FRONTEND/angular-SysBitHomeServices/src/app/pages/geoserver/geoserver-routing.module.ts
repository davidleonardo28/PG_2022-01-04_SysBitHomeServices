import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { GeoserverComponent } from './geoserver.component';

const routes: Routes = [{ path: '', component: GeoserverComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class GeoserverRoutingModule { }
