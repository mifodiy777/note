package ru.innopolis.note.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.innopolis.note.DAO.RecordDAO;
import ru.innopolis.note.entity.Record;
import ru.innopolis.note.service.RecordService;

import java.util.List;

/**
 * Created by Кирилл on 21.11.2016.
 */
@Service
public class RecordServiceImpl implements RecordService {

    @Autowired
    private RecordDAO recordDAO;

    @Override
    public Record getRecord(Integer id) {
        return recordDAO.findOne(id);
    }

    @Override
    public List<Record> getRecords(String username) {
        return recordDAO.findByUser(username);
    }

    @Override
    public Record saveRecord(Record record) {
        return recordDAO.save(record);
    }

    @Override
    public void deleteRecord(Integer id) {
        recordDAO.delete(id);
    }
}
