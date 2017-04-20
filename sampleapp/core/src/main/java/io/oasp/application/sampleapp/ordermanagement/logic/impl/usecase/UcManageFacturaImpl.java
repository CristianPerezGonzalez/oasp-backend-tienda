package io.oasp.application.sampleapp.ordermanagement.logic.impl.usecase;

import java.util.Objects;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;

import io.oasp.application.sampleapp.general.logic.api.UseCase;
import io.oasp.application.sampleapp.ordermanagement.dataaccess.api.FacturaEntity;
import io.oasp.application.sampleapp.ordermanagement.logic.api.to.FacturaEto;
import io.oasp.application.sampleapp.ordermanagement.logic.api.usecase.UcManageFactura;
import io.oasp.application.sampleapp.ordermanagement.logic.base.usecase.AbstractFacturaUc;

/**
 * Use case implementation for modifying and deleting Facturas
 */
@Named
@UseCase
@Validated
public class UcManageFacturaImpl extends AbstractFacturaUc implements UcManageFactura {

  /**
   * Logger instance.
   */
  private static final Logger LOG = LoggerFactory.getLogger(UcManageFacturaImpl.class);

  @Override
  public boolean deleteFactura(Long facturaId) {

    FacturaEntity factura = getFacturaDao().find(facturaId);
    getFacturaDao().delete(factura);
    LOG.debug("The factura with id '{}' has been deleted.", facturaId);
    return true;
  }

  @Override
  public FacturaEto saveFactura(FacturaEto factura) {

    Objects.requireNonNull(factura, "factura");

    FacturaEntity facturaEntity = getBeanMapper().map(factura, FacturaEntity.class);

    // initialize, validate facturaEntity here if necessary

    getFacturaDao().save(facturaEntity);
    LOG.debug("Factura with id '{}' has been created.", facturaEntity.getId());
    return getBeanMapper().map(facturaEntity, FacturaEto.class);
  }

}
