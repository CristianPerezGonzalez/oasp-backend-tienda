package io.oasp.application.sampleapp.ordermanagement.logic.api.usecase;

import java.util.List;

import io.oasp.application.sampleapp.ordermanagement.logic.api.to.DetalleEto;
import io.oasp.application.sampleapp.ordermanagement.logic.api.to.DetalleSearchCriteriaTo;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

public interface UcFindDetalle {

  /**
   * Returns a Detalle by its id 'id'.
   *
   * @param id The id 'id' of the Detalle.
   * @return The {@link DetalleEto} with id 'id'
   */
  DetalleEto findDetalle(Long id);

  /**
   * Returns a paginated list of Detalles matching the search criteria.
   *
   * @param criteria the {@link DetalleSearchCriteriaTo}.
   * @return the {@link List} of matching {@link DetalleEto}s.
   */
  PaginatedListTo<DetalleEto> findDetalleEtos(DetalleSearchCriteriaTo criteria);

  /**
   * @return
   */
  List<DetalleEto> findDetalles();

  /**
   * @param id
   * @return
   */
  List<DetalleEto> findDetallesByPedido(Long id);

}
