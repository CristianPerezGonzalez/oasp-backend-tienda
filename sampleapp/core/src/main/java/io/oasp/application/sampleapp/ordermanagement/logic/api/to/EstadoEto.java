package io.oasp.application.sampleapp.ordermanagement.logic.api.to;

import io.oasp.application.sampleapp.general.common.api.to.AbstractEto;
import io.oasp.application.sampleapp.ordermanagement.common.api.Estado;

/**
 * Entity transport object of Estado
 */
public class EstadoEto extends AbstractEto implements Estado {

  private static final long serialVersionUID = 1L;

  private String codestado;

  private String descripcion;

  /**
   * {@inheritDoc}
   */
  @Override
  public String getCodestado() {

    return codestado;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setCodestado(String codestado) {

    this.codestado = codestado;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String getDescripcion() {

    return descripcion;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setDescripcion(String descripcion) {

    this.descripcion = descripcion;
  }

  @Override
  public int hashCode() {

    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((this.codestado == null) ? 0 : this.codestado.hashCode());
    result = prime * result + ((this.descripcion == null) ? 0 : this.descripcion.hashCode());
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
    EstadoEto other = (EstadoEto) obj;
    if (this.codestado == null) {
      if (other.codestado != null) {
        return false;
      }
    } else if (!this.codestado.equals(other.codestado)) {
      return false;
    }
    if (this.descripcion == null) {
      if (other.descripcion != null) {
        return false;
      }
    } else if (!this.descripcion.equals(other.descripcion)) {
      return false;
    }
    return true;
  }

}
