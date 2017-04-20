package io.oasp.application.sampleapp.ordermanagement.logic.api.to;

import io.oasp.application.sampleapp.general.common.api.to.AbstractEto;
import io.oasp.application.sampleapp.ordermanagement.common.api.Articulo;

/**
 * Entity transport object of Articulo
 */
public class ArticuloEto extends AbstractEto implements Articulo {

  private static final long serialVersionUID = 1L;

  private Long codarticulo;

  private Long detalleId;

  private String nombre;

  private Integer precio;

  @Override
  public int hashCode() {

    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((this.codarticulo == null) ? 0 : this.codarticulo.hashCode());
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
    ArticuloEto other = (ArticuloEto) obj;
    if (this.codarticulo == null) {
      if (other.codarticulo != null) {
        return false;
      }
    } else if (!this.codarticulo.equals(other.codarticulo)) {
      return false;
    }
    return true;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String getNombre() {

    return nombre;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setNombre(String nombre) {

    this.nombre = nombre;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Integer getPrecio() {

    return precio;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setPrecio(Integer precio) {

    this.precio = precio;
  }

}
