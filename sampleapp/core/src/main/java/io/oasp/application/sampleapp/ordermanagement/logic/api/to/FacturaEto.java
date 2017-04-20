package io.oasp.application.sampleapp.ordermanagement.logic.api.to;

import java.util.List;

import io.oasp.application.sampleapp.general.common.api.to.AbstractEto;
import io.oasp.application.sampleapp.ordermanagement.common.api.DetalleFactura;
import io.oasp.application.sampleapp.ordermanagement.common.api.Factura;
import io.oasp.application.sampleapp.ordermanagement.dataaccess.api.DetalleFacturaEntity;

/**
 * Entity transport object of Factura
 */
public class FacturaEto extends AbstractEto implements Factura {

  private static final long serialVersionUID = 1L;

  private Long pedidoId;

  private String descripcion;

  private List<DetalleFactura> detallesFactura;

  private List<DetalleFacturaEntity> detallesFacturaIds;

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
  public String getDescripcion() {

    return this.descripcion;
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
    result = prime * result + ((this.pedidoId == null) ? 0 : this.pedidoId.hashCode());
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
    FacturaEto other = (FacturaEto) obj;
    if (this.pedidoId == null) {
      if (other.pedidoId != null) {
        return false;
      }
    } else if (!this.pedidoId.equals(other.pedidoId)) {
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

  /**
   * {@inheritDoc}
   */
  @Override
  public List<DetalleFacturaEntity> getDetallesFacturaIds() {

    return this.detallesFacturaIds;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setDetallesFacturaIds(List<DetalleFacturaEntity> detallesFacturaIds) {

    this.detallesFacturaIds = detallesFacturaIds;
  }

}
