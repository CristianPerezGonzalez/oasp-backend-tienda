package io.oasp.application.sampleapp.ordermanagement.logic.impl.usecase;

import java.util.List;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;

import io.oasp.application.sampleapp.general.logic.api.UseCase;
import io.oasp.application.sampleapp.ordermanagement.dataaccess.api.ArticuloEntity;
import io.oasp.application.sampleapp.ordermanagement.logic.api.to.ArticuloEto;
import io.oasp.application.sampleapp.ordermanagement.logic.api.to.ArticuloSearchCriteriaTo;
import io.oasp.application.sampleapp.ordermanagement.logic.api.usecase.UcFindArticulo;
import io.oasp.application.sampleapp.ordermanagement.logic.base.usecase.AbstractArticuloUc;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * Use case implementation for searching, filtering and getting Articulos
 */
@Named
@UseCase
@Validated
public class UcFindArticuloImpl extends AbstractArticuloUc implements UcFindArticulo {

  /**
   * Logger instance.
   */
  private static final Logger LOG = LoggerFactory.getLogger(UcFindArticuloImpl.class);

  @Override
  public ArticuloEto findArticulo(Long id) {

    LOG.debug("Get Articulo with id {} from database.", id);
    return getBeanMapper().map(getArticuloDao().findOne(id), ArticuloEto.class);
  }

  @Override
  public PaginatedListTo<ArticuloEto> findArticuloEtos(ArticuloSearchCriteriaTo criteria) {

    criteria.limitMaximumPageSize(MAXIMUM_HIT_LIMIT);
    PaginatedListTo<ArticuloEntity> articulos = getArticuloDao().findArticulos(criteria);
    return mapPaginatedEntityList(articulos, ArticuloEto.class);
  }

  @Override
  public List<ArticuloEto> findAllArticulos() {

    LOG.debug("Get all restaurant tables from database.");
    List<ArticuloEntity> tables = getArticuloDao().findAllArticulos();
    return getBeanMapper().mapList(tables, ArticuloEto.class);
  }

}
