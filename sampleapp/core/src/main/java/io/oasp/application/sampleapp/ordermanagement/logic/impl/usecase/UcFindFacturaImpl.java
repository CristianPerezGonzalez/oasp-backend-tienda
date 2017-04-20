package io.oasp.application.sampleapp.ordermanagement.logic.impl.usecase;

import java.util.List;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;

import io.oasp.application.sampleapp.general.logic.api.UseCase;
import io.oasp.application.sampleapp.ordermanagement.dataaccess.api.FacturaEntity;
import io.oasp.application.sampleapp.ordermanagement.logic.api.to.FacturaEto;
import io.oasp.application.sampleapp.ordermanagement.logic.api.to.FacturaSearchCriteriaTo;
import io.oasp.application.sampleapp.ordermanagement.logic.api.usecase.UcFindFactura;
import io.oasp.application.sampleapp.ordermanagement.logic.base.usecase.AbstractFacturaUc;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * Use case implementation for searching, filtering and getting Facturas
 */
@Named
@UseCase
@Validated
public class UcFindFacturaImpl extends AbstractFacturaUc implements UcFindFactura {

  /**
   * Logger instance.
   */
  private static final Logger LOG = LoggerFactory.getLogger(UcFindFacturaImpl.class);

  @Override
  public FacturaEto findFactura(Long id) {

    LOG.debug("Get Factura with id {} from database.", id);
    return getBeanMapper().map(getFacturaDao().findOne(id), FacturaEto.class);
  }

  @Override
  public PaginatedListTo<FacturaEto> findFacturaEtos(FacturaSearchCriteriaTo criteria) {

    criteria.limitMaximumPageSize(MAXIMUM_HIT_LIMIT);
    PaginatedListTo<FacturaEntity> facturas = getFacturaDao().findFacturas(criteria);
    return mapPaginatedEntityList(facturas, FacturaEto.class);
  }

  @Override
  public List<FacturaEto> findAllFacturas() {

    LOG.debug("Get all restaurant tables from database.");
    List<FacturaEntity> tables = getFacturaDao().findAllFacturas();
    return getBeanMapper().mapList(tables, FacturaEto.class);
  }

}
