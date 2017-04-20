package io.oasp.application.sampleapp.ordermanagement.logic.impl.usecase;

import java.util.Objects;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;

import io.oasp.application.sampleapp.general.logic.api.UseCase;
import io.oasp.application.sampleapp.ordermanagement.dataaccess.api.EstadoEntity;
import io.oasp.application.sampleapp.ordermanagement.logic.api.to.EstadoEto;
import io.oasp.application.sampleapp.ordermanagement.logic.api.usecase.UcManageEstado;
import io.oasp.application.sampleapp.ordermanagement.logic.base.usecase.AbstractEstadoUc;

/**
 * Use case implementation for modifying and deleting Estados
 */
@Named
@UseCase
@Validated
public class UcManageEstadoImpl extends AbstractEstadoUc implements UcManageEstado {

  /**
   * Logger instance.
   */
  private static final Logger LOG = LoggerFactory.getLogger(UcManageEstadoImpl.class);

  @Override
  public boolean deleteEstado(Long estadoId) {

    EstadoEntity estado = getEstadoDao().find(estadoId);
    getEstadoDao().delete(estado);
    LOG.debug("The estado with id '{}' has been deleted.", estadoId);
    return true;
  }

  @Override
  public EstadoEto saveEstado(EstadoEto estado) {

    Objects.requireNonNull(estado, "estado");

    EstadoEntity estadoEntity = getBeanMapper().map(estado, EstadoEntity.class);

    // initialize, validate estadoEntity here if necessary

    getEstadoDao().save(estadoEntity);
    LOG.debug("Estado with id '{}' has been created.", estadoEntity.getId());
    return getBeanMapper().map(estadoEntity, EstadoEto.class);
  }

}
