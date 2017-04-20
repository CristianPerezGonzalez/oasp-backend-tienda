package io.oasp.application.sampleapp.ordermanagement.logic.base.usecase;

import javax.inject.Inject;

import io.oasp.application.sampleapp.general.logic.base.AbstractUc;
import io.oasp.application.sampleapp.ordermanagement.dataaccess.api.dao.PedidoDao;

/**
 * Abstract use case for Pedidos, which provides access to the commonly necessary data access objects.
 */
public class AbstractPedidoUc extends AbstractUc {

  /** @see #getPedidoDao() */
  private PedidoDao pedidoDao;

  /**
   * Returns the field 'pedidoDao'.
   * 
   * @return the {@link PedidoDao} instance.
   */
  public PedidoDao getPedidoDao() {

    return this.pedidoDao;
  }

  /**
   * Sets the field 'pedidoDao'.
   * 
   * @param pedidoDao New value for pedidoDao
   */
  @Inject
  public void setPedidoDao(PedidoDao pedidoDao) {

    this.pedidoDao = pedidoDao;
  }

}
