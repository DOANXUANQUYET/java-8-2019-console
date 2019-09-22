package com.laptrinhjavaweb.utils;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

public class FormUtil {

    @SuppressWarnings("unchecked")
    public static <T> T toModel(Class<T> tclass, HttpServletRequest request) {
        T object = null;
        try {
            object = tclass.newInstance();
            // chuyen parametter qua kieu key value map ve object
            BeanUtils.populate(object, request.getParameterMap());
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            System.out.print(e.getMessage());
        }

        return object;
    }

}
