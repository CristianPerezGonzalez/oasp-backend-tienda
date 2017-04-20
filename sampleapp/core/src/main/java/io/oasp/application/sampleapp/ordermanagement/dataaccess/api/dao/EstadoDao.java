package io.oasp.application.sampleapp.ordermanagement.dataaccess.api.dao;

import io.oasp.application.sampleapp.general.dataaccess.api.dao.ApplicationDao;
import io.oasp.application.sampleapp.ordermanagement.dataaccess.api.EstadoEntity;
import io.oasp.application.sampleapp.ordermanagement.logic.api.to.EstadoSearchCriteriaTo;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * Data access interface for Estado entities
 */
public interface EstadoDao extends ApplicationDao<EstadoEntity> {

  /**
   * Finds the {@link EstadoEntity estados} matching the given {@link EstadoSearchCriteriaTo}.
   *
   * @param criteria is the {@link EstadoSearchCriteriaTo}.
   * @return the {@link PaginatedListTo} with the matching {@link EstadoEntity} objects.
   */
  PaginatedListTo<EstadoEntity> findEstados(EstadoSearchCriteriaTo criteria);

}
