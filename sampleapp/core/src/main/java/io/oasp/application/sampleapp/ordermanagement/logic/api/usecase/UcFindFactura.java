package io.oasp.application.sampleapp.ordermanagement.logic.api.usecase;

import java.util.List;

import io.oasp.application.sampleapp.ordermanagement.logic.api.to.FacturaEto;
import io.oasp.application.sampleapp.ordermanagement.logic.api.to.FacturaSearchCriteriaTo;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

public interface UcFindFactura {

  /**
   * Returns a Factura by its id 'id'.
   *
   * @param id The id 'id' of the Factura.
   * @return The {@link FacturaEto} with id 'id'
   */
  FacturaEto findFactura(Long id);

  /**
   * Returns a paginated list of Facturas matching the search criteria.
   *
   * @param criteria the {@link FacturaSearchCriteriaTo}.
   * @return the {@link List} of matching {@link FacturaEto}s.
   */
  PaginatedListTo<FacturaEto> findFacturaEtos(FacturaSearchCriteriaTo criteria);

  /**
   * @return
   */
  List<FacturaEto> findAllFacturas();

}
