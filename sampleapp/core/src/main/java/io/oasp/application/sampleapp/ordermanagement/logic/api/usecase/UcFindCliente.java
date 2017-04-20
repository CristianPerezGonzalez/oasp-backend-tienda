package io.oasp.application.sampleapp.ordermanagement.logic.api.usecase;

import java.util.List;

import io.oasp.application.sampleapp.ordermanagement.logic.api.to.ClienteEto;
import io.oasp.application.sampleapp.ordermanagement.logic.api.to.ClienteSearchCriteriaTo;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

public interface UcFindCliente {

  /**
   * Returns a Cliente by its id 'id'.
   *
   * @param id The id 'id' of the Cliente.
   * @return The {@link ClienteEto} with id 'id'
   */
  ClienteEto findCliente(Long id);

  /**
   * Returns a paginated list of Clientes matching the search criteria.
   *
   * @param criteria the {@link ClienteSearchCriteriaTo}.
   * @return the {@link List} of matching {@link ClienteEto}s.
   */
  PaginatedListTo<ClienteEto> findClienteEtos(ClienteSearchCriteriaTo criteria);

  /**
   * @return
   */
  List<ClienteEto> findAllClientes();

}
