package io.oasp.application.sampleapp.ordermanagement.logic.api.usecase;

import java.util.List;

import io.oasp.application.sampleapp.ordermanagement.logic.api.to.DetalleFacturaEto;
import io.oasp.application.sampleapp.ordermanagement.logic.api.to.DetalleFacturaSearchCriteriaTo;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

public interface UcFindDetalleFactura {

  /**
   * Returns a DetalleFactura by its id 'id'.
   *
   * @param id The id 'id' of the DetalleFactura.
   * @return The {@link DetalleFacturaEto} with id 'id'
   */
  DetalleFacturaEto findDetalleFactura(Long id);

  /**
   * Returns a paginated list of DetalleFacturas matching the search criteria.
   *
   * @param criteria the {@link DetalleFacturaSearchCriteriaTo}.
   * @return the {@link List} of matching {@link DetalleFacturaEto}s.
   */
  PaginatedListTo<DetalleFacturaEto> findDetalleFacturaEtos(DetalleFacturaSearchCriteriaTo criteria);

  /**
   * @return
   */
  List<DetalleFacturaEto> findAllDetallesFactura();

}
