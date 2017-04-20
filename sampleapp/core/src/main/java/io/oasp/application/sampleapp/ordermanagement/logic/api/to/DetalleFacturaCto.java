package io.oasp.application.sampleapp.ordermanagement.logic.api.to;

import io.oasp.application.sampleapp.general.common.api.to.AbstractCto;

/**
 * Composite transport object of DetalleFactura
 */
public class DetalleFacturaCto extends AbstractCto {

  private static final long serialVersionUID = 1L;

  private DetalleFacturaEto detalleFactura;

  private FacturaEto factura;

  private ArticuloEto articulo;

  public DetalleFacturaEto getDetalleFactura() {

    return detalleFactura;
  }

  public void setDetalleFactura(DetalleFacturaEto detalleFactura) {

    this.detalleFactura = detalleFactura;
  }

  public FacturaEto getFactura() {

    return factura;
  }

  public void setFactura(FacturaEto factura) {

    this.factura = factura;
  }

  public ArticuloEto getArticulo() {

    return articulo;
  }

  public void setArticulo(ArticuloEto articulo) {

    this.articulo = articulo;
  }

}
