# 📅 Sistema de Agendamento Inteligente com Otimização

Um sistema desenvolvido em **Java** com **Spring Boot** para gerenciar e otimizar agendamentos de forma eficiente. A aplicação foi projetada para oferecer flexibilidade, escalabilidade e integração com APIs externas.

## 🚀 Tecnologias Utilizadas
- **Java 17+**
- **Spring Boot** (Web, Data JPA, Validation)
- **Hibernate** (ORM)
- **Banco de Dados**: H2 (dev) / MySQL ou PostgreSQL (prod)
- **Maven** (gerenciador de dependências)
- **Lombok** (redução de código boilerplate)
- **Netty** (interno do Spring Boot para comunicação)

## 📂 Estrutura do Projeto
```
src/
 ├── main/
 │    ├── java/
 │    │     └── com.sistema.agendamento
 │    │            ├── controller/   # Controladores REST
 │    │            ├── service/      # Regras de negócio
 │    │            ├── repository/   # Interface de acesso ao banco
 │    │            └── model/        # Entidades JPA
 │    └── resources/
 │          ├── application.properties
 │          └── data.sql (opcional para carga inicial)
 └── test/                           # Testes unitários
```

## ⚙️ Funcionalidades
- Cadastro, edição e remoção de agendamentos
- Definição de horários disponíveis
- Validação de conflitos de horários
- Otimização de agenda com base em critérios personalizados
- API REST para integração com outros sistemas

## 🛠 Como Executar o Projeto
```bash
# Clonar o repositório
git clone https://github.com/SEU_USUARIO/Sistema_de_Agendamento_Inteligente_com_Otimizacao.git
cd Sistema_de_Agendamento_Inteligente_com_Otimizacao

# Compilar e executar
mvn spring-boot:run

# Acessar no navegador
http://localhost:8080
```

## 📬 Endpoints Principais
| Método | Endpoint                  | Descrição                       |
|--------|---------------------------|----------------------------------|
| GET    | `/agendamentos`            | Lista todos os agendamentos     |
| POST   | `/agendamentos`            | Cria um novo agendamento        |
| PUT    | `/agendamentos/{id}`       | Atualiza um agendamento         |
| DELETE | `/agendamentos/{id}`       | Remove um agendamento           |

## 📝 Autor
**Keven Nogueira da Silva**  
📍 Duque de Caxias - RJ  
💻 Desenvolvedor Back-End Java Júnior
