import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminComponent } from './admin/admin.component';
import { HomeComponent } from './admin/home/home.component';
import { ListaEmpresasComponent } from './admin/lista-empresas/lista-empresas.component';
import { EmpresasComponent } from './empresas/empresas.component';
import { ImportacionArchivoComponent } from './empresas/importacion-archivo/importacion-archivo.component';

const routes: Routes = [
  {path: 'admin', redirectTo: '/admin', pathMatch: 'full'},
  {path: 'admin', component: AdminComponent},
  {path: 'admin/home', component: HomeComponent},
  {path: 'admin/lista-empresas', component: ListaEmpresasComponent},
  {path: 'empresas', component: EmpresasComponent},
  {path: 'empresas/importar-archivo', component: ImportacionArchivoComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
