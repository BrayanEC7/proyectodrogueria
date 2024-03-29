<template>
	<div class="right_col" role="main">
		<div class="row">
			<div class="col-md-12 col-sm-12 ">
				<div class="x_panel" id="tabladatoscategorias" v-show="!mostrarformulario">
					<div class="x_title">
						<h2>Menus de Categorías <small>listado</small></h2>
						<ul class="nav navbar-right panel_toolbox">
							<li><a>
									<i class="fa fa-files-o" v-on:click="nuevoregistro()"></i></a>
							</li>
							<li><a class="collapse-link">
									<i class="fa fa-chevron-up"></i></a>
							</li>
							<li class="dropdown">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
									aria-haspopup="true" aria-expanded="false"><i class="fa fa-wrench"></i></a>
							</li>
							<li><a class="close-link">
									<i class="fa fa-close"></i></a>
							</li>
						</ul>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">

						<div class="row">
							<div class="col-sm-12 input-group mb-3">
								<input type="text" id="searchnombre" name="searchnombre" v-model="searchnombre"
									v-on:blur="iniciarCarga();" required class="form-control"
									placeholder="Buscar por nombre de Categorías">
								<div class="input-group-append">
									<button class="btn btn-primary" type="button"
										style="width: 40px; height: 40px;"></button>
								</div>
							</div>
							<div class="col-sm-12">
								<div class="card-box table-responsive">
									<table id="datatable-fixed-header" class="table table-striped table-bordered"
										style="width:100%">
										<thead>
											<tr>
												<th>Nombre</th>
												<th>Descripción</th>
												<th>Acciones</th>
											</tr>
										</thead>


										<tbody>
											<tr v-for="itemCategoria in listacategorias ">
												<td>{{ itemCategoria.nombreCategoria }}</td>
												<td>{{ itemCategoria.descripcion }}</td>
												<td class="text-center">
													<i class="fa fa-pencil" v-on:click="editarCategoria(itemCategoria)"
														style="cursor:pointer; padding-right: 1ex; color: burlywood;"></i>
													<i class="fa fa-trash" v-on:click="eliminarCategoria(itemCategoria.id)"
														style="cursor:pointer; padding-right: 1ex; color:red"></i>
												</td>
											</tr>
										</tbody>
									</table>
								</div>
							</div>
						</div>

					</div>
				</div>
				<div class="x_panel" id="formulariocategorias" v-show="mostrarformulario">
					<div class="x_title">
						<h2>Menus de Categorías <small>editar/crear</small></h2>
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
						<form id="frmCategoria" v-on:submit="guardardatos()" data-parsley-validate
							class="form-horizontal form-label-left">
							<input type="hidden" id="id" name="id" v-model="id" />
							<div class="item form-group">
								<label class="col-form-label col-md-3 col-sm-3 label-align" for="nombreCategoria">Nombre de
									Categoría <span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 ">
									<input type="text" id="nombreCategoria" name="nombreCategoria" v-model="nombreCategoria"
										required class="form-control ">
								</div>
							</div>
							<div class="item form-group">
								<label class="col-form-label col-md-3 col-sm-3 label-align" for="descripcion">Descripción
									<span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 ">
									<input type="text" id="descripcion" name="descripcion" v-model="descripcion" required
										class="form-control">
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
export default {
	data() {
		return {
			id: null,
			nombreCategoria: "",
			descripcion: "",
			listacategorias: [],
			mostrarformulario: false,
			searchnombre: "",
		};
	},
	methods: {
		async iniciarCarga() {
			try {
				var urltmp = "http://localhost:8080/v1/categoria/buscarBy/" + this.searchnombre;
				if (this.searchnombre == "") urltmp = urltmp = "http://localhost:8080/v1/categoria/";
				const response = await fetch(urltmp);
				this.listacategorias = this.listCategoriaItems = await response.json();
			} catch (error) {
				//console.log(error);
			}
		},
		guardardatos() {
			var data = {
				nombreCategoria: this.nombreCategoria,
				descripcion: this.descripcion,
			};
			var metodo = "POST";
			if (this.id != null) {//guardar datos			
				data.id = this.id
				metodo = "PUT";
			}

			fetch("http://localhost:8080/v1/categoria/", {
				method: metodo, // or 'PUT'
				headers: { "Content-Type": "application/json", },
				body: JSON.stringify(data),
			}).then((response) => response.json())
				.then((data) => {
					this.id = null;
					this.iniciarCarga();
					this.mostrarformulario = false;
				})
				.catch((error) => {
					console.error("Error:", error);
					return;
				});
		},
		editarCategoria(datos) {
			this.id = datos.id;
			this.nombreCategoria = datos.nombreCategoria;
			this.descripcion = datos.descripcion;
			this.mostrarformulario = true;
		},
		eliminarCategoria(idtmp) {
			Swal.fire({
				title: 'Esta Seguro de Eliminar el registro Seleccionado?',
				showDenyButton: true,
				showCancelButton: true,
				confirmButtonText: 'Si, Borrar',
				denyButtonText: `No, Cancelar`,
			}).then((result) => {
				/* Read more about isConfirmed, isDenied below */
				if (result.isConfirmed) {
					fetch("http://localhost:8080/v1/categoria/" + idtmp, {
						method: 'DELETE', // or 'PUT'
						headers: { "Content-Type": "application/json", },
					}).then((response) => response.text())
						.then((data) => {
							Swal.fire(data, '', 'success')
							this.iniciarCarga();
						})
						.catch((error) => {
							Swal.fire('Error: ' + error, '', 'error')
							return;
						});
				} else if (result.isDenied) {
					Swal.fire('Operación Cancelada', '', 'info')
				}
			})

		},
		nuevoregistro() {
			this.mostrarformulario = true;
			this.id = null;
			this.nombreCategoria = "";
			this.descripcion = "";
		},
		cancelar() {
			this.mostrarformulario = false;
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