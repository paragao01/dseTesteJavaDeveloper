## Projeto: DSE - Sistema de Geração de Anagramas (Prova Java)

Este projeto foi criado com base no enunciado do teste para vaga Java Developer.
O foco principal é um utilitário de geração de **anagramas** com validação de entrada
e testes unitários (JUnit 4), em uma estrutura padrão Maven.

### Estrutura de Pastas

- **pom.xml**: configuração Maven do projeto.
- **src/main/java/br/com/dse/anagram/AnagramGenerator.java**  
  Classe responsável por gerar todos os anagramas possíveis de uma string de letras distintas.
- **src/main/java/br/com/dse/anagram/Application.java**  
  Classe com método `main` para execução via linha de comando (console).
- **src/test/java/br/com/dse/anagram/AnagramGeneratorTest.java**  
  Testes unitários (JUnit 4) cobrindo os cenários solicitados no teste.

### Requisitos Atendidos

- Aceita qualquer grupo de letras distintas como entrada.
- Validação básica:
  - Não aceita `null`;
  - Não aceita string vazia;
  - Não aceita caracteres não alfabéticos (apenas `[a-zA-Z]`).
- Implementação focada em **clareza** e **legibilidade**, usando recursão (backtracking).
- Testes unitários com pelo menos 3 casos, incluindo:
  - Três letras (`"abc"`);
  - Uma única letra (`"Z"`);
  - Entrada vazia (gera exceção).
- Código comentado e documentado em **português do Brasil**.

### Como Compilar e Rodar

Requisitos:
- Java 11+ instalado (`java`, `javac` no PATH).
- Maven instalado (`mvn` no PATH).

No diretório raiz do projeto (`dse-teste-vagaDeveloper`), execute:

```bash
mvn clean install
```

Para rodar os testes unitários separadamente:

```bash
mvn test
```

Para executar a aplicação no modo interativo (via console):

```bash
mvn exec:java
```

Você verá um prompt semelhante a:

```text
=== Gerador de Anagramas (DSE) ===
Informe uma sequência de letras distintas (ex: abc):
```

Exemplo de execução informando `abc`:

```text
Total de anagramas gerados: 6
abc
acb
bac
bca
cab
cba
```

Também é possível passar a entrada diretamente pela linha de comando:

```bash
mvn exec:java -Dexec.args=abc
```



