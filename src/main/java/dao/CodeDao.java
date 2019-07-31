package dao;

import model.Code;
import model.Order;

public interface CodeDao  {

    void  add(Code code);

    int getCode(int orderId);

    int getCode(Order order);
}
