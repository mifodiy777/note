package ru.innopolis.note.controller;

import com.google.gson.GsonBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.innopolis.note.Utils;
import ru.innopolis.note.entity.Record;
import ru.innopolis.note.service.RecordService;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Кирилл on 21.11.2016.
 */

@Controller
public class RecordController {

    private static Logger logger = LoggerFactory.getLogger(RecordController.class);

    @Autowired
    private RecordService recordService;

    @RequestMapping(value = "allRecords", method = RequestMethod.POST)
    public ResponseEntity<String> allRecords(HttpSession session) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        return Utils.convertListToJson(gsonBuilder, recordService.getRecords((String) session.getAttribute("username")));

    }

    @RequestMapping(value = "recordForm", method = RequestMethod.GET)
    public String recordForm(HttpSession session, ModelMap map) {
        Record record = new Record();
        record.setUser((String) session.getAttribute("username"));
        map.addAttribute("record", record);
        return "record";
    }

    @RequestMapping(value = "recordForm/{id}", method = RequestMethod.GET)
    public String recordUpdateForm(@PathVariable("id") Integer id, ModelMap map) {
        map.addAttribute("record", recordService.getRecord(id));
        return "record";
    }

    @RequestMapping(value = "/saveRecord", method = RequestMethod.POST)
    public String saveRecord(Record record, ModelMap map, HttpServletResponse response) {
        try {
            recordService.saveRecord(record);
            map.addAttribute("message", "Запись сохранена!");
            return "success";
        } catch (DataIntegrityViolationException e) {
            response.setStatus(409);
            map.addAttribute("message", "Ошибка сохранения записи");
            logger.error("Ошибка сохранения записи", e);
            return "error";
        }
    }


    /**
     * Метод удаляет типы тренировок
     *
     * @param id       Тип тренировок
     * @param map      ModelMap
     * @param response response
     * @return сообщение
     */
    @RequestMapping(value = "deleteRecord/{id}", method = RequestMethod.POST)
    public String deleteTrainingType(@PathVariable("id") Integer id, ModelMap map, HttpServletResponse response) {
        try {
            recordService.deleteRecord(id);
            map.put("message", "Запись удалена!");
            return "success";
        } catch (DataIntegrityViolationException e) {
            map.put("message", "Невозможно удалить");
            logger.error("Ошибка удаления записи", e);
            response.setStatus(409);
            return "error";
        }

    }
}
