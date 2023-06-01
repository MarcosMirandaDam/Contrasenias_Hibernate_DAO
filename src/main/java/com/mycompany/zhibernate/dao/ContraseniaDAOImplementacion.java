package com.mycompany.zhibernate.dao;

import com.mycompany.zhibernate.modelo.Contrasenia;
import com.mycompany.zhibernate.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author Marcos Mirand
 */
public class ContraseniaDAOImplementacion implements ContraseniaDAO{
    
    private SessionFactory sessionFactory;
    
    public ContraseniaDAOImplementacion(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void crear(Contrasenia contrasenia) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(contrasenia);
            transaction.commit();
            
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println("Error al crear la contrasenia: " + e.getMessage());
          
        }
    }

    @Override
    public Contrasenia obtenerPorId(int id) {
        Session session = sessionFactory.openSession();
        Contrasenia contrasenia = session.get(Contrasenia.class, id);
        session.close();
        return contrasenia;
    }

    @Override
    public List<Contrasenia> obtenerTodos() {
        Session session = sessionFactory.openSession();
        List<Contrasenia> contrasenias = session.createQuery("from contrasenias", Contrasenia.class).list();
        session.close();
        return contrasenias;
    }

    @Override
    public void actualizar(Contrasenia contrasenia) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(contrasenia);
        transaction.commit();
        session.close();
    }

    @Override
    public void eliminar(Contrasenia contrasenia) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(contrasenia);
        transaction.commit();
        session.close(); 
    }

    @Override
    public List<Contrasenia> findByNombreEntidadContainingIgnoreCase(String nombreEntidad) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Contrasenia> query = session.createQuery("FROM contrasenias WHERE lower(entidad) LIKE :entidad", Contrasenia.class);
            query.setParameter("Entidad", "%" + nombreEntidad.toLowerCase() + "%");
            return query.list();

            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Contrasenia> findByNombreClaveOrderByFechaDesc(String clave) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Contrasenia> query = session.createQuery("FROM contrasenias WHERE clave = :clave ORDER BY fecha DESC", Contrasenia.class);
            query.setParameter("Clave", clave);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    
    }
    
}
