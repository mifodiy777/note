package ru.innopolis.note.DAO.impl;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.innopolis.note.DAO.RecordDAO;
import ru.innopolis.note.entity.Record;

import java.util.List;

/**
 * Created by Кирилл on 22.11.2016.
 */
@Repository
public class RecordDAOImpl implements RecordDAO {

    @Autowired
    private SessionFactory sessionFactory;

/*    @Autowired
    private IgniteConfiguration igniteCfg;*/

    @Override
    public Record findOne(Integer id) {
        return null;
    }

    @Override
    @Transactional
    public List<Record> findByUser(String username) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Record.class);
        List<Record> records = (List<Record>) criteria.list();
        return records;
    }

    @Override
    public Record save(Record record) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
