package io.oasp.application.sampleapp.ordermanagement.logic.impl.usecase;

import java.util.Objects;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;

import io.oasp.application.sampleapp.general.logic.api.UseCase;
import io.oasp.application.sampleapp.ordermanagement.dataaccess.api.ArticuloEntity;
import io.oasp.application.sampleapp.ordermanagement.logic.api.to.ArticuloEto;
import io.oasp.application.sampleapp.ordermanagement.logic.api.usecase.UcManageArticulo;
import io.oasp.application.sampleapp.ordermanagement.logic.base.usecase.AbstractArticuloUc;

/**
 * Use case implementation for modifying and deleting Articulos
 */
@Named
@UseCase
@Validated
public class UcManageArticuloImpl extends AbstractArticuloUc implements UcManageArticulo {

  /**
   * Logger instance.
   */
  private static final Logger LOG = LoggerFactory.getLogger(UcManageArticuloImpl.class);

  @Override
  public boolean deleteArticulo(Long articuloId) {

    ArticuloEntity articulo = getArticuloDao().find(articuloId);
    getArticuloDao().delete(articulo);
    LOG.debug("The articulo with id '{}' has been deleted.", articuloId);
    return true;
  }

  @Override
  public ArticuloEto saveArticulo(ArticuloEto articulo) {

    Objects.requireNonNull(articulo, "articulo");

    ArticuloEntity articuloEntity = getBeanMapper().map(articulo, ArticuloEntity.class);

    // initialize, validate articuloEntity here if necessary

    getArticuloDao().save(articuloEntity);
    LOG.debug("Articulo with id '{}' has been created.", articuloEntity.getId());
    return getBeanMapper().map(articuloEntity, ArticuloEto.class);
  }

}
