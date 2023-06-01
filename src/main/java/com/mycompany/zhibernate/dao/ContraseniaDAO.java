package com.mycompany.zhibernate.dao;

import com.mycompany.zhibernate.modelo.Contrasenia;
import java.util.List;

/**
 *
 * @author Marcos Miranda
 */
public interface ContraseniaDAO {
    
    // Crear una nueva contraseña
    void crear(Contrasenia contrasenia);

    // Leer una Contrasenia por ID
    Contrasenia obtenerPorId(int id);

    // Leer todas las Contrasenias
    List<Contrasenia> obtenerTodos();

    // Actualizar un Contrasenia
    void actualizar(Contrasenia contrasenia);

    // Eliminar un Contrasenia
    void eliminar(Contrasenia contrasenia);

    
    // Buscar Contrasenia por entidad (ignorando mayúsculas y minúsculas)
    List<Contrasenia> findByNombreEntidadContainingIgnoreCase(String nombreEntidad);

    // Buscar Contrasenia por clave y ordenar por fecha de forma descendente
    List<Contrasenia> findByNombreClaveOrderByFechaDesc(String clave);
    
}
