import { TipoDocumento } from "../tipoDocumento/tipoDocumento";

export class Contratante {
    codUce:number;
    nomUce:string;
    apeUce:string;
    correoUce:string;
    claveUce:string;
    confirmClaveUce:string;
    telefonoUce:number;
    numDocumentoUce:number;
    username:string;
    fechaNacimientoUce:string;
    tipoDocContratantes:TipoDocumento;
    supervisados:String[]=[];
}
