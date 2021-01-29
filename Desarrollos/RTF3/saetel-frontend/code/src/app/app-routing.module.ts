import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminComponent } from './admin/admin.component';
import { HomeComponent } from './admin/home/home.component';
import { ListaEmpresasComponent } from './admin/lista-empresas/lista-empresas.component';

const routes: Routes = [
  {path: 'admin', redirectTo: '/admin', pathMatch: 'full'},
  {path: 'admin', component: AdminComponent},
  {path: 'admin/home', component: HomeComponent},
  {path: 'admin/lista-empresas', component: ListaEmpresasComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
