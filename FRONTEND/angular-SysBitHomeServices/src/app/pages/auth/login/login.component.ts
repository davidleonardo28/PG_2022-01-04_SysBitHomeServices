import { Component, OnInit } from '@angular/core';
import { Contratante } from '@auth/contratantes/contratantes';
import swal from 'sweetalert2';
import { LoginService } from './login.service';
import { Router } from '@angular/router';
import { Administrador } from '@auth/administradores/administradores';
import { Colaborador } from '@auth/colaboradores/colaboradores';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html'
})
export class LoginComponent implements OnInit {

  administrador: Administrador;
  contratante: Contratante;
  colaborador: Colaborador;
  tipoUsuario: string;
  public userType: string;
  public showContratanteForm: boolean = false;
  public showColaboradorForm: boolean = false;
  public showAdministradorForm: boolean = false;

  constructor(private loginService: LoginService, private route: Router) {
    this.administrador = new Administrador;
    this.colaborador = new Colaborador;
    this.contratante = new Contratante;

  }

  onUserTypeSelected(value: string) {
    this.userType = value;

    if (this.userType === 'contratante') {
      this.showContratanteForm = true;
      this.showColaboradorForm = false;
      this.showAdministradorForm = false;
    } else if (this.userType === 'colaborador') {
      this.showContratanteForm = false;
      this.showColaboradorForm = true;
      this.showAdministradorForm = false;
      }else if(this.userType === 'administrador'){
        this.showContratanteForm = false;
        this.showColaboradorForm = false;
        this.showAdministradorForm = true;
      
    } else {
      this.showContratanteForm = false;
      this.showColaboradorForm = false;
      this.showAdministradorForm = false;
    }
  }

  ngOnInit(): void {
    if (this.loginService.isAuthenticated()) {
      swal('Login', `Hola, ${this.loginService.administrador.username}, ya te encuentras autenticado`, 'info');
      this.route.navigate(['/home']);
    } else if (this.loginService.isAuthenticated()) {
      swal('Login', `Hola, ${this.loginService.colaborador.username}, ya te encuentras autenticado`, 'info');
      this.route.navigate(['/home']);
    } else if (this.loginService.isAuthenticated()) {
      swal('Login', `Hola, ${this.loginService.contratante.username}, ya te encuentras autenticado`, 'info');
      this.route.navigate(['/home']);
    }

  }

  loginAdministrador(): void {
    if (this.administrador.username && this.administrador.claveAdmin) {
      this.loginService.loginAdministrador(this.administrador).subscribe(response => {
        this.loginService.guardarAdmin(response.access_token);
        this.loginService.guardarToken(response.access_token);

        const administrador = this.loginService.administrador;
        swal('Login', `Hola, ${administrador.username}, has iniciado sesión con éxito`, 'success');
        this.route.navigate(['/home']);
      }, err => {
        if (err.status == 400) {
          swal('Error Login', 'Nombre de usuario o contraseña incorrectos', 'error');
        }
      });
    } else {
      swal('Error Login', 'Nombre de usuario o contraseña vacíos', 'error');
    }
  }

  loginContratante(): void {
    if (this.contratante.username && this.contratante.claveUce) {
      this.loginService.loginContratante(this.contratante).subscribe(response => {
        this.loginService.guardarContratante(response.access_token);
        this.loginService.guardarToken(response.access_token);

        const contratante = this.loginService.contratante;
        swal('Login', `Hola, ${contratante.username}, has iniciado sesión con éxito`, 'success');
        this.route.navigate(['/home']);
      }, err => {
        if (err.status == 400) {
          swal('Error Login', 'Nombre de usuario o contraseña incorrectos', 'error');
        }
      });
    } else {
      swal('Error Login', 'Nombre de usuario o contraseña vacíos', 'error');
    }
  }
  loginColaborador(): void {
    if (this.colaborador.username && this.colaborador.claveUcr) {
      this.loginService.loginColaborador(this.colaborador).subscribe(response => {
        this.loginService.guardarColaborador(response.access_token);
        this.loginService.guardarToken(response.access_token);

        const colaborador = this.loginService.colaborador;
        swal('Login', `Hola, ${colaborador.username}, has iniciado sesión con éxito`, 'success');
        this.route.navigate(['/home']);
      }, err => {
        if (err.status == 400) {
          swal('Error Login', 'Nombre de usuario o contraseña incorrectos', 'error');
        }
      });
    } else {
      swal('Error Login', 'Nombre de usuario o contraseña vacíos', 'error');
    }
  }
}