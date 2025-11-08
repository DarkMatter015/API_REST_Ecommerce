# 🧪 RiffHouse API – Testes de API (Postman)

Coleção para testes de **API RESTful** desenvolvida no **Postman** para a aplicação **RiffHouse** — um e-commerce de instrumentos musicais. A coleção cobre todos os **endpoints principais da API**.

---

## 📁 Estrutura da Coleção

| Pasta | Descrição                                                                          | Métodos testados |
|-------|------------------------------------------------------------------------------------|------------------|
| **Auth** | Autenticação e validação de tokens JWT                                             | `POST /auth/login`, `GET /auth/validate` |
| **Users** | CRUD de usuários (criação, atualização, leitura e exclusão)                        | `POST`, `PATCH`, `GET`, `DELETE` |
| **Addresses** | CRUD de endereços vinculados ao usuário                                            | `POST`, `GET`, `PATCH`, `DELETE` |
| **Products** | CRUD de produtos (POST, PATCH e DELETE acessível para usuários admin)                   | `POST`, `GET`, `PATCH`, `DELETE` |
| **Categories** | CRUD de categorias de produtos (POST, PATCH e DELETE acessível para usuários admin) | `POST`, `GET`, `PATCH`, `DELETE` |
| **Payments** | CRUD de métodos de pagamento (POST, PATCH e DELETE acessível para usuários admin)  | `POST`, `GET`, `PATCH`, `DELETE` |
| **Orders** | Criação e atualização de pedidos (sem exclusão)                                    | `POST`, `GET`, `PATCH` |
| **OrderItems** | CRUD de itens de pedido vinculados a uma compra                                    | `POST`, `GET`, `PATCH`, `DELETE` |

---

## 🧠 Cenário de Teste

A coleção cobre todas as operações principais da API, que serve para o usuário simular o fluxo de uso de um e-commerce:

1. Criação e autenticação de um usuário (`Users`, `Auth`)
2. (ADMIN) Cadastro de produtos, categorias e métodos de pagamento (`Products`, `Categories`, `Payments`)
3. Criação de endereços vinculados ao usuário (`Addresses`)
4. Criação de pedidos com itens associados (`Orders`, `OrderItems`)
5. Validação de respostas HTTP e autenticação JWT

---

## ⚙️ Configuração e Variáveis

A coleção utiliza variáveis de ambiente para facilitar a execução dos testes:

| Variável | Descrição | Exemplo |
|-----------|------------|---------|
| `base_url_ecommerce` | URL base da API | `http://localhost:8080` |
| `token` | Token JWT gerado após o login | gerado automaticamente via `Auth/Login` |

> 🔒 Após o login, o token é salvo automaticamente no ambiente e usado nas requisições seguintes com autenticação Bearer.

---

## ▶️ Como Executar os Testes

### 1️⃣ Importar a coleção:
No Postman:
- Vá em **File > Import**
- Selecione o arquivo:  
  `server-ecommerce API.postman_collection.json`

### 2️⃣ Configurar as variáveis:
- Crie um **Environment** chamado `RiffHouse Local`
- Adicione:
  ```
  base_url_ecommerce = http://localhost:8080
  token = (deixe vazio)
  ```

### 3️⃣ Executar a coleção:
- Clique em **Runner** no Postman
- Selecione a coleção `server-ecommerce API`
- Escolha o ambiente `RiffHouse Local`
- Execute a sequência completa ou selecione pastas específicas

---

## 🧩 Integração com o Projeto

Essa coleção se integra diretamente à **API do projeto RiffHouse**  
👉 [RiffHouse API (Back-end Java Spring Boot)](https://github.com/DarkMatter015/server-ecommerce)

Ela foi projetada para:
- Validar a consistência dos endpoints REST;
- Garantir a comunicação correta entre **front-end React** e **back-end Spring Boot**;
- Apoiar o processo de QA com futuro testes de regressão e smoke tests de API.

---

## 💡 Melhorias Futuras

- Adicionar **testes automatizados em todos os endpoints**
- Adicionar **variáveis dinâmicas** (IDs gerados automaticamente entre requests)
- Implementar **testes encadeados** (fluxo completo: criar usuário → logar → criar pedido)
- Adicionar **validações avançadas de resposta JSON**
- Exportar relatórios automatizados com **Newman**

---

## 👨‍💻 Autor

Desenvolvido por **Lucas Matheus de Camargo**  
📎 [LinkedIn](https://www.linkedin.com/in/lucas-matheus-de-camargo-49a315236/)  
💼 Buscando oportunidades como **QA Júnior** e **Desenvolvedor Java/Fullstack Júnior**
