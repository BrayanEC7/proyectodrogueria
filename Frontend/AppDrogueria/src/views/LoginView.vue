<template>
  <head>
	<title>Login</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<link rel="stylesheet" type="text/css" href="css/main.css">
</head>
    <body class="login">
    <div>
      <a class="hiddenanchor" id="signup"></a>
      <a class="hiddenanchor" id="signin"></a>

      <div class="login_wrapper">
        <div class="animate form login_form">
          <section class="login_content">
            <form>
              <h1>formulario de Acceso</h1>
              <div>
                <input id="user" name="user" v-model="user" type="text" class="form-control" placeholder="Usuario" required="" />
              </div>
              <div>
                <input id="clave" name="clave" v-model="clave" type="password" class="form-control" placeholder="Password" required="" />
              </div>
              <div>
                <a class="btn btn-default submit" v-on:click="login()">Iniciar Sesion</a>
                <a class="reset_pass" href="#">Recuperar Clave?</a>
              </div>
              <div class="clearfix"></div>              
            </form>
          </section>
        </div>
      </div>
    </div>
  </body>
</template>
<script>
export default{
	data() {
      return {
		id:null,
		nombre:"",
    user: null,
		clave:""		
      };
    },
	methods: {
		login(){     
			var data = { 
				user: this.user,
				clave:this.clave				
			};			
			fetch("http://localhost:8080/v1/usuarios/login", {
			method: "POST", // or 'PUT'
			headers: {"Content-Type": "application/json",},
			body: JSON.stringify(data),
			}).then((response) => response.json())
			.then((data) => {

        if(data.codigo==200){
          let tocken=data.token;
          sessionStorage.setItem('user_token', data.tocken);
          var datadecode=atob(tocken)
          var datos=datadecode.split("!=!");
          datos.forEach(element => {
            var datovalor=element.split("=");
            sessionStorage.setItem('user_'+ datovalor[0], datovalor[1]);
          });        
          window.location.href=window.location.origin;
        }else{
          Swal.fire(
            data.mensaje,
            '',
            'error'
          )
        }
			})
			.catch((error) => {
				console.error("Error:", error);
				return;
			});
		}		
	}	
}
</script>
