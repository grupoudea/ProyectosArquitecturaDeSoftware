import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ClienteDto } from '../dto/cliente.dto';

const urlBase = environment.SERVER_API_URL;
const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  constructor(private httpClient: HttpClient) { }

  crearClientes(clientes: ClienteDto[]): Observable<any> {
    return this.httpClient.post(urlBase.concat('/cliente'), clientes, httpOptions);
  }

  getTiposDocumentos(): Observable<any> {
    return this.httpClient.get<any>(`${urlBase}/cliente/get-tipos-documentos`, httpOptions);
  }

}
