package app.repository.hibernateImpls;

import app.model.Developer;
import app.repository.DeveloperRepository;
import org.hibernate.Session;
import app.util.utilConnection;

import java.util.List;

public class DeveloperRepositoryHibernateImpl implements DeveloperRepository {
    public void create(Developer developer) {
        Session session = utilConnection.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(developer);
        session.getTransaction().commit();
        session.close();
    }

    public List<Developer> findAll() {
        Session session = utilConnection.getSessionFactory().openSession();
        String hql = "from developers";
        List<Developer> devs = session.createQuery(hql, Developer.class).getResultList();
        session.close();
        return devs;
    }

    public void update(Developer developer) {
        Session session = utilConnection.getSessionFactory().openSession();
        int id = developer.getId();
        String fName = developer.getFirstName();
        String lName = developer.getLastName();
        String newSpecialty = developer.getSpecialty();

        session.beginTransaction();
        Developer newDev = session.get(Developer.class, id);
        newDev.setFirstName(fName);
        newDev.setLastName(lName);
        newDev.setSpecialty(newSpecialty);

        session.update(newDev);
        session.getTransaction().commit();
        session.close();
    }

    public void delete(Integer integer) {
        Session session = utilConnection.getSessionFactory().openSession();
        session.beginTransaction();

        Developer dev = session.get(Developer.class, integer);
        session.delete(dev);
        session.getTransaction().commit();
        session.close();
    }

    public Developer getById(Integer integer) {
        Session session = utilConnection.getSessionFactory().openSession();
        Developer developer = session.get(Developer.class, integer);
        session.close();
        return developer;
    }
}
