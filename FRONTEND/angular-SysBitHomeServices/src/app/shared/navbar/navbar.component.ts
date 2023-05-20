import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from '@auth/login/login.service';
import { AuthService } from '@auth/services/auth.services';
import swal from 'sweetalert2';

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

  constructor(private readonly authSvc: AuthService, private loginService: LoginService, private router:Router) { }

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

  logout():void{
    let username = this.loginService.administrador.username;
    this.loginService.logout();
    swal('Login', `Hola, ${username}, has cerrado sesión con exito`,'success');
    this.router.navigate(['/login'])
  }
}
