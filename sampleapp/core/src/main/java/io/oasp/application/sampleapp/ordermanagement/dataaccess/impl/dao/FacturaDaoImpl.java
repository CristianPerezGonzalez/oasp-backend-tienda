package io.oasp.application.sampleapp.ordermanagement.dataaccess.impl.dao;

import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityNotFoundException;

import com.mysema.query.alias.Alias;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.path.EntityPathBase;

import io.oasp.application.sampleapp.general.dataaccess.base.dao.ApplicationDaoImpl;
import io.oasp.application.sampleapp.ordermanagement.dataaccess.api.DetalleFacturaEntity;
import io.oasp.application.sampleapp.ordermanagement.dataaccess.api.FacturaEntity;
import io.oasp.application.sampleapp.ordermanagement.dataaccess.api.dao.FacturaDao;
import io.oasp.application.sampleapp.ordermanagement.logic.api.to.FacturaSearchCriteriaTo;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * This is the implementation of {@link FacturaDao}.
 */
@Named
public class FacturaDaoImpl extends ApplicationDaoImpl<FacturaEntity> implements FacturaDao {

  /**
   * The constructor.
   */
  public FacturaDaoImpl() {

    super();
  }

  @Override
  public Class<FacturaEntity> getEntityClass() {

    return FacturaEntity.class;
  }

  @Override
  public PaginatedListTo<FacturaEntity> findFacturas(FacturaSearchCriteriaTo criteria) {

    FacturaEntity factura = Alias.alias(FacturaEntity.class);
    EntityPathBase<FacturaEntity> alias = Alias.$(factura);
    JPAQuery query = new JPAQuery(getEntityManager()).from(alias);

    Long pedido = criteria.getPedidoId();
    if (pedido != null) {
      query.where(Alias.$(factura.getPedidoId()).eq(pedido));
    }

    String descripcion = criteria.getDescripcion();
    if (descripcion != null) {
      query.where(Alias.$(factura.getDescripcion()).eq(descripcion));
    }

    return findPaginated(criteria, query, alias);
  }

  @Override
  public List<FacturaEntity> findAllFacturas() {

    return findAll();
  }

  @Override
  public FacturaEntity save(FacturaEntity entity) {

    if (isNew(entity)) {

      List<DetalleFacturaEntity> detalles = entity.getDetallesFacturaIds();

      for (DetalleFacturaEntity detalleFacturaEntity : detalles) {
        detalleFacturaEntity.setFactura(entity);
      }

      getEntityManager().persist(entity);
      return entity;
    } else {
      if (getEntityManager().find(entity.getClass(), entity.getId()) != null) {
        FacturaEntity update = getEntityManager().merge(entity);
        return update;
      } else {
        throw new EntityNotFoundException("Entity not found");
      }
    }

  }

}
