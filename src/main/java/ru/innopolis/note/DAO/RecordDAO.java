package ru.innopolis.note.DAO;

import ru.innopolis.note.entity.Record;

import java.util.List;

/**
 * Created by Кирилл on 21.11.2016.
 */

public interface RecordDAO {

    Record findOne(Integer id);

    List<Record> findByUser(String username);

    Record save(Record record);

    void delete(Integer id);
}
