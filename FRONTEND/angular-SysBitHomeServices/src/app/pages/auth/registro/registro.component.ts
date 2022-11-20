import { Component, ViewEncapsulation } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import {MatCalendarCellClassFunction} from '@angular/material/datepicker';

interface Documento {
  value: string;
  viewValue: string;
}


@Component({
  selector: 'app-registro',
  templateUrl: './registro.component.html',
  styleUrls: ['./registro.component.scss'],
  encapsulation: ViewEncapsulation.None,
})
export class RegistroComponent  {
  public registroUsuarios: FormGroup;

  dateClass: MatCalendarCellClassFunction<Date> = (cellDate, view) => {
    // Only highligh dates inside the month view.
    if (view === 'month') {
      const date = cellDate.getDate();

      // Highlight the 1st and 20th day of each month.
      return date === 1 || date === 20 ? 'example-custom-date-class' : '';
    }

    return '';
  };

  constructor() {
    this.registroUsuarios = this.createForm();
  }

  documento: Documento[] = [
    {value: 'Cédula Ciudadania', viewValue: 'Cédula Ciudadania'},
    {value: 'Cedula de Extranjeria', viewValue: 'Cédula de Extranjería'},
    {value: 'Pasaporte', viewValue: 'Pasaporte'},
    {value: 'Carnet Diplomatico', viewValue: 'Carnet Diplomatico'},
    {value: 'Registro Civil', viewValue: 'Registro Civil'},
    {value: 'Nit Persona Natural', viewValue: 'Nit Persona Natural'},
    {value: 'Nit Persona Juridica', viewValue: 'Nit Persona Jurídica'},
    // {value: 'Tarjeta De Identidad', viewValue: 'Tarjeta De Identidad'},
  ];

  createForm() {
    return new FormGroup({
      name: new FormControl('', [Validators.required]),
      date: new FormControl('', [Validators.required]),
      email: new FormControl('', [Validators.email]),
      text: new FormControl('', [Validators.maxLength(200)]),
      category: new FormControl('', [Validators.required]),
      gender: new FormControl('', [Validators.required]),
    })
  }

  guardar(){

  }



}
