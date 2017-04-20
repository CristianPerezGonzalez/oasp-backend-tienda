package io.oasp.application.sampleapp.ordermanagement.dataaccess.api;

import javax.persistence.Entity;
import javax.persistence.Table;

import io.oasp.application.sampleapp.ordermanagement.common.api.Cliente;
import io.oasp.module.jpa.dataaccess.api.AbstractPersistenceEntity;

/**
 * @author crperezg
 */
@SuppressWarnings("deprecation")
@Entity
@Table(name = "TCliente")
public class ClienteEntity extends AbstractPersistenceEntity implements Cliente {

  /**
   */
  private static final long serialVersionUID = 1L;

  private String dni;

  private String nombre;

  /**
   * @return dni
   */
  @Override
  public String getDni() {

    return this.dni;
  }

  /**
   * @param dni new value of {@link #getdni}.
   */
  @SuppressWarnings("javadoc")
  @Override
  public void setDni(String dni) {

    this.dni = dni;
  }

  /**
   * @return nombre
   */
  @Override
  public String getNombre() {

    return this.nombre;
  }

  /**
   * @param nombre new value of {@link #getnombre}.
   */
  @SuppressWarnings("javadoc")
  @Override
  public void setNombre(String nombre) {

    this.nombre = nombre;
  }

}
