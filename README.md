# 🏦 AppBanco

Um sistema simples em **Java** para gerenciamento de clientes de um banco, desenvolvido com arquitetura **MVC (Model-View-Controller)**.  

> ⚠️ Este projeto está em **implementação contínua** e tem como objetivo o **aprimoramento dos meus estudos e conhecimentos em programação**.

---

## 📂 Estrutura do Projeto

src/
├── AppBanco.java # Classe principal
├── controller/
│ └── ClienteController.java
├── model/
│ └── Cliente.java
└── view/
└── Menu.java

markdown
Copiar código

- **Model** → contém as classes de domínio (ex: `Cliente`)  
- **View** → responsável pela interação com o usuário (ex: `Menu`)  
- **Controller** → lógica de controle (ex: `ClienteController`)  
- **AppBanco** → ponto de entrada da aplicação  

---

## 🚀 Como executar

1. Certifique-se de ter o **Java 17+** instalado:
   ```bash
   java -version
Compile os arquivos:

bash
Copiar código
javac src/**/*.java -d out
Execute a aplicação:

bash
Copiar código
java -cp out AppBanco
✅ Funcionalidades atuais
- Criar cliente (nome, CPF e idade)
- Listar clientes cadastrados
- Abrir conta
- Listar contas
- Encerrar programa

📌 Próximos Passos
- Implementar persistência em arquivo ou banco de dados
- Criar operações bancárias (saque, depósito, etc.)
- Melhorar validações de dados

👨‍💻 Autor
Julio Lima
