package io.oasp.application.sampleapp.ordermanagement.logic.impl.usecase;

import java.util.List;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;

import io.oasp.application.sampleapp.general.logic.api.UseCase;
import io.oasp.application.sampleapp.ordermanagement.dataaccess.api.ClienteEntity;
import io.oasp.application.sampleapp.ordermanagement.logic.api.to.ClienteEto;
import io.oasp.application.sampleapp.ordermanagement.logic.api.to.ClienteSearchCriteriaTo;
import io.oasp.application.sampleapp.ordermanagement.logic.api.usecase.UcFindCliente;
import io.oasp.application.sampleapp.ordermanagement.logic.base.usecase.AbstractClienteUc;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * Use case implementation for searching, filtering and getting Clientes
 */
@Named
@UseCase
@Validated
public class UcFindClienteImpl extends AbstractClienteUc implements UcFindCliente {

  /**
   * Logger instance.
   */
  private static final Logger LOG = LoggerFactory.getLogger(UcFindClienteImpl.class);

  @Override
  public ClienteEto findCliente(Long id) {

    LOG.debug("Get Cliente with id {} from database.", id);
    return getBeanMapper().map(getClienteDao().findOne(id), ClienteEto.class);
  }

  @Override
  public PaginatedListTo<ClienteEto> findClienteEtos(ClienteSearchCriteriaTo criteria) {

    criteria.limitMaximumPageSize(MAXIMUM_HIT_LIMIT);
    PaginatedListTo<ClienteEntity> clientes = getClienteDao().findClientes(criteria);
    return mapPaginatedEntityList(clientes, ClienteEto.class);
  }

  @Override
  public List<ClienteEto> findAllClientes() {

    LOG.debug("Get all restaurant tables from database.");
    List<ClienteEntity> tables = getClienteDao().findAllClientes();
    return getBeanMapper().mapList(tables, ClienteEto.class);
  }

}
