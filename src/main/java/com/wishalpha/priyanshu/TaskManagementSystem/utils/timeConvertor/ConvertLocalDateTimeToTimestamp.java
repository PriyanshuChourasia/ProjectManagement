package com.wishalpha.priyanshu.TaskManagementSystem.utils.timeConvertor;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class ConvertLocalDateTimeToTimestamp {
    private final LocalDateTime userlocalDateTime;
    public ConvertLocalDateTimeToTimestamp(LocalDateTime localDateTime){
        userlocalDateTime = localDateTime;
    }

    public Long convertToTimestamp(){
        ZoneId zoneId =ZoneId.of("Asia/Kolkata");
        return userlocalDateTime.atZone(zoneId).toInstant().toEpochMilli();
    }
}
