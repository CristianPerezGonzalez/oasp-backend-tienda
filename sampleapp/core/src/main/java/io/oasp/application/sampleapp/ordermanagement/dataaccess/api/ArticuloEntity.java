package io.oasp.application.sampleapp.ordermanagement.dataaccess.api;

import javax.persistence.Entity;
import javax.persistence.Table;

import io.oasp.application.sampleapp.ordermanagement.common.api.Articulo;
import io.oasp.module.jpa.dataaccess.api.AbstractPersistenceEntity;

/**
 * TODO crperezg This type ...
 *
 * @author crperezg
 * @since 0.0.1
 */
@SuppressWarnings("deprecation")
@Entity
@Table(name = "TArticulo")
public class ArticuloEntity extends AbstractPersistenceEntity implements Articulo {

  private static final long serialVersionUID = 1L;

  private String nombre;

  private Integer precio;

  /**
   * @return nombre
   */
  public String getNombre() {

    return nombre;
  }

  /**
   * @param nombre new value of {@link #getnombre}.
   */
  public void setNombre(String nombre) {

    this.nombre = nombre;
  }

  /**
   * @return precio
   */
  public Integer getPrecio() {

    return precio;
  }

  /**
   * @param precio new value of {@link #getprecio}.
   */
  public void setPrecio(Integer precio) {

    this.precio = precio;
  }

}
