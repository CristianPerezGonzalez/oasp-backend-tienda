package io.oasp.application.sampleapp.ordermanagement.logic.impl.usecase;

import java.util.Objects;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;

import io.oasp.application.sampleapp.general.logic.api.UseCase;
import io.oasp.application.sampleapp.ordermanagement.dataaccess.api.PedidoEntity;
import io.oasp.application.sampleapp.ordermanagement.logic.api.to.PedidoEto;
import io.oasp.application.sampleapp.ordermanagement.logic.api.usecase.UcManagePedido;
import io.oasp.application.sampleapp.ordermanagement.logic.base.usecase.AbstractPedidoUc;

/**
 * Use case implementation for modifying and deleting Pedidos
 */
@Named
@UseCase
@Validated
public class UcManagePedidoImpl extends AbstractPedidoUc implements UcManagePedido {

  /**
   * Logger instance.
   */
  private static final Logger LOG = LoggerFactory.getLogger(UcManagePedidoImpl.class);

  @Override
  public boolean deletePedido(Long pedidoId) {

    PedidoEntity pedido = getPedidoDao().find(pedidoId);
    getPedidoDao().delete(pedido);
    LOG.debug("The pedido with id '{}' has been deleted.", pedidoId);
    return true;
  }

  @Override
  public PedidoEto savePedido(PedidoEto pedido) {

    Objects.requireNonNull(pedido, "pedido");

    PedidoEntity pedidoEntity = getBeanMapper().map(pedido, PedidoEntity.class);

    // initialize, validate pedidoEntity here if necessary

    getPedidoDao().save(pedidoEntity);
    LOG.debug("Pedido with id '{}' has been created.", pedidoEntity.getId());
    return getBeanMapper().map(pedidoEntity, PedidoEto.class);
  }

}
