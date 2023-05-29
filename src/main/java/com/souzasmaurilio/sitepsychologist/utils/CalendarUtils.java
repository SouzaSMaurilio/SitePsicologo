package com.souzasmaurilio.sitepsychologist.utils;

import java.text.ParseException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.aggregation.DateOperators.DayOfMonth;
import org.springframework.stereotype.Component;

import com.souzasmaurilio.sitepsychologist.domain.NewCalendar;
import com.souzasmaurilio.sitepsychologist.repository.NewCalendarRepository;

@Component
public class CalendarUtils {

    private static NewCalendarRepository repo;

    @Autowired
    public CalendarUtils(NewCalendarRepository repo) {
        this.repo = repo;
    }

    public static void generateNext90days() {

        LocalDate today = LocalDate.now();
        LocalDate todayPlus90 = today.plusDays(90);

        for (LocalDate date = today; date.isBefore(todayPlus90); date = date.plusDays(1)) {
            try {
            	if (repo.findByDate(date, PageRequest.of(0, 1)).hasContent()) {
            	    System.out.println("Data já existe: " + date);
            	} else {
            		DayOfWeek dayOfWeek = date.getDayOfWeek();
            		if (dayOfWeek != DayOfWeek.SATURDAY && dayOfWeek != DayOfWeek.SUNDAY) {
            	    NewCalendar calendar = new NewCalendar(null, date);
            	    repo.save(calendar);
            	    System.out.println("Data salva: " + date);
            		}
            		else {
            			System.out.println("Fim de semana");
            		}
                }
            } catch (Exception e) {
                System.out.println("Erro ao salvar a data: " + date);
                e.printStackTrace();
            }
        }
    }
    
    public NewCalendar update(String calendarId, String hour) {
    	Optional<NewCalendar> calendar = repo.findById(calendarId);
    	 if (calendar != null) {
    	        calendar.get().getOfficeHours().put(hour, false);
    	        return repo.save(calendar.get());
    	    } else {
    	        return null;
    	    }
   
//    	System.out.println(calendar.getOfficeHours().get(Hour));
//		if(calendar.getOfficeHours().containsKey(Hour)) {
//			calendar.getOfficeHours().put(Hour, false);
//		}
//		System.out.println(calendar.getOfficeHours().get(Hour));
//		
//		return calendar;
    }

}



