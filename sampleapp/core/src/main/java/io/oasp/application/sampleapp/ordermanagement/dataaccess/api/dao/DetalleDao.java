package io.oasp.application.sampleapp.ordermanagement.dataaccess.api.dao;

import java.util.List;

import io.oasp.application.sampleapp.general.dataaccess.api.dao.ApplicationDao;
import io.oasp.application.sampleapp.ordermanagement.dataaccess.api.DetalleEntity;
import io.oasp.application.sampleapp.ordermanagement.logic.api.to.DetalleSearchCriteriaTo;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * Data access interface for Detalle entities
 */
public interface DetalleDao extends ApplicationDao<DetalleEntity> {

  /**
   * Finds the {@link DetalleEntity detalles} matching the given {@link DetalleSearchCriteriaTo}.
   *
   * @param criteria is the {@link DetalleSearchCriteriaTo}.
   * @return the {@link PaginatedListTo} with the matching {@link DetalleEntity} objects.
   */
  PaginatedListTo<DetalleEntity> findDetalles(DetalleSearchCriteriaTo criteria);

  /**
   * @return
   */
  List<DetalleEntity> findAllDetalles();

  /**
   * @param id
   * @return
   */
  List<DetalleEntity> findAllDetallesByPedido(Long id);

}
