package io.oasp.application.sampleapp.ordermanagement.logic.api.to;

import io.oasp.module.jpa.common.api.to.SearchCriteriaTo;

/**
 * This is the {@link SearchCriteriaTo search criteria} {@link net.sf.mmm.util.transferobject.api.TransferObject TO}
 * used to find {@link io.oasp.application.sampleapp.ordermanagement.common.api.Detalle}s.
 */
public class DetalleSearchCriteriaTo extends SearchCriteriaTo {

  private static final long serialVersionUID = 1L;

  private Long pedidoId;

  private Long articuloId;

  private int uds;

  private int precio;

  private Long estadoId;

  /**
   * The constructor.
   */
  public DetalleSearchCriteriaTo() {

    super();
  }

  public Long getPedidoId() {

    return this.pedidoId;
  }

  public void setPedidoId(Long pedidoId) {

    this.pedidoId = pedidoId;
  }

  public Long getArticuloId() {

    return this.articuloId;
  }

  public void setArticuloId(Long articuloId) {

    this.articuloId = articuloId;
  }

  public int getUds() {

    return this.uds;
  }

  public void setUds(int uds) {

    this.uds = uds;
  }

  public int getPrecio() {

    return this.precio;
  }

  public void setPrecio(int precio) {

    this.precio = precio;
  }

  public Long getEstadoId() {

    return this.estadoId;
  }

  public void setEstadoId(Long estadoId) {

    this.estadoId = estadoId;
  }

}
