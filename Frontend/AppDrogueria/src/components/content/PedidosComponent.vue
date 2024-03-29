<template>
    <div class="right_col" role="main">
        <div class="row">
            <div class="col-md-12 col-sm-12 ">

                <div class="x_panel" id="tabladatosproductos">
                    <div class="x_title">
                        <h2>Menú de Pedidos <small>listado</small></h2>
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
                                    placeholder="Buscar por código del Pedido">
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
                                                <th>numeroPedido</th>
                                                <th>fecha</th>
                                                <th>docCliente</th>
                                                <th>nombreCliente</th>
                                                <th>codProducto</th>
                                                <th>nombreProducto</th>
                                                <th>precioProducto</th>
                                                <th>cantidad</th>
                                                <th>subtotal</th>
                                                <th>descuento</th>
                                                <th>totalPagar</th>
                                                <th>estado</th>
                                                <th>Acciones</th>
                                            </tr>
                                        </thead>

                                        <tbody>
                                            <tr v-for="itemPedido in listapedidos ">
                                                <td>{{ itemPedido.numeroPedido }}</td>
                                                <td>{{ itemPedido.fechaPedido }}</td>
                                                <td>{{ itemPedido.idClienteNumDocCliente }}</td>
                                                <td>{{ itemPedido.idClienteNombreCliente }}</td>
                                                <td>{{ itemPedido.idProductoCodigoProducto }}</td>
                                                <td>{{ itemPedido.idProductoNombreProducto }}</td>
                                                <td>{{ itemPedido.idProductoPrecioVenta }}</td>
                                                <td>{{ itemPedido.cantidad }}</td>
                                                <td>{{ itemPedido.subtotal }}</td>
                                                <td>{{ itemPedido.descuento }}</td>
                                                <td>{{ itemPedido.totalPagar }}</td>
                                                <td>{{ itemPedido.estado }}</td>
                                                <td class="text-center">
                                                    <i class="fa fa-pencil" v-on:click="editarProducto(itemPedido)"
                                                        style="cursor:pointer; padding-right: 1ex; color: burlywood;"></i>
                                                    <i class="fa fa-trash" v-on:click="eliminarProducto(itemPedido.id)"
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

                            <div class="row">
                                <div class="form-group row">
                                    <label class="control-label col-md-4 col-sm-4 label-align">Documento</label>
                                    <div class="col-md-8 col-sm-8 ">
                                        <select v-model="DevolverDocCliente" class="select2_single form-control"
                                            tabindex="-1">
                                            <option>Selecciona el Documento</option>
                                            <option v-for="itemCliente in listaclientes " :value="itemCliente.id">{{
                                                itemCliente.numDocCliente }}</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-md-8 d-flex form-group">
                                    <input type="text" name="selectcliente" class="form-control"
                                        placeholder="Documento Cliente" v-model="selectcliente">
                                    <input type="button" name="accion" value="BuscarCliente"
                                        v-on:click="BuscarDocCliente()">
                                </div>
                                <div class="col-md-8 d-flex form-group">
                                    <input type="text" name="nombrecliente" class="form-control"
                                        placeholder="Nombre Cliente" v-model="nombrecliente" disabled>
                                </div>
                            </div>

                            <div class="row">
                                <div class="form-group row">
                                    <label class="control-label col-md-4 col-sm-4 label-align">Producto</label>
                                    <div class="col-md-8 col-sm-8 ">
                                        <select v-model="DevolverCodProducto" class="select2_single form-control"
                                            tabindex="-1">
                                            <option>Selecciona el código producto</option>
                                            <option v-for="itemProducto in listaproductos" :value="itemProducto.id">{{
                                                itemProducto.codigoProducto }}</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-md-8 d-flex form-group">
                                    <input type="number" name="selectproducto" class="form-control"
                                        placeholder="Código Producto" v-model="selectproducto">
                                    <input type="button" name="accion" value="BuscarProducto"
                                        v-on:click="BuscarCodProducto()">
                                </div>
                                <div class="col-md-4 d-flex form-group">
                                    <input type="number" name="cantidad" class="form-control" placeholder="Cantidad"
                                        v-model="cantidad" v-on:input="multiplicar()">
                                </div>
                                <div class="col-md-8 d-flex form-group">
                                    <input type="text" name="nombreproducto" class="form-control"
                                        placeholder="Nombre Producto" v-model="nombreproducto" disabled>
                                </div>
                                <div class="col-md-4 d-flex form-group">
                                    <input type="text" name="precioproducto" class="form-control" placeholder="S/. 0000.00"
                                        v-model="precioproducto" disabled>
                                </div>
                                <div class="col-md-2 d-flex form-group">
                                    <input type="text" name="stock" class="form-control" placeholder="Stock" v-model="stock"
                                        disabled>
                                </div>
                                <div class="col-md-2 d-flex form-group">
                                    <input type="text" name="fechavencimiento" class="form-control"
                                        placeholder="Fecha Vencimiento" v-model="fechavencimiento" disabled>
                                </div>
                                <div class="col-md-4 d-flex form-group">
                                    <input type="text" name="marcaProducto" class="form-control" placeholder="Marca"
                                        v-model="marcaProducto" disabled>
                                </div>
                                <div class="col-md-4 d-flex form-group">
                                    <input type="text" name="categoriaProducto" class="form-control" placeholder="Categoría"
                                        v-model="categoriaProducto" disabled>
                                </div>
                                <div class="col-md-4 d-flex form-group">
                                    <input type="text" name="proveedorProducto" class="form-control" placeholder="Proveedor"
                                        v-model="proveedorProducto" disabled>
                                </div>
                                <div class="col-md-4 d-flex form-group">
                                    <input type="text" name="presentacionProducto" class="form-control"
                                        placeholder="Presentación" v-model="presentacionProducto" disabled>
                                </div>
                            </div>
                            <div class="row">
                                <input type="hidden" id="id" name="id" v-model="id" />

                                <div class="col-md-4 d-flex form-group">
                                    <input type="text" name="numeroPedido" class="form-control" placeholder="Número pedido"
                                        v-model="numeroPedido">
                                </div>
                                <div class="col-md-4 d-flex form-group">
                                    <input type="date" name="fechaPedido" class="form-control" v-model="fechaPedido">
                                </div>

                                <div class="col-md-4 d-flex form-group">
                                    <input type="number" name="descuento" class="form-control" placeholder="Descuento"
                                        v-model="descuento" v-on:input="descuentoAgregado()">
                                </div>

                                <div class="col-md-6 col-sm-6 ">
                                    <select v-model="estado" class="select2_single form-control" tabindex="-1">
                                        <option disabled value="">Seleccione un estado</option>
                                        <option v-for="opcion in opciones" :key="opcion.ide" :value="opcion.valor">
                                            {{ opcion.texto }}</option>
                                    </select>
                                </div>

                                <div class="col-md-3 d-flex form-group">
                                    <input type="number" name="proveedorProducto" class="form-control" v-model="subtotal"
                                        placeholder="Subtotal">
                                </div>
                                <div class="col-md-3 d-flex form-group">
                                    <input type="number" name="proveedorProducto" class="form-control" v-model="totalPagar"
                                        placeholder="Total a Pagar">
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
            subtotal: 0.00,
            descuento : 0,
            id: null,
            DevolverCodProducto: "",
            DevolverDocCliente: "",
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
            listapedidos: [],
            searchnombre: "",
            selectPedido: "",
            opciones: [
                { ide: 1, valor: 'Por Aprobación', texto: 'Por Aprobación' },
                { ide: 2, valor: 'Pendiente de Facturación', texto: 'Pendiente de Facturación' },
                { ide: 3, valor: 'Facturado', texto: 'Facturado' },
                { ide: 4, valor: 'Embalado', texto: 'Embalado' },
                { ide: 5, valor: 'Despachado en Agencia', texto: 'Despachado en Agencia' },
                { ide: 6, valor: 'Despachado en Tienda', texto: 'Despachado en Tienda' },
                { ide: 7, valor: 'Entregado', texto: 'Entregado' },
            ],
            estado: null,
        };
    },

    methods: {
        async iniciarCarga() {
            try {
                var urltmp = "http://localhost:8080/v1/pedido/";
                const response = await fetch(urltmp);
                this.listapedidos = this.listPedidoItems = await response.json();
            } catch (error) {
                //console.log(error);
            }
        },
        async iniciarCliente() {
            try {
                var urltmp = "http://localhost:8080/v1/cliente/";
                const response = await fetch(urltmp);
                this.listaclientes = this.listClienteItems = await response.json();
            } catch (error) {
                //console.log(error);
            }
        },
        async iniciarProducto() {
            try {
                var urltmp = "http://localhost:8080/v1/producto/";
                const response = await fetch(urltmp);
                this.listaproductos = this.listProductoItems = await response.json();
            } catch (error) {
                //console.log(error);
            }
        },
        multiplicar() {
            var multi = (this.cantidad * (this.precioproducto).substring(4));
            this.subtotal = multi
        },
        descuentoAgregado() {
            console.log("DESCUENTO: " + this.descuento);
            this.totalPagar = this.subtotal - this.descuento
        },
        BuscarDocCliente() {
            //console.log(this.NumDocCliente)
            fetch('http://localhost:8080/v1/cliente/buscarPorDoc/' + this.selectcliente)
                .then(response => response.json())
                .then(data => {
                    this.iniciarCarga();
                    this.nombrecliente = data.nombreCliente;
                    //console.log(JSON.stringify(data.nombreCliente)); // aquí puedes hacer lo que necesites con los datos
                })
                .catch(error => {
                    console.error('Ha ocurrido un error:', error);
                });
        },
        BuscarCodProducto() {
            fetch('http://localhost:8080/v1/producto/buscarPorCod/' + this.selectproducto)
                .then(response => response.json())
                .then(data => {
                    this.iniciarCarga();
                    this.nombreproducto = data.nombreProducto;
                    this.precioproducto = "S/. " + data.precioVenta;
                    this.stock = data.stock;
                    this.fechavencimiento = data.fechaVencimiento;
                    this.marcaProducto = data.idMarcaNombreMarca;
                    this.categoriaProducto = data.idCategoriaNombreCategoria;
                    this.proveedorProducto = data.idProveedorNombreProveedor;
                    this.presentacionProducto = data.idPresentacionNombrePresentacion;
                    //console.log(JSON.stringify(data.nombreCliente)); // aquí puedes hacer lo que necesites con los datos
                })
                .catch(error => {
                    console.error('Ha ocurrido un error:', error);
                });
        },
        guardardatos() {
            var data = {
                numeroPedido: this.numeroPedido,
                fechaPedido: this.fechaPedido,
                descuento: this.descuento,
                estado: this.estado,
                subtotal: this.subtotal,
                totalPagar: this.totalPagar,
                idCliente: this.DevolverDocCliente,
                idProducto: this.DevolverCodProducto,
                cantidad: this.cantidad,
            };
            var metodo = "POST";

            console.log(this.id)

            if (this.id != null || this.id != "") {//guardar datos			
                data.id = this.id
                metodo = "PUT";
            }

            fetch("http://localhost:8080/v1/pedido/", {
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
                    fetch("http://localhost:8080/v1/pedido/" + idtmp, {
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
    },
    created() {
        this.iniciarCarga();
        this.iniciarCliente();
        this.iniciarProducto();
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