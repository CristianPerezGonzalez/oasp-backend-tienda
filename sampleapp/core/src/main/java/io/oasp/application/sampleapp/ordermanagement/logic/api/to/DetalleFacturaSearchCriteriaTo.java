package io.oasp.application.sampleapp.ordermanagement.logic.api.to;

import io.oasp.module.jpa.common.api.to.SearchCriteriaTo;

/**
 * This is the {@link SearchCriteriaTo search criteria} {@link net.sf.mmm.util.transferobject.api.TransferObject TO}
 * used to find {@link io.oasp.application.sampleapp.ordermanagement.common.api.DetalleFactura}s.
 */
public class DetalleFacturaSearchCriteriaTo extends SearchCriteriaTo {

  private static final long serialVersionUID = 1L;

  private Long facturaId;

  private Long articuloId;

  private int uds;

  private int precio;

  /**
   * The constructor.
   */
  public DetalleFacturaSearchCriteriaTo() {

    super();
  }

  public Long getFacturaId() {

    return facturaId;
  }

  public void setFacturaId(Long facturaId) {

    this.facturaId = facturaId;
  }

  public Long getArticuloId() {

    return articuloId;
  }

  public void setArticuloId(Long articuloId) {

    this.articuloId = articuloId;
  }

  public int getUds() {

    return uds;
  }

  public void setUds(int uds) {

    this.uds = uds;
  }

  public int getPrecio() {

    return precio;
  }

  public void setPrecio(int precio) {

    this.precio = precio;
  }

}
