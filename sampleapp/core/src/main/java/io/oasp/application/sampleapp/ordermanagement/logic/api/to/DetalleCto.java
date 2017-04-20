package io.oasp.application.sampleapp.ordermanagement.logic.api.to;

import io.oasp.application.sampleapp.general.common.api.to.AbstractCto;

/**
 * Composite transport object of Detalle
 */
public class DetalleCto extends AbstractCto {

  private static final long serialVersionUID = 1L;

  private DetalleEto detalle;

  private PedidoEto pedido;

  private ArticuloEto articulo;

  private EstadoEto estado;

  public DetalleEto getDetalle() {

    return detalle;
  }

  public void setDetalle(DetalleEto detalle) {

    this.detalle = detalle;
  }

  public PedidoEto getPedido() {

    return pedido;
  }

  public void setPedido(PedidoEto pedido) {

    this.pedido = pedido;
  }

  public ArticuloEto getArticulo() {

    return articulo;
  }

  public void setArticulo(ArticuloEto articulo) {

    this.articulo = articulo;
  }

  public EstadoEto getEstado() {

    return estado;
  }

  public void setEstado(EstadoEto estado) {

    this.estado = estado;
  }

}
