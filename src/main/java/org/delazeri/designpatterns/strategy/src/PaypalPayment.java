package org.delazeri.designpatterns.strategy.src;

public class PaypalPayment implements Payable{

    public PaypalPayment(){}

    @Override
    public boolean pay(Order order) {
        System.out.printf("Seu pagamento de R$ %s está sendo processado por Paypal%n", order.getAmount());
        return true;
    }
}
