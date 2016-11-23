package ru.innopolis.note.service;

import ru.innopolis.note.entity.Record;

import java.util.List;

/**
 * Created by Кирилл on 21.11.2016.
 */
public interface RecordService {

    Record getRecord(Integer id);

    List<Record> getRecords(String username);

    Record saveRecord(Record record);

    void deleteRecord(Integer id);


}
