package io.oasp.application.sampleapp.ordermanagement.logic.impl.usecase;

import java.util.Objects;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;

import io.oasp.application.sampleapp.general.logic.api.UseCase;
import io.oasp.application.sampleapp.ordermanagement.dataaccess.api.ClienteEntity;
import io.oasp.application.sampleapp.ordermanagement.logic.api.to.ClienteEto;
import io.oasp.application.sampleapp.ordermanagement.logic.api.usecase.UcManageCliente;
import io.oasp.application.sampleapp.ordermanagement.logic.base.usecase.AbstractClienteUc;

/**
 * Use case implementation for modifying and deleting Clientes
 */
@Named
@UseCase
@Validated
public class UcManageClienteImpl extends AbstractClienteUc implements UcManageCliente {

  /**
   * Logger instance.
   */
  private static final Logger LOG = LoggerFactory.getLogger(UcManageClienteImpl.class);

  @Override
  public boolean deleteCliente(Long clienteId) {

    ClienteEntity cliente = getClienteDao().find(clienteId);
    getClienteDao().delete(cliente);
    LOG.debug("The cliente with id '{}' has been deleted.", clienteId);
    return true;
  }

  @Override
  public ClienteEto saveCliente(ClienteEto cliente) {

    Objects.requireNonNull(cliente, "cliente");

    ClienteEntity clienteEntity = getBeanMapper().map(cliente, ClienteEntity.class);

    // initialize, validate clienteEntity here if necessary

    getClienteDao().save(clienteEntity);
    LOG.debug("Cliente with id '{}' has been created.", clienteEntity.getId());
    return getBeanMapper().map(clienteEntity, ClienteEto.class);
  }

}
