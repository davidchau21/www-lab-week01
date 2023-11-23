package vn.edu.iuh.fit.repositories;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import vn.edu.iuh.fit.db.ConnectDB;
import vn.edu.iuh.fit.models.Logs;

public class LogRepository {
    private EntityManager em;

    public LogRepository() {
        em = ConnectDB.getInstance().getEmf().createEntityManager();
    }

    public void insertLog(Logs log) {
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try {
            em.merge(log);
            tr.commit();
        } catch (Exception e) {
            tr.rollback();
            System.out.println(e.getMessage());
        }
    }

    public List<Logs> getLogs() {
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try {
            String sql = "select * from logs";
            List<Logs> rl = em.createNativeQuery(sql, Logs.class).getResultList();

            tr.commit();
            return rl;
        } catch (Exception e) {
            tr.rollback();
            System.out.println(e.getMessage());
        }
        return null;
    }
}
