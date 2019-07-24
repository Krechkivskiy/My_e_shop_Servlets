package model;

public class Code {

    private int code;
    private Order order;

    public Code(int code, Order order) {
        this.code = code;
        this.order = order;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
