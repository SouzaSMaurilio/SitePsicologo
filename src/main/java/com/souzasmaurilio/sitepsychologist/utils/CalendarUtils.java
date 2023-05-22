package com.souzasmaurilio.sitepsychologist.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate today = LocalDate.now();
        LocalDate todayPlus90 = today.plusDays(90);

        for (LocalDate date = today; date.isBefore(todayPlus90); date = date.plusDays(1)) {
            try {
                if (repo.findByDate(date, PageRequest.of(0, 1)).hasContent()) {
                    System.out.println("Data já existe: " + date);
                } else {
                    NewCalendar calendar = new NewCalendar(null, date);
                    repo.save(calendar);
                    System.out.println("Data salva: " + date);
                }
            } catch (Exception e) {
                System.out.println("Erro ao salvar a data: " + date);
                e.printStackTrace();
            }
        }
    }
}

