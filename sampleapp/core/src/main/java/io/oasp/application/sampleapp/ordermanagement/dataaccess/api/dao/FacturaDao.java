package io.oasp.application.sampleapp.ordermanagement.dataaccess.api.dao;

import java.util.List;

import io.oasp.application.sampleapp.general.dataaccess.api.dao.ApplicationDao;
import io.oasp.application.sampleapp.ordermanagement.dataaccess.api.FacturaEntity;
import io.oasp.application.sampleapp.ordermanagement.logic.api.to.FacturaSearchCriteriaTo;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * Data access interface for Factura entities
 */
public interface FacturaDao extends ApplicationDao<FacturaEntity> {

  /**
   * Finds the {@link FacturaEntity facturas} matching the given {@link FacturaSearchCriteriaTo}.
   *
   * @param criteria is the {@link FacturaSearchCriteriaTo}.
   * @return the {@link PaginatedListTo} with the matching {@link FacturaEntity} objects.
   */
  PaginatedListTo<FacturaEntity> findFacturas(FacturaSearchCriteriaTo criteria);

  /**
   * @return
   */
  List<FacturaEntity> findAllFacturas();

  @Override
  public FacturaEntity save(FacturaEntity entity);

}
