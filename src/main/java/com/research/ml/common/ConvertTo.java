package com.research.ml.common;

import org.springframework.lang.Nullable;

import java.util.Arrays;
import java.util.stream.Stream;

public class ConvertTo {

    @Nullable
    public static <T> Stream<T> stream(@Nullable T[] array) {
        return (array == null) ? null : Arrays.stream(array);
    }
}
