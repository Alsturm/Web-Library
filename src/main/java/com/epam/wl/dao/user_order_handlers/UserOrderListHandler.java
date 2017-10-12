package com.epam.wl.dao.user_order_handlers;

import com.epam.wl.entities.UserOrder;
import com.epam.wl.enums.UserOrderStatus;
import com.epam.wl.executor.ResultHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserOrderListHandler implements ResultHandler<List<UserOrder>> {
    @Override
    public List<UserOrder> handle(ResultSet resultSet) throws SQLException {
        List<UserOrder> resultUserOrderList = new ArrayList();
        while (resultSet.next()) {
            int userOrderID = resultSet.getInt("user_order.id");
            int userID = resultSet.getInt("user.id");
            String userName = resultSet.getString("user.name");
            String userLastname = resultSet.getString("user.lastname");
            String userEmail = resultSet.getString("user.email");
            String bookTitle = resultSet.getString("book.title");
            String bookAuthor = resultSet.getString("book.author");
            int bookYear = resultSet.getInt("book.year");
            UserOrderStatus status = UserOrderStatus.valueOf(resultSet.getString("user_order.status"));
            resultUserOrderList.add(new UserOrder(userOrderID, userID, userName, userLastname, userEmail, bookTitle, bookAuthor, bookYear, status));
        }
        return resultUserOrderList;
    }
}