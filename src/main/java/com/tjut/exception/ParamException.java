package com.tjut.exception;

import com.tjut.pojo.dto.CommonResult;
import com.tjut.pojo.dto.result.BlankResult;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.sql.SQLException;
import java.util.Set;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ParamException {
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public CommonResult<BlankResult> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        StringBuilder sb = new StringBuilder("校验失败:");
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            sb.append(fieldError.getField()).append("：").append(fieldError.getDefaultMessage()).append(", ");
        }
        String msg = sb.toString();
        return CommonResult.fail(msg);
    }
    @ExceptionHandler({ConstraintViolationException .class})
    public CommonResult<BlankResult> handleConstraintViolationException(ConstraintViolationException ex) {
        Set<ConstraintViolation<?>> violations = ex.getConstraintViolations();
        String msg = violations.stream().map(ConstraintViolation::getMessage).collect(Collectors.joining(";"));
        return CommonResult.fail(msg);
    }

    @ExceptionHandler({SQLException.class})
    public CommonResult<BlankResult> handleSQLException(SQLException e) {
        return CommonResult.fail("SQL异常");
    }
    @ExceptionHandler({PersistenceException.class})
    public CommonResult<BlankResult> handlePersistenceException(PersistenceException ex) {
        return CommonResult.fail("持久化异常");
    }
    @ExceptionHandler({DataIntegrityViolationException.class})
    public CommonResult<BlankResult> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        return CommonResult.fail("数据完整性异常");
    }
}