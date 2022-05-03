package Services;

import Dao.KotikDao;
import Entities.Kotik;

import java.util.ArrayList;

public class ServiceOwner {
    private KotikDao ownersDao;

    public ServiceOwner(KotikDao ownersDao){
        this.ownersDao = ownersDao;
    }
    public Kotik findById(Integer id) {
        Kotik kotik = ownersDao.get(id);
        return kotik;
    }

    public ArrayList<Kotik> findAll() {
        return ownersDao.getAll();
    }

    public void save(Kotik kotik) {
        ownersDao.save(kotik);
    }

    public void update(Kotik kotik) {
        ownersDao.update(kotik);
    }

    public void delete(Kotik kotik) {
        ownersDao.delete(kotik);
    }
}
