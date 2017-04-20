package io.oasp.application.sampleapp.ordermanagement.logic.impl.usecase;

import java.util.List;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;

import io.oasp.application.sampleapp.general.logic.api.UseCase;
import io.oasp.application.sampleapp.ordermanagement.dataaccess.api.DetalleEntity;
import io.oasp.application.sampleapp.ordermanagement.logic.api.to.DetalleEto;
import io.oasp.application.sampleapp.ordermanagement.logic.api.to.DetalleSearchCriteriaTo;
import io.oasp.application.sampleapp.ordermanagement.logic.api.usecase.UcFindDetalle;
import io.oasp.application.sampleapp.ordermanagement.logic.base.usecase.AbstractDetalleUc;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * Use case implementation for searching, filtering and getting Detalles
 */
@Named
@UseCase
@Validated
public class UcFindDetalleImpl extends AbstractDetalleUc implements UcFindDetalle {

  /**
   * Logger instance.
   */
  private static final Logger LOG = LoggerFactory.getLogger(UcFindDetalleImpl.class);

  @Override
  public DetalleEto findDetalle(Long id) {

    LOG.debug("Get Detalle with id {} from database.", id);
    return getBeanMapper().map(getDetalleDao().findOne(id), DetalleEto.class);
  }

  @Override
  public PaginatedListTo<DetalleEto> findDetalleEtos(DetalleSearchCriteriaTo criteria) {

    criteria.limitMaximumPageSize(MAXIMUM_HIT_LIMIT);
    PaginatedListTo<DetalleEntity> detalles = getDetalleDao().findDetalles(criteria);
    return mapPaginatedEntityList(detalles, DetalleEto.class);
  }

  @Override
  public List<DetalleEto> findDetalles() {

    LOG.debug("Get all restaurant tables from database.");
    List<DetalleEntity> tables = getDetalleDao().findAllDetalles();
    return getBeanMapper().mapList(tables, DetalleEto.class);
  }

  @Override
  public List<DetalleEto> findDetallesByPedido(Long id) {

    LOG.debug("Get all restaurant tables from database.");
    List<DetalleEntity> tables = getDetalleDao().findAllDetallesByPedido(id);
    return getBeanMapper().mapList(tables, DetalleEto.class);
  }

}
