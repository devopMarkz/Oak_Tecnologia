# Teste Técnico - Oak Tecnologia

Este projeto foi desenvolvido como parte do teste técnico para a vaga de estágio na **Oak Tecnologia**. A aplicação é uma API RESTful desenvolvida com o **Spring Boot** e outras tecnologias modernas.
Apenas o backend foi commitado para que possam ser passadas as instruções para fazê-lo funcionar.

## Tecnologias Utilizadas

O projeto utiliza as seguintes tecnologias e frameworks:

- **Java 21**: A versão mais recente do Java, utilizada para o desenvolvimento da aplicação backend.
- **Spring Boot 3.4.1**: Framework para desenvolvimento de aplicações Java baseadas em Spring, oferecendo fácil configuração e inicialização de servidores.
- **Spring Data JPA**: Utilizado para a persistência de dados em banco de dados relacional com uma abordagem de mapeamento objeto-relacional (ORM).
- **Spring Security**: Framework para proteção e autenticação de aplicações web.
- **Bean Validation (javax.validation)**: Usado para validações de dados na entrada de requisições.
- **Maven**: Ferramenta de automação de compilação que gerencia dependências do projeto.
- **Hibernate**: Framework ORM utilizado para mapear as entidades Java para o banco de dados.
- **HTML/CSS/JavaScript**: Tecnologias para a construção da interface frontend.

Essas tecnologias foram escolhidas para fornecer uma solução escalável, segura e fácil de manter, com foco na produtividade e boas práticas de desenvolvimento.

## Passos para Importar o Projeto

Para importar e rodar o projeto em sua máquina local, siga os passos abaixo.

### 1. Pré-requisitos

Antes de começar, certifique-se de que os seguintes softwares estão instalados em sua máquina:

