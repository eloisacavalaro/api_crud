# 💳 API Bancária - CRUD com Spring Boot

API REST desenvolvida com **Java + Spring Boot** simulando um sistema bancário simples, com gerenciamento de clientes, contas bancárias, transações e endereços.

O projeto foi desenvolvido para praticar arquitetura em camadas, persistência com JPA e regras de negócio.

---

## 🚀 Funcionalidades

### 👤 Cliente
- Criar cliente
- Atualizar dados
- Listar todos os clientes
- Listar apenas clientes ativos
- Delete lógico
- Retorno utilizando DTO

### 🏦 Conta Bancária
- Criar conta vinculada a um cliente
- Atualizar saldo
- Consulta por ID

### 💸 Transações
- Depósito
- Saque
- Transferência entre contas
- Extrato ordenado por data
- Validação de saldo antes da transação

### 📍 Endereço
- Cadastro manual
- Busca automática por CEP utilizando a API pública ViaCEP
- Persistência no banco de dados

### 📧 Email
- Envio de e-mail ao cadastrar novo cliente (Spring Mail)

---

## 🛠 Tecnologias utilizadas

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- PostgreSQL
- Lombok
- Spring Mail
- OkHttp
- Gson
- API ViaCEP

---

## 🗃 Banco de Dados

Banco utilizado: **PostgreSQL**

Exemplo de configuração no `application.properties`:

spring.datasource.url=jdbc:postgresql://localhost:5432/apibdd  
spring.datasource.username=postgres  
spring.datasource.password=123456  

---

## 📂 Arquitetura

O projeto segue o padrão em camadas:

- Controller → Responsável pelos endpoints REST
- Service → Regras de negócio
- Repository → Comunicação com o banco
- DTO → Transferência de dados simplificada
- Entity → Mapeamento das tabelas com JPA

---

## ▶️ Como executar o projeto

1. Clonar o repositório
2. Criar um banco PostgreSQL
3. Ajustar as credenciais no `application.properties`
4. Rodar a aplicação com:

mvn spring-boot:run

A API ficará disponível em:

http://localhost:8080

---

## 📌 Exemplos de endpoints

### Clientes
- GET /clientes
- GET /clientes/{id}
- POST /clientes
- PUT /clientes/{id}
- DELETE /clientes/{id}

### Contas
- GET /contas
- POST /contas

### Transações
- POST /transacoes
- GET /transacoes/extrato/{id}

---

## 🎯 Objetivo do Projeto

Praticar desenvolvimento de APIs REST com Spring Boot, aplicando:

- Relacionamentos JPA (OneToOne, ManyToOne)
- Enum para tipo de transação
- Regras de negócio para movimentação financeira
- Integração com API externa
- Envio de e-mail automatizado
