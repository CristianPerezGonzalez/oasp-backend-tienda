package io.oasp.application.sampleapp.ordermanagement.logic.api.usecase;

import io.oasp.application.sampleapp.ordermanagement.logic.api.to.EstadoEto;

/**
 * Interface of UcManageEstado to centralize documentation and signatures of methods.
 */
public interface UcManageEstado {

  /**
   * Deletes a estado from the database by its id 'estadoId'.
   *
   * @param estadoId Id of the estado to delete
   * @return boolean <code>true</code> if the estado can be deleted, <code>false</code> otherwise
   */
  boolean deleteEstado(Long estadoId);

  /**
   * Saves a estado and store it in the database.
   *
   * @param estado the {@link EstadoEto} to create.
   * @return the new {@link EstadoEto} that has been saved with ID and version.
   */
  EstadoEto saveEstado(EstadoEto estado);

}
