## Projeto Formulário Web

Este projeto consiste em um sistema completo de envio e armazenamento de formulários, utilizando um frontend web, backend em Java com Spring Boot, e PostgreSQL como banco de dados.

### Dependências e Requisitos
#### Backend
* Java 17+
* Spring Boot 3+
* Maven
* Docker e Docker Compose (para configurar o PostgreSQL)
* PostgreSQL
#### Frontend
* Navegador Web Moderno (Google Chrome, Firefox, Edge, etc.)
* Live Server ou servidor estático para servir os arquivos HTML e JS localmente
* Outros
    * Cliente de API (opcional, para testes): Postman, Insomnia ou cURL
    * IDE ou editor de texto (recomendado: IntelliJ IDEA, VS Code)

### Configuração do Ambiente
#### 1. Banco de Dados com Docker Compose
No diretório raiz do projeto, certifique-se de ter um arquivo `docker-compose.yml` configurado. Utilize o seguinte comando para iniciar o banco de dados PostgreSQL:
```
docker-compose up -d
```
Isso iniciará o container com o PostgreSQL e criará o banco forms-web-db.

### 2. Configuração do Backend
* Clone o repositório
```
git clone <URL_DO_REPOSITORIO>
cd backend
```

* Certifique-se de que o arquivo application.properties está configurado corretamente para o PostgreSQL:

```
spring.datasource.url=jdbc:postgresql://localhost:5432/forms-web-db
spring.datasource.username=postgres
spring.datasource.password=passwd123
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update
```
* Execute o back-end:
```
mvn spring-boot:run
```

### 3. Configuração do Frontend
* Naveque até o diretório do frontend:
```
cd front-end
```

* Inicie um servidor local para servir os arquivos HTML. Por exemplo, utilizando o VS Code com Live Server:
    * Abra o diretório no VS Code.
    * Clique com o botão direito no arquivo index.html e selecione Open with Live Server. O frontend estará acessível em: http://127.0.0.1:5500
    
### Fluxo de Uso
* Abra o frontend no navegador.
* Preencha o formulário com os dados solicitados, incluindo o arquivo de currículo.
* Clique em Enviar.
* Verifique se os dados foram salvos no banco de dados.