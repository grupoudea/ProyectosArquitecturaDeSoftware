import { Component, OnInit } from '@angular/core';
import { MenuItem } from 'primeng/api';
import * as XLSX from 'xlsx';
import { ClienteDto } from '../dto/cliente.dto';
import { ColumnasPlantillaExcel } from '../dto/COLUMNAS_PLANTILLA.dto';
import { TipoDocumentoDto } from '../dto/tipo-documento.dto';
import { ClienteService } from '../service/cliente.service';

@Component({
  selector: 'app-importacion-archivo',
  templateUrl: './importacion-archivo.component.html',
  styleUrls: ['./importacion-archivo.component.css']
})
export class ImportacionArchivoComponent implements OnInit {

  public items: MenuItem[];
  public activeItem: MenuItem;

  flag: boolean;
  arrayBuffer: any;
  jsontext: any[]= [];
  disabledBtnGuardarArchivo = true;
  tiposDocumentos: TipoDocumentoDto[] = [];
  
  constructor(
    private readonly clienteService: ClienteService
  ) { }

  ngOnInit(): void {
    this.items = [
      {label: 'Home', icon: 'pi pi-fw pi-home', routerLink: ['../../empresas']},
      {label: 'Importar archivo', icon: 'pi pi-fw pi-upload', routerLink: ['../importar-archivo']},
    ];
    this.activeItem = this.items[0];

    this.getTiposDocumentos();
  }

  public onUpload(event: {[x: string]: any[] }){
    this.excelToJson(event['files'][0])
  }

  public onRemove(event: {[x: string]: any[] }){

  }

  descargarPlantilla(){}

  guardarClientes(clientes: ClienteDto[]) {
    this.clienteService.crearClientes(clientes).subscribe(
      data => {
        if (data.body) {
                   
        }
      }, error => {
        console.log('Error'.concat(error));
      });
  }

  getTiposDocumentos() {
    this.clienteService.getTiposDocumentos().subscribe(
      data => {
        if (data.body) {
          this.tiposDocumentos = data.body;
        }
      }, error => {
        console.log('Error'.concat(error));
      });
  }

  public excelToJson(file: File){
    this.flag = false;
    let fileReader = new FileReader();
    fileReader.readAsArrayBuffer(file);
    fileReader.onload = (e) => {
        this.arrayBuffer = fileReader.result;
        var data = new Uint8Array(this.arrayBuffer);
        var arr = new Array();
        for(var i = 0; i != data.length; ++i) arr[i] = String.fromCharCode(data[i]);
        var bstr = arr.join("");
        var workbook = XLSX.read(bstr, {type:"binary"});
        var first_sheet_name = workbook.SheetNames[0];
        var worksheet = workbook.Sheets[first_sheet_name];
        this.jsontext = XLSX.utils.sheet_to_json<string>(worksheet,{raw:true});                
        this.validarJson(this.jsontext);
    }
    fileReader.onloadend = (e) =>{
        this.flag = true;
    }
  }

  validarJson(jsontext: any[]){
    if(this.jsontext.length>0){
      let json = jsontext[0];
      const obj = JSON.parse(JSON.stringify(json));    
      let arrColumnas = this.obtenerColumnasPlantilla();
      let jsonValido = true;
      for(const i in obj){
        let dato = arrColumnas.find(item => item===i);
        if(!dato){
          this.disabledBtnGuardarArchivo = true;
          jsonValido = false;
                    break;
        }
      }
      if(jsonValido){
        this.disabledBtnGuardarArchivo = false;
      }
    }else{
      this.disabledBtnGuardarArchivo = true;
    }
  }

  obtenerColumnasPlantilla(){
    const obj2 = JSON.parse(JSON.stringify(new ColumnasPlantillaExcel())); 
    let arr: any[] = [];
    for(const i in obj2){
      arr.push(i);
    }
    return arr;
  }

  construirClientes(){
    this.disabledBtnGuardarArchivo = true;
    const clientes: ClienteDto[] = [];
    let huboError = false;
    for(let registro of this.jsontext){
      registro = this.limpiarEspacios(registro);

      const numeroValido = this.validarNumeroDocumento(registro);
      if(!numeroValido){
        huboError = true;
        break;
      }
      const tipoValido = this.validarTipoDocumento(registro);
      if(!tipoValido){
        huboError = true;
        break;
      }

      const cliente = new ClienteDto();      
        cliente.numeroDocumento = registro.NUMERO_DOCUMENTO,
        cliente.idTipoDocumento = this.tiposDocumentos.find(item => item.descripcion===registro.TIPO_DOCUMENTO).id,
        cliente.primerNombre = registro.PRIMER_NOMBRE,
        cliente.segundoNombre = registro.SEGUNDO_NOMBRE,
        cliente.primerApellido = registro.PRIMER_APELLIDO,
        cliente.segundoApellido = registro.SEGUNDO_APELLIDO,
        cliente.direccionResidencia = registro.DIRECCION_RESIDENCIA,
        cliente.celularPrincipal = registro.CELULAR_PRINCIPAL,
        cliente.celularSecundario = registro.CELULAR_SECUNDARIO,
        cliente.telefonoFijo = registro.TELEFONO_FIJO
      
      clientes.push(cliente);
    }

    if(clientes.length>0 && !huboError){
      this.guardarClientes(clientes);
    }
  }

  limpiarEspacios(registro: any){
    let registroLimpio: any = {};
    registroLimpio.TIPO_DOCUMENTO = this.getTextoLimpio(registro.TIPO_DOCUMENTO);
    registroLimpio.NUMERO_DOCUMENTO = this.getTextoLimpio(registro.NUMERO_DOCUMENTO);
    registroLimpio.PRIMER_NOMBRE = this.getTextoLimpio(registro.PRIMER_NOMBRE);
    registroLimpio.SEGUNDO_NOMBRE = this.getTextoLimpio(registro.SEGUNDO_NOMBRE);
    registroLimpio.PRIMER_APELLIDO = this.getTextoLimpio(registro.PRIMER_APELLIDO);
    registroLimpio.SEGUNDO_APELLIDO = this.getTextoLimpio(registro.SEGUNDO_APELLIDO);
    registroLimpio.DIRECCION_RESIDENCIA = this.getTextoLimpio(registro.DIRECCION_RESIDENCIA);
    registroLimpio.CELULAR_PRINCIPAL = this.getTextoLimpio(registro.CELULAR_PRINCIPAL);
    registroLimpio.CELULAR_SECUNDARIO = this.getTextoLimpio(registro.CELULAR_SECUNDARIO);
    registroLimpio.TELEFONO_FIJO = this.getTextoLimpio(registro.TELEFONO_FIJO);
    return registroLimpio
  }

  getTextoLimpio(valor: any){
    return valor?valor.toString().trim():null;
  }

  validarNumeroDocumento(registro: any){
    if(!registro.NUMERO_DOCUMENTO){
      return false;
    }
    if(registro.NUMERO_DOCUMENTO.length < 6){
      return false;
    }
    return true;
  }

  validarTipoDocumento(registro: any){
    const dato = this.tiposDocumentos.find(item => item.descripcion===registro.TIPO_DOCUMENTO);
    if(!dato){
      return false;
    }    
    return true;
  }

}
