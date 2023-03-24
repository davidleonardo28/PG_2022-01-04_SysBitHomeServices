import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ContratantesService } from 'src/app/contratantes/contratante.service';
import { Contratante } from 'src/app/contratantes/contratantes';
import { TipoDocumento } from 'src/app/tipoDocumento/tipoDocumento';
import { Storage, ref, uploadBytes, listAll, getDownloadURL} from '@angular/fire/storage';

@Component({
  selector: 'app-formcontratantes',
  templateUrl: './formcontratantes.component.html',
})
export class FormContratantesComponent implements OnInit {
  contratante: Contratante = new Contratante()
  tipoDocumentos: TipoDocumento[] = [];
  archivoSeguridadSocial: string[] = [];


    constructor(private contratanteService: ContratantesService, private router:Router, private activatedRouter: ActivatedRoute, private storage: Storage){

    }

    ngOnInit() {
      this.cargarContratante()
      this.getArchivos();
      this.contratanteService.getTipo_documento().subscribe(tipoDocumento => {this.tipoDocumentos = tipoDocumento});
      
    }

    public cargarContratante(): void{
      this.activatedRouter.params.subscribe(params =>{
        let id = params['id']
        if(id){
          this.contratanteService.getContratanteId(id).subscribe((contratante) => this.contratante = contratante)
        }

      })
    }

    public create(): void{
     this.contratanteService.create(this.contratante).subscribe(
    contratante => this.router.navigate(['./home']))
     console.log(this.contratante)
    }

    public update(): void{
      this.contratanteService.update(this.contratante).subscribe(contratante =>{
        this.router.navigate(['./home'])
      })
    }

    cargaArchivos($event: any){

      const file = $event.target.files[0];
      console.log(file);

      const fileRef = ref(this.storage, `DocumentosContratantes/${file.name}`);

      uploadBytes(fileRef, file)
      .then(response => console.log(response))
      .catch(error => console.log(error))
    }

    getArchivos(){

      const fileRef = ref(this.storage, 'DocumentosContratantes');
      
      listAll(fileRef)
      .then(async response => {
        console.log(response)
        this.archivoSeguridadSocial = []
      for(let item of response.items){
       const url = await getDownloadURL(item);
       this.archivoSeguridadSocial.push(url);

        
      }
    }
      )
      .catch(error => console.log(error));

    }
}
