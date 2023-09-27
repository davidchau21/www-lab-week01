package vn.edu.iuh.fit.service;

import vn.edu.iuh.fit.models.Logs;
import vn.edu.iuh.fit.repositories.LogRepository;

import java.util.List;

public class LogServices {
    private static LogRepository logDao = new LogRepository();

    public static void insertLog(Logs log) {
        logDao.insertLog(log);
    }

    public static List<Logs> getLogs() {
        return logDao.getLogs();
    }
}
