package io.oasp.application.sampleapp.ordermanagement.logic.api.to;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.oasp.application.sampleapp.general.common.api.to.AbstractEto;
import io.oasp.application.sampleapp.ordermanagement.common.api.Detalle;
import io.oasp.application.sampleapp.ordermanagement.dataaccess.api.EstadoEntity;

/**
 * Entity transport object of Detalle
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DetalleEto extends AbstractEto implements Detalle {

  private static final long serialVersionUID = 1L;

  private Long pedidoId;

  private Long articuloId;

  private int uds;

  private int precio;

  private EstadoEntity estadoId;

  /**
   * {@inheritDoc}
   */
  @Override
  public Long getPedidoId() {

    return this.pedidoId;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setPedidoId(Long pedidoId) {

    this.pedidoId = pedidoId;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Long getArticuloId() {

    return this.articuloId;
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

    return this.uds;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setUds(int uds) {

    this.uds = uds;
  }

  @Override
  public int hashCode() {

    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((this.pedidoId == null) ? 0 : this.pedidoId.hashCode());
    result = prime * result + ((this.articuloId == null) ? 0 : this.articuloId.hashCode());
    result = prime * result + ((Integer) this.uds).hashCode();
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
    DetalleEto other = (DetalleEto) obj;
    if (this.pedidoId == null) {
      if (other.pedidoId != null) {
        return false;
      }
    } else if (!this.pedidoId.equals(other.pedidoId)) {
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
    return true;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int getPrecio() {

    return this.precio;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setPrecio(int precio) {

    this.precio = precio;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public EstadoEntity getEstadoId() {

    return this.estadoId;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setEstadoId(EstadoEntity estadoId) {

    this.estadoId = estadoId;
  }

}
