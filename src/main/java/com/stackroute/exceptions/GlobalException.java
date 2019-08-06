package com.stackroute.exceptions;

import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Logger;

public class GlobalException {
   private static final Logger logger = (Logger) LoggerFactory.getLogger(GlobalException.class);

   @ExceptionHandler(SQLException.class)
   public String handleSQLException(HttpServletRequest request, Exception ex){
       logger.info("SQLException Occured:: URL="+request.getRequestURL());
       return "database_error";
   }

   @ResponseStatus(value= HttpStatus.NOT_FOUND, reason="IOException occured")
   @ExceptionHandler(IOException.class)
   public void handleIOException(){
       logger.error("IOException handler executed");
       //returning 404 error code
   }


}
