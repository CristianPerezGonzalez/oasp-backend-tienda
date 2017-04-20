package io.oasp.application.sampleapp.ordermanagement.dataaccess.api.dao;

import java.util.List;

import io.oasp.application.sampleapp.general.dataaccess.api.dao.ApplicationDao;
import io.oasp.application.sampleapp.ordermanagement.dataaccess.api.PedidoEntity;
import io.oasp.application.sampleapp.ordermanagement.logic.api.to.PedidoSearchCriteriaTo;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * Data access interface for Pedido entities
 */
public interface PedidoDao extends ApplicationDao<PedidoEntity> {

  /**
   * Finds the {@link PedidoEntity pedidos} matching the given {@link PedidoSearchCriteriaTo}.
   *
   * @param criteria is the {@link PedidoSearchCriteriaTo}.
   * @return the {@link PaginatedListTo} with the matching {@link PedidoEntity} objects.
   */
  PaginatedListTo<PedidoEntity> findPedidos(PedidoSearchCriteriaTo criteria);

  /**
   * @return
   */
  List<PedidoEntity> findAllPedidos();

}
