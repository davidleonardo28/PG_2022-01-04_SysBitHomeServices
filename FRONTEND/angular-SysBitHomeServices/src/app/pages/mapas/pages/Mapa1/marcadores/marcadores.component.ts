import { AfterViewInit, Component, ElementRef, ViewChild } from '@angular/core';
import { LoginService } from '@auth/login/login.service';
import * as mapboxgl from 'mapbox-gl';
import swal from 'sweetalert2';

interface MarcadorColor {
  color: string;
  marker?: mapboxgl.Marker;
  // popup?: mapboxgl.Popup;
  centro?: [number, number];
  direccion?:string;
  telefono?:number;
}

@Component({
  selector: 'app-marcadores',
  templateUrl: './marcadores.component.html',
  styles: [
    `
      .mapa-container {
        height: 100%;
        width: 100%;
      }

      .list-group {
        position: fixed;
        top: 95px;
        right: 20px;
        z-index: 99;
      }
      li {
        cursor: pointer;
      }
      .row {
        background-color: white;
        border-radius: 5px;
        bottom: 50px;
        left: 50px;
        padding: 10px;
        position: fixed;
        z-index: 999;
        width: 400px;
      }
      .static {
        position: static ;

      }
    `,
  ],
})
export class MarcadoresComponent implements AfterViewInit {
  @ViewChild('mapa') divMapa!: ElementRef;
  mapa!: mapboxgl.Map;
  zoomLevel: number = 12;
  center: [number, number] = [-74.0818175, 4.619714];

  ngOnDestroy(): void {
    this.mapa.off('zoom', () => { });
    this.mapa.off('zoomend', () => { });
    this.mapa.off('move', () => { });
  }
  // Arreglo de marcadores
  marcadores: MarcadorColor[] = [];

  constructor(public loginService: LoginService) {

  }

  ngAfterViewInit(): void {
    this.mapa = new mapboxgl.Map({
      container: this.divMapa.nativeElement,
      style: 'mapbox://styles/mapbox/streets-v11',
      center: this.center,
      zoom: this.zoomLevel,
    });

    this.mapa.on('zoom', (ev) => {
      this.zoomLevel = this.mapa.getZoom();
    });

    this.mapa.on('zoomend', (ev) => {
      if (this.mapa.getZoom() > 18) {
        this.mapa.zoomTo(18);
      }
    });

    // Movimiento del mapa
    this.mapa.on('move', (event) => {
      const target = event.target;
      const { lng, lat } = target.getCenter();
      this.center = [lng, lat];
    });

    this.leerLocalStorage();

    // const markerHtml: HTMLElement = document.createElement('div');
    // markerHtml.innerHTML = 'Hola Mundo';

    // new mapboxgl.Marker()
    //   .setLngLat( this.center )
    //   .addTo( this.mapa );
  }
  agregarMarcador() {
    swal({
      title: 'Ingrese su dirección',
      html:
        '<input id="direccion-input" class="swal2-input" placeholder="Escriba su dirección">' +
        '<input id="telefono-input" class="swal2-input" placeholder="Escriba su número de teléfono">',
      showCancelButton: true,
      confirmButtonText: 'Aceptar',
      cancelButtonText: 'Cancelar',
      preConfirm: () => {
        const direccion = (document.getElementById('direccion-input') as HTMLInputElement).value;
        const telefono = (document.getElementById('telefono-input') as HTMLInputElement).value;
        return { direccion, telefono };
      }
    }).then((result) => {
      if (result.value) {
        const { direccion, telefono } = result.value;
        const color = '#xxxxxx'.replace(/x/g, (y) =>
          ((Math.random() * 16) | 0).toString(16)
        );
  
        const nuevoMarcador = new mapboxgl.Marker({
          draggable: true,
          color,
        })
          .setLngLat(this.center)
          .addTo(this.mapa);
  
        this.marcadores.push({
          color,
          marker: nuevoMarcador,
          direccion: direccion,
          telefono: telefono // Agregar el número de teléfono al objeto MarcadorColor
        });
  
        this.guardarMarcadoresLocalStorage();
  
        nuevoMarcador.on('dragend', () => {
          this.guardarMarcadoresLocalStorage();
        });
        
      }
    });
  }
  
  

  irMarcador(marker: mapboxgl.Marker) {
    this.mapa.flyTo({
      center: marker.getLngLat(),
    });
  }

  guardarMarcadoresLocalStorage() {
    const lngLatArr: MarcadorColor[] = [];

    this.marcadores.forEach((m) => {
      const color = m.color;
      const { lng, lat } = m.marker!.getLngLat();

      lngLatArr.push({
        color: color,
        centro: [lng, lat],
        direccion:m.direccion,
        telefono:m.telefono
      });
    });

    localStorage.setItem('marcadores', JSON.stringify(lngLatArr));
  }

  leerLocalStorage() {
    if (!localStorage.getItem('marcadores')) {
      return;
    }

    const lngLatArr: MarcadorColor[] = JSON.parse(localStorage.getItem('marcadores')!);

    lngLatArr.forEach((m) => {
      const newMarker = new mapboxgl.Marker({
        color: m.color,
        draggable: true,
        
      })
        .setLngLat(m.centro!)
        .addTo(this.mapa);

      this.marcadores.push({
        marker: newMarker,
        color: m.color,
        direccion: m.direccion,
        telefono:m.telefono

      });

      newMarker.on('dragend', () => {
        this.guardarMarcadoresLocalStorage();
      });


      // Agregar enlace al contenido del marcador
      const link = document.createElement('a');
      link.href = '../pagos/cuidadopersonal';
      link.textContent = 'Ver el servicio que vas a solicitar.';
      console.log(m.direccion)
      link.addEventListener('click', (event) => {
        event.preventDefault();
        
        swal({
          text: `Dirección: ${m.direccion} - Telefono: ${m.telefono}`,
          type: 'info',
          showCancelButton: true,
          confirmButtonColor: '#3085d6',
          cancelButtonColor: '#d33',
          confirmButtonText: 'Si',
          cancelButtonText: 'No',
          confirmButtonClass: 'btn btn-success',
          cancelButtonClass: 'btn btn-danger',
          buttonsStyling: false,
          reverseButtons: true
        }).then((result) => {
          if (result.value) {
            window.open(link.href, '_blank');
          } else {
            // Acciones cuando se selecciona "No"
          }
        });
      });

      const popup = new mapboxgl.Popup().setDOMContent(link);

      newMarker.setPopup(popup);
    });
  }

  borrarMarcador(i: number) {
    this.marcadores[i].marker?.remove();
    this.marcadores.splice(i, 1);
    this.guardarMarcadoresLocalStorage();
  }

  zoomOut() {
    this.mapa.zoomOut();
  }

  zoomIn() {
    this.mapa.zoomIn();
  }

  zoomCambio(valor: string) {
    this.mapa.zoomTo(Number(valor));
  }
}
