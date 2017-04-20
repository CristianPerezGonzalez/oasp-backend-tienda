package io.oasp.application.sampleapp.ordermanagement.logic.impl.usecase;

import java.util.Objects;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;

import io.oasp.application.sampleapp.general.logic.api.UseCase;
import io.oasp.application.sampleapp.ordermanagement.dataaccess.api.DetalleFacturaEntity;
import io.oasp.application.sampleapp.ordermanagement.logic.api.to.DetalleFacturaEto;
import io.oasp.application.sampleapp.ordermanagement.logic.api.usecase.UcManageDetalleFactura;
import io.oasp.application.sampleapp.ordermanagement.logic.base.usecase.AbstractDetalleFacturaUc;

/**
 * Use case implementation for modifying and deleting DetalleFacturas
 */
@Named
@UseCase
@Validated
public class UcManageDetalleFacturaImpl extends AbstractDetalleFacturaUc implements UcManageDetalleFactura {

  /**
   * Logger instance.
   */
  private static final Logger LOG = LoggerFactory.getLogger(UcManageDetalleFacturaImpl.class);

  @Override
  public boolean deleteDetalleFactura(Long detalleFacturaId) {

    DetalleFacturaEntity detalleFactura = getDetalleFacturaDao().find(detalleFacturaId);
    getDetalleFacturaDao().delete(detalleFactura);
    LOG.debug("The detalleFactura with id '{}' has been deleted.", detalleFacturaId);
    return true;
  }

  @Override
  public DetalleFacturaEto saveDetalleFactura(DetalleFacturaEto detalleFactura) {

    Objects.requireNonNull(detalleFactura, "detalleFactura");

    DetalleFacturaEntity detalleFacturaEntity = getBeanMapper().map(detalleFactura, DetalleFacturaEntity.class);

    // initialize, validate detalleFacturaEntity here if necessary

    getDetalleFacturaDao().save(detalleFacturaEntity);
    LOG.debug("DetalleFactura with id '{}' has been created.", detalleFacturaEntity.getId());
    return getBeanMapper().map(detalleFacturaEntity, DetalleFacturaEto.class);
  }

}
