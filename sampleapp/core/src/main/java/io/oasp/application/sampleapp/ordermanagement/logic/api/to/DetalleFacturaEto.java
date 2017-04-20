package io.oasp.application.sampleapp.ordermanagement.logic.api.to;

import io.oasp.application.sampleapp.general.common.api.to.AbstractEto;
import io.oasp.application.sampleapp.ordermanagement.common.api.DetalleFactura;

/**
 * Entity transport object of DetalleFactura
 */
public class DetalleFacturaEto extends AbstractEto implements DetalleFactura {

  private static final long serialVersionUID = 1L;

  private Long facturaId;

  private Long articuloId;

  private int uds;

  private int precio;

  /**
   * {@inheritDoc}
   */
  @Override
  public Long getFacturaId() {

    return facturaId;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setFacturaId(Long facturaId) {

    this.facturaId = facturaId;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Long getArticuloId() {

    return articuloId;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setArticuloId(Long articuloId) {

    this.articuloId = articuloId;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int getUds() {

    return uds;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setUds(int uds) {

    this.uds = uds;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int getPrecio() {

    return precio;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setPrecio(int precio) {

    this.precio = precio;
  }

  @Override
  public int hashCode() {

    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((this.facturaId == null) ? 0 : this.facturaId.hashCode());
    result = prime * result + ((this.articuloId == null) ? 0 : this.articuloId.hashCode());
    result = prime * result + ((Integer) uds).hashCode();
    result = prime * result + ((Integer) precio).hashCode();
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
    DetalleFacturaEto other = (DetalleFacturaEto) obj;
    if (this.facturaId == null) {
      if (other.facturaId != null) {
        return false;
      }
    } else if (!this.facturaId.equals(other.facturaId)) {
      return false;
    }
    if (this.articuloId == null) {
      if (other.articuloId != null) {
        return false;
      }
    } else if (!this.articuloId.equals(other.articuloId)) {
      return false;
    }
    if (this.uds != other.uds) {
      return false;
    }
    if (this.precio != other.precio) {
      return false;
    }
    return true;
  }

}
