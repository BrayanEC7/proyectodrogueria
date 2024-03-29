<template>
    <div class="right_col" role="main">
        <div class="row">
            <div class="col-md-12 col-sm-12 ">

                <div class="x_panel" id="tabladatosproductos">
                    <div class="x_title">
                        <h2>Facturación SisDroguería <small></small></h2>
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
                        <div class="row">
                            <div class="col-sm-12 input-group mb-3">
                                <input type="text" id="searchnombre" name="searchnombre" v-model="searchnombre"
                                    v-on:blur="iniciarCarga();" required class="form-control"
                                    placeholder="Buscar por código del Producto">
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
                                                <th>Tipo de Comprobante</th>
                                                <th>Serie</th>
                                                <th>Emisión</th>
                                                <th>Número de Pedido</th>
                                                <th>Acciones</th>
                                            </tr>
                                        </thead>

                                        <tbody>
                                            <tr v-for="itemFacturacion in listafacturaciones ">
                                                <td>{{ itemFacturacion.tipoComprobante }}</td>
                                                <td>{{ itemFacturacion.serieComprobante }}</td>
                                                <td>{{ itemFacturacion.fechaFacturacion }}</td>
                                                <td>{{ itemFacturacion.idPedidoNumeroPedido }}</td>
                                                <td class="text-center">
                                                    <i class="fa fa-pencil" v-on:click="editarProducto(itemFacturacion)"
                                                        style="cursor:pointer; padding-right: 1ex; color: burlywood;"></i>
                                                    <i class="fa fa-trash" v-on:click="eliminarProducto(itemFacturacion.id)"
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
                        <h2>Productos de Opciones <small>editar/crear</small></h2>
                        <ul class="nav navbar-right panel_toolbox">
                            <li><a class="collapse-link">
                                    <i class="fa fa-chevron-up"></i></a>
                            </li>
                            <li><a>
                                    <i class="fa fa-print" v-on:click="imprimir"></i></a>
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
                        <form id="frmProducto" v-on:submit="guardardatos()" data-parsley-validate
                            class="form-horizontal form-label-left">
                            <input type="hidden" id="id" name="id" v-model="id" />

                            <div class="col-md-12 d-flex form-group">
                                <input type="text" name="serie" class="form-control" placeholder="Serie Comprobante"
                                    v-model="serie">
                            </div>
                            <div class="col-md-6 col-sm-6 ">
                                <select v-model="tipofac" class="select2_single form-control" tabindex="-1">
                                    <option disabled value="">Seleccione un estado</option>
                                    <option v-for="opcion in opciones" :key="opcion.ide" :value="opcion.valor">
                                        {{ opcion.texto }}</option>
                                </select>
                            </div>

                            <div class="col-md-6 d-flex form-group">
                                <input type="date" name="categoriaProducto" class="form-control" v-model="fechafac">
                            </div>



                            <div class="row">
                                <div class="form-group row">
                                    <label class="control-label col-md-4 col-sm-4 label-align">Pedido</label>
                                    <div class="col-md-8 col-sm-8 ">
                                        <select v-model="selectPedido" class="select2_single form-control" tabindex="-1">
                                            <option>Selecciona el pedido</option>
                                            <option v-for="itemPedido in listapedidos " :value="itemPedido.id">{{
                                                itemPedido.numeroPedido }}</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-md-4 d-flex form-group">
                                    <label class="control-label col-md-4 col-sm-4 label-align">Consulta</label>
                                    <input type="text" id="codigoProducto" name="codigoProducto" v-model="NumPedido"
                                        required class="form-control ">
                                    <input type="button" name="accion" value="BuscarPedido" v-on:click="BuscarPedido()">
                                </div>
                                <div class="col-md-4 d-flex form-group">
                                    <input type="text" name="DevolverNomCliente" class="form-control"
                                        placeholder="Nombre Cliente" v-model="DevolverNomCliente" disabled>
                                </div>
                                <div class="col-md-8 d-flex form-group">
                                    <input type="text" name="DevolverNomProducto" class="form-control"
                                        placeholder="Nombre Producto" v-model="DevolverNomProducto" disabled>
                                </div>
                                <div class="col-md-4 d-flex form-group">
                                    <input type="text" name="DevolverPrecio" class="form-control" placeholder="Precio"
                                        v-model="DevolverPrecio" disabled>
                                </div>
                                <div class="col-md-3 d-flex form-group">
                                    <input type="text" name="DevolverCantidad" class="form-control" placeholder="Cantidad"
                                        v-model="DevolverCantidad" disabled>
                                </div>
                                <div class="col-md-3 d-flex form-group">
                                    <input type="text" name="DevolverSubtotal" class="form-control" placeholder="SubTotal"
                                        v-model="DevolverSubtotal" disabled>
                                </div>
                                <div class="col-md-3 d-flex form-group">
                                    <input type="text" name="DevolverDescuento" class="form-control" placeholder="Descuento"
                                        v-model="DevolverDescuento" disabled>
                                </div>
                                <div class="col-md-3 d-flex form-group">
                                    <input type="text" name="DevolverTotalPagar" class="form-control"
                                        placeholder="Total Pagar" v-model="DevolverTotalPagar" disabled>
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
            DevolverIdPedido: "",
            DevolverNomCliente: "",
            DevolverPrecio: "",
            DevolverCantidad: "",
            DevolverSubtotal: "",
            DevolverDescuento: "",
            DevolverTotalPagar: "",
            serie: "",
            tipofac: "",
            fechafac: "",
            DevolverNomProducto: "",
            NumPedido: "",
            listafacturaciones: [],
            searchnombre: "",
            selectPedido: "",
            opciones: [
                { ide: 1, valor: 'Boleta', texto: 'Boleta' },
                { ide: 2, valor: 'Factura', texto: 'Factura' },
            ],
            estado: null,
        };
    },
    methods: {
        async iniciarCarga() {
            try {
                var urltmp = "http://localhost:8080/v1/facturacion/";
                const response = await fetch(urltmp);
                this.listafacturaciones = this.listFacturaItems = await response.json();
            } catch (error) {
                //console.log(error);
            }
        },
        async iniciarPedido() {
            try {
                var urltmp = "http://localhost:8080/v1/pedido/";
                const response = await fetch(urltmp);
                this.listapedidos = this.listPedidoItems = await response.json();
            } catch (error) {
                //console.log(error);
            }
        },
        imprimir() {
            window.print();
        },
        guardardatos() {
            var data = {
                serieComprobante: this.serie,
                tipoComprobante: this.tipofac,
                fechaFacturacion: this.fechafac,
                idPedido: this.selectPedido,
            };
            var metodo = "POST";

            console.log(this.id)

            if (this.id != null || this.id != "") {//guardar datos			
                data.id = this.id
                metodo = "PUT";
            }

            fetch("http://localhost:8080/v1/facturacion/", {
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
                    fetch("http://localhost:8080/v1/facturacion/" + idtmp, {
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
        BuscarPedido() {
            fetch('http://localhost:8080/v1/pedido/buscarPorNum/' + this.NumPedido)
                .then(response => response.json())
                .then(data => {
                    this.DevolverNomCliente = data.idClienteNombreCliente;
                    this.DevolverNomProducto = data.idProductoNombreProducto;
                    this.DevolverPrecio = data.idProductoPrecioVenta;
                    this.DevolverCantidad = data.cantidad;
                    this.DevolverSubtotal = data.subtotal;
                    this.DevolverDescuento = data.descuento;
                    this.DevolverTotalPagar = data.totalPagar;
                    this.DevolverIdPedido = data.idPedido;
                    //console.log(JSON.stringify(data.nombreCliente)); // aquí puedes hacer lo que necesites con los datos
                })
                .catch(error => {
                    console.error('Ha ocurrido un error:', error);
                });
        },
    },
    created() {
        this.iniciarCarga();
        this.iniciarPedido();
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