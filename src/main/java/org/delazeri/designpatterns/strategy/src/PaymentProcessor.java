package org.delazeri.designpatterns.strategy.src;

public class PaymentProcessor {
    public static Payable getPayable(PaymentMethod paymentMethod) {
        switch (paymentMethod) {
            case PAYPAL -> {
                return new PaypalPayment();
            }
            case STRIPE -> {
                return new StripePayment();
            }
            default -> {
                throw new IllegalArgumentException("Erro ao tentar identificar a forma de pagamento selecionada");
            }
        }
    }

    public static void process(Payable payable, Order order) {
        payable.pay(order);
    }
}
