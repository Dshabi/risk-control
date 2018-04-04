package com.zhenghao.risk.control.common.util;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ModelHelper {

    private static final ModelMapper modelMapper = new ModelMapper();

    static {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    public static <F, T> T map(F from, Class<T> to) {
        return modelMapper.map(from, to);
    }

    public static <F, T> T map(F from, Type T) {
        return modelMapper.map(from, T);
    }

    public static <F, T> List<T> listMap(List<F> fromList, Class<T> to) {
        Type type = new TypeToken<List<T>>() {
        }.getType();

        return modelMapper.map(fromList, type);
    }

    public static <F, T> T listMap(List<F> fromList, TypeToken<T> typeTokenOfList) {
        return modelMapper.map(fromList, typeTokenOfList.getType());
    }

    public static <T, U> void setIfFieldEquals(T source, U target) {
        if (source == null) {
            throw new IllegalArgumentException("source cannot be null");
        }
        if (target == null) {
            throw new IllegalArgumentException("target cannot be null");
        }

        try {
            Field[] sourceFields = source.getClass().getDeclaredFields();
            Map<String, Field> sourceNameToField = Arrays.stream(sourceFields).collect(Collectors.toMap(Field::getName, x -> x));

            Field[] targetFields = target.getClass().getDeclaredFields();
            for (Field f : targetFields) {
                if (Modifier.isStatic(f.getModifiers()) || Modifier.isFinal(f.getModifiers())) {
                    continue;
                }

                f.setAccessible(true);
                if (sourceNameToField.containsKey(f.getName())
                        && f.getType().equals(sourceNameToField.get(f.getName()).getType())) {
                    Field baseField = sourceNameToField.get(f.getName());
                    baseField.setAccessible(true);
                    baseField.set(source, f.get(target));
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
