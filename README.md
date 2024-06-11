# ALPHA API
Esta API foi desenvolvida como parte de um desafio técnico, buscando proporcionar o contexto necessário para possibilitar que uma instituição financeira crie contas para pessoas jurídicas.<br>

## Estrutura de Pasta

📦 root<br>
┣ 📂 exceptions<br>
┣ 📂 modules<br>
┃ ┣ 📂 account<br>
┃ ┃ ┣ 📂 controllers<br>
┃ ┃ ┣ 📂 dto<br>
┃ ┃ ┗ 📂 useCases<br>
┃ ┣ 📂 account-tracking<br>
┃ ┃ ┣ 📂 controllers<br>
┃ ┃ ┣ 📂 dto<br>
┃ ┃ ┗ 📂 useCases<br>
┃ ┗ 📂 client<br>
┃ ┃ ┣ 📂 controllers<br>
┃ ┃ ┣ 📂 dto<br>
┃ ┃ ┗ 📂 useCases<br>
┣ 📂 security<br>
┣ 📂 services<br>

## Rotas

| name                    | controller#action                | rota                     |
| ----------------------- | -------------------------------- | ------------------------ |
| client                  | ClientController                 | POST client/             |
| client-auth             | AuthClientController             | POST client/auth         |
| account                 | AccountController                | POST account/            |
| account-access          | AccountController                | GET  account/            |
| account-tracking        | AccountTrackingController        | POST account-tracking/   |
| account-tracking-access | AccountTrackingController        | GET  account-tracking/   |


# Instalação
```bash
# Instalar o Java 17

# Instalar o Docker

# Clonar o projeto 

# Incializar o PostgreSQL com o Docker
  docker compose -d

# Rodar o projeto
```

## 🚀 Tecnologias
No desenvolvimento deste projeto foram usadas as seguintes tecnologias:
* Java
* Spring Boot
* Maven

<br>

## 📚 Packages and Libraries
* [maven](https://maven.apache.org/)
* [lombok](https://projectlombok.org/)
* [springboot](https://spring.io/projects/spring-boot/)
* [jsonwebtoken](https://jwt.io/libraries)

<br>

## 📚 Author
<a href="https://www.linkedin.com/in/dayanesallet/" target="_blank"><img align="left" src="https://raw.githubusercontent.com/yushi1007/yushi1007/main/images/linkedin.svg" alt="" width="21px"/></a>
