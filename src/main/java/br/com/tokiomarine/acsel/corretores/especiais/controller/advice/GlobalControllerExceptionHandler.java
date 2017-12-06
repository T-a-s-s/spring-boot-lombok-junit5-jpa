package br.com.tokiomarine.acsel.corretores.especiais.controller.advice;

import br.com.tokiomarine.acsel.corretores.especiais.exception.InternalServerErrorException;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalControllerExceptionHandler
{
  @ExceptionHandler({Exception.class})
  public void handleException(Exception e)
    throws Exception
  {
    if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null) {
      throw e;
    }
    throw new InternalServerErrorException("Ocorreu um erro ao utilizar o serviço, por favor tente novamente mais tarde!");
  }
}
