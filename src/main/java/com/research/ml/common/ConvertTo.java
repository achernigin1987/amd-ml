package com.research.ml.common;

import org.springframework.lang.Nullable;

import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class ConvertTo {

    @Nullable
    public static <T> Stream<T> stream(@Nullable T[] array) {
        return (array == null) ? null : Arrays.stream(array);
    }

    public static <T> Stream<T> stream(@Nullable Iterator<T> iterator) {
        Iterable<T> iterable = () -> iterator;
        return StreamSupport.stream(iterable.spliterator(), false);
    }
}
