<template>
<html lang="pt-br">
<head>
	<title>Login</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<link rel="stylesheet" type="text/css">
</head>
<body>
	<div class="container">
		<div class="container-login">
			<div class="wrap-login">
				<form class="login-form">
					<span class="login-form-title">
						Iniciar Sesión
					</span>

					<div class="wrap-input margin-top-35 margin-bottom-35">
						<input class="input-form" type="text" name="email" autocomplete="off" v-model="user">
						<span class="focus-input-form" data-placeholder="Usuario"></span>
					</div>

					<div class="wrap-input margin-bottom-35">
						<input class="input-form" type="password" name="password" v-model="clave"> 
						<span class="focus-input-form" data-placeholder="Contraseña"></span>
					</div>

					<div class="container-login-form-btn" >
						<button class="login-form-btn" v-on:click="login()">
							Login
						</button>
					</div>

					<ul class="login-utils">
						<li class="margin-bottom-8 margin-top-8">
							<span class="text1">
								¿Recuperar
							</span>

							<a href="#" class="text2">
								contraseña?
							</a>
						</li>

					</ul>
				</form>
			</div>
			<img src="https://github.com/VitorCeron/Formulario_Login/blob/main/images/login.png?raw=true" width="300" height="300" class="margin-left-50" />
		</div>
	</div>

</body>
</html>
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
let inputs = document.getElementsByClassName('input-form');
		for (let input of inputs) {
			input.addEventListener("blur", function() {
				if(input.value.trim() != ""){
					input.classList.add("has-val");
				} else {
					input.classList.remove("has-val");
				}
			});
		}
	</script>
  <style>
/*
  Variáveis
*/

:root {
  --main-color: #407bff;
  --link-color: #666666;
  --text1: #999999;
  --highligth-text: #333333;
  --input-text: #555555;
  --white-color: #FFFFFF;
  --point-list: #CCCCCC;
  --line-input: #D9D9D9;
}

/*
  Fontes
*/

/*
  Zerar estilos
*/

* {
	margin: 0px; 
	padding: 0px; 
	box-sizing: border-box;
}

body, html {
	height: 100%;
	font-family: 'Overpass', sans-serif;
}

ul, li {
	margin: 0px;
	list-style-type: none;
}

input, button {
	outline: none !important;
	border: none;
}

button:hover {
	cursor: pointer;
}

/*
  Utilitários
*/

.text1 {
  font-family: 'Overpass', sans-serif;
  font-size: 15px;
  color: var(--text1);
  line-height: 1.5;
}

.text2 {
  font-family: 'Overpass', sans-serif;
  font-size: 15px;
  color: var(--main-color);
  line-height: 1.5;
}

.margin-bottom-35 {
  margin-bottom: 35px;
}

.margin-top-35 {
  margin-top: 35px;
}

.margin-bottom-8 {
  margin-bottom: 8px;
}

.margin-top-8 {
  margin-top: 8px;
}

.margin-left-50 {
  margin-left: 50px;
}

/*
  Login
*/

.container {
  width: 100%;
  margin: 0 auto;
}

.container-login {
  width: 100%;  
  min-height: 100vh;
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
  align-items: center;
  padding: 15px;
  background: var(--white-color);  
}

.wrap-login {
  width: 370px;
  margin-right: 50px;
  background: var(--white-color);
}

/*
  Formulário
*/

.login-form {
  width: 100%;
}

.login-form-title {
  display: block;
  font-family: 'Overpass', sans-serif;
  font-size: 39px;
  color: var(--highligth-text);
  line-height: 1.2;
  text-align: center;
}

/*
  Input
*/

.wrap-input {
  width: 100%;
  position: relative;
  border-bottom: 2px solid var(--line-input);
}

.input-form {
  font-family: 'Overpass', sans-serif;
  font-size: 18px;
  color: var(--input-text);
  line-height: 1.2;
  display: block;
  width: 100%;
  height: 52px;
  background: transparent;
  padding: 0 5px;
}

.focus-input-form {
  position: absolute;
  display: block;
  width: 100%;
  height: 100%;
  top: 0;
  left: 0;
  pointer-events: none;
}

.focus-input-form::before {
  content: "";
  display: block;
  position: absolute;
  bottom: -2px;
  left: 0;
  width: 0;
  height: 2px;
  transition: all 0.4s;
  background: var(--main-color);
}

.focus-input-form::after {
  font-family: 'Overpass', sans-serif;
  font-size: 18px;
  color: var(--text1);
  line-height: 1.2;
  content: attr(data-placeholder);
  display: block;
  width: 100%;
  position: absolute;
  top: 15px;
  left: 0px;
  padding-left: 5px;
  transition: all 0.4s;
}

.input-form:focus + .focus-input-form::after {
  top: -20px;
  font-size: 15px;
}

.input-form:focus + .focus-input-form::before {
  width: 100%;
}

.has-val.input-form + .focus-input-form::after {
  top: -20px;
  font-size: 15px;
}

.has-val.input-form + .focus-input-form::before {
  width: 100%;
}

/*
  Botão
*/

.container-login-form-btn {
  width: 100%;
  display: flex;
  justify-content: center;
}

.login-form-btn {
  font-family: 'Overpass', sans-serif;
  font-size: 16px;
  color: var(--white-color);
  line-height: 1.2;
  text-transform: uppercase;
  display: flex;
  justify-content: center;
  align-items: center;
  padding: 0 20px;
  width: 100%;
  height: 50px;
  background-color: var(--main-color);
  border-radius: 5px;
  transition: all 0.4s;
}

.login-form-btn:hover  {
  background-color: var(--highligth-text);
}

/*
  Links - Login utils
*/

a {
	font-family: 'Overpass', sans-serif;
	font-size: 14px;
	line-height: 1.7;
	color: var(--link-color);
	margin: 0px;
	transition: all 0.4s;
}

a:focus {
	outline: none !important;
}

a:hover {
	text-decoration: none;
  color: var(--highligth-text);
}

/*
  Login utils
*/

.login-utils {
  margin-top: 20px;
}

.login-utils li {
  position: relative;
  padding-left: 16px;
}

.login-utils li::before {
  content: "";
  display: block;
  position: absolute;
  width: 5px;
  height: 5px;
  border-radius: 50%;
  background-color: var(--point-list);
  top: 45%;
  transform: translateY(-50%);
  left: 0;
}
</style>