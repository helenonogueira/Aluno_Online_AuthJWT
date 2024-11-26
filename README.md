# Documentação do Projeto: API Aluno Online
Descrição
A API Aluno Online é um sistema desenvolvido para o gerenciamento de alunos, professores, disciplinas e matrículas. Oferece funcionalidades de criação, atualização, listagem e exclusão de registros, além de permitir cálculos como a média de notas, garantindo um ambiente eficiente para a administração acadêmica.

Configuração do Ambiente
Passo 1: Download das Dependências
Acesse o site start.spring.io.

Selecione as seguintes dependências:

Spring Web
Spring Data JPA
PostgreSQL Driver
Lombok
Baixe o projeto gerado.

Passo 2: Abrindo o Projeto
Utilize a IDE de sua preferência para abrir a pasta da API baixada.
Configure as dependências para garantir o funcionamento correto do projeto.
Estrutura do Projeto
A API é composta por sete componentes principais:

Controller
Responsável por gerenciar as requisições HTTP, como adicionar ou listar alunos.
Model
Define a estrutura e os atributos das entidades, como Aluno e Disciplina.
Repository
Faz a interface entre o código Java e o banco de dados.
Service
Contém as regras de negócios, como validações ao criar ou atualizar um aluno.
DTOs (Data Transfer Objects)
Usados para transportar dados entre as camadas de maneira segura e eficiente.
Enums
Define constantes para gerenciamento de status, como "Ativo" ou "Trancado".
Config
Configuração do Swagger, ferramenta para documentação e teste da API.
Anotações Utilizadas
No Controller
@RestController: Define a classe como RESTful, permitindo lidar com requisições HTTP.
@RequestMapping: Define a rota base para os métodos da classe.
@PostMapping, @GetMapping, @DeleteMapping, @PutMapping, @PatchMapping: Mapeiam requisições POST, GET, DELETE, PUT e PATCH, respectivamente.
@ResponseStatus: Define o código de status HTTP retornado.
@RequestBody: Converte o corpo da requisição JSON em objeto Java.
@PathVariable: Captura valores específicos da URL.
@Autowired: Realiza a injeção de dependências automaticamente.
No Model
@Entity: Define a classe como uma entidade JPA (mapeada para uma tabela no banco).
@Id e @GeneratedValue: Configura o campo como chave primária e sua geração automática.
@NoArgsConstructor, @AllArgsConstructor, @Data: Geram construtores e métodos úteis.
@ManyToOne e @JoinColumn: Configuram relacionamentos entre entidades.
@Enumerated: Mapeia campos do tipo enum para colunas no banco de dados.
No Repository
@Repository: Define a interface como um repositório para acesso a dados.
No Service
@Service: Marca a classe como um componente de serviço Spring.
@Autowired: Realiza a injeção automática de dependências.
Funcionalidades Principais
Aluno
Criar um novo aluno.
Listar todos os alunos cadastrados.
Buscar aluno por ID.
Atualizar dados de um aluno.
Deletar um aluno.
Professor
Cadastrar professores.
Associar disciplinas aos professores.
Matrícula
Matricular alunos em disciplinas.
Atualizar notas e calcular média.
Trancar matrícula.
Disciplina
Adicionar novas disciplinas.
Listar disciplinas associadas a um professor.
Endpoints Disponíveis
Aluno
POST /alunos: Criar um novo aluno.
GET /alunos: Listar todos os alunos.
GET /alunos/{id}: Buscar aluno por ID.
PUT /alunos/{id}: Atualizar dados de um aluno.
DELETE /alunos/{id}: Remover um aluno.
Professor
POST /professores: Criar novo professor.
GET /disciplinas/{professorId}: Listar disciplinas atribuídas a um professor.
Disciplina
POST /disciplinas: Criar nova disciplina.
Matrícula
POST /matriculas-alunos: Criar uma nova matrícula.
PATCH /matriculas-alunos/trancar/{id}: Trancar uma matrícula.
PATCH /matriculas-alunos/atualiza-notas/{id}: Atualizar notas.
Swagger
O Swagger é integrado ao projeto para facilitar a documentação e testes da API. Ele gera automaticamente uma interface gráfica que permite explorar os endpoints, visualizar os modelos de dados e executar requisições diretamente no navegador.

Definição de DTO
O DTO (Data Transfer Object) é utilizado para transferir dados entre diferentes camadas do sistema, simplificando o fluxo de informações e protegendo os modelos internos.

Com esta estrutura, a API Aluno Online oferece um sistema robusto para gerenciar dados acadêmicos de forma eficiente e escalável.
