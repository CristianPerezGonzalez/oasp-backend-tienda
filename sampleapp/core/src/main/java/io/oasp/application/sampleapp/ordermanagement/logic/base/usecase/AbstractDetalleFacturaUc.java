package io.oasp.application.sampleapp.ordermanagement.logic.base.usecase;

import javax.inject.Inject;

import io.oasp.application.sampleapp.general.logic.base.AbstractUc;
import io.oasp.application.sampleapp.ordermanagement.dataaccess.api.dao.DetalleFacturaDao;

/**
 * Abstract use case for DetalleFacturas, which provides access to the commonly necessary data access objects.
 */
public class AbstractDetalleFacturaUc extends AbstractUc {

  /** @see #getDetalleFacturaDao() */
  private DetalleFacturaDao detalleFacturaDao;

  /**
   * Returns the field 'detalleFacturaDao'.
   * 
   * @return the {@link DetalleFacturaDao} instance.
   */
  public DetalleFacturaDao getDetalleFacturaDao() {

    return this.detalleFacturaDao;
  }

  /**
   * Sets the field 'detalleFacturaDao'.
   * 
   * @param detalleFacturaDao New value for detalleFacturaDao
   */
  @Inject
  public void setDetalleFacturaDao(DetalleFacturaDao detalleFacturaDao) {

    this.detalleFacturaDao = detalleFacturaDao;
  }

}
