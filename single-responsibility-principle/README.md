# 📌 Single Responsibility Principle (SRP)

Este projeto demonstra o uso do **S** dos princípios **SOLID — o Single Responsibility Principle**, que afirma que uma classe deve ter apenas uma única responsabilidade e, portanto, apenas um motivo para mudar.

---

## 📚 Descrição
O **SRP (Single Responsibility Principle)** é frequentemente mal interpretado como a necessidade de manter arquivos pequenos ou de dividir o sistema excessivamente. No entanto, o foco real está na coerência de responsabilidades de uma classe. Sempre que uma classe possuir múltiplos motivos para ser alterada, estamos provavelmente violando o SRP.

Neste projeto, usamos um exemplo simples de processamento de pedido para demonstrar boas práticas com o SRP.

## 🏗️ Estrutura Inicial do Projeto
A estrutura inicial possuía a classe `OrderProcessorService`, responsável por:

- Verificar inventário;
- Calcular o valor total do pedido;
- Processar pagamento.

```bash
public class OrderProcessorService {

    public void processOrder(Order order){
        this.checkInventory(order);
        this.calculateTotal(order);
        this.processPayment(order);
    }

    private void checkInventory(Order order){
        // LOGIC
    }
    private void calculateTotal(Order order){
        // LOGIC
    }
    private void processPayment(Order order){
        // LOGIC
    }
}
```

Isso violava o SRP pois a classe possuía múltiplas responsabilidades (e múltiplos motivos para mudar) e conhecia muitas regras de negócio.

## ✅ Refatoração com SRP
Para aplicar corretamente o SRP, extraímos cada responsabilidade para sua própria classe:

- 🔍 `InventoryChecker` – responsável por verificar o inventário.
- 💰 `OrderCalculator` – responsável por calcular o total do pedido.
- 💳 `PaymentProcessor` – responsável por processar o pagamento.

Essas classes encapsulam suas respectivas lógicas, promovendo reutilização e melhor manutenção do código.

## 💡 Ordem de Execução com Composição de Objetos
Criamos novamente a classe `OrderProcessorService`, mas agora com foco apenas em coordenar o processo. Ela utiliza injeção de dependências para compor os objetos especializados e executá-los na ordem correta:

```bash
public class OrderProcessorService {
    private final InventoryChecker inventoryChecker;
    private final OrderCalculator orderCalculator;
    private final PaymentProcessor paymentProcessor;

    public void processOrder(Order order) {
        inventoryChecker.check(order);
        orderCalculator.calculate(order);
        paymentProcessor.processPayment(order);
    }
}
```

Modificamos a classe SolidApplication (main):

```bash
public class SolidApplication {
    public static void main(String[] args) {
        Order order = new Order("ba1aef0d-4ccb-489c-90b5-cb7664a53c2d", 500);
        InventoryChecker inventoryChecker = new InventoryChecker();
        OrderCalculator orderCalculator = new OrderCalculator();
        PaymentProcessor paymentProcessor = new PaymentProcessor();

        OrderProcessorService orderProcessorService = new OrderProcessorService(
                inventoryChecker,
                orderCalculator,
                paymentProcessor
        );

        orderProcessorService.processOrder(order);
    }
}
```

Essa estrutura reflete o **Design Pattern Facade**, promovendo separação de responsabilidades e baixo acoplamento.

## 🧠 O que aprendemos
- **Coesão**: Classes coesas fazem apenas uma coisa.
- **Reutilização**: Cada classe pode ser reutilizada em outros contextos.
- **Manutenção**: Mudanças são mais localizadas e seguras.
- **Testabilidade**: Facilita testes unitários por responsabilidade.