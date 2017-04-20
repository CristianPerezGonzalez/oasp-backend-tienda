package io.oasp.application.sampleapp.ordermanagement.logic.api.usecase;

import java.util.List;

import io.oasp.application.sampleapp.ordermanagement.logic.api.to.ArticuloEto;
import io.oasp.application.sampleapp.ordermanagement.logic.api.to.ArticuloSearchCriteriaTo;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

public interface UcFindArticulo {

  /**
   * Returns a Articulo by its id 'id'.
   *
   * @param id The id 'id' of the Articulo.
   * @return The {@link ArticuloEto} with id 'id'
   */
  ArticuloEto findArticulo(Long id);

  /**
   * Returns a paginated list of Articulos matching the search criteria.
   *
   * @param criteria the {@link ArticuloSearchCriteriaTo}.
   * @return the {@link List} of matching {@link ArticuloEto}s.
   */
  PaginatedListTo<ArticuloEto> findArticuloEtos(ArticuloSearchCriteriaTo criteria);

  /**
   * @return
   */
  List<ArticuloEto> findAllArticulos();

}
