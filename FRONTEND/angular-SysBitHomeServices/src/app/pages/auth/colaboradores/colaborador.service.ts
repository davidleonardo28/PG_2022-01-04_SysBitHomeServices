import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { TipoDocumento } from '../tipoDocumento/tipoDocumento';
import { Colaborador } from './colaboradores';

@Injectable()
export class ColaboradorService {

  private urlEndPoint:string = 'http://localhost:8080/api/colaboradores'
  private urlEndPointTipoDoc:string = 'http://localhost:8080/api/TipoDocumentos'

  private httpHeaders = new HttpHeaders({'Content-Type':'application/json'})
  constructor(private http: HttpClient) {

  }

  getColaborador():Observable<Colaborador[]>{
    return this.http.get<Colaborador[]>(this.urlEndPoint);

  }

  getTipo_documento():Observable<TipoDocumento[]>{
    return this.http.get<TipoDocumento[]>(this.urlEndPointTipoDoc);
  }

  create(colaborador: Colaborador) : Observable<Colaborador>{
    return this.http.post<Colaborador>(this.urlEndPoint, colaborador,{headers: this.httpHeaders})
  }
  getColaboradorId(id):Observable<Colaborador>{
    return this.http.get<Colaborador>(`${this.urlEndPoint}/${id}`);
  }
  update(colaborador:Colaborador):Observable<Colaborador>{
    return this.http.put<Colaborador>(`${this.urlEndPoint}/${colaborador.codUcr}`, colaborador, {headers: this.httpHeaders});
  }

  delete(id:number):Observable<Colaborador>{
    return this.http.delete<Colaborador>(`${this.urlEndPoint}/${id}`, {headers: this.httpHeaders})
  }
}
