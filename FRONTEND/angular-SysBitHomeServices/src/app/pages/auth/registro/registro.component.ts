import { Component, ViewEncapsulation } from '@angular/core';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  Validators,
} from '@angular/forms';
import { MatCalendarCellClassFunction } from '@angular/material/datepicker';
import { PDFSource, PDFProgressData, PDFDocumentProxy } from 'ng2-pdf-viewer';
import { pdfDefaultOptions } from 'ngx-extended-pdf-viewer';

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
export class RegistroComponent {
  public registroUsuarios: FormGroup;
  src = '../../../../assets/pdf/certificado-para-empleados.pdf';
  pdfSrc: string | PDFSource | ArrayBuffer = './assets/pdf-test.pdf';
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
    pdfDefaultOptions.assetsFolder = 'bleeding-edge';
  }


  private _zoomSetting: number | string | undefined = 'page-width';
  private currentZoomFactor!: number;
  // getter and setter make the demo nicer -
  // you probably don't need them in your code
  public get zoomSetting(): number | string {
    return String(this._zoomSetting);
  }
  public set zoomSetting(zoom: number | string) {
    if (isNaN(Number(zoom))) {
      this._zoomSetting = zoom;
    } else {
      this._zoomSetting = zoom + '%';
    }
  }
  public updateZoomFactor(zoom: number): void {
    this.currentZoomFactor = zoom;
  }

  documento: Documento[] = [
    { value: 'Cédula Ciudadania', viewValue: 'Cédula Ciudadania' },
    { value: 'Cedula de Extranjeria', viewValue: 'Cédula de Extranjería' },
    { value: 'Pasaporte', viewValue: 'Pasaporte' },
    { value: 'Carnet Diplomatico', viewValue: 'Carnet Diplomatico' },
    { value: 'Registro Civil', viewValue: 'Registro Civil' },
    { value: 'Nit Persona Natural', viewValue: 'Nit Persona Natural' },
    { value: 'Nit Persona Juridica', viewValue: 'Nit Persona Jurídica' },
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
    });
  }

  guardar() {}

  onFileSelected() {
    const $pdf: any = document.querySelector('#file');

    if (typeof FileReader !== 'undefined') {
      const reader = new FileReader();

      reader.onload = (e: any) => {
        this.pdfSrc = e.target.result;
      };

      reader.readAsArrayBuffer($pdf.files[0]);
    }
  }

  loadPdf() {
    const xhr = new XMLHttpRequest();
    xhr.open('GET', '/assets/pdf-test.pdf', true);
    xhr.responseType = 'blob';

    xhr.onload = (e: any) => {
      console.log(xhr);
      if (xhr.status === 200) {
        const blob = new Blob([xhr.response], { type: 'application/pdf' });
        this.pdfSrc = URL.createObjectURL(blob);
      }
    };

    xhr.send();
  }
}
