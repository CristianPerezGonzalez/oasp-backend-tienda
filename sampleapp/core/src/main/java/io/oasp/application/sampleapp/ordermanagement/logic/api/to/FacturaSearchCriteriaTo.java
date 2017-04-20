package io.oasp.application.sampleapp.ordermanagement.logic.api.to;

import java.util.List;

import io.oasp.module.jpa.common.api.to.SearchCriteriaTo;

/**
 * This is the {@link SearchCriteriaTo search criteria} {@link net.sf.mmm.util.transferobject.api.TransferObject TO}
 * used to find {@link io.oasp.application.sampleapp.ordermanagement.common.api.Factura}s.
 */
public class FacturaSearchCriteriaTo extends SearchCriteriaTo {

  private static final long serialVersionUID = 1L;

  private Long pedidoId;

  private String descripcion;

  private List<Long> detallesFacturaIds;

  /**
   * The constructor.
   */
  public FacturaSearchCriteriaTo() {

    super();
  }

  public Long getPedidoId() {

    return this.pedidoId;
  }

  public void setPedidoId(Long pedidoId) {

    this.pedidoId = pedidoId;
  }

  public String getDescripcion() {

    return this.descripcion;
  }

  public void setDescripcion(String descripcion) {

    this.descripcion = descripcion;
  }

  public List<Long> getDetallesFacturaIds() {

    return this.detallesFacturaIds;
  }

  public void setDetallesFacturaIds(List<Long> detallesFacturaIds) {

    this.detallesFacturaIds = detallesFacturaIds;
  }

}
