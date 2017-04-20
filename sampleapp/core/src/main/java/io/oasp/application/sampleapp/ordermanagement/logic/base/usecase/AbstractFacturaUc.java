package io.oasp.application.sampleapp.ordermanagement.logic.base.usecase;

import javax.inject.Inject;

import io.oasp.application.sampleapp.general.logic.base.AbstractUc;
import io.oasp.application.sampleapp.ordermanagement.dataaccess.api.dao.FacturaDao;

/**
 * Abstract use case for Facturas, which provides access to the commonly necessary data access objects.
 */
public class AbstractFacturaUc extends AbstractUc {

  /** @see #getFacturaDao() */
  private FacturaDao facturaDao;

  /**
   * Returns the field 'facturaDao'.
   * 
   * @return the {@link FacturaDao} instance.
   */
  public FacturaDao getFacturaDao() {

    return this.facturaDao;
  }

  /**
   * Sets the field 'facturaDao'.
   * 
   * @param facturaDao New value for facturaDao
   */
  @Inject
  public void setFacturaDao(FacturaDao facturaDao) {

    this.facturaDao = facturaDao;
  }

}
