import { Injectable } from '@angular/core';
import { of ,Observable } from 'rxjs';
//import { ADMINISTRADORES } from './administradores.json';
import { Administrador } from './administradores';
import { HttpClient, HttpHeaders } from '@angular/common/http'
import { LoginService } from '@auth/login/login.service';


@Injectable()
export class AdministradorService {

  private urlEndPoint:string = 'http://sysbithomeservices-backend-v1-env-1.eba-akv9utb2.us-east-2.elasticbeanstalk.com/api/administradores/lista'
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
