package org.swing.contrasenias_hibernate_dao;

import com.mycompany.zhibernate.dao.ContraseniaDAOImplementacion;
import com.mycompany.zhibernate.modelo.Contrasenia;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Marcos Miranda
 */
public class MainContrasenias {

    public static void main(String[] args) {
        // Configurar Hibernate
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        
        //creamos lista de contraseás
        List<Contrasenia>contrasenias=new ArrayList<>();
        //creamos la contraseña
        Contrasenia contrasenia1=new Contrasenia(1,"AEAT","13158801H","BKZXSW",new Date());
        ContraseniaDAOImplementacion contraseniaDAOImplementacion = new ContraseniaDAOImplementacion(sessionFactory);
        contraseniaDAOImplementacion.crear(contrasenia1);
        contrasenias.add(contrasenia1);
        
        
        
        
        
        
        sessionFactory.close();
    }
    
}
