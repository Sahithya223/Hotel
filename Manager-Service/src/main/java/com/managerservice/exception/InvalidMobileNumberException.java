package com.managerservice.exception;

public class InvalidMobileNumberException extends RuntimeException 
{
   public InvalidMobileNumberException(String msg)
   {
	   super(msg);
   }
}
