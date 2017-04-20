package io.oasp.application.sampleapp.ordermanagement.logic.api.to;

import io.oasp.application.sampleapp.general.common.api.to.AbstractEto;
import io.oasp.application.sampleapp.ordermanagement.common.api.Cliente;

/**
 * Entity transport object of Cliente
 */
public class ClienteEto extends AbstractEto implements Cliente {

  private static final long serialVersionUID = 1L;

  private Long id;

  private String dni;

  private String nombre;

  private Long codcliente;

  /**
   * {@inheritDoc}
   */
  @Override
  public Long getId() {

    return this.id;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setId(Long id) {

    this.id = id;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String getDni() {

    return this.dni;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setDni(String dni) {

    this.dni = dni;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String getNombre() {

    return this.nombre;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setNombre(String nombre) {

    this.nombre = nombre;
  }

  @Override
  public int hashCode() {

    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
    result = prime * result + ((this.dni == null) ? 0 : this.dni.hashCode());
    result = prime * result + ((this.nombre == null) ? 0 : this.nombre.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {

    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    // class check will be done by super type EntityTo!
    if (!super.equals(obj)) {
      return false;
    }
    ClienteEto other = (ClienteEto) obj;
    if (this.id == null) {
      if (other.id != null) {
        return false;
      }
    } else if (!this.id.equals(other.id)) {
      return false;
    }
    if (this.dni == null) {
      if (other.dni != null) {
        return false;
      }
    } else if (!this.dni.equals(other.dni)) {
      return false;
    }
    if (this.nombre == null) {
      if (other.nombre != null) {
        return false;
      }
    } else if (!this.nombre.equals(other.nombre)) {
      return false;
    }
    return true;
  }

}
