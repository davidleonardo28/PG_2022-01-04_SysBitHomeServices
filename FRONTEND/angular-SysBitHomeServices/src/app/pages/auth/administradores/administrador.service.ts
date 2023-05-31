import { Injectable } from '@angular/core';
import { of ,Observable } from 'rxjs';
//import { ADMINISTRADORES } from './administradores.json';
import { Administrador } from './administradores';
import { HttpClient, HttpHeaders } from '@angular/common/http'
import { LoginService } from '@auth/login/login.service';
import { environment } from '@env/environment.prod';


@Injectable()
export class AdministradorService {

  private urlEndPoint:string = `${environment.backendUrl}/api/administradores/lista`
  private httpHeaders = new HttpHeaders({'Content-Type':'application/json'})

  constructor(private http: HttpClient, private loginService: LoginService) {

  }

  private agregarAutorizacion(){
    let token = this.loginService.token;
    if(token!=null){
      return this.httpHeaders.append('Authorization', 'Bearer ' + token)
    }
    return this.httpHeaders;
  }

  getAdministrador():Observable<Administrador[]>{
    //return of(ADMINISTRADORES);
    return this.http.get<Administrador[]>(this.urlEndPoint,  {headers : this.agregarAutorizacion()});

  }

}
