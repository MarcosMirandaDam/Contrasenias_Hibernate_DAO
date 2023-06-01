package com.mycompany.zhibernate.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Marcos Miranda
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "contrasenias")
public class Contrasenia implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "entidad")
    private String entidad;
    @Column(name = "usuario")
    private String usuario;
    @Column(name = "clave")
    private String clave;
    @Column(name = "fecha")
    private Date fecha;

    @Override
    public String toString() {
        return "Contrasenias{" + "id=" + id + ", entidad=" + entidad + ", usuario=" + usuario + ", clave=" + clave + ", fecha=" + fecha + '}';
    }
    
    
    
    
}
