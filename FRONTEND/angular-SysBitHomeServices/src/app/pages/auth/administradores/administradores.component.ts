import { Component, OnInit } from '@angular/core';
import { AdministradorService } from './administrador.service';
import { Administrador } from './administradores';
@Component({
  selector: 'app-administradores',
  templateUrl: './administradores.component.html',
  styleUrls: ['./administradores.component.scss']
})
export class AdministradoresComponent implements OnInit {

  administradores: Administrador[];
  constructor(private administradorService: AdministradorService){}

ngOnInit(): void {
  this.administradorService.getAdministrador().subscribe(administradores =>
    this.administradores = administradores)
}
}
