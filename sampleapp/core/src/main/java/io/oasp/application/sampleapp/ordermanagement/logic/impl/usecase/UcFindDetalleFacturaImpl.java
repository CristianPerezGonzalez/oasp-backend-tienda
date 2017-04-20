package io.oasp.application.sampleapp.ordermanagement.logic.impl.usecase;

import java.util.List;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;

import io.oasp.application.sampleapp.general.logic.api.UseCase;
import io.oasp.application.sampleapp.ordermanagement.dataaccess.api.DetalleFacturaEntity;
import io.oasp.application.sampleapp.ordermanagement.logic.api.to.DetalleFacturaEto;
import io.oasp.application.sampleapp.ordermanagement.logic.api.to.DetalleFacturaSearchCriteriaTo;
import io.oasp.application.sampleapp.ordermanagement.logic.api.usecase.UcFindDetalleFactura;
import io.oasp.application.sampleapp.ordermanagement.logic.base.usecase.AbstractDetalleFacturaUc;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * Use case implementation for searching, filtering and getting DetalleFacturas
 */
@Named
@UseCase
@Validated
public class UcFindDetalleFacturaImpl extends AbstractDetalleFacturaUc implements UcFindDetalleFactura {

  /**
   * Logger instance.
   */
  private static final Logger LOG = LoggerFactory.getLogger(UcFindDetalleFacturaImpl.class);

  @Override
  public DetalleFacturaEto findDetalleFactura(Long id) {

    LOG.debug("Get DetalleFactura with id {} from database.", id);
    return getBeanMapper().map(getDetalleFacturaDao().findOne(id), DetalleFacturaEto.class);
  }

  @Override
  public PaginatedListTo<DetalleFacturaEto> findDetalleFacturaEtos(DetalleFacturaSearchCriteriaTo criteria) {

    criteria.limitMaximumPageSize(MAXIMUM_HIT_LIMIT);
    PaginatedListTo<DetalleFacturaEntity> detallefacturas = getDetalleFacturaDao().findDetalleFacturas(criteria);
    return mapPaginatedEntityList(detallefacturas, DetalleFacturaEto.class);
  }

  @Override
  public List<DetalleFacturaEto> findAllDetallesFactura() {

    List<DetalleFacturaEntity> tables = getDetalleFacturaDao().findAllDetallesFactura();
    return getBeanMapper().mapList(tables, DetalleFacturaEto.class);
  }

}
