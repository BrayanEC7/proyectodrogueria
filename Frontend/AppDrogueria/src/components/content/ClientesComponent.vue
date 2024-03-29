<template>
    <div class="right_col" role="main">
        <div class="row">
			<div class="col-md-12 col-sm-12 ">
				<div class="x_panel" id="tabladatosclientes">
					<div class="x_title">
						<h2>Registro de Clientes <small>listado</small></h2>
						<ul class="nav navbar-right panel_toolbox">
							<li><a class="collapse-link">
								<i class="fa fa-chevron-up"></i></a>
							</li>
							<li class="dropdown">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><i class="fa fa-wrench"></i></a>
								<ul class="dropdown-menu" role="menu">
									<li><a class="dropdown-item" href="#">Settings 1</a>
									</li>
									<li><a class="dropdown-item" href="#">Settings 2</a>
									</li>
								</ul>
							</li>
							<li><a class="close-link"><i class="fa fa-close"></i></a>
							</li>
						</ul>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
						<div class="row">
							<div class="col-sm-12 input-group mb-3">
								<input type="text" id="searchnombre" name="searchnombre" v-model="searchnombre"
									v-on:blur="iniciarCarga();" required class="form-control"
									placeholder="Buscar por nombre de Clientes">
								<div class="input-group-append">
									<button class="btn btn-primary" type="button"
										style="width: 40px; height: 40px;"></button>
								</div>
							</div>

                          <div class="col-sm-12">
                            <div class="card-box table-responsive">
                    <table id="datatable-fixed-header" class="table table-striped table-bordered" style="width:100%">
                      <thead>
                        <tr>
                          <th>Tipo documento</th>
                          <th>Número de Documento</th>
                          <th>Nombre</th>
                          <th>Celular</th>
                          <th>Correo</th>
						  <th>Dirección</th>
						  <th>Acciones</th>
                        </tr>
                      </thead>


                      <tbody>
                        <tr v-for="itemCliente in listaclientes ">
                          <td>{{itemCliente.tipoDocumento}}</td>
                          <td>{{ itemCliente.numDocCliente }}</td>
                          <td>{{itemCliente.nombreCliente}}</td>
						  <td>{{itemCliente.celularCliente}}</td>
                          <td>{{ itemCliente.correoCliente }}</td>
                          <td>{{itemCliente.direccionCliente}}</td>
						  <td class="text-center">
							<i class="fa fa-pencil" v-on:click="editarCliente(itemCliente)" style="cursor:pointer; padding-right: 1ex; color: burlywood;"></i>
							<i class="fa fa-trash" v-on:click="eliminarCliente(itemCliente.id)"  style="cursor:pointer; color:red"></i>
						  </td>
                        </tr>                       
                      </tbody>
                    </table>
                  </div>
                </div>
              </div>

					</div>
				</div>
				<div class="x_panel" id="formularioempleados">
                    <div class="x_title">
                        <h2>Registro de Empleados <small>editar/crear</small></h2>
                        <ul class="nav navbar-right panel_toolbox">
                            <li><a class="collapse-link">
                                    <i class="fa fa-chevron-up"></i></a>
                            </li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                                    aria-haspopup="true" aria-expanded="false"><i class="fa fa-wrench"></i></a>
                                <ul class="dropdown-menu" role="menu">
                                    <li><a class="dropdown-item" href="#">Settings 1</a>
                                    </li>
                                    <li><a class="dropdown-item" href="#">Settings 2</a>
                                    </li>
                                </ul>
                            </li>
                            <li><a class="close-link"><i class="fa fa-close"></i></a>
                            </li>
                        </ul>
                        <div class="clearfix"></div>
                    </div>
                    <div class="x_content">
                        <br />
                        <form id="frmEmpleado" v-on:submit="guardardatos()" data-parsley-validate
                            class="form-horizontal form-label-left">
                            <input type="hidden" id="id" name="id" v-model="id"/>
							
							

							<div class="form-group row">
								<label class="control-label col-md-3 col-sm-3 label-align" for="tipoDocumento">Tipo de Documento</label>
								<div class="col-md-6 col-sm-6 ">
									<select v-model="tipoDocumento" class="select2_single form-control" tabindex="-1">
										<option disabled value="">Seleccione una opción</option>									
										<option v-for="opcion in opciones" :key="opcion.ide" :value="opcion.valor">{{ opcion.texto }}</option>
									</select>
								</div>
							</div>
  
							<div class="item form-group">
                                <label class="col-form-label col-md-3 col-sm-3 label-align" for="numDocCliente">
                                    <span class="required"></span>
                                </label>
                                <div class="col-md-6 col-sm-6 ">
                                    <input type="text" class="form-control has-feedback-left" id="numDocCliente" name="numDocCliente" v-model="numDocCliente"
                                        placeholder="Número de Documento">
                                    <span class="fa fa-credit-card form-control-feedback left" aria-hidden="true"></span>
                                </div>
                            </div>
							
                            <div class="item form-group">
                                <label class="col-form-label col-md-3 col-sm-3 label-align" for="nombreCliente">
                                    <span class="required"></span>
                                </label>
                                <div class="col-md-6 col-sm-6 ">
                                    <input type="text" class="form-control has-feedback-left" id="nombreCliente" name="nombreCliente" v-model="nombreCliente"
                                        placeholder="Nombre">
                                    <span class="fa fa-user form-control-feedback left" aria-hidden="true"></span>
                                </div>
                            </div>

                            <div class="item form-group">
                                <label class="col-form-label col-md-3 col-sm-3 label-align" for="celularCliente">
                                    <span class="required"></span>
                                </label>
                                <div class="col-md-6 col-sm-6 ">
                                    <input type="text" class="form-control has-feedback-left" id="celularCliente" name="celularCliente" v-model="celularCliente"
                                        placeholder="Celular">
                                    <span class="fa fa-phone form-control-feedback left" aria-hidden="true"></span>
                                </div>
                            </div>

                            <div class="item form-group">
                                <label class="col-form-label col-md-3 col-sm-3 label-align" for="correoCliente">
                                    <span class="required"></span>
                                </label>
                                <div class="col-md-6 col-sm-6 ">
                                    <input type="tel" class="form-control has-feedback-left" id="correoCliente" name="correoCliente" v-model="correoCliente"
                                        placeholder="Correo electrónico">
                                    <span class="fa fa-envelope-o form-control-feedback left" aria-hidden="true"></span>
                                </div>
                            </div>

                            <div class="item form-group">
                                <label class="col-form-label col-md-3 col-sm-3 label-align" for="direccionCliente">
                                    <span class="required"></span>
                                </label>
                                <div class="col-md-6 col-sm-6 ">
                                    <input type="tel" class="form-control has-feedback-left" id="direccionCliente" name="direccionCliente" v-model="direccionCliente"
                                        placeholder="Dirección de envío">
                                    <span class="fa fa-bus form-control-feedback left" aria-hidden="true"></span>
                                </div>
                            </div>

                            <div class="ln_solid"></div>
                            <div class="item form-group">
                                <div class="col-md-6 col-sm-6 offset-md-3">
                                    <button class="btn btn-primary" type="button" v-on:click="cancelar()">Cancel</button>
                                    <button class="btn btn-primary" type="reset">Reset</button>
                                    <button type="submit" class="btn btn-success" v-on:click="cargardatos()">Submit</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
			</div>
		</div>
    </div>
