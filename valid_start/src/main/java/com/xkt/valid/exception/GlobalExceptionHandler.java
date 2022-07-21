package com.xkt.valid.exception;

import com.xkt.valid.dto.ResultDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;


/**
 * @author LiJing
 * @ClassName: GlobalExceptionHandler
 * @Description: 全局异常处理器
 * @date 2019/7/30 13:57
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private static int DUPLICATE_KEY_CODE = 1001;
    private static int PARAM_FAIL_CODE = 1002;
    private static int VALIDATION_CODE = 1003;

    /**
     * 处理自定义异常
     */
    /*@ExceptionHandler(BizException.class)
    public ResultDTO handleRRException(BizException e) {
        logger.error(e.getMessage(), e);
        return new ResultDTO(e.getCode(), e.getMessage());
    }*/

    /**
     * 方法参数校验
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultDTO handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        logger.error(e.getMessage(), e);
        return new ResultDTO(PARAM_FAIL_CODE, e.getBindingResult().getFieldError().getDefaultMessage());
    }

    /**
     * ValidationException
     */
    @ExceptionHandler(ValidationException.class)
    public ResultDTO handleValidationException(ValidationException e) {
        logger.error(e.getMessage(), e);
        return new ResultDTO(VALIDATION_CODE, e.getCause().getMessage());
    }

    /**
     * ConstraintViolationException
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public ResultDTO handleConstraintViolationException(ConstraintViolationException e) {
        logger.error(e.getMessage(), e);
        return new ResultDTO(PARAM_FAIL_CODE, e.getMessage());
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResultDTO handlerNoFoundException(Exception e) {
        logger.error(e.getMessage(), e);
        return new ResultDTO(404, "路径不存在，请检查路径是否正确");
    }

    /*@ExceptionHandler(DuplicateKeyException.class)
    public ResultDTO handleDuplicateKeyException(DuplicateKeyException e) {
        logger.error(e.getMessage(), e);
        return new ResultDTO(DUPLICATE_KEY_CODE, "数据重复，请检查后提交");
    }*/


    @ExceptionHandler(Exception.class)
    public ResultDTO handleException(Exception e) {
        logger.error(e.getMessage(), e);
        return new ResultDTO(500, "系统繁忙,请稍后再试");
    }
}
