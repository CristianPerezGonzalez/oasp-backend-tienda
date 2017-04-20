package io.oasp.application.sampleapp.ordermanagement.logic.base.usecase;

import javax.inject.Inject;

import io.oasp.application.sampleapp.general.logic.base.AbstractUc;
import io.oasp.application.sampleapp.ordermanagement.dataaccess.api.dao.EstadoDao;

/**
 * Abstract use case for Estados, which provides access to the commonly necessary data access objects.
 */
public class AbstractEstadoUc extends AbstractUc {

  /** @see #getEstadoDao() */
  private EstadoDao estadoDao;

  /**
   * Returns the field 'estadoDao'.
   * 
   * @return the {@link EstadoDao} instance.
   */
  public EstadoDao getEstadoDao() {

    return this.estadoDao;
  }

  /**
   * Sets the field 'estadoDao'.
   * 
   * @param estadoDao New value for estadoDao
   */
  @Inject
  public void setEstadoDao(EstadoDao estadoDao) {

    this.estadoDao = estadoDao;
  }

}
