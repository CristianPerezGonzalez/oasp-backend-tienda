package io.oasp.application.sampleapp.ordermanagement.logic.api.usecase;

import io.oasp.application.sampleapp.ordermanagement.logic.api.to.DetalleFacturaEto;

/**
 * Interface of UcManageDetalleFactura to centralize documentation and signatures of methods.
 */
public interface UcManageDetalleFactura {

  /**
   * Deletes a detalleFactura from the database by its id 'detalleFacturaId'.
   *
   * @param detalleFacturaId Id of the detalleFactura to delete
   * @return boolean <code>true</code> if the detalleFactura can be deleted, <code>false</code> otherwise
   */
  boolean deleteDetalleFactura(Long detalleFacturaId);

  /**
   * Saves a detalleFactura and store it in the database.
   *
   * @param detalleFactura the {@link DetalleFacturaEto} to create.
   * @return the new {@link DetalleFacturaEto} that has been saved with ID and version.
   */
  DetalleFacturaEto saveDetalleFactura(DetalleFacturaEto detalleFactura);

}
