package io.oasp.application.sampleapp.ordermanagement.logic.api.usecase;

import java.util.List;

import io.oasp.application.sampleapp.ordermanagement.logic.api.to.PedidoEto;
import io.oasp.application.sampleapp.ordermanagement.logic.api.to.PedidoSearchCriteriaTo;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

public interface UcFindPedido {

  /**
   * Returns a Pedido by its id 'id'.
   *
   * @param id The id 'id' of the Pedido.
   * @return The {@link PedidoEto} with id 'id'
   */
  PedidoEto findPedido(Long id);

  /**
   * Returns a paginated list of Pedidos matching the search criteria.
   *
   * @param criteria the {@link PedidoSearchCriteriaTo}.
   * @return the {@link List} of matching {@link PedidoEto}s.
   */
  PaginatedListTo<PedidoEto> findPedidoEtos(PedidoSearchCriteriaTo criteria);

  /**
   * @return
   */
  List<PedidoEto> findAllPedidos();

}
