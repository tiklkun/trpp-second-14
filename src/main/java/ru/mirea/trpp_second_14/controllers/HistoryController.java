package ru.mirea.trpp_second_14.controllers;

import com.opencsv.bean.CsvToBeanBuilder;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import ru.mirea.trpp_second_14.entity.History;

import java.io.InputStreamReader;
import java.util.List;
import java.util.Optional;

/** Контроллер для работы с историей. */
@Controller("/history")
public class HistoryController {

    /** Список записей. */
    private final List<History> historyList;

    /** Конструктор. */
    public HistoryController() {
        historyList = new CsvToBeanBuilder<History>(new InputStreamReader(this.getClass().getResourceAsStream("/MOCK_DATA.csv"))).withType(History.class).build().parse();
    }

    /**
     * Получить список действий.
     * @return список действий
     */
    @Get()
    public HttpResponse<List<History>> getEmployee() {
        return HttpResponse.ok(historyList);
    }

    /**
     * Найти действие по идентификатору.
     * @param id идентификатор действия
     * @return Действие, если есть, иначе 404 ошибка
     */
    @Get("/{id}")
    public HttpResponse<History> findById(Long id) {
        Optional<History> result = historyList.stream().filter(it -> it.getId().equals(id)).findAny();
        if (result.isPresent()) {
            return HttpResponse.ok(result.get());
        } else {
            return HttpResponse.notFound();
        }
    }
}
