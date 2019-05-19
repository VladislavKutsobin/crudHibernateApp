package app.repository.hibernateImpls;

import app.model.Account;
import app.model.AccountStatus;
import app.repository.AccountRepository;
import org.hibernate.Session;
import app.util.utilConnection;

import java.util.List;

public class AccountRepositoryHibernateImpl implements AccountRepository {
    public void create(Account account) {
        Session session = utilConnection.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(account);
        session.getTransaction().commit();
        session.close();
    }

    public List<Account> findAll() {
        Session session = utilConnection.getSessionFactory().openSession();
        String hql = "from accounts";
        List<Account> accnts = session.createQuery(hql, Account.class).getResultList();
        return accnts;
    }

    public void update(Account account) {
        int id = account.getId();
        String name = account.getAccountName();
        AccountStatus accstatus = account.getAccountStatus();
        Session session = utilConnection.getSessionFactory().openSession();
        session.beginTransaction();

        Account newAccount = session.get(Account.class, id);
        newAccount.setAccountName(name);
        newAccount.setAccountStatus(accstatus);
        session.update(newAccount);
        session.getTransaction().commit();
        session.close();
    }

    public void delete(Integer integer) {
        Session session = utilConnection.getSessionFactory().openSession();
        session.beginTransaction();
        Account account = session.get(Account.class, integer);
        session.delete(account);
        session.getTransaction().commit();
    }

    public Account getById(Integer integer) {
        Session session = utilConnection.getSessionFactory().openSession();
        Account account = session.get(Account.class, integer);
        session.close();
        return account;
    }
}
