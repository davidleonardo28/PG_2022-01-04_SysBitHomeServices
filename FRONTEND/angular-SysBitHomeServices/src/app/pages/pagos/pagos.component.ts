import { Component, OnInit } from '@angular/core';
import { Pagos } from './pagos';
import { PagosService } from './pagos.service';
import swal from 'sweetalert2';


@Component({
  selector: 'app-pagos',
  templateUrl: './pagos.component.html',
  styleUrls: ['./pagos.component.scss'],
})
export class PagosComponent  {
  // pagos: Pagos = new Pagos();

  // constructor(private pagosService: PagosService) {}

  // public finalizar(): void {
  //   this.pagosService.finalizar(this.pagos).subscribe((pago) => {
  //     //  this.router.navigate(['./home'])
  //     swal('Servicio Finalizado', `Gracias por utilizar nuestros servicios`);
  //   });
  // }
}
