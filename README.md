<h1 align="center">💳 Neo Bank - Terminal Banking Experience</h1>
<p align="center">Um banco digital minimalista no terminal, feito com Java e Spring Boot.</p>

<p align="center">
<!--   <a href="https://github.com/sponsors/carlos0ff">
    <img src="https://img.shields.io/badge/Sponsor-%23EA4AAA.svg?style=for-the-badge&logo=github-sponsors&logoColor=white" alt="Sponsor">
  </a> -->
  <a href="https://github.com/carlos0ff/neoBank/stargazers">
    <img src="https://img.shields.io/github/stars/carlos0ff/neoBank?style=for-the-badge&color=yellow" alt="Stars">
  </a>
  <a href="https://github.com/carlos0ff/neoBank/network/members">
    <img src="https://img.shields.io/github/forks/carlos0ff/neoBank?style=for-the-badge&color=blue" alt="Forks">
  </a>
  <a href="https://github.com/carlos0ff/neoBank/issues">
    <img src="https://img.shields.io/github/issues/carlos0ff/neoBank?style=for-the-badge&color=green" alt="Issues">
  </a>
  <a href="https://github.com/carlos0ff/neoBank/blob/main/LICENSE">
    <img src="https://img.shields.io/badge/license-MIT-green?style=for-the-badge&logo=open-source-initiative" alt="License">
  </a>
</p>

---

## 🧠 Sobre o Projeto

O **Neo Bank** é uma aplicação de console que simula operações bancárias essenciais. Desenvolvida com foco educacional, é ideal para quem quer aprender Java, lógica de programação e princípios de orientação a objetos.

### ✨ Recursos disponíveis:

- 📲 Abertura e acesso de contas
- 💸 Depósitos e saques
- 🔁 Transferências entre contas
- 📄 Geração de extrato bancário
- 🎛️ Menus interativos com navegação via terminal

> **Tudo 100% no terminal. Sem interface gráfica. Sem dependências pesadas. Simples, direto ao ponto.**

---

## ⚙️ Tecnologias Utilizadas

- Java 17+
- Spring Boot (opcional/futuramente)
- ANSI Escape Codes (cores no terminal)
- Paradigma orientado a objetos

---

## 🚀 Como Rodar o Projeto

### 🔧 Pré-requisitos
- Java 17 ou superior instalado
- Terminal (bash, zsh, cmd ou PowerShell)

### ▶️ Executar localmente

```bash
# Clone o repositório
git clone https://github.com/carlos0ff/neoBank.git
cd neoBank

# Compile a aplicação 
javac src/zecabank/Main.java

# Execute
java src/zecabank/Main
```
>Obs: certifique-se de que a estrutura de diretórios está correta e todos os arquivos .java estão presentes.

### 📂 Estrutura do Projeto
```bash
src/
├── br/
│   └── com/
│       └── suapackage/
│           ├── app/                     # Pontos de entrada do programa (Main.java)
│           │   └── Main.java
│           │
│           ├── core/                    # Regras de negócio (services, lógica principal)
│           │   └── services/
│           │       └── ExtractService.java
│           │
│           ├── domain/                  # Representações de dados (Transaction, Cliente, etc)
│           │   ├── models/
│           │   │   └── Transaction.java
│           │   └── enums/
│           │       └── BankType.java
│           │
│           ├── presentation/           # Interação com usuário (menus, UI de console)
│           │   ├── menu/
│           │   │   ├── ClientAccess.java
│           │   │   └── MainMenu.java
│           │   └── style/
│           │       ├── InnerConsoleStyle.java
│           │       └── StyledText.java
│           │
│           ├── utils/                  # Utilitários auxiliares e helpers
│           │   ├── CleanScreen.java
│           │   ├── Loading.java
│           │   └── Validator.java
│
├── images/                              # Imagens usadas no projeto
├── docs/                                # Documentação
│   └── README.md
├── .gitignore
├── LICENSE
└── README.md

```
## 🤝 Contribuindo
Contribuições são bem-vindas! Se você quiser adicionar exemplos, melhorar a estrutura ou traduzir conteúdo, sinta-se à vontade para bifurcar este repositório e abrir um pull request.

## 👨‍💻 Autor
Feito com ❤️ por [Carlos](https://github.com/carlos0ff)
Se gostou do projeto, deixe uma ⭐️, contribua com PRs ou me apoie no GitHub Sponsors!

### 📄 Licença
Distribuído sob licença MIT.
Veja o arquivo LICENSE para mais detalhes.
