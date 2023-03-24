import { Injectable } from '@angular/core';
import { of ,Observable } from 'rxjs';
//import { ADMINISTRADORES } from './administradores.json';
import { Administrador } from './administradores';
import { HttpClient } from '@angular/common/http'


@Injectable()
export class AdministradorService {

  private urlEndPoint:string = 'http://localhost:8080/api/administradores'
  constructor(private http: HttpClient) {

  }

  getAdministrador():Observable<Administrador[]>{
    //return of(ADMINISTRADORES);
    return this.http.get<Administrador[]>(this.urlEndPoint);

  }

}
