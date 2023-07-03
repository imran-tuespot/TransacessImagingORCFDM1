package com.peniel.dao.helper;

import com.peniel.common.PenielException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Date;

/**
 * User: todds
 * Date: 11/4/11
 * Time: 5:01 PM
 */
public class FieldHelper {
    private static final Logger LOGGER = LoggerFactory.getLogger(FieldHelper.class);
    private String fieldName;
    private Class clazz;
    private Class parameterClazz;
    private Method method;

    public FieldHelper(Class clazz, String fieldName, Class paramClass) throws NoSuchMethodException {
        this.clazz = clazz;
        this.fieldName = fieldName;
        this.parameterClazz = paramClass;
        String methodName = "set" + fieldName.substring(0,1).toUpperCase() + fieldName.substring(1);
        method = clazz.getMethod(methodName, parameterClazz);
    }

    public boolean isFieldThisType(Class clazz) {
        return parameterClazz == clazz;
    }


    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    /**
     * set the value in the class
     * @param thisObject
     * @param value
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    public void setter(Object thisObject, Object value) throws IllegalAccessException {
        try {
            if (parameterClazz.isPrimitive()) {
                if (parameterClazz == int.class) {
                    if (value == null) {
                        value = 0;
                    }
                    if (value instanceof Integer) {
                        method.invoke(thisObject, (Integer)value);
                    }
                    if (value instanceof Long) {
                        method.invoke(thisObject, ((Long)value).intValue());
                    }
                    if (value instanceof Double) {
                        method.invoke(thisObject, ((Double) value).intValue());
                    }
                    if (value instanceof Float) {
                        method.invoke(thisObject, ((Float) value).intValue());
                    }
                } else {
                    if (parameterClazz == long.class) {
                        if (value == null) {
                            value = 0l;
                        }
                        if (value instanceof Integer) {
                            method.invoke(thisObject, ((Integer)value).longValue());
                        }
                        if (value instanceof Long) {
                            method.invoke(thisObject, (Long)value);
                        }
                        if (value instanceof Double) {
                            method.invoke(thisObject, ((Double) value).longValue());
                        }
                        if (value instanceof Float) {
                            method.invoke(thisObject, ((Float) value).longValue());
                        }
                    } else {
                        if (parameterClazz == double.class) {
                            if (value == null) {
                                value = 0f;
                            }
                            if (value instanceof Float) {
                                method.invoke(thisObject, ((Float)value).doubleValue());
                            }
                            if (value instanceof Double) {
                                method.invoke(thisObject, (Double)value);
                            }
                        } else {
                            if (parameterClazz == float.class) {
                                if (value == null) {
                                    value = 0.0;
                                }
                                if (value instanceof Double) {
                                    method.invoke(thisObject, ((Double)value).floatValue());
                                }
                                if (value instanceof Float) {
                                    method.invoke(thisObject, (Float)value);
                                }
                            }
                        }
                    }
                }
            } else {
                if (value instanceof Date) {
                    if (value == null) {
                        method.invoke(thisObject, value);
                    } else {
                        method.invoke(thisObject, value.toString());
                    }
                } else {
                    if (value == null) {
                        method.invoke(thisObject, value);
                    } else {
                        method.invoke(thisObject, value.toString());
                    }
                }
            }
        } catch (InvocationTargetException e) {

        }
//        Field field = thisObject.getClass().getField(fieldName);
//        field.set(thisObject, value);

    }

    /**
     * set the value in the class
     * @param thisObject
     * @param value
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    public void setter(Object thisObject, int value) throws IllegalAccessException {
        try {
            method.invoke(thisObject, value);
        } catch (InvocationTargetException e) {

        }
//        Field field = thisObject.getClass().getField(fieldName);
//        field.set(thisObject, value);

    }

    public static boolean isGetter(Method method){
        return method.getName().startsWith("get") && method.getParameterTypes().length == 0 && !void.class.equals(method.getReturnType());
    }

    public static boolean isSetter(Method method){
        return method.getName().startsWith("set") && method.getParameterTypes().length == 1;
    }

}
