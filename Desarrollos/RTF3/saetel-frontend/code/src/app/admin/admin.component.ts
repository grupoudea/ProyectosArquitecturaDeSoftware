import { Component, OnInit } from '@angular/core';
import { MenuItem } from 'primeng/api';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  public items: MenuItem[];
  public activeItem: MenuItem;
  
  constructor() { }

  ngOnInit(): void {
    this.items = [
      {label: 'Home', icon: 'pi pi-fw pi-home', routerLink: ['/home']},
      {label: 'Lista de empresas', icon: 'pi pi-fw pi-list', routerLink: ['/lista-empresas']},
    ];
    this.activeItem = this.items[0];
  }

}
