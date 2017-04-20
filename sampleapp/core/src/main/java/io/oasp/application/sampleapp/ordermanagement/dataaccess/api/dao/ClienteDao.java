package io.oasp.application.sampleapp.ordermanagement.dataaccess.api.dao;

import java.util.List;

import io.oasp.application.sampleapp.general.dataaccess.api.dao.ApplicationDao;
import io.oasp.application.sampleapp.ordermanagement.dataaccess.api.ClienteEntity;
import io.oasp.application.sampleapp.ordermanagement.logic.api.to.ClienteSearchCriteriaTo;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * Data access interface for Cliente entities
 */
public interface ClienteDao extends ApplicationDao<ClienteEntity> {

  /**
   * Finds the {@link ClienteEntity clientes} matching the given {@link ClienteSearchCriteriaTo}.
   *
   * @param criteria is the {@link ClienteSearchCriteriaTo}.
   * @return the {@link PaginatedListTo} with the matching {@link ClienteEntity} objects.
   */
  PaginatedListTo<ClienteEntity> findClientes(ClienteSearchCriteriaTo criteria);

  /**
   * @return
   */
  List<ClienteEntity> findAllClientes();

}
