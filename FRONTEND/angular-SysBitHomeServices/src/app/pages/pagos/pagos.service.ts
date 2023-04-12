import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Pagos } from './pagos';

@Injectable()
export class PagosService {

  private urlEndPoint:string = 'http://localhost:8080/api/pagos'
  private urlEndPointTipoDoc:string = 'http://localhost:8080/api/pagos'

  private httpHeaders = new HttpHeaders({'Content-Type':'application/json'})
  constructor(private http: HttpClient) {

  }

  getPagos():Observable<Pagos[]>{
    return this.http.get<Pagos[]>(this.urlEndPoint);

  }
  finalizar(pago: Pagos) : Observable<Pagos>{
    return this.http.post<Pagos>(this.urlEndPoint, pago,{headers: this.httpHeaders})
  }
  getPagoId(id):Observable<Pagos>{
    return this.http.get<Pagos>(`${this.urlEndPoint}/${id}`);
  }
  delete(id:number):Observable<Pagos>{
    return this.http.delete<Pagos>(`${this.urlEndPoint}/${id}`, {headers: this.httpHeaders})
  }
}
