package io.oasp.application.sampleapp.ordermanagement.logic.impl.usecase;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;

import io.oasp.application.sampleapp.general.logic.api.UseCase;
import io.oasp.application.sampleapp.ordermanagement.dataaccess.api.EstadoEntity;
import io.oasp.application.sampleapp.ordermanagement.logic.api.to.EstadoEto;
import io.oasp.application.sampleapp.ordermanagement.logic.api.to.EstadoSearchCriteriaTo;
import io.oasp.application.sampleapp.ordermanagement.logic.api.usecase.UcFindEstado;
import io.oasp.application.sampleapp.ordermanagement.logic.base.usecase.AbstractEstadoUc;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * Use case implementation for searching, filtering and getting Estados
 */
@Named
@UseCase
@Validated
public class UcFindEstadoImpl extends AbstractEstadoUc implements UcFindEstado {

  /**
   * Logger instance.
   */
  private static final Logger LOG = LoggerFactory.getLogger(UcFindEstadoImpl.class);

  @Override
  public EstadoEto findEstado(Long id) {

    LOG.debug("Get Estado with id {} from database.", id);
    return getBeanMapper().map(getEstadoDao().findOne(id), EstadoEto.class);
  }

  @Override
  public PaginatedListTo<EstadoEto> findEstadoEtos(EstadoSearchCriteriaTo criteria) {

    criteria.limitMaximumPageSize(MAXIMUM_HIT_LIMIT);
    PaginatedListTo<EstadoEntity> estados = getEstadoDao().findEstados(criteria);
    return mapPaginatedEntityList(estados, EstadoEto.class);
  }

}
