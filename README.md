# 🛡️ API Aluno Online - Segurança e Autenticação
Java | Spring Boot | PostgreSQL | Spring Security | JWT

# 📜 Descrição
Continuação do projeto Aluno Online, agora com foco na implementação de segurança, autenticação e autorização utilizando Spring Security com JWT.

Foram adicionadas funcionalidades essenciais para proteger a API e controlar o acesso com base em permissões (roles), além de melhorias nas práticas de desenvolvimento e deploy.

# 🛠️ Melhorias Implementadas
## ✅ 1. Segurança com Spring Security e JWT
Objetivos:

### Proteger a API com autenticação e autorização.

### Controle de acesso baseado em permissões (ROLE_ADMIN e ROLE_ALUNO).

### Prevenção contra ataques CSRF e clickjacking.

### Principais Configurações:

### SecurityConfigurations: Centraliza todas as regras de segurança.

### Stateless: Cada requisição é independente, autenticada via token.

### Desativação do CSRF: Utilizando tokens para segurança.

## ✅ 2. Implementação de Autenticação
### login: Endpoint para autenticação e geração do token JWT.

### AuthController: Gerencia autenticação e cadastro.

### AutenticacaoService: Implementa UserDetailsService para buscar usuário no banco.

### PasswordEncoder: Criptografia de senhas com BCrypt.

### DTOs Criados:

### AuthenticationDTO – Recebe login e senha no login.

### LoginResponseDTO – Retorna o token JWT ao usuário.

### RegisterDTO – Utilizado no cadastro de novos usuários.

## Exemplo de fluxo:

### Usuário envia login e senha.

### Backend valida e gera JWT.

### Token enviado nas próximas requisições no Authorization: Bearer.

## ✅ 3. Controle de Acesso por Permissões (Roles)
### Roles Definidas:

### ROLE_ADMIN: Pode cadastrar professores, alunos e realizar alterações.

### ROLE_ALUNO: Acesso restrito a visualizar informações e realizar matrículas.

Exemplo de Configuração:

http
  .authorizeRequests()
  .antMatchers("/cadastros").permitAll()
  .antMatchers("/admin/**").hasRole("ADMIN")
  .anyRequest().authenticated();

No Frontend:
Exibir ou ocultar abas conforme a role decodificada do JWT.

## ✅ 4. Pacotes e Classes de Segurança
### SecurityFilter: Filtra as requisições e valida o token JWT.

### TokenService: Responsável por gerar e validar tokens com Auth0 JWT.

### Configuração do tempo de expiração: Exemplo: 2 horas.

### Chave secreta: Definida via application.properties.

## ✅ 5. Cadastro de Usuários
### /cadastros: Endpoint público para criação de novos usuários.

### UsuarioController: Gerencia cadastro com validações e criptografia de senha.

### Prevenção de cadastros duplicados.

### Tratamento de exceções centralizado (TratadorDeErros).

## ✅ 6. Documentação da API com SpringDoc
### Swagger OpenAPI: Geração automática da documentação.

### Endpoints de Documentação:

### /swagger-ui.html

### /v3/api-docs/**

### Configurações Especiais:

### Liberação do Swagger sem necessidade de autenticação.

### Configurado suporte para enviar o token Bearer diretamente pelo Swagger.

## ✅ 7. Build e Deploy
### Separação de configurações:

### application.properties para desenvolvimento.

### application-prod.properties para produção.

### Uso de variáveis de ambiente para dados sensíveis.

Build com Maven:

bash
mvn package
Deploy:

bash
java -jar alunoonline.jar
🏗️ Estrutura do Projeto
Controller – Gerencia as requisições HTTP.

Model – Define entidades.

Repository – Interface com banco de dados.

Service – Regras de negócio.

DTOs – Dados de entrada e saída, incluindo autenticação.

Config – Configurações de segurança e documentação.

🚀 Tecnologias Utilizadas
Java 11+

Spring Boot

Spring Security

PostgreSQL

JWT (Auth0)

Lombok

SpringDoc OpenAPI

# 📸 Exemplos de Requisições
Logo abaixo, insira imagens demonstrando o fluxo completo utilizando o Insomnia:

## 🔐 Login
➡️ Imagem: Requisição de login bem-sucedida, recebendo token JWT

## ✅ Usuário Autenticado
➡️ Imagem: Requisição autenticada com token JWT

## 👤 Cadastro de Aluno
➡️ Imagem: Cadastro de aluno como ROLE_ADMIN

## 👨‍🏫 Cadastro de Admin
➡️ Imagem: Cadastro de usuário com ROLE_ADMIN

## 🛠️ Configuração de Ambientes
➡️ Imagem: Exemplo de application.properties e application-prod.properties configurados

## 💡 Boas Práticas Aplicadas
### ✅ Autenticação e autorização com Spring Security e JWT
### ✅ Criptografia de senhas com BCrypt
### ✅ Separação de configurações por ambiente
### ✅ Build e deploy automatizados com Maven
### ✅ Documentação completa e integrada com SpringDoc
### ✅ Tratamento centralizado de exceções

## 📖 Endpoints de Autenticação
### Método	Endpoint	Descrição
### POST	/login	Login e geração de token JWT
### POST	/cadastros	Cadastro de novo usuário

## 📖 Exemplo de Proteção de Endpoints
### Método	Endpoint	Permissão Necessária
### POST	/admin/professores	ROLE_ADMIN
### GET	/alunos	ROLE_ALUNO, ROLE_ADMIN
### PATCH	/admin/matriculas/{id}	ROLE_ADMIN

## 📈 Próximos Passos
### ✅ Controle de acesso por roles → Implementado

### ✅ Geração e validação de tokens → Implementado

### ✅ Documentação → Implementado

### 🔜 Testes unitários e de integração

### 🔜 Monitoramento e logging avançados

### 🔜 Deploy automatizado via CI/CD

### ✅ Como Configurar
## 1️⃣ Pré-requisitos:

Java 11+

PostgreSQL

Maven

## 2️⃣ Configuração:

Ajuste o application.properties com as credenciais do banco.

Para produção, use application-prod.properties e variáveis de ambiente.

properties
Copiar
Editar
spring.datasource.url=jdbc:postgresql://localhost:5432/alunoonline
spring.datasource.username=usuario
spring.datasource.password=senha
spring.jpa.hibernate.ddl-auto=update
jwt.secret=minha_chave_secreta
jwt.expiration=2h
## 3️⃣ Executar:

bash
Copiar
Editar
mvn package  
java -jar target/alunoonline.jar  
📬 Contato
Em caso de dúvidas ou sugestões, entre em contato:
Heleno Nogueira
