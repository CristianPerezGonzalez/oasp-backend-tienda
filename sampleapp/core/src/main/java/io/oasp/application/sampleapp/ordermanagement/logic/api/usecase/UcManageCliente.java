package io.oasp.application.sampleapp.ordermanagement.logic.api.usecase;

import io.oasp.application.sampleapp.ordermanagement.logic.api.to.ClienteEto;

/**
 * Interface of UcManageCliente to centralize documentation and signatures of methods.
 */
public interface UcManageCliente {

  /**
   * Deletes a cliente from the database by its id 'clienteId'.
   *
   * @param clienteId Id of the cliente to delete
   * @return boolean <code>true</code> if the cliente can be deleted, <code>false</code> otherwise
   */
  boolean deleteCliente(Long clienteId);

  /**
   * Saves a cliente and store it in the database.
   *
   * @param cliente the {@link ClienteEto} to create.
   * @return the new {@link ClienteEto} that has been saved with ID and version.
   */
  ClienteEto saveCliente(ClienteEto cliente);

}
