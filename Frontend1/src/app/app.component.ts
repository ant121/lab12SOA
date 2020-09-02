import { Component } from '@angular/core';
import { ClienteserviceService }  from './service/clienteservice.service';
import { Cliente } from './service/Cliente';
import { FormGroup, FormControl } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'frontend';
  clientes: Cliente[];
  clientesA: Cliente[];
  myFormCliente: FormGroup;
  idGet: number;
  titulo: string;


  constructor( public servc:ClienteserviceService){
    this.idGet = 0;
    this.titulo= 'Ingresar nuevos datos';
   }

  ngOnInit(){
    this.obtenerClientes()

    this.myFormCliente = new FormGroup({
      nombre: new FormControl(''),
      apellido: new FormControl(''),
      direccion: new FormControl(''),
      telefono: new FormControl(''),
      email: new FormControl('')
    });
  }

  obtenerClientes(){
    this.servc.getClientes().subscribe(r=>{
      console.table(r);
      return this.clientes=r
    })
  }

  ingresarDatosorUpdate(id: number){
    if(id == 0){    
      let nombre = this.myFormCliente.value.nombre;
      let apellido = this.myFormCliente.value.apellido;
      let direccion = this.myFormCliente.value.direccion;
      let telefono = this.myFormCliente.value.telefono;
      let email = this.myFormCliente.value.email;

      this.servc.addClinetes(nombre,apellido,direccion,telefono,email)
      .subscribe(r =>{
        this.obtenerClientes()
        this.myFormCliente = new FormGroup({
          nombre: new FormControl(''),
          apellido: new FormControl(''),
          direccion: new FormControl(''),
          telefono: new FormControl(''),
          email: new FormControl('')
        });
      })
    }else{
      let nombre = this.myFormCliente.value.nombre;
      let apellido = this.myFormCliente.value.apellido;
      let direccion = this.myFormCliente.value.direccion;
      let telefono = this.myFormCliente.value.telefono;
      let email = this.myFormCliente.value.email;
      this.idGet=0;
      this.titulo='Ingresar nuevos datos';
      this.servc.updateClientes(id,nombre,apellido,direccion,telefono,email)
      .subscribe(r =>{
        this.obtenerClientes()
        this.myFormCliente = new FormGroup({
          nombre: new FormControl(''),
          apellido: new FormControl(''),
          direccion: new FormControl(''),
          telefono: new FormControl(''),
          email: new FormControl('')
        });
      })
  }
}

actualizarDatos(id: number){
  this.servc.getClientesId(id).subscribe(r=>{
    this.clientesA = r;
    this.titulo='Actualizar datos de ' + this.clientesA['nombre'];
    this.myFormCliente = new FormGroup({
      nombre: new FormControl(this.clientesA['nombre']),
      apellido: new FormControl(this.clientesA['apellido']),
      direccion: new FormControl(this.clientesA['direccion']),
      telefono: new FormControl(this.clientesA['telefono']),
      email: new FormControl(this.clientesA['email'])
    });
    this.idGet=this.clientesA['idCliente']
  })
}


eliminardatos(id: number){
  this.servc.deleteClientes(id).subscribe(r =>{
    this.obtenerClientes()
  })
}

}
