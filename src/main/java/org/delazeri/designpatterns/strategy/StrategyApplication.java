package org.delazeri.designpatterns.strategy;

import org.delazeri.designpatterns.strategy.src.Order;
import org.delazeri.designpatterns.strategy.src.PaymentMethod;
import org.delazeri.designpatterns.strategy.src.PaymentProcessor;

public class StrategyApplication {
    public static void main(String[] args) {
        PaymentMethod paypal = PaymentMethod.PAYPAL;
        PaymentMethod stripe = PaymentMethod.STRIPE;

        Order order = new Order("A guerra dos tronos ed-1", 53.99);

        PaymentProcessor.process(
                PaymentProcessor.getPayable(paypal),
                order
        );
    }
}
