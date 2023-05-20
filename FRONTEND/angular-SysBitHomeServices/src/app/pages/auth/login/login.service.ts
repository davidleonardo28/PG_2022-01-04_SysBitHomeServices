import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Administrador } from '@auth/administradores/administradores';
import { Contratante } from '@auth/contratantes/contratantes';
import { Colaborador } from '@auth/colaboradores/colaboradores';

@Injectable()
export class LoginService {

    private _admin : Administrador;
    private _uce : Contratante;
    private _ucr : Colaborador;
    private _token: string;

    public get administrador():Administrador{
        if(this._admin != null){
            return this._admin;
        }else if(this._admin == null && sessionStorage.getItem('administrador') != null){
            this._admin = JSON.parse(sessionStorage.getItem('administrador')) as Administrador;
            return this._admin;
        } 
        return new Administrador();
    }

    public get colaborador():Colaborador{
        if(this._ucr != null){
            return this._ucr;
        }else if(this._ucr == null && sessionStorage.getItem('colaborador') != null){
            this._ucr = JSON.parse(sessionStorage.getItem('colaborador')) as Colaborador;
            return this._ucr;
        } 
        return new Colaborador();
    }

    public get contratante():Contratante{
        if(this._uce != null){
            return this._uce;
        }else if(this._uce == null && sessionStorage.getItem('contratante') != null){
            this._uce = JSON.parse(sessionStorage.getItem('contratante')) as Contratante;
            return this._uce;
        } 
        return new Contratante();
    }

    
    public get token():string{
        if(this._token != null){
            return this._token;
        }else if(this._token == null && sessionStorage.getItem('token') != null){
            this._token = sessionStorage.getItem('token');
            return this._token;
        } 
        return null;
    }
    constructor(private http : HttpClient){}

    loginAdministrador(administrador:Administrador):Observable<any>{

        const urlEndpoint = 'http://sysbithomeservices-backend-v1-env-1.eba-akv9utb2.us-east-2.elasticbeanstalk.com/oauth/token'; 
        const credenciales = btoa('angularapp' + ':' + 'angular12345');
        const httpHeaders = new HttpHeaders({'Content-Type':'application/x-www-form-urlencoded',
        'Authorization':'Basic ' + credenciales})

        let params = new URLSearchParams();
        params.set('grant_type','password'); 
        params.set('username',administrador.username);
        params.set('password',administrador.claveAdmin);
        console.log(params.toString())

        return this.http.post<any>(urlEndpoint,params.toString(),{headers: httpHeaders});
    }

    loginColaborador(colaborador:Colaborador):Observable<any>{

        const urlEndpoint = 'http://sysbithomeservices-backend-v1-env-1.eba-akv9utb2.us-east-2.elasticbeanstalk.com/oauth/token'; 
        const credenciales = btoa('angularapp' + ':' + 'angular12345');
        const httpHeaders = new HttpHeaders({'Content-Type':'application/x-www-form-urlencoded',
        'Authorization':'Basic ' + credenciales})

        let params = new URLSearchParams();
        params.set('grant_type','password'); 
        params.set('username',colaborador.username);
        params.set('password',colaborador.claveUcr);
        console.log(params.toString())

        return this.http.post<any>(urlEndpoint,params.toString(),{headers: httpHeaders});
    }

    
    loginContratante(contratante:Contratante):Observable<any>{

        const urlEndpoint = 'http://sysbithomeservices-backend-v1-env-1.eba-akv9utb2.us-east-2.elasticbeanstalk.com/oauth/token'; 
        const credenciales = btoa('angularapp' + ':' + 'angular12345');
        const httpHeaders = new HttpHeaders({'Content-Type':'application/x-www-form-urlencoded',
        'Authorization':'Basic ' + credenciales})

        let params = new URLSearchParams();
        params.set('grant_type','password'); 
        params.set('username',contratante.username);
        params.set('password',contratante.claveUce);
        console.log(params.toString())
        return this.http.post<any>(urlEndpoint,params.toString(),{headers: httpHeaders});
    }

    guardarColaborador(accessToken: string):void{
        let payload = this.obtenerDatosToken(accessToken);
        this._uce = new Contratante();
        this._uce.username = payload.user_name;
        this._uce.supervisados = payload.authorities;
        sessionStorage.setItem('contratante', JSON.stringify(this._uce));
        
    }

    guardarContratante(accessToken: string):void{
        let payload = this.obtenerDatosToken(accessToken);
        this._ucr = new Colaborador();
        this._ucr.username = payload.user_name;
        this._ucr.supervisados = payload.authorities;
        sessionStorage.setItem('colaborador', JSON.stringify(this._ucr));
        
    }

    guardarAdmin(accessToken: string):void{
        let payload = this.obtenerDatosToken(accessToken);
        this._admin = new Administrador();
        this._admin.username = payload.user_name;
        this._admin.supervisados = payload.authorities;
        sessionStorage.setItem('administrador', JSON.stringify(this._admin));
        
    }

    guardarToken(accessToken: string):void{
        this._token = accessToken;
        sessionStorage.setItem('token', accessToken);
 
    }

    obtenerDatosToken(accessToken: string):any{
        if(accessToken != null){
            return JSON.parse(atob(accessToken.split(".")[1]));
        }
        return null;
    }

    isAuthenticated(): boolean{
        let payload = this.obtenerDatosToken(this.token);
        if(payload != null && payload.user_name && payload.user_name.length>0){
            if (this.hasRole('ROLE_ADMIN')) {
                return true;
              } else if (this.hasRole('ROLE_UCE')) {
                return true;
              }else if (this.hasRole('ROLE_UCR')) {
                return true;
            }
    }
    return false;        

}

    logout():void{
        this._admin=null;
        this._token = null;
        sessionStorage.clear();
    }

    hasRole(role:string):boolean{
        if(this.administrador.supervisados.includes(role)||this.colaborador.supervisados.includes(role)||this.contratante.supervisados.includes(role)){
            return true;
    }
    return false;
}

}
