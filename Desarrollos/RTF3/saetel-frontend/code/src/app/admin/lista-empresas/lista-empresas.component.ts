import { Component, OnInit } from '@angular/core';
import { MenuItem } from 'primeng/api';
import { InscripcionEmpresaDto } from '../dto/inscripcion-empresa.dto';
import { InscripcionEmpresaService } from '../service/inscripcion-empresa.service';

@Component({
  selector: 'app-lista-empresas',
  templateUrl: './lista-empresas.component.html',
  styleUrls: ['./lista-empresas.component.css']
})
export class ListaEmpresasComponent implements OnInit {

  public items: MenuItem[];
  public activeItem: MenuItem;
  public empresasInscritas = new InscripcionEmpresaDto();
  public empresasNoInscritas = new InscripcionEmpresaDto();

  constructor(
    private readonly inscripcionService: InscripcionEmpresaService
  ) { }

  ngOnInit(): void {
    this.items = [
      {label: 'Home', icon: 'pi pi-fw pi-home', routerLink: ['../home']},
      {label: 'Lista de empresas', icon: 'pi pi-fw pi-list', routerLink: ['../lista-empresas']},
    ];
    this.activeItem = this.items[0];
    this.getEmpresasInscritas();
    this.getEmpresasNoInscritas();
  }

  getEmpresasInscritas() {
    this.inscripcionService.getEmpresasInscritas().subscribe(
      data => {
        if (data.body) {
          this.empresasInscritas = data.body;
          console.log(this.empresasInscritas);
          
        }
      }, error => {
        console.log('Error'.concat(error));
      });
  }

  getEmpresasNoInscritas() {
    this.inscripcionService.getEmpresasNoInscritas().subscribe(
      data => {
        if (data.body) {
          this.empresasNoInscritas = data.body;
          console.log(this.empresasNoInscritas);
          
        }
      }, error => {
        console.log('Error'.concat(error));
      });
  }

}
