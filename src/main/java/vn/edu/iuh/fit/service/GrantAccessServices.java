package vn.edu.iuh.fit.service;

import vn.edu.iuh.fit.models.GrantAccess;
import vn.edu.iuh.fit.repositories.GrantAccesRepository;

import java.util.List;

public class GrantAccessServices {
    private static GrantAccesRepository grantAccessDao = new GrantAccesRepository();

    public static void insertGrantAccess(GrantAccess grantAccess) {
        grantAccessDao.insertGrantAccess(grantAccess);
    }

    public static GrantAccess searchGrantAccessByAccountId(String id) {
        return grantAccessDao.searchGrantAccessByAccountId(id);
    }

    public static List<GrantAccess> getListGrantAccess() {
        return grantAccessDao.getListGrantAccess();
    }
}
