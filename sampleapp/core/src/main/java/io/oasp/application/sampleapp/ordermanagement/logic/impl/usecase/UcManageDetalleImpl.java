package io.oasp.application.sampleapp.ordermanagement.logic.impl.usecase;

import java.util.Objects;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;

import io.oasp.application.sampleapp.general.logic.api.UseCase;
import io.oasp.application.sampleapp.ordermanagement.dataaccess.api.DetalleEntity;
import io.oasp.application.sampleapp.ordermanagement.logic.api.to.DetalleEto;
import io.oasp.application.sampleapp.ordermanagement.logic.api.usecase.UcManageDetalle;
import io.oasp.application.sampleapp.ordermanagement.logic.base.usecase.AbstractDetalleUc;

/**
 * Use case implementation for modifying and deleting Detalles
 */
@Named
@UseCase
@Validated
public class UcManageDetalleImpl extends AbstractDetalleUc implements UcManageDetalle {

  /**
   * Logger instance.
   */
  private static final Logger LOG = LoggerFactory.getLogger(UcManageDetalleImpl.class);

  @Override
  public boolean deleteDetalle(Long detalleId) {

    DetalleEntity detalle = getDetalleDao().find(detalleId);
    getDetalleDao().delete(detalle);
    LOG.debug("The detalle with id '{}' has been deleted.", detalleId);
    return true;
  }

  @Override
  public DetalleEto saveDetalle(DetalleEto detalle) {

    Objects.requireNonNull(detalle, "detalle");

    DetalleEntity detalleEntity = getBeanMapper().map(detalle, DetalleEntity.class);

    // initialize, validate detalleEntity here if necessary

    getDetalleDao().save(detalleEntity);
    LOG.debug("Detalle with id '{}' has been created.", detalleEntity.getId());
    return getBeanMapper().map(detalleEntity, DetalleEto.class);
  }

}
