import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { TipoDocumento } from '../tipoDocumento/tipoDocumento';
import { Colaborador } from './colaboradores';
import { Router } from '@angular/router';
import { LoginService } from '@auth/login/login.service';
import { environment } from '@env/environment';

@Injectable()
export class ColaboradorService {

  private urlEndPoint:string = `${environment.backendUrl}/api/colaboradores`
  private urlEndPointTipoDoc:string = `${environment.backendUrl}/api/TipoDocumentos`
  private urlEndPointregistro:string = `${environment.backendUrl}/api/colaboradores/registro`

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

  getColaborador():Observable<Colaborador[]>{
    return this.http.get<Colaborador[]>(this.urlEndPoint+'/Lista', {headers: this.agregarAutorizacion()});

  }

  getTipo_documento():Observable<TipoDocumento[]>{
    return this.http.get<TipoDocumento[]>(this.urlEndPointTipoDoc);
  }

  create(colaborador: Colaborador) : Observable<Colaborador>{
    return this.http.post<Colaborador>(this.urlEndPointregistro, colaborador,{headers: this.httpHeaders})
  }
  getColaboradorId(id):Observable<Colaborador>{
    return this.http.get<Colaborador>(`${this.urlEndPoint}/${id}`, {headers: this.agregarAutorizacion()});
  }
  update(colaborador:Colaborador):Observable<Colaborador>{
    return this.http.put<Colaborador>(`${this.urlEndPoint}/${colaborador.codUcr}`, colaborador, {headers: this.agregarAutorizacion()});
  }

  delete(id:number):Observable<Colaborador>{
    return this.http.delete<Colaborador>(`${this.urlEndPoint}/${id}`, {headers: this.httpHeaders})
  }
}