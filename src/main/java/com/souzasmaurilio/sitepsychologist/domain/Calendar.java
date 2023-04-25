package com.souzasmaurilio.sitepsychologist.domain;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Calendar {

    private static final LocalTime START_TIME = LocalTime.of(8, 0);
    private static final LocalTime END_TIME = LocalTime.of(18, 0);

    private final List<LocalDateTime> availableDates;

    public Calendar() {
        availableDates = new ArrayList<>();
        LocalDateTime currentDate = LocalDateTime.now().withHour(0).withMinute(0).withSecond(0).withNano(0);
        while (currentDate.getDayOfWeek() != DayOfWeek.SATURDAY && currentDate.getDayOfWeek() != DayOfWeek.SUNDAY) {
            if (currentDate.toLocalTime().isAfter(START_TIME) && currentDate.toLocalTime().isBefore(END_TIME)) {
                availableDates.add(currentDate);
            }
            currentDate = currentDate.plus(1, ChronoUnit.DAYS);
        }
    }

    public List<LocalDateTime> getAvailableDates() {
        return availableDates;
    }
    
    public boolean isDateValid(String consultDate) {
 
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate date = LocalDate.parse(consultDate, formatter);
   
        LocalDate today = LocalDate.now();
 
        if (date.isBefore(today) || date.isAfter(today.plusYears(1))) {
            return false;
        }

        DayOfWeek dayOfWeek = date.getDayOfWeek();
        if (dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY) {
            return false;
        }
   
        return true;
    }
        
    public boolean isTimeValid(String consultTime) {
    	
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime time = LocalTime.parse(consultTime, formatter);
        return time.isAfter(LocalTime.of(7, 0)) && time.isBefore(LocalTime.of(18, 0));
    }
}

