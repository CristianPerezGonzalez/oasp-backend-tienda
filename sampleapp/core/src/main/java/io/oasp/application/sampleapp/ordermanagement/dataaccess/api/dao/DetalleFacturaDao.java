package io.oasp.application.sampleapp.ordermanagement.dataaccess.api.dao;

import java.util.List;

import io.oasp.application.sampleapp.general.dataaccess.api.dao.ApplicationDao;
import io.oasp.application.sampleapp.ordermanagement.dataaccess.api.DetalleFacturaEntity;
import io.oasp.application.sampleapp.ordermanagement.logic.api.to.DetalleFacturaSearchCriteriaTo;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * Data access interface for DetalleFactura entities
 */
public interface DetalleFacturaDao extends ApplicationDao<DetalleFacturaEntity> {

  /**
   * Finds the {@link DetalleFacturaEntity detallefacturas} matching the given {@link DetalleFacturaSearchCriteriaTo}.
   *
   * @param criteria is the {@link DetalleFacturaSearchCriteriaTo}.
   * @return the {@link PaginatedListTo} with the matching {@link DetalleFacturaEntity} objects.
   */
  PaginatedListTo<DetalleFacturaEntity> findDetalleFacturas(DetalleFacturaSearchCriteriaTo criteria);

  /**
   * @return
   */
  List<DetalleFacturaEntity> findAllDetallesFactura();

}
