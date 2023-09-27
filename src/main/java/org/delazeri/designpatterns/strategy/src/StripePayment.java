package org.delazeri.designpatterns.strategy.src;

public class StripePayment implements Payable {

    public StripePayment() {}

    @Override
    public boolean pay(Order order) {
        System.out.printf("Seu pagamento de R$ %s está sendo processado por Stripe%n", order.getAmount());
        return true;
    }
}
