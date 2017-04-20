package io.oasp.application.sampleapp.ordermanagement.logic.api.usecase;

import io.oasp.application.sampleapp.ordermanagement.logic.api.to.DetalleEto;

/**
 * Interface of UcManageDetalle to centralize documentation and signatures of methods.
 */
public interface UcManageDetalle {

  /**
   * Deletes a detalle from the database by its id 'detalleId'.
   *
   * @param detalleId Id of the detalle to delete
   * @return boolean <code>true</code> if the detalle can be deleted, <code>false</code> otherwise
   */
  boolean deleteDetalle(Long detalleId);

  /**
   * Saves a detalle and store it in the database.
   *
   * @param detalle the {@link DetalleEto} to create.
   * @return the new {@link DetalleEto} that has been saved with ID and version.
   */
  DetalleEto saveDetalle(DetalleEto detalle);

}
