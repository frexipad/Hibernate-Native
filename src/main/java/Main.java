import config.HibernateUtil;
import domain.*;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        Patient p1 = new Patient(null,"yousra",null);
        Patient p2 = new Patient(null,"sahila",null);

        Doctor d1 = new Doctor(null,"Swinnen", Speciality.General,null);
        Doctor d2 = new Doctor(null,"Vanhearen", Speciality.General,null);

        Appointment a1 = new Appointment(d1,p1);

        Consultation c1=new Consultation(null,"Report ....",a1);
        Consultation c2=new Consultation(null,"Report ....",a1);
        Consultation c3=new Consultation(null,"Report ....",null);
        Consultation c4=new Consultation(null,"Report ....",null);

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student objects
            session.save(p1);
            session.save(p2);
            session.save(d1);
            //before savint a1 , d1 and p1 shoud be present into data base
            session.save(a1);
            session.save(c1);
            session.save(c2);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }


    }
}
