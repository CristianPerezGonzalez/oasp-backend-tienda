package io.oasp.application.sampleapp.ordermanagement.logic.api.to;

import java.util.List;

import io.oasp.application.sampleapp.general.common.api.to.AbstractCto;

/**
 * Composite transport object of Pedido
 */
public class PedidoCto extends AbstractCto {

  private static final long serialVersionUID = 1L;

  private PedidoEto pedido;

  private ClienteEto cliente;

  private DetalleEto detalle;

  private FacturaEto factura;

  private EstadoEto estado;

  private List<DetalleEto> detalles;

  public PedidoEto getPedido() {

    return pedido;
  }

  public void setPedido(PedidoEto pedido) {

    this.pedido = pedido;
  }

  public ClienteEto getCliente() {

    return cliente;
  }

  public void setCliente(ClienteEto cliente) {

    this.cliente = cliente;
  }

  public DetalleEto getDetalle() {

    return detalle;
  }

  public void setDetalle(DetalleEto detalle) {

    this.detalle = detalle;
  }

  public FacturaEto getFactura() {

    return factura;
  }

  public void setFactura(FacturaEto factura) {

    this.factura = factura;
  }

  public EstadoEto getEstado() {

    return estado;
  }

  public void setEstado(EstadoEto estado) {

    this.estado = estado;
  }

  public List<DetalleEto> getDetalles() {

    return detalles;
  }

  public void setDetalles(List<DetalleEto> detalles) {

    this.detalles = detalles;
  }

}
