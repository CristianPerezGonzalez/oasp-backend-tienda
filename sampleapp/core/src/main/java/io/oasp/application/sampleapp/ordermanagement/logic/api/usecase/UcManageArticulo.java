package io.oasp.application.sampleapp.ordermanagement.logic.api.usecase;

import io.oasp.application.sampleapp.ordermanagement.logic.api.to.ArticuloEto;

/**
 * Interface of UcManageArticulo to centralize documentation and signatures of methods.
 */
public interface UcManageArticulo {

  /**
   * Deletes a articulo from the database by its id 'articuloId'.
   *
   * @param articuloId Id of the articulo to delete
   * @return boolean <code>true</code> if the articulo can be deleted, <code>false</code> otherwise
   */
  boolean deleteArticulo(Long articuloId);

  /**
   * Saves a articulo and store it in the database.
   *
   * @param articulo the {@link ArticuloEto} to create.
   * @return the new {@link ArticuloEto} that has been saved with ID and version.
   */
  ArticuloEto saveArticulo(ArticuloEto articulo);

}
