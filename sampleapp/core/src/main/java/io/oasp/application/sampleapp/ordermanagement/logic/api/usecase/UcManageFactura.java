package io.oasp.application.sampleapp.ordermanagement.logic.api.usecase;

import io.oasp.application.sampleapp.ordermanagement.logic.api.to.FacturaEto;

/**
 * Interface of UcManageFactura to centralize documentation and signatures of methods.
 */
public interface UcManageFactura {

  /**
   * Deletes a factura from the database by its id 'facturaId'.
   *
   * @param facturaId Id of the factura to delete
   * @return boolean <code>true</code> if the factura can be deleted, <code>false</code> otherwise
   */
  boolean deleteFactura(Long facturaId);

  /**
   * Saves a factura and store it in the database.
   *
   * @param factura the {@link FacturaEto} to create.
   * @return the new {@link FacturaEto} that has been saved with ID and version.
   */
  FacturaEto saveFactura(FacturaEto factura);

}
