import { ColaboradorService } from './../../../../colaboradores/colaborador.service';
import { TipoDocumento } from './../../../../tipoDocumento/tipoDocumento';
import { Colaborador } from './../../../../colaboradores/colaboradores';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Storage, ref, uploadBytes, listAll, getDownloadURL} from '@angular/fire/storage';
import swal from 'sweetalert2'


@Component({
  selector: 'app-formcolaboradores',
  templateUrl: './formcolaboradores.component.html',
})
export class FormColaboradoresComponent implements OnInit {
  colaborador: Colaborador = new Colaborador()
  tipoDocumentos: TipoDocumento[];
  archivoDocumento: string[] = [];



    constructor(private colaboradorService: ColaboradorService, private router:Router, private activatedRouter:ActivatedRoute, private storage: Storage  ){}

    ngOnInit() {
      this.colaboradorService.getTipo_documento().subscribe(tipoDocumento => {this.tipoDocumentos = tipoDocumento;console.log(tipoDocumento)})
      this.cargarColaborador();
      console.log("Componente")
    }

    public create(): void{
     this.colaboradorService.create(this.colaborador).subscribe(
      colaborador => {
        if(colaborador.claveUcr === colaborador.confirmClaveUcr){
          this.router.navigate(['./home'])
          swal('Colaborador Nuevo', `El Colaborador se ha creado exitosamente`, 'success')
        }else{
          swal('Contraseña invalida', 'La verificación de la contraseña es erronea', 'error')
        }
      }
        )
    }

    public cargarColaborador(): void{
      this.activatedRouter.params.subscribe(params =>{
        let id = params['id']
        if(id){
          this.colaboradorService.getColaboradorId(id).subscribe((colaborador) => this.colaborador = colaborador)
        }

      })

    }
 
    public update(): void{
      this.colaboradorService.update(this.colaborador).subscribe(colaborador =>{
        this.router.navigate(['./home'])
        swal('Colaborador Editado', `El Colaborador ha sido editado exitosamente`, 'success')

      })
    }

    cargaArchivosCedulaColaboradores($event: any){

      const file = $event.target.files[0];
      console.log(file);

      const fileRef = ref(this.storage, `Colaboradores/Cedula/${file.name}`);

      uploadBytes(fileRef, file)
      .then(response => {
        console.log(response)})
        swal('Archivo Documento', 'El Archivo ha sido guardado', 'success')
      .catch(error => console.log(error)
      )

    }

    cargaArchivosSeguridadSocialColaboradores($event: any){

      const file = $event.target.files[0];
      console.log(file);

      const fileRef = ref(this.storage, `Colaboradores/SeguridadSocial/${file.name}`);

      uploadBytes(fileRef, file)
      .then(response => {
        console.log(response)})
        swal('Archivo Documento', 'El Archivo ha sido guardado', 'success')
      .catch(error => console.log(error)
      )

    }

    getArchivosCedula(){

      const fileRef = ref(this.storage, 'Colaboradores/Cedula');

      listAll(fileRef)
      .then(async response => {
        console.log(response)
        this.archivoDocumento = []
      for(let item of response.items){
       const url = await getDownloadURL(item);
       this.archivoDocumento.push(url);
      }
    }
      )
      .catch(error => console.log(error));

    }
}
