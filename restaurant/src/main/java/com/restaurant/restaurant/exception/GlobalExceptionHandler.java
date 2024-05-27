package com.restaurant.restaurant.exception;

import com.restaurant.restaurant.entity.Order;
import com.restaurant.restaurant.exception.adminex.AdminNotFound;
import com.restaurant.restaurant.exception.adminex.EmptyAdminList;
import com.restaurant.restaurant.exception.itemex.EmptyMenuItem;
import com.restaurant.restaurant.exception.itemex.MenuItemNotFound;
import com.restaurant.restaurant.exception.menuex.EmptyMenu;
import com.restaurant.restaurant.exception.menuex.MenuNotFound;
import com.restaurant.restaurant.exception.order_itemex.EmptyOrderItem;
import com.restaurant.restaurant.exception.order_itemex.OrderItemNotFound;
import com.restaurant.restaurant.exception.orderex.EmptyOrderList;
import com.restaurant.restaurant.exception.orderex.OrderNotFound;
import com.restaurant.restaurant.exception.userex.EmptyUserList;
import com.restaurant.restaurant.exception.userex.UserNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {



    @ExceptionHandler(UserNotFound.class)
    public ResponseEntity<ErrorDataTransfer> userNotFound(UserNotFound userNotFound){
        ErrorDataTransfer errorDataTransfer  = new ErrorDataTransfer();
         errorDataTransfer.setErrorMessage(userNotFound.getMessage());
         errorDataTransfer.setLocalDateTime(LocalDateTime.now());
       return new ResponseEntity<>(errorDataTransfer, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmptyAdminList.class)
    public ResponseEntity<ErrorDataTransfer> EmptyAdminListFound(EmptyAdminList emptyAdminList){
        ErrorDataTransfer errorDataTransfer = new ErrorDataTransfer();
        errorDataTransfer.setErrorMessage(emptyAdminList.getMessage());
        errorDataTransfer.setLocalDateTime(LocalDateTime.now());
        return new ResponseEntity<>(errorDataTransfer,HttpStatus.OK);
    }

    @ExceptionHandler(AdminNotFound.class)
    public  ResponseEntity<ErrorDataTransfer> adminNotFound(AdminNotFound adminNotFound){
        return new ResponseEntity<>(new ErrorDataTransfer(adminNotFound.getMessage(),LocalDateTime.now()),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmptyUserList.class)
    public ResponseEntity<ErrorDataTransfer> emptyUserList(EmptyUserList emptyUserList){
        return new ResponseEntity<>(new ErrorDataTransfer(emptyUserList.getMessage(),LocalDateTime.now()),HttpStatus.OK);
    }

    @ExceptionHandler(OrderItemNotFound.class)
    public ResponseEntity<ErrorDataTransfer> orderItemNotFound(OrderItemNotFound orderItemNotFound){
        ErrorDataTransfer errorDataTransfer =new ErrorDataTransfer(orderItemNotFound.getMessage(),LocalDateTime.now());
        return new ResponseEntity<>(errorDataTransfer,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmptyOrderItem.class)
    public ResponseEntity<ErrorDataTransfer> emptyErrorItem(EmptyOrderItem emptyOrderItem){
        return new ResponseEntity<>(new ErrorDataTransfer(emptyOrderItem.getMessage(),LocalDateTime.now()),HttpStatus.OK);
    }

    @ExceptionHandler(OrderNotFound.class)
    public ResponseEntity<ErrorDataTransfer> orderNotFound(OrderNotFound orderNotFound){
        ErrorDataTransfer errorDataTransfer =  new ErrorDataTransfer();
        errorDataTransfer.setLocalDateTime(LocalDateTime.now());
        errorDataTransfer.setErrorMessage(orderNotFound.getMessage());
        return new ResponseEntity<>(errorDataTransfer,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmptyOrderList.class)
    public ResponseEntity<ErrorDataTransfer> emptyOrderListFound(EmptyOrderList emptyOrderList){

        return new ResponseEntity<>(new ErrorDataTransfer(emptyOrderList.getMessage(),LocalDateTime.now()),HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(MenuItemNotFound.class)
    public ResponseEntity<ErrorDataTransfer> MenuItemNotFound(MenuItemNotFound menuItemNotFound){
         ErrorDataTransfer errorDataTransfer =new ErrorDataTransfer();
         errorDataTransfer.setErrorMessage(menuItemNotFound.getMessage());
         errorDataTransfer.setLocalDateTime(LocalDateTime.now());
        return new ResponseEntity<>(errorDataTransfer,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(EmptyMenuItem.class)
    public ResponseEntity<ErrorDataTransfer> emptyMenuItem(EmptyMenuItem emptyMenuItem){
        return new ResponseEntity<>(new ErrorDataTransfer(emptyMenuItem.getMessage(),LocalDateTime.now()),HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(EmptyMenu.class)
    public ResponseEntity<ErrorDataTransfer> emptyMenu(EmptyMenu emptyMenu){
        return new ResponseEntity<>(new ErrorDataTransfer(emptyMenu.getMessage(),LocalDateTime.now()),HttpStatus.OK);
    }

    @ExceptionHandler(MenuNotFound.class)
    public ResponseEntity<ErrorDataTransfer> menuNotFound(MenuNotFound menuNotFound){
        ErrorDataTransfer errorDataTransfer =  new ErrorDataTransfer(menuNotFound.getMessage(),LocalDateTime.now());
        return new ResponseEntity<>(errorDataTransfer,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<ErrorDataTransfer> noHandlerFound(NoHandlerFoundException noHandlerFoundException){

        ErrorDataTransfer errorDataTransfer = new ErrorDataTransfer(noHandlerFoundException.getMessage(),LocalDateTime.now());
        return new ResponseEntity<>(errorDataTransfer,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorDataTransfer> parentExceptionHandler(Exception exception){
          ErrorDataTransfer errorDataTransfer = new ErrorDataTransfer(exception.getMessage(),LocalDateTime.now());
          return new ResponseEntity<>(errorDataTransfer,HttpStatus.BAD_REQUEST);
    }
}
