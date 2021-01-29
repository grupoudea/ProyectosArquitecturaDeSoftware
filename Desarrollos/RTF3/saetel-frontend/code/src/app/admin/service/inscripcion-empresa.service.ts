import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

const urlBase = environment.SERVER_API_URL;
const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class InscripcionEmpresaService {

  constructor(private httpClient: HttpClient) { }

  getEmpresasInscritas(): Observable<any> {
    return this.httpClient.get<any>(`${urlBase}/inscripcion-empresa/get-inscritas`, httpOptions);
  }

}
