import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { HttpClientModule, HttpClient } from '@angular/common/http';
import { TranslateModule, TranslateLoader } from '@ngx-translate/core';
import { TranslateHttpLoader } from '@ngx-translate/http-loader';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import {ButtonModule} from 'primeng/button';
import {MenuModule} from 'primeng/menu';
import {TabMenuModule} from 'primeng/tabmenu';
import {TableModule} from 'primeng/table';
import {FormsModule} from '@angular/forms';
import {TabViewModule} from 'primeng/tabview';
import {ChartModule} from 'primeng/chart';

import { AdminComponent } from './admin/admin.component';
import { ListaEmpresasComponent } from './admin/lista-empresas/lista-empresas.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { HomeComponent } from './admin/home/home.component';
import { EmpresasComponent } from './empresas/empresas.component';
import { ImportacionArchivoComponent } from './empresas/importacion-archivo/importacion-archivo.component';

export function createTranslateLoader(http: HttpClient) {
  return new TranslateHttpLoader(http, './assets/i18n/', '.json');
}

@NgModule({
  declarations: [
    AppComponent,
    AdminComponent,
    ListaEmpresasComponent,
    HomeComponent,
    EmpresasComponent,
    ImportacionArchivoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    TranslateModule.forRoot({
      loader: {
        provide: TranslateLoader,
        useFactory: (createTranslateLoader),
        deps: [HttpClient]
      }
    }),
    HttpClientModule,
    ButtonModule,
    MenuModule,
    TabMenuModule,
    TableModule,
    FormsModule,
    NgbModule,
    TabViewModule,
    ChartModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
