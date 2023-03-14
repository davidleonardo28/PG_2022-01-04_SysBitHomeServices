import { Component } from '@angular/core';

interface Propiedad {
  titulo: string;
  descripcion: string;
  lngLat: [number, number];
}

@Component({
  selector: 'app-propiedades',
  templateUrl: './propiedades.component.html',
  styles: [
  ]
})
export class PropiedadesComponent {

  propiedades: Propiedad[] = [
    {
      titulo: 'Servicio de Aseo',
      descripcion: 'Busca profesionales para servicio de aseo.',
      lngLat: [  -74.08953691,4.632881126]
    },
    {
      titulo: 'Servicio de Pintura',
      descripcion: 'Si quieres hacer una remodelación y reforma de baños, cocinas, una reforma integral o parcial de tu casa.',
      lngLat: [ -74.14575223267086,4.651630860090506]
    },
    {
      titulo: 'Servicio de Albañieria',
      descripcion: 'Albañiles para reformas, construcciones o tareas de bricolage en casa.',
      lngLat: [ -74.14685375722232 , 4.680683685428978 ]
    },
    {
      titulo: 'Servicio de Niñera',
      descripcion: 'Tenemos cuidadores domiciliarios en Bogotá que se encargan de cuidar a ancianos y personas con necesidades especiales.',
      lngLat: [  -74.04317029303826, 4.7364564278180055 ]
    },
    {
      titulo: 'Servicio de arreglos de flores',
      descripcion: 'Jardineros en Bogotá que prestan su servicio a través de la aplicación',
      lngLat: [  -74.13823533960218 , 4.617052425350363]
    },
    {
      titulo: 'Servicio de seguridad Privada',
      descripcion: 'Tenemos empresas de seguridad en Bogotá y profesionales que se dedican a la seguridad privada en toda la ciudad.',
      lngLat: [  -74.11561138798776, 4.632777165304997 ]
    },
    {
      titulo: 'Servicio de Plomeria',
      descripcion: 'Encuentra plomeros matriculados para arreglo de goteras, instalación de tanques de agua, limpieza de tuberías y mucho más.',
      lngLat: [  -74.09020550729421, 4.7412465156575045, ]
    },
    {
      titulo: 'Servicio de Veterinaria',
      descripcion: 'Busca y encuentra un cuidador de perros en Bogotá confiable a través de la aplicacion y no dejes tu perro a cualquiera',
      lngLat: [ -74.11461619593415, 4.600690269583866 ]
    },
  ]

}
