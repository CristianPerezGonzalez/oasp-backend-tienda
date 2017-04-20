package io.oasp.application.sampleapp.ordermanagement.logic.api.to;

import io.oasp.application.sampleapp.general.common.api.to.AbstractCto;

/**
 * Composite transport object of Estado
 */
public class EstadoCto extends AbstractCto {

  private static final long serialVersionUID = 1L;

  private EstadoEto estado;

  public EstadoEto getEstado() {

    return estado;
  }

  public void setEstado(EstadoEto estado) {

    this.estado = estado;
  }

}
