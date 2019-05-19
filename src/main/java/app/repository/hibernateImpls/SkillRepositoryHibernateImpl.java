package app.repository.hibernateImpls;

import app.model.Skill;
import app.repository.SkillRepository;
import app.util.utilConnection;
import org.hibernate.Session;

import java.util.List;

public class SkillRepositoryHibernateImpl implements SkillRepository {
    public void create(Skill skill) {
        Session session = utilConnection.getSessionFactory().openSession();
        session.beginTransaction();

        session.save(skill);
        session.getTransaction().commit();
        session.close();
    }

    public List<Skill> findAll() {
        Session session = utilConnection.getSessionFactory().openSession();

        String hql = "from skills";
        List<Skill> skills = session.createQuery(hql, Skill.class).getResultList();
        session.close();
        return skills;
    }

    public void update(Skill skill) {
        int id = skill.getId();
        String skillName = skill.getName();
        Session session = utilConnection.getSessionFactory().openSession();

        session.beginTransaction();
        Skill newSkill = session.get(Skill.class, id);
        newSkill.setName(skillName);
        session.update(newSkill);
        session.getTransaction().commit();
        session.close();

    }


    public void delete(Integer integer) {
        Session session = utilConnection.getSessionFactory().openSession();
        session.beginTransaction();

        Skill skill = session.get(Skill.class, integer);
        session.delete(skill);
        session.getTransaction().commit();
        session.close();
    }

    public Skill getById(Integer integer) {
        Session session = utilConnection.getSessionFactory().openSession();
        Skill skill = session.get(Skill.class, integer);
        session.close();
        return skill;
    }
}
