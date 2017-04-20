package io.oasp.application.sampleapp.ordermanagement.logic.api.to;

import java.util.List;

import io.oasp.application.sampleapp.ordermanagement.dataaccess.api.DetalleEntity;
import io.oasp.module.jpa.common.api.to.SearchCriteriaTo;

/**
 * This is the {@link SearchCriteriaTo search criteria} {@link net.sf.mmm.util.transferobject.api.TransferObject TO}
 * used to find {@link io.oasp.application.sampleapp.ordermanagement.common.api.Pedido}s.
 */
public class PedidoSearchCriteriaTo extends SearchCriteriaTo {

  private static final long serialVersionUID = 1L;

  private Long clienteId;

  private Long detalleId;

  private String descripcion;

  private Long facturaId;

  private Long estadoId;

  private List<DetalleEntity> detalleIds;

  /**
   * The constructor.
   */
  public PedidoSearchCriteriaTo() {

    super();
  }

  public Long getClienteId() {

    return this.clienteId;
  }

  public void setClienteId(Long clienteId) {

    this.clienteId = clienteId;
  }

  public Long getDetalleId() {

    return this.detalleId;
  }

  public void setDetalleId(Long detalleId) {

    this.detalleId = detalleId;
  }

  public String getDescripcion() {

    return this.descripcion;
  }

  public void setDescripcion(String descripcion) {

    this.descripcion = descripcion;
  }

  public Long getFacturaId() {

    return this.facturaId;
  }

  public void setFacturaId(Long facturaId) {

    this.facturaId = facturaId;
  }

  public Long getEstadoId() {

    return this.estadoId;
  }

  public void setEstadoId(Long estadoId) {

    this.estadoId = estadoId;
  }

  public List<DetalleEntity> getDetalleIds() {

    return this.detalleIds;
  }

  public void setDetalleIds(List<DetalleEntity> detalleIds) {

    this.detalleIds = detalleIds;
  }

}
