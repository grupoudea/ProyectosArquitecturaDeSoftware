import { Component, OnInit } from '@angular/core';
import { MenuItem } from 'primeng/api';

@Component({
  selector: 'app-empresas',
  templateUrl: './empresas.component.html',
  styleUrls: ['./empresas.component.css']
})
export class EmpresasComponent implements OnInit {

  public items: MenuItem[];
  public activeItem: MenuItem;
  
  constructor() { }

  ngOnInit(): void {
    this.items = [
      {label: 'Home', icon: 'pi pi-fw pi-home', routerLink: ['../empresas']},
      {label: 'Importar archivo', icon: 'pi pi-fw pi-upload', routerLink: ['importar-archivo']},
    ];
    this.activeItem = this.items[0];
  }

}
