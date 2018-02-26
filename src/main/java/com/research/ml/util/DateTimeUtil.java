package com.research.ml.util;

import java.time.Instant;

public class DateTimeUtil {

    public static Long nowUtcTs() {
        return Instant.now().toEpochMilli();
    }
}
