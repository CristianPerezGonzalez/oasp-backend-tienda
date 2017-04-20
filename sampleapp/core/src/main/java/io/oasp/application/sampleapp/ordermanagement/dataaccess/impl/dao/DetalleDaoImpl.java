package io.oasp.application.sampleapp.ordermanagement.dataaccess.impl.dao;

import java.util.List;

import javax.inject.Named;

import com.mysema.query.alias.Alias;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.path.EntityPathBase;

import io.oasp.application.sampleapp.general.dataaccess.base.dao.ApplicationDaoImpl;
import io.oasp.application.sampleapp.ordermanagement.dataaccess.api.DetalleEntity;
import io.oasp.application.sampleapp.ordermanagement.dataaccess.api.dao.DetalleDao;
import io.oasp.application.sampleapp.ordermanagement.logic.api.to.DetalleSearchCriteriaTo;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * This is the implementation of {@link DetalleDao}.
 */
@Named
public class DetalleDaoImpl extends ApplicationDaoImpl<DetalleEntity> implements DetalleDao {

  /**
   * The constructor.
   */
  public DetalleDaoImpl() {

    super();
  }

  @Override
  public Class<DetalleEntity> getEntityClass() {

    return DetalleEntity.class;
  }

  @Override
  public PaginatedListTo<DetalleEntity> findDetalles(DetalleSearchCriteriaTo criteria) {

    DetalleEntity detalle = Alias.alias(DetalleEntity.class);
    EntityPathBase<DetalleEntity> alias = Alias.$(detalle);
    JPAQuery query = new JPAQuery(getEntityManager()).from(alias);

    Long pedido = criteria.getPedidoId();
    if (pedido != null) {
      query.where(Alias.$(detalle.getPedidoId()).eq(pedido));
    }

    Long articulo = criteria.getArticuloId();
    if (articulo != null) {
      query.where(Alias.$(detalle.getArticuloId()).eq(articulo));
    }

    int uds = criteria.getUds();
    query.where(Alias.$(detalle.getUds()).eq(uds));

    return findPaginated(criteria, query, alias);
  }

  @Override
  public List<DetalleEntity> findAllDetalles() {

    return findAll();
  }

  @Override
  public List<DetalleEntity> findAllDetallesByPedido(Long id) {

    DetalleSearchCriteriaTo criteria = new DetalleSearchCriteriaTo();

    criteria.setPedidoId(id);

    DetalleEntity detalle = Alias.alias(DetalleEntity.class);
    EntityPathBase<DetalleEntity> alias = Alias.$(detalle);
    JPAQuery query = new JPAQuery(getEntityManager()).from(alias);

    Long pedido = criteria.getPedidoId();
    query.where(Alias.$(detalle.getPedidoId()).eq(pedido));

    // ----
    /*
     * query = (JPAQuery) getEntityManager().createNativeQuery("select detalleEntity" +
     * "from DetalleEntity detalleEntity" + "where detalleEntity.pedidoId = " + detalle.getPedidoId());
     */
    return findPaginated(criteria, query, alias).getResult();
  }

}
