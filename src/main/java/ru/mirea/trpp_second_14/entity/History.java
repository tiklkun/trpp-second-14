package ru.mirea.trpp_second_14.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.opencsv.bean.CsvBindByName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/** Сущность истории действий. */
@Getter
@Setter
@ToString
public class History {

    /** Идентификатор. */
    @JsonProperty("id")
    @CsvBindByName(column = "id")
    private Long id;
    /** Пользователь. */
    @JsonProperty("user")
    @CsvBindByName(column = "user")
    private String user;
    /** Ссылка, куда переходил пользователь. */
    @JsonProperty("actionLink")
    @CsvBindByName(column = "action_link")
    private String actionLink;
    /** Дата создания записи. */
    @JsonProperty("created")
    @CsvBindByName(column = "created")
    private String created;

}
