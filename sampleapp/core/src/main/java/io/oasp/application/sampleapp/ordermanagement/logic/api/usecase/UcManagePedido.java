package io.oasp.application.sampleapp.ordermanagement.logic.api.usecase;

import io.oasp.application.sampleapp.ordermanagement.logic.api.to.PedidoEto;

/**
 * Interface of UcManagePedido to centralize documentation and signatures of methods.
 */
public interface UcManagePedido {

  /**
   * Deletes a pedido from the database by its id 'pedidoId'.
   *
   * @param pedidoId Id of the pedido to delete
   * @return boolean <code>true</code> if the pedido can be deleted, <code>false</code> otherwise
   */
  boolean deletePedido(Long pedidoId);

  /**
   * Saves a pedido and store it in the database.
   *
   * @param pedido the {@link PedidoEto} to create.
   * @return the new {@link PedidoEto} that has been saved with ID and version.
   */
  PedidoEto savePedido(PedidoEto pedido);

}
