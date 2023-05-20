import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { TipoDocumento } from '../tipoDocumento/tipoDocumento';
import { Contratante } from './contratantes';
import { LoginService } from '@auth/login/login.service';
import { Router } from '@angular/router';

@Injectable()
export class ContratantesService {

  private urlEndPoint:string = 'http://sysbithomeservices-backend-v1-env-1.eba-akv9utb2.us-east-2.elasticbeanstalk.com/api/contratentes'
  private urlEndPointTipoDoc:string = 'http://sysbithomeservices-backend-v1-env-1.eba-akv9utb2.us-east-2.elasticbeanstalk.com/api/TipoDocumentos'

  private httpHeaders = new HttpHeaders({'Content-Type':'application/json'})
  constructor(private http: HttpClient, private router: Router, private loginService: LoginService) {
  }
  
  private agregarAutorizacion(){
    let token = this.loginService.token;
    if(token!=null){
      return this.httpHeaders.append('Authorization', 'Bearer ' + token)
    }
    return this.httpHeaders;
  }

  getContratante():Observable<Contratante[]>{
    return this.http.get<Contratante[]>(this.urlEndPoint+'/Lista', {headers: this.agregarAutorizacion()});

  }

  getTipo_documento():Observable<TipoDocumento[]>{
    return this.http.get<TipoDocumento[]>(this.urlEndPointTipoDoc);
  }

  create(contratanes: Contratante) : Observable<Contratante>{
    return this.http.post<Contratante>(this.urlEndPoint, contratanes,{headers: this.agregarAutorizacion()})
  }

  getContratanteId(id):Observable<Contratante>{
    return this.http.get<Contratante>(`${this.urlEndPoint}/${id}`, {headers: this.agregarAutorizacion()});
  }
  update(contratante:Contratante):Observable<Contratante>{
    return this.http.put<Contratante>(`${this.urlEndPoint}/${contratante.codUce}`, contratante,{headers: this.agregarAutorizacion()});
  }

  delete(id:number):Observable<Contratante>{
    return this.http.delete<Contratante>(`${this.urlEndPoint}/${id}`, {headers: this.httpHeaders})
  }
}
