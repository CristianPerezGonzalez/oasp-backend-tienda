package io.oasp.application.sampleapp.ordermanagement.logic.impl.usecase;

import java.util.List;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;

import io.oasp.application.sampleapp.general.logic.api.UseCase;
import io.oasp.application.sampleapp.ordermanagement.dataaccess.api.PedidoEntity;
import io.oasp.application.sampleapp.ordermanagement.logic.api.to.PedidoEto;
import io.oasp.application.sampleapp.ordermanagement.logic.api.to.PedidoSearchCriteriaTo;
import io.oasp.application.sampleapp.ordermanagement.logic.api.usecase.UcFindPedido;
import io.oasp.application.sampleapp.ordermanagement.logic.base.usecase.AbstractPedidoUc;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * Use case implementation for searching, filtering and getting Pedidos
 */
@Named
@UseCase
@Validated
public class UcFindPedidoImpl extends AbstractPedidoUc implements UcFindPedido {

  /**
   * Logger instance.
   */
  private static final Logger LOG = LoggerFactory.getLogger(UcFindPedidoImpl.class);

  @Override
  public PedidoEto findPedido(Long id) {

    LOG.debug("Get Pedido with id {} from database.", id);
    PedidoEntity findOne = getPedidoDao().findOne(id);
    return getBeanMapper().map(findOne, PedidoEto.class);
  }

  @Override
  public PaginatedListTo<PedidoEto> findPedidoEtos(PedidoSearchCriteriaTo criteria) {

    criteria.limitMaximumPageSize(MAXIMUM_HIT_LIMIT);
    PaginatedListTo<PedidoEntity> pedidos = getPedidoDao().findPedidos(criteria);
    return mapPaginatedEntityList(pedidos, PedidoEto.class);
  }

  @Override
  public List<PedidoEto> findAllPedidos() {

    LOG.debug("Get all restaurant tables from database.");
    List<PedidoEntity> tables = getPedidoDao().findAllPedidos();
    return getBeanMapper().mapList(tables, PedidoEto.class);
  }

}
