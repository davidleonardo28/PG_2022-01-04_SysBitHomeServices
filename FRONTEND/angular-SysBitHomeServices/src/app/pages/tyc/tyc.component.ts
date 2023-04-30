import { Component } from '@angular/core';
import Swal from 'sweetalert2';
@Component({
  selector: 'app-tyc',
  templateUrl: './tyc.component.html',
  styleUrls: ['./tyc.component.css'],
})
export class TycComponent {
  aceptarTerminosCondiciones(): void {
    Swal(
      'SysbitHomeServicies!',
      'Enhorabuena, ahora puedes realizar el registro para realizar el proceso de contratación, dependiente del rol que escojas de algún tipo de servicio domésticos',
      'success'
    );
  }

  rechazarTerminosCondiciones(): void {
    Swal(
      'SysbitHomeServicies!',
      'Es importante leer completamente los términos y condiciones para poder cumplir con el proceso de registro, si tienes alguna consulta no dudes en consultarnos!',
      'error'
    );
  }
}
