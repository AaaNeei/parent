package com.yxw.utils;

import org.springframework.beans.BeanUtils;

/**
 * dto与do,vo之间转换工具类
 *
 * @param <DTO>
 * @param <DO>
 * @param <VO>
 */
public class YxwBeanUtils<DTO, DO,VO> {

    /**
     * dot 转换为Do 工具类
     *
     * @param dtoEntity
     * @param doClass
     * @return
     */
    public static <DO> DO dtoToDo(Object dtoEntity, Class<DO> doClass) {
        // 判断dto是否为空!
        if (dtoEntity == null) {
            return null;
        }
        // 判断DoClass 是否为空
        if (doClass == null) {
            return null;
        }
        try {
            DO newInstance = doClass.newInstance();
            BeanUtils.copyProperties(dtoEntity, newInstance);
            // Dto转换Do
            return newInstance;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * do 转换为Dto 工具类
     *
     * @param doEntity
     * @param dtoClass
     * @return
     */
    public static <DTO> DTO doToDto(Object doEntity, Class<DTO> dtoClass) {
        // 判断dto是否为空!
        if (doEntity == null) {
            return null;
        }
        // 判断DoClass 是否为空
        if (dtoClass == null) {
            return null;
        }
        try {
            DTO newInstance = dtoClass.newInstance();
            BeanUtils.copyProperties(doEntity, newInstance);
            // Dto转换Do
            return newInstance;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * dto 转换为vo 工具类
     *
     * @param doEntity
     * @param dtoClass
     * @return
     */
    public static <VO> VO dtoToVO(Object doEntity, Class<VO> dtoClass) {
        // 判断dto是否为空!
        if (doEntity == null) {
            return null;
        }
        // 判断DoClass 是否为空
        if (dtoClass == null) {
            return null;
        }
        try {
            VO newInstance = dtoClass.newInstance();
            BeanUtils.copyProperties(doEntity, newInstance);
            // Dto转换Do
            return newInstance;
        } catch (Exception e) {
            return null;
        }
    }

    // 后面集合类型带封装
}