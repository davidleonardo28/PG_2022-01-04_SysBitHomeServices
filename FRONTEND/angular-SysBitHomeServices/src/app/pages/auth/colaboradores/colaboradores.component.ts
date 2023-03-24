import { Component, OnInit } from '@angular/core';
import { ColaboradorService } from './colaborador.service';
import { Colaborador } from './colaboradores';


@Component({
  selector: 'app-colaboradores',
  templateUrl: './colaboradores.component.html',
  styleUrls: ['./colaboradores.component.css']
})
export class ColaboradoresComponent implements OnInit{

  colaboradores: Colaborador[];
  constructor(private colabService: ColaboradorService){}

  ngOnInit(): void {
    this.colabService.getColaborador().subscribe(colaboradores =>
      this.colaboradores = colaboradores)

  }

}
