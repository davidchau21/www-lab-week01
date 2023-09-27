package vn.edu.iuh.fit.test;

import vn.edu.iuh.fit.models.Logs;
import vn.edu.iuh.fit.service.LogServices;

import java.sql.Timestamp;
import java.util.Date;

public class LogServices_test {
    public static void main(String[] args) {
        Date date = new Date();

        Logs log1 = new Logs("met", new Timestamp(date.getTime()), new Timestamp(date.getTime()), "oke");

        LogServices.insertLog(log1);
    }
}
