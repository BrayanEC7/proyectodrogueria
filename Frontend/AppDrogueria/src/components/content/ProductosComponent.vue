<template>
  <div class="right_col" role="main">
    <div class="row">
      <div class="col-md-12 col-sm-12 ">

        <div class="x_panel" id="tabladatosproductos">
          <div class="x_title">
            <h2>Menú de Productos <small>listado</small></h2>
            <ul class="nav navbar-right panel_toolbox">
              <li><a class="collapse-link">
                  <i class="fa fa-chevron-up"></i></a>
              </li>
              <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                  aria-expanded="false"><i class="fa fa-wrench"></i></a>
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
                  v-on:blur="iniciarCarga();" required class="form-control" placeholder="Buscar por código del Producto">
                <div class="input-group-append">
                  <button class="btn btn-primary" type="button" style="width: 40px; height: 40px;"></button>
                </div>
              </div>

              <div class="col-sm-12">
                <div class="card-box table-responsive">
                  <table id="datatable-fixed-header" class="table table-striped table-bordered" style="width:100%">
                    <thead>
                      <tr>
                        <th>codigoProducto</th>
                        <th>nombreProducto</th>
                        <th>fechaVencimiento</th>
                        <th>Stock</th>
                        <th>precioCompra</th>
                        <th>precioVenta</th>
                        <th>Marca</th>
                        <th>Categoría</th>
                        <th>Proveedor</th>
                        <th>Presentación</th>
                        <th>Acciones</th>
                      </tr>
                    </thead>

                    <tbody>
                      <tr v-for="itemProducto in listaproductos ">
                        <td>{{ itemProducto.codigoProducto }}</td>
                        <td>{{ itemProducto.nombreProducto }}</td>
                        <td>{{ itemProducto.fechaVencimiento }}</td>
                        <td>{{ itemProducto.stock }}</td>
                        <td>{{ itemProducto.precioCompra }}</td>
                        <td>{{ itemProducto.precioVenta }}</td>
                        <td>{{ itemProducto.idMarcaNombreMarca }}</td>
                        <td>{{ itemProducto.idCategoriaNombreCategoria }}</td>
                        <td>{{ itemProducto.idProveedorNombreProveedor }}</td>
                        <td>{{ itemProducto.idPresentacionNombrePresentacion }}</td>
                        <td class="text-center">
                          <i class="fa fa-pencil" v-on:click="editarProducto(itemProducto)"
                            style="cursor:pointer; padding-right: 1ex; color: burlywood;"></i>
                          <i class="fa fa-trash" v-on:click="eliminarProducto(itemProducto.id)"
                            style="cursor:pointer; color:red"></i>
                        </td>
                      </tr>
                    </tbody>
                  </table>
                </div>
              </div>
            </div>
          </div>
        </div>

        <div class="x_panel" id="formularioproductos">
          <div class="x_title">
            <h2>Registro de Productos<small>editar/crear</small></h2>
            <ul class="nav navbar-right panel_toolbox">
              <li><a class="collapse-link">
                  <i class="fa fa-chevron-up"></i></a>
              </li>
              <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                  aria-expanded="false"><i class="fa fa-wrench"></i></a>
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
            <form id="frmProducto" v-on:submit="guardardatos()" data-parsley-validate
              class="form-horizontal form-label-left">
              <input type="hidden" id="id" name="id" v-model="id" />

              <div class="item form-group">
                <label class="col-form-label col-md-3 col-sm-3 label-align" for="codigoProducto">Código Producto <span
                    class="required">*</span>
                </label>
                <div class="col-md-6 col-sm-6 ">
                  <input type="number" id="codigoProducto" name="codigoProducto" v-model="codigoProducto" required
                    class="form-control ">
                </div>
              </div>

              <div class="item form-group">
                <label class="col-form-label col-md-3 col-sm-3 label-align" for="nombreProducto">Nombre <span
                    class="required">*</span>
                </label>
                <div class="col-md-6 col-sm-6 ">
                  <input type="text" id="nombreProducto" name="nombreProducto" v-model="nombreProducto" required
                    class="form-control ">
                </div>
              </div>

              <div class="item form-group">
                <label class="col-form-label col-md-3 col-sm-3 label-align" for="fechaVencimiento">Fecha de Vencimiento
                  <span class="required">*</span>
                </label>
                <div class="col-md-6 col-sm-6  form-group has-feedback">
                  <input type="date" class="form-control " placeholder="Fecha Nacimiento" id="fechaVencimiento"
                    name="fechaVencimiento" v-model="fechaVencimiento">

                </div>
              </div>

              <div class="item form-group">
                <label for="stock" class="col-form-label col-md-3 col-sm-3 label-align">Stock <span
                    class="required">*</span></label>
                <div class="col-md-6 col-sm-6 ">
                  <input id="stock" v-model="stock" class="form-control" type="number" name="stock">
                </div>
              </div>

              <div class="item form-group">
                <label for="precioCompra" class="col-form-label col-md-3 col-sm-3 label-align">Precio Compra *</label>
                <div class="col-md-6 col-sm-6 ">
                  <input id="precioCompra" v-model="precioCompra" class="form-control" type="text" name="precioCompra">
                </div>
              </div>

              <div class="item form-group">
                <label for="precioVenta" class="col-form-label col-md-3 col-sm-3 label-align">Precio Venta *</label>
                <div class="col-md-6 col-sm-6 ">
                  <input id="precioVenta" v-model="precioVenta" class="form-control" type="text" name="precioVenta">
                </div>
              </div>

              <div class="form-group row">
                <label class="control-label col-md-3 col-sm-3 label-align">Marca</label>
                <div class="col-md-6 col-sm-6 ">
                  <select v-model="selectMarca" class="select2_single form-control" tabindex="-1">
                    <option>Sin Marca</option>
                    <option v-for="itemMarca in listamarcas " :value="itemMarca.id">{{
                      itemMarca.nombreMarca }}</option>
                  </select>
                </div>
              </div>

              <div class="form-group row">
                <label class="control-label col-md-3 col-sm-3 label-align">Categoría</label>
                <div class="col-md-6 col-sm-6 ">
                  <select v-model="selectCategoria" class="select2_single form-control" tabindex="-1">
                    <option>Sin Categoría</option>
                    <option v-for="itemCategoria in listacategorias " :value="itemCategoria.id">{{
                      itemCategoria.nombreCategoria }}</option>
                  </select>
                </div>
              </div>

              <div class="form-group row">
                <label class="control-label col-md-3 col-sm-3 label-align">Proveedor</label>
                <div class="col-md-6 col-sm-6 ">
                  <select v-model="selectProveedor" class="select2_single form-control" tabindex="-1">
                    <option>Sin Proveedor</option>
                    <option v-for="itemProveedor in listaproveedores " :value="itemProveedor.id">{{
                      itemProveedor.nombreProveedor }}</option>
                  </select>
                </div>
              </div>

              <div class="form-group row">
                <label class="control-label col-md-3 col-sm-3 label-align">Presentación</label>
                <div class="col-md-6 col-sm-6 ">
                  <select v-model="selectPresentacion" class="select2_single form-control" tabindex="-1">
                    <option>Sin Presentación</option>
                    <option v-for="itemPresentacion in listapresentaciones" :value="itemPresentacion.id">{{
                      itemPresentacion.nombrePresentacion }}</option>
                  </select>
                </div>
              </div>

              <div class="ln_solid"></div>
              <div class="item form-group">
                <div class="col-md-6 col-sm-6 offset-md-3">
                  <button class="btn btn-primary" type="button">Cancel</button>
                  <button class="btn btn-primary" type="reset">Reset</button>
                  <button type="submit" class="btn btn-success">Submit</button>
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
      codigoProducto: "",
      nombreProducto: "",
      fechaVencimiento: "",
      stock: "",
      precioCompra: "",
      precioVenta: "",
      selectMarca: "",
      selectCategoria: "",
      selectProveedor: "",
      selectPresentacion: "",
      listaproductos: [],
      searchnombre: "",
      selecMarca: "",
    };
  },
  methods: {
    async iniciarCarga() {
      try {
        var urltmp = "http://localhost:8080/v1/producto/buscarBy/" + this.searchnombre;;
        if (this.searchnombre == "") urltmp = urltmp = "http://localhost:8080/v1/producto/";
        const response = await fetch(urltmp);
        this.listaproductos = this.listProductoItems = await response.json();
      } catch (error) {
        //console.log(error);
      }
    },
    async iniciarMarca() {
      try {
        var urltmp = "http://localhost:8080/v1/marca/";
        const response = await fetch(urltmp);
        this.listamarcas = this.listMarcaItems = await response.json();
        //console.log("prueba");
      } catch (error) {
        //console.log("error");
      }
    },
    async iniciarCategoria() {
      try {
        var urltmp = "http://localhost:8080/v1/categoria/";
        const response = await fetch(urltmp);
        this.listacategorias = this.listCategoriaItems = await response.json();
      } catch (error) {
        //console.log(error);
      }
    },
    async iniciarProveedor() {
      try {
        var urltmp = "http://localhost:8080/v1/proveedor/";
        const response = await fetch(urltmp);
        this.listaproveedores = this.listProveedorItems = await response.json();
      } catch (error) {
        //console.log(error);
      }
    },
    async iniciarPresentacion() {
      try {
        var urltmp = "http://localhost:8080/v1/presentacion/";
        const response = await fetch(urltmp);
        this.listapresentaciones = this.listPresentacionItems = await response.json();
      } catch (error) {
        //console.log(error);
      }
    },
    async BuscarNomMarca() {
      fetch('http://localhost:8080/v1/marca/buscarBy/' + this.selecMarca)
        .then(response => response.json())
        .then(data => {
          this.transMarca = data.nombreMarca;
          console.log(JSON.stringify(data.nombreMarca)); // aquí puedes hacer lo que necesites con los datos
        })
        .catch(error => {
          console.error('Ha ocurrido un error:', error);
        });
    },
    guardardatos() {
      var data = {
        codigoProducto: this.codigoProducto,
        nombreProducto: this.nombreProducto,
        fechaVencimiento: this.fechaVencimiento,
        stock: this.stock,
        precioCompra: this.precioCompra,
        precioVenta: this.precioVenta,
        idMarca: this.selectMarca,
        idCategoria: this.selectCategoria,
        idProveedor: this.selectProveedor,
        idPresentacion: this.selectPresentacion,
      };
      var metodo = "POST";

      console.log(this.id)

      if (this.id != null || this.id != "") {//guardar datos			
        data.id = this.id
        metodo = "PUT";
      }

      fetch("http://localhost:8080/v1/producto/", {
        method: metodo, // or 'PUT'
        headers: { "Content-Type": "application/json", },
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
    editarProducto(datos) {
      this.id = datos.id;
      this.codigoProducto = datos.codigoProducto;
      this.nombreProducto = datos.nombreProducto;
      this.fechaVencimiento = datos.fechaVencimiento;
      this.stock = datos.stock;
      this.precioCompra = datos.precioCompra;
      this.precioVenta = datos.precioVenta;
      this.selectMarca = datos.idMarcaNombreMarca;
      this.selectCategoria = datos.idCategoriaNombreCategoria;
      this.selectProveedor = datos.idProveedorNombreProveedor;
      this.selectPresentacion = datos.idPresentacionNombrePresentacion;
    },
    nuevoregistro() {
      this.mostrarformulario = true;
      this.id = null;
    },
    cancelar() {
      this.mostrarformulario = false;
    },
    eliminarProducto(idtmp) {
      Swal.fire({
        title: 'Esta Seguro de Eliminar el registro Seleccionado?',
        showDenyButton: true,
        showCancelButton: true,
        confirmButtonText: 'Si, Borrar',
        denyButtonText: `No, Cancelar`,
      }).then((result) => {
        /* Read more about isConfirmed, isDenied below */
        if (result.isConfirmed) {
          fetch("http://localhost:8080/v1/producto/" + idtmp, {
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
    }
  },
  created() {
    this.iniciarCarga();
    this.iniciarMarca();
    this.iniciarCategoria();
    this.iniciarProveedor();
    this.iniciarPresentacion();
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