# API Aluno Online

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-336791?style=for-the-badge&logo=postgresql&logoColor=white)

## 📜 Descrição
A **API Aluno Online** é um sistema para gerenciamento de alunos, professores, disciplinas e matrículas. Oferece funcionalidades como:
- **Criação, atualização, listagem e exclusão de registros**.
- Cálculo de **média de notas**.
- Gerenciamento de matrículas e disciplinas.

---

## 🛠️ Funcionalidades
### 📘 Aluno
- Criar, listar, buscar, atualizar e deletar alunos.
### 👨‍🏫 Professor
- Cadastrar professores e associar disciplinas.
### 📚 Disciplina
- Criar disciplinas e listar as associadas a um professor.
### 📝 Matrícula
- Matricular alunos, atualizar notas, calcular médias e trancar matrículas.

---

## 🏗️ Estrutura do Projeto
A API é composta por:
1. **Controller**: Gerencia as requisições HTTP.
2. **Model**: Define as entidades do sistema.
3. **Repository**: Conexão entre a aplicação e o banco de dados.
4. **Service**: Implementa a lógica de negócios.
5. **DTOs**: Transfere dados entre as camadas.
6. **Enums**: Gerencia constantes do sistema.
7. **Config**: Configuração do Swagger.

---

## 🚀 Tecnologias Utilizadas
- **Java 11+**
- **Spring Boot**
- **PostgreSQL**
- **Lombok**
- **Swagger**

---

## 📦 Como Configurar o Projeto

### 1️⃣ Pré-requisitos
- **Java 11+** instalado.
- **IDE** como IntelliJ ou Eclipse.
- **Banco de dados PostgreSQL** configurado.

### 2️⃣ Passos
1. Acesse [start.spring.io](https://start.spring.io/) e gere um projeto com as dependências:
   - **Spring Web**
   - **Spring Data JPA**
   - **PostgreSQL Driver**
   - **Lombok**
2. Baixe e extraia o projeto.
3. Abra a pasta no **IDE de sua preferência**.
4. Configure o arquivo `application.properties` com as credenciais do PostgreSQL:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/seu_banco
   spring.datasource.username=seu_usuario
   spring.datasource.password=sua_senha
   spring.jpa.hibernate.ddl-auto=update


📖 Endpoints
**Aluno**
POST /alunos: Criar aluno.
GET /alunos: Listar todos os alunos.
GET /alunos/{id}: Buscar aluno por ID.
PUT /alunos/{id}: Atualizar aluno.
DELETE /alunos/{id}: Deletar aluno.
**Professor**
POST /professores: Criar professor.
GET /disciplinas/{professorId}: Listar disciplinas associadas.
**Disciplina**
POST /disciplinas: Criar disciplina.
**Matrícula**
POST /matriculas-alunos: Criar matrícula.
PATCH /matriculas-alunos/trancar/{id}: Trancar matrícula.
PATCH /matriculas-alunos/atualiza-notas/{id}: Atualizar notas.


🧰 Ferramentas Adicionais
Swagger
O Swagger está integrado e pode ser acessado em:

bash
Copiar código
http://localhost:8080/swagger-ui/index.html
Permite explorar os endpoints e testar a API.

💡 Melhorias Futuras
Adicionar autenticação com JWT.
Implementar testes unitários e de integração.
Adicionar novos endpoints para relatórios.