</template>
<script>
export default{
	data() {
      return {
		id:null,
		opciones: [
        { ide: 1, valor: 'DNI', texto: 'DNI (Documento Nacional de Identidad)' },
        { ide: 2, valor: 'RUC', texto: 'RUC (Registro Único de Contribuyentes)' },
        { ide: 3, valor: 'CE', texto: 'CE (Carné de Extranjería)' },
      	],
		tipoDocumento: null,
        numDocCliente:"",
		nombreCliente:"",
		celularCliente:"",
		correoCliente:"",
		direccionCliente:"",
		listaclientes:[],
		searchnombre:"",
      	
    };
    },
	methods: {
		async iniciarCarga() {
			try {
				var urltmp="http://localhost:8080/v1/cliente/buscarBy/"+this.searchnombre;
				if(this.searchnombre=="") urltmp=urltmp="http://localhost:8080/v1/cliente/";
				const response = await fetch(urltmp);
				this.listaclientes= this.listClienteItems = await response.json();   
			} catch (error) {
			//console.log(error);
			}
		},
		guardardatos(){
			var data = { 
				tipoDocumento: this.tipoDocumento,
				numDocCliente:this.numDocCliente,
				nombreCliente:this.nombreCliente,
				celularCliente:this.celularCliente,
				correoCliente:this.correoCliente,
				direccionCliente:this.direccionCliente
			};
			var metodo="POST";

			console.log(this.id)
			
			if(this.id!=null||this.id!=""){//guardar datos			
				data.id=this.id
				metodo="PUT";
			}

			fetch("http://localhost:8080/v1/cliente/", {
			method: metodo, // or 'PUT'
			headers: {"Content-Type": "application/json",},
			body: JSON.stringify(data),
			}).then((response) => response.json())
			.then((data) => {
				this.iniciarCarga();
			})
			.catch((error) => {
				console.error("Error:", error);
				return;
			});
		},
		editarCliente(datos){
			this.id=datos.id;
			this.tipoDocumento=datos.tipoDocumento;
			this.numDocCliente=datos.numDocCliente;
			this.nombreCliente=datos.nombreCliente;
			this.celularCliente=datos.celularCliente;
			this.correoCliente=datos.correoCliente;
			this.direccionCliente=datos.direccionCliente;
		},
		nuevoregistro(){
			this.mostrarformulario = true;
			this.id=null;
			this.tipoDocumento="";
			this.numDocCliente="";
			this.nombreCliente="";
			this.celularCliente="";
			this.correoCliente="";
			this.direccionCliente="";
		},
		cancelar(){
			this.mostrarformulario = false;
		},
		eliminarCliente(idtmp){
			Swal.fire({
				title: 'Esta Seguro de Eliminar el registro Seleccionado?',
				showDenyButton: true,
				showCancelButton: true,
				confirmButtonText: 'Si, Borrar',
				denyButtonText: `No, Cancelar`,
				}).then((result) => {
				/* Read more about isConfirmed, isDenied below */
				if (result.isConfirmed) {
					fetch("http://localhost:8080/v1/cliente/"+idtmp, {
					method: 'DELETE', // or 'PUT'
					headers: {"Content-Type": "application/json",},					
					}).then((response) => response.text())
					.then((data) => {
						Swal.fire(data, '', 'success')
						this.iniciarCarga();
					})
					.catch((error) => {
						Swal.fire('Error: '+error, '', 'error')						
						return;
					});				
				} else if (result.isDenied) {
					Swal.fire('Operación Cancelada', '', 'info')
				}
			})			
		}
	},
	created() {
      this.iniciarCarga();
    },
}
</script>
<style>
/* Estilo para input de texto */
input[type="text"] {
  background-color: #e2e2e2;
  border: none;
}

