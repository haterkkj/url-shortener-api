# URL Shortener API

> 🇺🇸 Esse README também está disponível em [Inglês (README.md)](./README.md)

Este projeto é uma API desenvolvida em Java com Spring Boot para encurtamento de URLs. Ela permite transformar URLs longas em URLs curtas, facilitando o compartilhamento e a organização.

## Funcionalidades

A aplicação permite que você:

* Cadastre uma URL longa e obtenha uma URL curta.
* Redirecione automaticamente para a URL original ao acessar a URL curta.
* Remova URLs encurtadas do sistema.

## Tecnologias Utilizadas

* Java 17
* Spring Boot
* PostgreSQL
* Flyway (migrações de banco de dados)
* Docker & Docker Compose

## Como iniciar o projeto

### 1. Clonar o repositório

```bash
git clone https://github.com/thiago-f-santos/url-shortener-api.git
cd .\url-shortener-api
```

### 2. Configurar o PostgreSQL

A aplicação **não sobe o banco de dados automaticamente com o Docker Compose**. Portanto, você precisa:

* Ter um PostgreSQL instalado localmente **ou**
* Ter um contêiner PostgreSQL em execução por conta própria.

#### Com Docker Compose

Crie um arquivo `.env` na raiz do projeto com as seguintes variáveis:

```env
DB_CONNECTION_STRING=jdbc:postgresql://DATABASE:PORT/urlshortener
DB_USERNAME=postgres
DB_PASSWORD=root
```

> 💡 `host.docker.internal` permite que o contêiner da aplicação acesse o PostgreSQL que está rodando fora dele. No Linux, talvez seja necessário usar o IP do host ou configurar uma rede Docker personalizada.

#### Sem Docker Compose

Você pode configurar a conexão diretamente no seu ambiente ou modificar o `application.yml` com os valores desejados:

```yaml
spring:
  datasource:
    driver-class-name: org.postgresql.Driver
    url: jdbc:postgresql://localhost:5432/urlshortener
    username: postgres
    password: root
```

A aplicação também suporta variáveis de ambiente via:

```yaml
spring:
  datasource:
    driver-class-name: org.postgresql.Driver
    url: ${DB_CONNECTION_STRING:jdbc:postgresql://localhost:5432/urlshortener}
    username: ${DB_USERNAME:postgres}
    password: ${DB_PASSWORD:root}
```

> ✅ Os valores de usuário, senha e porta **podem ser personalizados**, desde que coincidam com os usados pela aplicação.

Certifique-se de que o banco esteja criado e acessível antes de iniciar a aplicação.

### 3. Rodar a aplicação com Docker Compose

```bash
docker-compose up --build
```

Isso irá:

* Construir a imagem da aplicação.
* Aplicar as migrações do Flyway.
* Iniciar o Spring Boot.

> 📌 **Lembre-se:** o PostgreSQL **não é iniciado pelo Docker Compose** deste projeto. Você deve garantir que ele esteja rodando previamente.

### 4. Acessar a aplicação

A aplicação estará disponível em:

```
http://localhost:8080
```

A documentação da API pode ser acessada via Swagger UI:

```
http://localhost:8080/docs.html
```

## Observações

* As migrações estão em: `src/main/resources/db/migration`
* Os endpoints estão documentados em `/docs` no formato OpenAPI.

---

Fique à vontade para personalizar as variáveis do `.env` e os parâmetros de configuração conforme sua necessidade.