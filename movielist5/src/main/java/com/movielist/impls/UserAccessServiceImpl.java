package com.movielist.impls;

import com.movielist.interfaces.UserAccessService;
import com.movielist.main.dto.Customer;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Component
@Service
@Repository
@Transactional
public class UserAccessServiceImpl implements UserAccessService {

    public UserAccessServiceImpl() {}

    @PersistenceContext
    private EntityManager em;

    @Override
    public Customer loginUser(String login, String pass) {
        TypedQuery<Customer> q = em.createQuery("SELECT u FROM Customer u WHERE u.login = :login AND u.pass = :pass", Customer.class);
        q.setParameter("login", login);
        q.setParameter("pass", pass);
        return q.getSingleResult();
        /*Connection con = null;
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        String name = null;
        String tempLogin = null;
        String tempPassword = null;
        if (login != null && password != null) {
            try {
                Locale.setDefault(Locale.ENGLISH);
                con = DriverManager.getConnection(SqlQueries.url, SqlQueries.user, SqlQueries.password);
                DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
                pStmt = con.prepareStatement("SELECT * FROM USER_INFO WHERE LOGIN = ? AND PASSWORD = ?");
                pStmt.setString(1, login);
                pStmt.setString(2, password);
                rs = pStmt.executeQuery();
                while (rs.next()) {
                    tempLogin = rs.getString("LOGIN");
                    tempPassword = rs.getString("PASSWORD");
                    name = rs.getString("F_NAME");
                }
            }
            catch (Exception e) { e.printStackTrace(); }
            finally {
                try { if (con != null) con.close(); }
                catch (Exception e) { e.printStackTrace(); }
                try { if (pStmt != null) pStmt.close(); }
                catch (Exception e) { e.printStackTrace(); }
                try { if (rs != null) rs.close(); }
                catch (Exception e) { e.printStackTrace(); }
            }
        }
        return new Customer(tempLogin, tempPassword, name);*/
    }

    @Override
    public Customer registerUser(String login, String pass, String name) {
        Customer user = new Customer(login, pass, name);
        em.persist(user);
        return user;

        /*Connection con = null;
        PreparedStatement pStmt = null;
        try {
            Locale.setDefault(Locale.ENGLISH);
            con = DriverManager.getConnection(SqlQueries.url, SqlQueries.user, SqlQueries.password);
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            pStmt = con.prepareStatement("INSERT INTO USER_INFO (LOGIN, PASSWORD, F_NAME) VALUES (?,?,?)");
            pStmt.setString(1,login);
            pStmt.setString(2,password);
            pStmt.setString(3,name);
            pStmt.executeUpdate();
        }
        catch (Exception e) { e.printStackTrace(); }
        finally {
            try { if (con != null) con.close(); }
            catch (Exception e) { e.printStackTrace(); }
            try { if (pStmt != null) pStmt.close(); }
            catch (Exception e) { e.printStackTrace(); }
        }
        return new Customer(login,password,name);*/
    }
}
