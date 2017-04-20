package io.oasp.application.sampleapp.ordermanagement.logic.api.usecase;

import java.util.List;

import io.oasp.application.sampleapp.ordermanagement.logic.api.to.EstadoEto;
import io.oasp.application.sampleapp.ordermanagement.logic.api.to.EstadoSearchCriteriaTo;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

public interface UcFindEstado {

  /**
   * Returns a Estado by its id 'id'.
   *
   * @param id The id 'id' of the Estado.
   * @return The {@link EstadoEto} with id 'id'
   */
  EstadoEto findEstado(Long id);

  /**
   * Returns a paginated list of Estados matching the search criteria.
   *
   * @param criteria the {@link EstadoSearchCriteriaTo}.
   * @return the {@link List} of matching {@link EstadoEto}s.
   */
  PaginatedListTo<EstadoEto> findEstadoEtos(EstadoSearchCriteriaTo criteria);

}
