package io.oasp.application.sampleapp.ordermanagement.logic.api.to;

import io.oasp.application.sampleapp.general.common.api.to.AbstractCto;

/**
 * Composite transport object of Cliente
 */
public class ClienteCto extends AbstractCto {

  private static final long serialVersionUID = 1L;

  private ClienteEto cliente;

  public ClienteEto getCliente() {

    return cliente;
  }

  public void setCliente(ClienteEto cliente) {

    this.cliente = cliente;
  }

}
