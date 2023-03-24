
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuard } from '@auth/guards/auth.guard';

const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  {
    path: 'home',
    loadChildren: () =>
      import('./pages/home/home.module').then((m) => m.HomeModule),
  },
  {
    path: 'about',
    loadChildren: () =>
      import('./pages/about/about.module').then((m) => m.AboutModule),
  },
  {
    path: 'registro',
    loadChildren: () =>
      import('./pages/auth/registro/registro-module').then(
        (m) => m.RegistroModule
      ),
  },
  {
    path: 'localizacion',
    loadChildren: () =>
      import('./pages/mapas/mapas.module').then((m) => m.MapasModule),
  },
  {
    path: 'servicios',
    loadChildren: () =>
      import('./pages/servicios/servicios.module').then((m) => m.ServiciosModule),
  },
  {
    path: 'sign-in',
    loadChildren: () =>
      import('./pages/auth/sign-in/sign-in.module').then((m) => m.SignInModule),
    canActivate: [AuthGuard],
  },
  {
    path: 'sign-up',
    loadChildren: () =>
      import('./pages/auth/sign-up/sign-up.module').then((m) => m.SignUpModule),
    canActivate: [AuthGuard],
  },


  // { path: '**', redirectTo: '/home', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
