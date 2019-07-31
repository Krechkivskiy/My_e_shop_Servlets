package service;

import model.Code;
import model.Order;

public interface CodeService {
    void  add(Code code);

    int getCode(int orderId);

    int getCode(Order order);
}
