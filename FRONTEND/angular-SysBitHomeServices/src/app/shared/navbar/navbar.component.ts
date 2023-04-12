import { Component } from '@angular/core';
import { AuthService } from '@auth/services/auth.services';

interface MenuUsers {
  ruta: string;
  nombre: string;
}
@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent {
  user$ = this.authSvc.user$;

  constructor(private readonly authSvc: AuthService) { }

  async onLogout(): Promise<void> {
    try {
      await this.authSvc.signOut();
    } catch (error) {
      console.log(error);
    }
  }

  menuUsers: MenuUsers[] = [
    {
      ruta: '/administradores',
      nombre: 'Administradores'
    },
    {
      ruta: '/colaboradores',
      nombre: 'Colaboradores'
    },
    {
      ruta: '/contratantes',
      nombre: 'Contratantes'
    },
  ];
}
