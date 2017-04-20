package io.oasp.application.sampleapp.ordermanagement.logic.api.to;

import io.oasp.module.jpa.common.api.to.SearchCriteriaTo;

/**
 * This is the {@link SearchCriteriaTo search criteria} {@link net.sf.mmm.util.transferobject.api.TransferObject TO}
 * used to find {@link io.oasp.application.sampleapp.ordermanagement.common.api.Articulo}s.
 */
public class ArticuloSearchCriteriaTo extends SearchCriteriaTo {

  private static final long serialVersionUID = 1L;

  private Long codarticulo;

  private Long detalleId;

  private String nombre;

  private Integer precio;

  /**
   * The constructor.
   */
  public ArticuloSearchCriteriaTo() {

    super();
  }

  public Long getCodarticulo() {

    return codarticulo;
  }

  public void setCodarticulo(Long codarticulo) {

    this.codarticulo = codarticulo;
  }

  public Long getDetalleId() {

    return detalleId;
  }

  public void setDetalleId(Long detalleId) {

    this.detalleId = detalleId;
  }

  public String getNombre() {

    return nombre;
  }

  public void setNombre(String nombre) {

    this.nombre = nombre;
  }

  public Integer getPrecio() {

    return precio;
  }

  public void setPrecio(Integer precio) {

    this.precio = precio;
  }

}
