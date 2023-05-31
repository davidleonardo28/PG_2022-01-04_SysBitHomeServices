import { Component, OnInit } from '@angular/core';
import { Pagos } from '../pagos';
import { PagosService } from '../pagos.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-pagos',
  templateUrl: './pagos3.component.html',
  styleUrls: ['./pagos3.component.scss'],
})
export class Pagos3Component {
  // pagos: Pagos = new Pagos();

  // constructor(private pagosService: PagosService) {}

  // public finalizar(): void {
  //   this.pagosService.finalizar(this.pagos).subscribe((pago) => {
  //      this.router.navigate(['./home'])
  //     swal('Servicio Finalizado', `Gracias por utilizar nuestros servicios`);
  //   });
  // }

  finalizoServicio(): void {
    Swal({
      title: 'SysbitHomeServicies!',
      text: 'Usuario de Pruebas!!, Espera que hayas teniendo una gran experiencia. Vuelve pronto, cualquier duda comunicarse con +57 320-942-8588.',
      imageUrl: '../../../assets/img/pagos/MensajeDespedida.png',
      imageWidth: 400,
      imageHeight: 200,
      imageAlt: 'Custom image',
    });
  }

  goToUrl(): void {
    // window.location.href = 'https://mpago.li/1dFnchx';
    window.open('https://mpago.li/1dFnchx', '_blank');
  }
}
