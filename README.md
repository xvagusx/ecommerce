# Ecommerce
Aplicação gerada com as seguintes dependências até o momento:

* Spring Boot Versão: 2.2.4.RELEASE
* H2 Database: 1.4.200
* Swagger Versão: 2.9.2
* Spring Boot Starter Web
* Spring Boot Data Jpa

## Desenvolvimento
Criado Servicos para contemplar: Campanha e Socio Torcedor.

### Download de Libs
Para baixar as libs, basta usar o comando:

```
mvn compile
````

### Ambiente de Desenvolvimento

Iniciando a aplicação via linha de comando:

````
mvn spring-boot:run
````

### Qualidade de código

Basicamente, o código deverá respeitar as diretivas de qualidade do Sonar.

## Swagger

Foi configurado o Swagger na aplicação para documentação de APIs.

O endereço padrão é:

````
http://localhost:8081/swagger-ui.html
````

## H2 Database

Foi configurado o h2 na aplicação para geração do banco de dados em memoria.

O endereço padrão é:

````
http://localhost:8081/h2
````