- **Java 21**: A versão do JDK utilizada no projeto. Baixe e instale o Java 21 em [https://adoptopenjdk.net/](https://adoptopenjdk.net/) ou diretamente no [site da Oracle](https://www.oracle.com/java/technologies/javase-jdk21-downloads.html).
- **Maven**: O projeto utiliza Maven para gerenciamento de dependências. Caso não tenha o Maven instalado, baixe e instale em [https://maven.apache.org/download.cgi](https://maven.apache.org/download.cgi).
- **IDE** (IntelliJ ou Eclipse): A IDE que você utilizará para importar e rodar o projeto. Se ainda não possui, baixe o IntelliJ em [https://www.jetbrains.com/idea/](https://www.jetbrains.com/idea/) ou o Eclipse em [https://www.eclipse.org/downloads/](https://www.eclipse.org/downloads/).

### 2. Importando o Projeto no IntelliJ

1. Abra o IntelliJ IDEA.
2. Selecione **Open** no menu principal.
3. Navegue até a pasta onde você clonou ou extraiu o repositório do projeto e selecione o diretório do projeto.
4. O IntelliJ deve detectar automaticamente que o projeto é um projeto Maven e importar as dependências automaticamente. Caso contrário, você pode forçar o IntelliJ a carregar as dependências Maven manualmente:
   - Vá em **View** → **Tool Windows** → **Maven**.
   - Clique no ícone de **refresh** na janela do Maven para atualizar as dependências.
5. Verifique se o Maven está configurado corretamente:
   - Vá em **File** → **Project Structure** → **Modules**.
   - Certifique-se de que o módulo está apontando para a versão correta do **JDK 21**.

### 3. Importando o Projeto no Eclipse

1. Abra o Eclipse IDE.
2. Selecione **File** → **Import...**.
3. No menu de importação, selecione **Existing Maven Projects** e clique em **Next**.
4. Na próxima tela, clique em **Browse...** e selecione a pasta onde você clonou ou extraiu o repositório do projeto.
5. O Eclipse detectará o arquivo `pom.xml` do Maven e listará todos os projetos do Maven. Selecione o projeto e clique em **Finish**.
6. O Eclipse começará a importar as dependências do Maven. Caso as dependências não sejam importadas automaticamente, você pode forçar a atualização clicando com o botão direito do mouse no projeto na aba de **Project Explorer** e selecionando **Maven** → **Update Project**.
7. Verifique se o Maven está configurado corretamente:
   - Clique com o botão direito no projeto e vá até **Properties**.
   - Em **Java Build Path**, verifique se o **JDK 21** está selecionado.

### 4. Rodando a Aplicação

Após importar o projeto, basta rodar a aplicação da seguinte forma:

- **IntelliJ**: Abra a classe principal que contém a anotação @SpringBootApplication e clique no botão direito em **Run**, ou vá até **Run** → **Run 'Application'**.
- **Eclipse**: Abra a classe principal que contém a anotação @SpringBootApplication, clique com o botão direito no projeto e selecione **Run As** → **Spring Boot App**.

A aplicação será iniciada no servidor embutido do Spring Boot (Tomcat) e estará disponível no endereço `https://localhost:8080`.

---

Com esses passos, você conseguirá importar e rodar o projeto em sua máquina local utilizando IntelliJ ou Eclipse. Não se esqueça de garantir que o **Java 21** e o **Maven** estão corretamente instalados e configurados para evitar problemas durante a importação.

## Como Utilizar a API

### 1. Introdução

A API foi construída utilizando **Spring Boot** e oferece endpoints para gerenciar os produtos. Não será necessário utilizar o **Postman** para testar os endpoints, pois já há um **front-end funcional** em `index.html`, que interage diretamente com a API. Ao acessar o front-end, você poderá realizar todas as operações disponíveis, como criar e visualizar produtos.

### 2. Endpoints da API

A API possui os seguintes endpoints:

- **POST /produtos**: Para criar um novo produto.
- **GET /produtos**: Para listar todos os produtos cadastrados.

#### 2.1 Endpoint POST - Criar Produto

- **URL**: `https://localhost:8080/produtos`
- **Método**: `POST`
- **Corpo da Requisição** (JSON):
    ```json
    {
        "nome": "Geladeira",
        "descricao": "Geladeira Eletrolux",
        "valor": 1205.00,
        "disponivel": "sim"
    }
    ```
- **Resposta** (JSON):
    ```json
    [
        {
            "nome": "Geladeira",
            "valor": 1205.0
        },
        {
            "nome": "TV",
            "valor": 1500.0
        }
    ]
    ```
  Esse endpoint recebe um objeto de produto e o insere no banco de dados. A resposta é uma lista de todos os produtos cadastrados, incluindo o recém-criado.

#### 2.2 Endpoint GET - Listar Produtos

- **URL**: `https://localhost:8080/produtos`
- **Método**: `GET`
- **Resposta** (JSON):
    ```json
    [
        {
            "nome": "Geladeira",
            "valor": 1205.0
        },
        {
            "nome": "TV",
            "valor": 1500.0
        }
    ]
    ```
  Esse endpoint retorna a lista de todos os produtos cadastrados no banco de dados.

### 3. Interagindo com o Front-End

Como mencionado, o front-end funcional em **`index.html`** já está integrado à API. Você pode realizar as seguintes ações através da interface de usuário:

- **Criar Produto**: Preencha o formulário de criação de produto no front-end e clique no botão para adicionar um novo produto. O formulário enviará os dados para o endpoint **POST /produtos**.
  
- **Visualizar Produtos**: A lista de produtos será carregada automaticamente ao acessar o front-end e será exibida na interface.

Não é necessário utilizar o **Postman** ou qualquer outra ferramenta para interagir com os endpoints da API. Basta acessar o front-end, preencher os campos e visualizar os resultados.

### 4. Acessando o Front-End

1. Abra o arquivo `index.html` no seu navegador.
2. A interface do front-end será carregada automaticamente.
3. Utilize os formulários e botões para interagir com a API de forma simples e intuitiva.


### 5. Considerações Finais

Este projeto foi desenvolvido com o objetivo de fornecer uma solução prática e eficiente para a gestão de produtos, utilizando **Spring Boot** no back-end e um front-end simples. A combinação entre essas duas camadas permite uma interação tranquila e intuitiva, facilitando a comunicação entre o servidor e o usuário final. 

Ao utilizar o **Spring Boot**, conseguimos aproveitar a simplicidade e o poder do framework para criar uma API RESTful robusta, com endpoints claros e de fácil manutenção. A integração com o front-end, apesar de simples, oferece uma interface direta para realizar operações como o cadastro e a visualização de produtos, tornando o processo de desenvolvimento e uso da aplicação mais acessível e prático.

Além disso, o uso de um front-end básico já funcional reduz a necessidade de ferramentas externas para testar a API, tornando a experiência de uso mais fluida e a integração entre o back-end e o front-end mais eficiente. Esse projeto serve como uma boa base para quem deseja expandir para soluções mais complexas e adicionar funcionalidades adicionais, como segurança, validação mais robusta, e testes automatizados. A implementação também oferece flexibilidade para o uso de tecnologias e ferramentas adicionais no futuro.

Em resumo, o projeto cumpre bem o papel de demonstrar os conceitos de construção de APIs com **Spring Boot** e integração com o front-end, além de abrir caminho para possíveis melhorias e novos recursos à medida que as necessidades do sistema evoluem.