/* Estilo para select */
select {
  background-color: #e2e2e2;
  border: none;
}

/* Estilo para el botón de submit */
button[type="submit"] {
  background-color: #4CAF50; /* Cambia el color de fondo del botón */
  color: white;
  border: none;
  cursor: pointer;
  transition: all 0.3s ease; /* Agrega una transición al botón */
}

/* Estilo para el botón de submit al pasar el mouse */
button[type="submit"]:hover {
  background-color: #3e8e41; /* Cambia el color de fondo del botón al pasar el mouse */
}

/* Estilo para el botón de cancelar */
button[type="button"] {
  background-color: #f44336; /* Cambia el color de fondo del botón */
  color: white;
  border: none;
  cursor: pointer;
  transition: all 0.3s ease; /* Agrega una transición al botón */
}

/* Estilo para el botón de cancelar al pasar el mouse */
button[type="button"]:hover {
  background-color: #da190b; /* Cambia el color de fondo del botón al pasar el mouse */
}

/* Estilo para el botón de resetear */
button[type="reset"] {
  background-color: #2196F3; /* Cambia el color de fondo del botón */
  color: white;
  border: none;
  cursor: pointer;
  transition: all 0.3s ease; /* Agrega una transición al botón */
}

/* Estilo para el botón de resetear al pasar el mouse */
button[type="reset"]:hover {
  background-color: #0b7dda; /* Cambia el color de fondo del botón al pasar el mouse */
}
</style>