package com.research.ml.common;

import java.time.Instant;

public class DateTimeUtil {

    public static Long nowUtcTs() {
        return Instant.now().toEpochMilli();
    }
}
