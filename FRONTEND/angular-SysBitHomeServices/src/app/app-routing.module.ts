
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
    path: 'localizacion',
    loadChildren: () =>
      import('./pages/mapas/mapas.module').then((m) => m.MapasModule),
  },
  {
    path: 'registro',
    loadChildren: () =>
      import('./pages/auth/registro-general/registro-general.module').then((m) => m.RegistroGeneralModule),
  },
  {
    path: 'pagos',
    loadChildren: () =>
      import('./pages/pagos/pagos.module').then((m) => m.PagosModule),
  },
  {
    path: 'administradores',
    loadChildren: () =>
      import('./pages/auth/administradores/administradores.module').then((m) => m.AdministradoresModule),
  },
  {
    path: 'colaboradores',
    loadChildren: () =>
      import('./pages/auth/colaboradores/colaboradores.module').then((m) => m.ColaboradoresModule),
  },
  {
    path: 'contratantes',
    loadChildren: () =>
      import('./pages/auth/contratantes/contratantes.module').then((m) => m.ContratantesModule),
  },
  {
    path: 'servicios',
    loadChildren: () =>
      import('./pages/servicios/servicios.module').then((m) => m.ServiciosModule),
  },
  {
    path: 'tyc',
    loadChildren: () =>
      import('./pages/tyc/tyc.module').then((m) => m.TycModule),
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
  {
    path: 'login',
    loadChildren: () =>
      import('./pages/auth/login/login.module').then((m) => m.LoginModule),
  }, 
 


  // { path: '**', redirectTo: '/home', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
