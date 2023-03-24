import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { TipoDocumento } from '../tipoDocumento/tipoDocumento';
import { Contratante } from './contratantes';

@Injectable()
export class ContratantesService {

  private urlEndPoint:string = 'http://localhost:8080/api/contratentes'
  private urlEndPointTipoDoc:string = 'http://localhost:8080/api/TipoDocumentos'

  private httpHeaders = new HttpHeaders({'Content-Type':'application/json'})

  constructor(private http: HttpClient) {

  }

  getContratante():Observable<Contratante[]>{
    return this.http.get<Contratante[]>(this.urlEndPoint);

  }

  getTipo_documento():Observable<TipoDocumento[]>{
    return this.http.get<TipoDocumento[]>(this.urlEndPointTipoDoc);
  }

  create(contratanes: Contratante) : Observable<Contratante>{
    return this.http.post<Contratante>(this.urlEndPoint, contratanes,{headers: this.httpHeaders})
  }

  getContratanteId(id):Observable<Contratante>{
    return this.http.get<Contratante>(`${this.urlEndPoint}/${id}`);
  }
  update(contratante:Contratante):Observable<Contratante>{
    return this.http.put<Contratante>(`${this.urlEndPoint}/${contratante.codUce}`, contratante, {headers: this.httpHeaders});
  }

  delete(id:number):Observable<Contratante>{
    return this.http.delete<Contratante>(`${this.urlEndPoint}/${id}`, {headers: this.httpHeaders})
  }
}
