import { TipoDocumento } from "../tipoDocumento/tipoDocumento";

export class Colaborador {
    codUcr:number;
    nomUcr:string;
    apeUcr:string;
    correoUcr:string;
    claveUcr:string;
    confirmClaveUcr:string;
    telefonoUcr:number;
    cuentaBancaria:number;
    numDocumentoUcr:number;
    username:string;
    fechaNacimientoUcr:string;
    tipoDoc:TipoDocumento;
    supervisados:String[] = [];
}
