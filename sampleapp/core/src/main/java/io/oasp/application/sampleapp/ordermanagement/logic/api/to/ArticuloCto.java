package io.oasp.application.sampleapp.ordermanagement.logic.api.to;

import io.oasp.application.sampleapp.general.common.api.to.AbstractCto;

/**
 * Composite transport object of Articulo
 */
public class ArticuloCto extends AbstractCto {

  private static final long serialVersionUID = 1L;

  private ArticuloEto articulo;

  private DetalleEto detalle;

  public ArticuloEto getArticulo() {

    return articulo;
  }

  public void setArticulo(ArticuloEto articulo) {

    this.articulo = articulo;
  }

  public DetalleEto getDetalle() {

    return detalle;
  }

  public void setDetalle(DetalleEto detalle) {

    this.detalle = detalle;
  }

}
