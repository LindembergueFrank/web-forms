# Web Forms — Spring Boot + PostgreSQL

Projeto de estudo full stack para **envio e persistência de formulários**, com frontend web, backend Java/Spring Boot e PostgreSQL.

> Este repositório registra uma etapa de aprendizado. Ele não é apresentado como sistema de produção e deve ser avaliado pelo escopo implementado no código.

## Stack

### Backend

- Java 21
- Spring Boot 3.4.2
- Spring Data JPA
- Maven
- PostgreSQL

### Frontend

- HTML
- CSS
- JavaScript

### Infraestrutura local

- Docker
- Docker Compose

## Organização

```text
web-forms/
├── src/                 # backend Spring Boot
├── front-end/           # interface web
├── database-docker/     # PostgreSQL local e schema
├── pom.xml
└── README.md
```

## Configuração segura

Credenciais de banco **não ficam hardcoded no código ou na documentação**. A aplicação lê:

- `DB_URL`;
- `DB_USERNAME`;
- `DB_PASSWORD`.

O Compose usa `DB_USERNAME`, `DB_PASSWORD` e `DB_NAME`.

Arquivos `.env` locais são ignorados pelo Git. O arquivo `database-docker/.env.example` contém apenas valores de referência.

## Executando o PostgreSQL

```bash
cd database-docker
cp .env.example .env
```

Edite `.env` e defina uma senha apenas para seu ambiente local. Depois:

```bash
docker compose up -d
```

## Executando o backend

Na raiz do projeto, forneça as variáveis de ambiente ao processo Java. O projeto inclui Maven Wrapper; no Windows, utilize `mvnw.cmd spring-boot:run`. Exemplo em Linux/macOS:

```bash
export DB_URL=jdbc:postgresql://localhost:5432/forms-web-db
export DB_USERNAME=postgres
export DB_PASSWORD='sua-senha-local'
./mvnw spring-boot:run
```

No Windows/IDE, configure as mesmas variáveis no ambiente de execução.

## Executando o frontend

Entre em `front-end/` e sirva os arquivos com um servidor HTTP local, como Live Server, ou outra ferramenta equivalente.

## Fluxo básico

1. iniciar o PostgreSQL;
2. iniciar a aplicação Spring Boot;
3. servir o frontend;
4. preencher o formulário;
5. enviar os dados;
6. validar a persistência pela aplicação ou por uma ferramenta de banco.

## Boas práticas preservadas

- segredos fora do versionamento;
- configuração por ambiente;
- saída de build e metadados de IDE cobertos pelo `.gitignore`;
- separação entre frontend, backend e infraestrutura local.

## Próximas melhorias recomendadas

Para transformar este estudo em evidência mais forte de engenharia, as próximas etapas seriam:

- Bean Validation e respostas de erro padronizadas;
- migrations com Flyway;
- testes automatizados de controller/serviço;
- política explícita para upload e armazenamento de arquivos;
- limites de tamanho e validação de tipo de arquivo;
- autenticação/autorização, caso o domínio passe a exigir acesso restrito;
- CI para build e testes.

## Autor

**Lindembergue Frank**
