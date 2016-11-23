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

    @Override
    @Transactional
    public Record findOne(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        return (Record) session.get(Record.class, id);
    }

    @Override
    @Transactional
    public List<Record> findByUser(String username) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Record.class);
        criteria.setCacheable(true);
        List<Record> records = (List<Record>) criteria.list();
        return records;
    }

    @Override
    @Transactional
    public Record save(Record record) {
        Session session = sessionFactory.getCurrentSession();
        return (Record) session.merge(record);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(session.get(Record.class, id));
    }
}
