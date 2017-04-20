package io.oasp.application.sampleapp.ordermanagement.logic.api.to;

import java.util.List;

import io.oasp.application.sampleapp.general.common.api.to.AbstractEto;
import io.oasp.application.sampleapp.ordermanagement.common.api.Pedido;
import io.oasp.application.sampleapp.ordermanagement.dataaccess.api.DetalleEntity;
import io.oasp.application.sampleapp.ordermanagement.dataaccess.api.EstadoEntity;

/**
 * Entity transport object of Pedido
 */
public class PedidoEto extends AbstractEto implements Pedido {

  private static final long serialVersionUID = 1L;

  private Long clienteId;

  private Long detalleId;

  private String descripcion;

  private EstadoEntity estadoId;

  private List<DetalleEntity> detalleIds;

  /**
   * {@inheritDoc}
   */
  @Override
  public Long getClienteId() {

    return this.clienteId;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setClienteId(Long clienteId) {

    this.clienteId = clienteId;
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
    result = prime * result + ((this.clienteId == null) ? 0 : this.clienteId.hashCode());
    result = prime * result + ((this.detalleId == null) ? 0 : this.detalleId.hashCode());
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
    PedidoEto other = (PedidoEto) obj;
    if (this.clienteId == null) {
      if (other.clienteId != null) {
        return false;
      }
    } else if (!this.clienteId.equals(other.clienteId)) {
      return false;
    }
    if (this.detalleId == null) {
      if (other.detalleId != null) {
        return false;
      }
    } else if (!this.detalleId.equals(other.detalleId)) {
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

  /**
   * {@inheritDoc}
   */
  @Override
  public List<DetalleEntity> getDetalleIds() {

    return this.detalleIds;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setDetalleIds(List<DetalleEntity> detalleIds) {

    this.detalleIds = detalleIds;
  }

}
