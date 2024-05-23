package com.restaurant.restaurant.exception;

import com.restaurant.restaurant.exception.itemex.EmptyMenuItem;
import com.restaurant.restaurant.exception.itemex.MenuItemNotFound;
import com.restaurant.restaurant.exception.menuex.EmptyMenu;
import com.restaurant.restaurant.exception.menuex.MenuNotFound;
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
