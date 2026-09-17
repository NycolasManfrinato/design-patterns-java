# Design Patterns em Java — Desafio DIO

Projeto desenvolvido como desafio de código da trilha **Itaú Java com
Inteligência Artificial** (DIO), no módulo *Explorando Padrões de
Projeto na Prática com Java*.

O projeto simula o fechamento de um pedido em uma loja fictícia e
aplica, de forma integrada, três padrões de projeto (GoF) trabalhados
no curso:

## Padrões aplicados

### 1. Singleton — `singleton/AppConfig.java`
Garante uma única instância de configuração (nome da loja, moeda,
percentual máximo de desconto) compartilhada por toda a aplicação,
com criação *lazy* e *thread-safe*.

### 2. Strategy — `strategy/`
Define uma família de algoritmos de desconto intercambiáveis:
- `NoDiscountStrategy` — sem desconto;
- `RegularCustomerDiscount` — 10% de desconto;
- `VipCustomerDiscount` — 25% de desconto.

A regra de desconto é escolhida em tempo de execução, sem que o
código cliente precise conhecer os detalhes de cada implementação.

### 3. Facade — `facade/OrderFacade.java`
Expõe um único método (`fecharPedido`) que orquestra, por trás de uma
interface simples, os subsistemas de **estoque**, **pagamento** e
**notificação**, além dos padrões Singleton e Strategy já aplicados.

## Estrutura do projeto

```
src/main/java/com/nycolas/designpatterns/
├── Main.java
├── singleton/
│   └── AppConfig.java
├── strategy/
│   ├── DiscountStrategy.java
│   ├── NoDiscountStrategy.java
│   ├── RegularCustomerDiscount.java
│   └── VipCustomerDiscount.java
└── facade/
    ├── OrderFacade.java
    └── subsystems/
        ├── StockService.java
        ├── PaymentService.java
        └── NotificationService.java
```

## Como executar

Pré-requisitos: Java 17+ e Maven.

```bash
mvn clean compile exec:java -Dexec.mainClass="com.nycolas.designpatterns.Main"
```

ou, gerando o `.jar`:

```bash
mvn clean package
java -jar target/design-patterns-java.jar
```

## Como rodar os testes

```bash
mvn test
```

## Tecnologias

- Java 17
- Maven
- JUnit 5

---

Desafio de projeto do bootcamp **DIO** — trilha *Itaú Java com
Inteligência Artificial*.
