# 📌 Open Closed Principle (OCP)

Este projeto demonstra a aplicação do **O** dos princípios **SOLID — o Open Closed Principle**, que afirma que uma classe deve estar **aberta para extensão, mas fechada para modificação**. Também mostramos como aplicar esse princípio utilizando o **Design Pattern Strategy**.

---

## 📚 Descrição
O **OCP (Open Closed Principle)** nos orienta a projetar sistemas de forma que novas funcionalidades possam ser adicionadas sem alterar o código existente. Ao invés de modificar diretamente classes existentes, devemos **estendê-las** com novas implementações.

Neste projeto, utilizamos o exemplo de aplicação de **descontos em pedidos** para mostrar como uma refatoração orientada ao OCP pode tornar o código mais flexível e sustentável.

## 🏗️ Estrutura Inicial do Projeto
A estrutura inicial consistia na classe `Order`, responsável por:

- Armazenar o valor do pedido (`amount`);
- Aplicar desconto fixo (`applyFixedDiscount`);
- Aplicar desconto percentual (`applyPercentDiscount`).

```bash
public class Order {
    private double amount;

    public double getAmount() { return amount; }

    public void applyFixedDiscount(double value) {
        if (value > amount) throw new IllegalArgumentException("Discount cannot be greater than order value");
        amount -= value;
    }

    public void applyPercentDiscount(double percent) {
        if (percent < 0 || percent > 100) throw new IllegalArgumentException("Enter a percentage value between 1% and 100%");
        amount -= amount * (percent / 100.0);
    }
}
```

No `main`, eram criadas instâncias da classe `Order` com aplicação direta dos métodos de desconto.

## ⚠️ Problemas Encontrados
- A classe `Order` tinha **múltiplas responsabilidades** (violando o SRP);
- Era necessário **modificar a classe** `Order` toda vez que um novo tipo de desconto fosse criado (violando o OCP);
- O sistema **não possuía representação explícita** de um "Desconto", dificultando reuso e persistência em banco de dados;
- Faltava **polimorfismo**, tornando o sistema rígido e menos extensível.

## ✅ Refatoração com OCP + Strategy
Para resolver esses problemas, aplicamos o **Design Pattern Strategy** e criamos uma interface de estratégia de desconto chamada `DiscountInterface`:

```bash
public interface DiscountInterface {
    double apply(double amount);
}
```

Criamos duas implementações:

## 🔸 FixedDiscount

```bash
public class FixedDiscount implements DiscountInterface {
    private final double value;

    public FixedDiscount(double value) {
        this.value = value;
    }

    @Override
    public double apply(double amount) {
        if (value > amount) throw new IllegalArgumentException("Discount cannot be greater than the order value");
        return amount - value;
    }
}
```

## 🔸 PercentageDiscount

```bash
public class PercentageDiscount implements DiscountInterface {
    private final double percentage;

    public PercentageDiscount(double percentage) {
        if (percentage < 0 || percentage > 100)
            throw new IllegalArgumentException("The percentage value must be between 0 and 100");
        this.percentage = percentage;
    }

    @Override
    public double apply(double amount) {
        return amount - (amount * percentage / 100.0);
    }
}
```

## 🔁 Refatoração da Classe Order

```bash
public class Order {
    private double amount;
    private DiscountInterface discount;

    public Order(double amount) {
        this.amount = amount;
    }

    public void setDiscount(DiscountInterface discount) {
        this.discount = discount;
    }

    public double getAmount() {
        if (discount != null) {
            return discount.apply(amount);
        }
        return amount;
    }
}
```

## 💻 Método Main Após Refatoração

```bash
public class Main {
    public static void main(String[] args) {
        Order order1 = new Order(100);
        order1.setDiscount(new FixedDiscount(10));
        System.out.println("Order 1 total: " + order1.getAmount());

        Order order2 = new Order(200);
        order2.setDiscount(new PercentageDiscount(25));
        System.out.println("Order 2 total: " + order2.getAmount());
    }
}
```

## 🧠 O que aprendemos
- OCP facilita a **extensão de comportamento sem alterar código existente**;
- Estratégias (como descontos) podem ser **encapsuladas em classes separadas**;
- Utilizamos **polimorfismo** para desacoplar a lógica de cálculo de desconto da classe `Order`;
- A arquitetura se torna mais **flexível, testável e preparada para mudanças futuras**.

## 🧩 Possíveis Extensões
- Adicionar novos tipos de desconto sem tocar na classe `Order`;
- Criar abstrações para persistir descontos em banco de dados;
- Incluir regras de negócios mais complexas por tipo de cliente, canal de compra etc.