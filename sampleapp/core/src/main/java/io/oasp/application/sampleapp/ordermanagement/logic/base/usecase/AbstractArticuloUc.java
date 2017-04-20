package io.oasp.application.sampleapp.ordermanagement.logic.base.usecase;

import javax.inject.Inject;

import io.oasp.application.sampleapp.general.logic.base.AbstractUc;
import io.oasp.application.sampleapp.ordermanagement.dataaccess.api.dao.ArticuloDao;

/**
 * Abstract use case for Articulos, which provides access to the commonly necessary data access objects.
 */
public class AbstractArticuloUc extends AbstractUc {

  /** @see #getArticuloDao() */
  private ArticuloDao articuloDao;

  /**
   * Returns the field 'articuloDao'.
   * 
   * @return the {@link ArticuloDao} instance.
   */
  public ArticuloDao getArticuloDao() {

    return this.articuloDao;
  }

  /**
   * Sets the field 'articuloDao'.
   * 
   * @param articuloDao New value for articuloDao
   */
  @Inject
  public void setArticuloDao(ArticuloDao articuloDao) {

    this.articuloDao = articuloDao;
  }

}
