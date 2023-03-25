import { MapasRoutingModule } from './pages/mapas/mapas-routing.module';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { NavbarModule } from '@shared/navbar/navbar.module';
import { AboutRoutingModule } from '../app/pages/about/about-routing.module';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ToastrModule } from 'ngx-toastr';
import { initializeApp,provideFirebaseApp } from '@angular/fire/app';
import { environment } from '../environments/environment';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialModule } from './Material.module';
import { HttpClientModule } from '@angular/common/http';
import {ReactiveFormsModule, FormsModule } from '@angular/forms';
import { MatIconModule } from "@angular/material/icon";
import {MatMenuModule} from '@angular/material/menu';
import {MatDatepickerModule} from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {MatGridListModule} from '@angular/material/grid-list';
import {MatTooltipModule} from '@angular/material/tooltip';
import {MatSelectModule} from '@angular/material/select';
import { PdfViewerModule } from 'ng2-pdf-viewer';
import { NgxExtendedPdfViewerModule } from 'ngx-extended-pdf-viewer';
import { ColaboradoresComponent } from './pages/auth/colaboradores/colaboradores.component';
import { ContratantesComponent } from './pages/auth/contratantes/contratantes.component';
import { AdministradoresComponent } from './pages/auth/administradores/administradores.component';
import { FooterComponent } from './pages/footer/footer.component';
import { ServiciosRoutingModule } from './pages/servicios/servicios-routing.module';
import { AdministradorService } from '@auth/administradores/administrador.service';
import { CargarScriptsService } from './cargar-scripts.service';
import { ColaboradorService } from '@auth/colaboradores/colaborador.service';
import { ContratantesService } from '@auth/contratantes/contratante.service';
import { RouterModule, Routes} from '@angular/router';
import { provideStorage,getStorage } from '@angular/fire/storage';


@NgModule({
  declarations: [
    AppComponent,
    FooterComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NavbarModule,
    BrowserAnimationsModule,
    ToastrModule.forRoot({
      preventDuplicates: true,
    }),
    AboutRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    MaterialModule,
    HttpClientModule,
    MatIconModule,
    ReactiveFormsModule,
    ReactiveFormsModule,
    MatMenuModule,
    MatDatepickerModule,
    MatFormFieldModule,
    MatInputModule,
    MatGridListModule,
    MatTooltipModule,
    MatSelectModule,
    NgxExtendedPdfViewerModule,
    PdfViewerModule,
    MapasRoutingModule,
    ServiciosRoutingModule,
    provideFirebaseApp(() => initializeApp(environment.firebase)),
    provideStorage(() => getStorage())
  ],
  providers: [MatDatepickerModule,
    MatNativeDateModule,AdministradorService, CargarScriptsService, ColaboradorService, ContratantesService ],
  bootstrap: [AppComponent,MatDatepickerModule]
})
export class AppModule { }
