package io.oasp.application.sampleapp.ordermanagement.logic.api.to;

import java.util.List;

import io.oasp.application.sampleapp.general.common.api.to.AbstractCto;

/**
 * Composite transport object of Factura
 */
public class FacturaCto extends AbstractCto {

  private static final long serialVersionUID = 1L;

  private FacturaEto factura;

  private PedidoEto pedido;

  private List<DetalleFacturaEto> detallesFactura;

  public FacturaEto getFactura() {

    return factura;
  }

  public void setFactura(FacturaEto factura) {

    this.factura = factura;
  }

  public PedidoEto getPedido() {

    return pedido;
  }

  public void setPedido(PedidoEto pedido) {

    this.pedido = pedido;
  }

  public List<DetalleFacturaEto> getDetallesFactura() {

    return detallesFactura;
  }

  public void setDetallesFactura(List<DetalleFacturaEto> detallesFactura) {

    this.detallesFactura = detallesFactura;
  }

}
