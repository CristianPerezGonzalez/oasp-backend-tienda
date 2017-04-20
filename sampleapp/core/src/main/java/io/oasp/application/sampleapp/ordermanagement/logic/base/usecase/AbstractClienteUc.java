package io.oasp.application.sampleapp.ordermanagement.logic.base.usecase;

import javax.inject.Inject;

import io.oasp.application.sampleapp.general.logic.base.AbstractUc;
import io.oasp.application.sampleapp.ordermanagement.dataaccess.api.dao.ClienteDao;

/**
 * Abstract use case for Clientes, which provides access to the commonly necessary data access objects.
 */
public class AbstractClienteUc extends AbstractUc {

  /** @see #getClienteDao() */
  private ClienteDao clienteDao;

  /**
   * Returns the field 'clienteDao'.
   * 
   * @return the {@link ClienteDao} instance.
   */
  public ClienteDao getClienteDao() {

    return this.clienteDao;
  }

  /**
   * Sets the field 'clienteDao'.
   * 
   * @param clienteDao New value for clienteDao
   */
  @Inject
  public void setClienteDao(ClienteDao clienteDao) {

    this.clienteDao = clienteDao;
  }

}
