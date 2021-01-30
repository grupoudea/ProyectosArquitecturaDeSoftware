import { Component, OnInit } from '@angular/core';
import { MenuItem } from 'primeng/api';
import * as XLSX from 'xlsx';
import { ColumnasPlantillaExcel } from '../dto/COLUMNAS_PLANTILLA.dto';

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
  jsontext: any[] = [];
  disabledBtnGuardarArchivo = true;

  constructor() { }

  ngOnInit(): void {
    this.items = [
      { label: 'Home', icon: 'pi pi-fw pi-home', routerLink: ['../../empresas'] },
      { label: 'Importar archivo', icon: 'pi pi-fw pi-upload', routerLink: ['../importar-archivo'] },
    ];
    this.activeItem = this.items[0];
  }

  public onUpload(event: { [x: string]: any[] }) {
    this.excelToJson(event['files'][0])
  }

  public onRemove(event: { [x: string]: any[] }) {

  }

  descargarPlantilla() {
    const nombreArchivo = "PLANTILLA_CLIENTES.xlsx"
    const rutaArchivo = "assets/PLANTILLA_CLIENTES.xlsx"
    const linkDescarga = document.createElement('a');
    linkDescarga.href = rutaArchivo
    linkDescarga.setAttribute('download', nombreArchivo)
    document.body.appendChild(linkDescarga)
    linkDescarga.click()
  }

  public excelToJson(file: File) {
    this.flag = false;
    let fileReader = new FileReader();
    fileReader.readAsArrayBuffer(file);
    fileReader.onload = (e) => {
      this.arrayBuffer = fileReader.result;
      var data = new Uint8Array(this.arrayBuffer);
      var arr = new Array();
      for (var i = 0; i != data.length; ++i) arr[i] = String.fromCharCode(data[i]);
      var bstr = arr.join("");
      var workbook = XLSX.read(bstr, { type: "binary" });
      var first_sheet_name = workbook.SheetNames[0];
      var worksheet = workbook.Sheets[first_sheet_name];
      this.jsontext = XLSX.utils.sheet_to_json<string>(worksheet, { raw: true });
      console.log(this.jsontext);

      this.validarJson(this.jsontext);
    }
    fileReader.onloadend = (e) => {
      this.flag = true;
    }
  }

  validarJson(jsontext: any[]) {
    if (this.jsontext.length > 0) {
      let json = jsontext[0];
      const obj = JSON.parse(JSON.stringify(json));
      let arrColumnas = this.obtenerColumnasPlantilla();
      let jsonValido = true;
      for (const i in obj) {
        let dato = arrColumnas.find(item => item === i);
        if (!dato) {
          this.disabledBtnGuardarArchivo = true;
          jsonValido = false;
          console.log("El archivo no cumple con los requerimientos de la plantilla");

          // this.mensajeToast('error', `El archivo no cumple con los requerimientos de la plantilla`, false)
          break;
        }
      }
      if (jsonValido) {
        this.disabledBtnGuardarArchivo = false;
      }
    } else {
      console.log("El archivo no tiene registros");

      // this.mensajeToast('error', `El archivo no tiene registros`, false)
      this.disabledBtnGuardarArchivo = true;
    }
  }

  obtenerColumnasPlantilla() {
    const obj2 = JSON.parse(JSON.stringify(new ColumnasPlantillaExcel()));
    let arr: any[] = [];
    for (const i in obj2) {
      arr.push(i);
    }
    return arr;
  }

  construirClientes() {
    this.disabledBtnGuardarArchivo = true;
    const clientes: any[] = [];
    let huboError = false;
    for (let registro of this.jsontext) {
      registro = this.limpiarEspacios(registro);
    }
  }

  limpiarEspacios(registro: any) {
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
    registroLimpio.NUMERO_CONTRATO = this.getTextoLimpio(registro.NUMERO_CONTRATO);
    registroLimpio.DIRECCION_SERVICIO = this.getTextoLimpio(registro.DIRECCION_SERVICIO);
    registroLimpio.FECHA_INICIO_CONTRATO = this.getTextoLimpio(registro.FECHA_INICIO_CONTRATO);
    registroLimpio.FECHA_FIN_CONTRATO = this.getTextoLimpio(registro.FECHA_FIN_CONTRATO);
    registroLimpio.ESTRATO = this.getTextoLimpio(registro.ESTRATO);
  }

  getTextoLimpio(valor: any) {
    return valor ? valor.toString().trim() : null;
  }

}
