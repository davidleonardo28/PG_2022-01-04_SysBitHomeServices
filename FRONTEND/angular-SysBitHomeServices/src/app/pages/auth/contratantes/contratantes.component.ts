import { Component, OnInit } from '@angular/core';
import { TipoDocumento } from '../tipoDocumento/tipoDocumento';
import { ContratantesService } from './contratante.service';
import { Contratante } from './contratantes';

@Component({
  selector: 'app-contratantes',
  templateUrl: './contratantes.component.html',
  styleUrls: ['./contratantes.component.css']
})
export class ContratantesComponent implements OnInit {
  contratantes: Contratante[];
  tipoDocumentos: TipoDocumento[];

  constructor(private colabService: ContratantesService){}

  ngOnInit(): void {

    this.colabService.getTipo_documento().subscribe(tipoDocumento => {this.tipoDocumentos = tipoDocumento})

    this.colabService.getContratante().subscribe(contratantes =>
      this.contratantes = contratantes)

  }

}
