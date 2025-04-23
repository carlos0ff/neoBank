<h1 align="center">💻 Bankly - Simulando um Banco Digital </h1>
<p align="center">
  Um projeto feito para rodar exclusivamente no terminal/console, <br />
  oferecendo uma experiência bancária minimalista com Java
</p>

<p align="center">
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

O **Bankly** é uma aplicação Java que simula operações bancárias básicas através do terminal/console. Ideal para fins educacionais, prática de lógica de programação, e conceitos de orientação a objetos em Java.

## 🖥️ Execução via Terminal

Com uma interface simples via console, você poderá:

- Criar e acessar contas bancárias
- Verificar saldo
- Realizar depósitos e saques
- Simular transferências entre contas
- Ver o extrato de operações

Sem interface gráfica ou web – 100% no terminal, direto ao ponto. 💻⚡

## 🚀 Como Rodar

```bash
# Clone o repositório
git clone https://github.com/carlos0ff/neoBank.git
cd neoBank

# Compile e execute
javac src/com/banco/Main.java && java src/coom/banco/Main.java
```
### 📁 Estrutura do Repositório

```bash
bankly/
├── src/
│   ├── br/
│   │   └── com/
│   │       └── bankly/
│   │           ├── app/                     # Ponto de entrada da aplicação (Main.java)
│   │           │   └── Main.java
│   │           │
│   │           ├── core/                    # Regras de negócio (serviços, lógica principal)
│   │           │   └── services/
│   │           │       └── ExtractService.java
│   │           │
│   │           ├── domain/                  # Modelos de dados e enums
│   │           │   ├── models/
│   │           │   │   └── Transaction.java
│   │           │   └── enums/
│   │           │       └── BankType.java
│   │           │
│   │           ├── presentation/           # Camada de apresentação (menus e interface no terminal)
│   │           │   ├── menu/
│   │           │   │   ├── ClientAccess.java
│   │           │   │   └── MainMenu.java
│   │           │   └── style/
│   │           │       ├── InnerConsoleStyle.java
│   │           │       └── StyledText.java
│   │           │
│   │           └── utils/                  # Utilitários e helpers
│   │               ├── CleanScreen.java
│   │               ├── Loading.java
│   │               └── Validator.java
│
├── images/                                 # Imagens usadas no projeto
├── docs/                                   # Documentação do projeto
│   └── README.md
├── .gitignore
├── LICENSE
└── README.md
```

--- 

## 🤝🏼 Contribuições 
são bem-vindas! Siga estes passos:

- Faça um fork do projeto
- Crie uma branch
```bash
git checkout -b feature/nova-funcionalidade
```
- Commit suas mudanças
```bash
  git commit -m 'Adiciona nova funcionalidade'
```
- Push para a branch
```bash
 git push origin feature/nova-funcionalidade
```
- Abra um Pull Request 

--- 

## 📄 Licença
Este projeto está licenciado sob a Licença MIT - consulte o arquivo [LICENSE](LICENSE) para obter detalhes.

--- 

<p align="center"> Desenvolvido com ❤️ por <a href="https://github.com/carlos0ff">Carlos</a> </p>
