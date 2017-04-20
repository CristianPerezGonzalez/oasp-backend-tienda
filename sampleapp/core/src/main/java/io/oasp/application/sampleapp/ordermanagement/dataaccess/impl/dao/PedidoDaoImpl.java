package io.oasp.application.sampleapp.ordermanagement.dataaccess.impl.dao;

import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityNotFoundException;

import com.mysema.query.alias.Alias;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.path.EntityPathBase;

import io.oasp.application.sampleapp.general.dataaccess.base.dao.ApplicationDaoImpl;
import io.oasp.application.sampleapp.ordermanagement.dataaccess.api.DetalleEntity;
import io.oasp.application.sampleapp.ordermanagement.dataaccess.api.PedidoEntity;
import io.oasp.application.sampleapp.ordermanagement.dataaccess.api.dao.PedidoDao;
import io.oasp.application.sampleapp.ordermanagement.logic.api.to.PedidoSearchCriteriaTo;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * This is the implementation of {@link PedidoDao}.
 */
@Named
public class PedidoDaoImpl extends ApplicationDaoImpl<PedidoEntity> implements PedidoDao {

  /**
   * The constructor.
   */
  public PedidoDaoImpl() {

    super();
  }

  @Override
  public Class<PedidoEntity> getEntityClass() {

    return PedidoEntity.class;
  }

  @Override
  public PaginatedListTo<PedidoEntity> findPedidos(PedidoSearchCriteriaTo criteria) {

    PedidoEntity pedido = Alias.alias(PedidoEntity.class);
    EntityPathBase<PedidoEntity> alias = Alias.$(pedido);
    JPAQuery query = new JPAQuery(getEntityManager()).from(alias);

    Long cliente = criteria.getClienteId();
    if (cliente != null) {
      query.where(Alias.$(pedido.getClienteId()).eq(cliente));
    }

    String descripcion = criteria.getDescripcion();
    if (descripcion != null) {
      query.where(Alias.$(pedido.getDescripcion()).eq(descripcion));
    }

    return findPaginated(criteria, query, alias);
  }

  @Override
  public List<PedidoEntity> findAllPedidos() {

    return findAll();
  }

  @Override
  public PedidoEntity save(PedidoEntity entity) {

    if (isNew(entity)) {

      List<DetalleEntity> detalles = entity.getDetalleIds();

      for (DetalleEntity detalleFacturaEntity : detalles) {
        detalleFacturaEntity.setPedido(entity);
      }

      getEntityManager().persist(entity);
      return entity;
    } else {
      if (getEntityManager().find(entity.getClass(), entity.getId()) != null) {
        PedidoEntity update = getEntityManager().merge(entity);
        return update;
      } else {
        throw new EntityNotFoundException("Entity not found");
      }
    }

  }

}
