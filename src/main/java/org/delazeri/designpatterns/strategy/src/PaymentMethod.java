package org.delazeri.designpatterns.strategy.src;

public enum PaymentMethod {
    PAYPAL("paypal"),
    STRIPE("stripe");

    private String method;

    PaymentMethod(String method) {
        this.method = method;
    }

    public String getMethod() {
        return method;
    }
}
