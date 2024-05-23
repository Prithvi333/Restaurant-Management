package com.restaurant.restaurant.exception.order_itemex;

public class EmptyOrderItem extends RuntimeException{
  public EmptyOrderItem(){
       super("Empty order item");
  }
  public EmptyOrderItem(String message){
      super(message);
  }
}

