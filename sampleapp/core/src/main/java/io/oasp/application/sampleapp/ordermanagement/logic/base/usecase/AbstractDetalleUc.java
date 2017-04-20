package io.oasp.application.sampleapp.ordermanagement.logic.base.usecase;

import javax.inject.Inject;

import io.oasp.application.sampleapp.general.logic.base.AbstractUc;
import io.oasp.application.sampleapp.ordermanagement.dataaccess.api.dao.DetalleDao;

/**
 * Abstract use case for Detalles, which provides access to the commonly necessary data access objects.
 */
public class AbstractDetalleUc extends AbstractUc {

  /** @see #getDetalleDao() */
  private DetalleDao detalleDao;

  /**
   * Returns the field 'detalleDao'.
   * 
   * @return the {@link DetalleDao} instance.
   */
  public DetalleDao getDetalleDao() {

    return this.detalleDao;
  }

  /**
   * Sets the field 'detalleDao'.
   * 
   * @param detalleDao New value for detalleDao
   */
  @Inject
  public void setDetalleDao(DetalleDao detalleDao) {

    this.detalleDao = detalleDao;
  }

}
