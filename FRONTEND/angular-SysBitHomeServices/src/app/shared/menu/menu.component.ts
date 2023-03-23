import { Component } from '@angular/core';

interface MenuItem {
  ruta: string;
  nombre: string;
}


@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styles: [
    `
      li {
        cursor: pointer;
      }
    `
  ]
})
export class MenuComponent {

  menuItems: MenuItem[] = [
    {
      ruta: '/localizacion/fullscreen',
      nombre: 'FullScreen'
    },
    {
      ruta: '/localizacion/marcadores',
      nombre: 'Servicios Doméstico'
    },
    {
      ruta: '/localizacion/propiedades',
      nombre: 'Servicios en Curso'
    },
  ];
}
