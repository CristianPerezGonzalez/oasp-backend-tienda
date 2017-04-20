package io.oasp.application.sampleapp.ordermanagement.dataaccess.impl.dao;

import java.util.List;

import javax.inject.Named;

import com.mysema.query.alias.Alias;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.path.EntityPathBase;

import io.oasp.application.sampleapp.general.dataaccess.base.dao.ApplicationDaoImpl;
import io.oasp.application.sampleapp.ordermanagement.dataaccess.api.DetalleFacturaEntity;
import io.oasp.application.sampleapp.ordermanagement.dataaccess.api.dao.DetalleFacturaDao;
import io.oasp.application.sampleapp.ordermanagement.logic.api.to.DetalleFacturaSearchCriteriaTo;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * This is the implementation of {@link DetalleFacturaDao}.
 */
@Named
public class DetalleFacturaDaoImpl extends ApplicationDaoImpl<DetalleFacturaEntity> implements DetalleFacturaDao {

  /**
   * The constructor.
   */
  public DetalleFacturaDaoImpl() {

    super();
  }

  @Override
  public Class<DetalleFacturaEntity> getEntityClass() {

    return DetalleFacturaEntity.class;
  }

  @Override
  public PaginatedListTo<DetalleFacturaEntity> findDetalleFacturas(DetalleFacturaSearchCriteriaTo criteria) {

    DetalleFacturaEntity detallefactura = Alias.alias(DetalleFacturaEntity.class);
    EntityPathBase<DetalleFacturaEntity> alias = Alias.$(detallefactura);
    JPAQuery query = new JPAQuery(getEntityManager()).from(alias);

    Long factura = criteria.getFacturaId();
    if (factura != null) {
      query.where(Alias.$(detallefactura.getFacturaId()).eq(factura));
    }

    Long articulo = criteria.getArticuloId();
    if (articulo != null) {
      query.where(Alias.$(detallefactura.getArticuloId()).eq(articulo));
    }

    int uds = criteria.getUds();
    query.where(Alias.$(detallefactura.getUds()).eq(uds));

    int precio = criteria.getPrecio();
    query.where(Alias.$(detallefactura.getPrecio()).eq(precio));

    return findPaginated(criteria, query, alias);
  }

  @Override
  public List<DetalleFacturaEntity> findAllDetallesFactura() {

    return findAll();
  }

}
