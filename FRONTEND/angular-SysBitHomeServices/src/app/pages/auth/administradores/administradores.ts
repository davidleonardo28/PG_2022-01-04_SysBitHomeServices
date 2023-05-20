import { TipoDocumento } from './../tipoDocumento/tipoDocumento';

export class Administrador {
    codAdmin:number;
    nomAdmin:string;
    apeAdmin:string;
    correoAdmin:string;
    claveAdmin:string;
    telefonoAdmin:number;
    numDocumentoAdmin:number;
    username:string;
    docAdmin:TipoDocumento;
    supervisados:String[] = [];
}
