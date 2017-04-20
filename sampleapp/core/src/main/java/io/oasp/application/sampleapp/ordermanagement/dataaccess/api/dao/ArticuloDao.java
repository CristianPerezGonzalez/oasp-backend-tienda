package io.oasp.application.sampleapp.ordermanagement.dataaccess.api.dao;

import java.util.List;

import io.oasp.application.sampleapp.general.dataaccess.api.dao.ApplicationDao;
import io.oasp.application.sampleapp.ordermanagement.dataaccess.api.ArticuloEntity;
import io.oasp.application.sampleapp.ordermanagement.logic.api.to.ArticuloSearchCriteriaTo;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * Data access interface for Articulo entities
 */
public interface ArticuloDao extends ApplicationDao<ArticuloEntity> {

  /**
   * Finds the {@link ArticuloEntity articulos} matching the given {@link ArticuloSearchCriteriaTo}.
   *
   * @param criteria is the {@link ArticuloSearchCriteriaTo}.
   * @return the {@link PaginatedListTo} with the matching {@link ArticuloEntity} objects.
   */
  PaginatedListTo<ArticuloEntity> findArticulos(ArticuloSearchCriteriaTo criteria);

  /**
   * @return
   */
  List<ArticuloEntity> findAllArticulos();

}
