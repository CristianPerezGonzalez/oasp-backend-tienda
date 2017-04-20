package io.oasp.application.sampleapp.ordermanagement.dataaccess.impl.dao;

import javax.inject.Named;

import com.mysema.query.alias.Alias;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.path.EntityPathBase;

import io.oasp.application.sampleapp.general.dataaccess.base.dao.ApplicationDaoImpl;
import io.oasp.application.sampleapp.ordermanagement.dataaccess.api.EstadoEntity;
import io.oasp.application.sampleapp.ordermanagement.dataaccess.api.dao.EstadoDao;
import io.oasp.application.sampleapp.ordermanagement.logic.api.to.EstadoSearchCriteriaTo;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * This is the implementation of {@link EstadoDao}.
 */
@Named
public class EstadoDaoImpl extends ApplicationDaoImpl<EstadoEntity> implements EstadoDao {

  /**
   * The constructor.
   */
  public EstadoDaoImpl() {

    super();
  }

  @Override
  public Class<EstadoEntity> getEntityClass() {

    return EstadoEntity.class;
  }

  @Override
  public PaginatedListTo<EstadoEntity> findEstados(EstadoSearchCriteriaTo criteria) {

    EstadoEntity estado = Alias.alias(EstadoEntity.class);
    EntityPathBase<EstadoEntity> alias = Alias.$(estado);
    JPAQuery query = new JPAQuery(getEntityManager()).from(alias);

    String codestado = criteria.getCodestado();
    if (codestado != null) {
      query.where(Alias.$(estado.getCodestado()).eq(codestado));
    }

    String descripcion = criteria.getDescripcion();
    if (descripcion != null) {
      query.where(Alias.$(estado.getDescripcion()).eq(descripcion));
    }

    return findPaginated(criteria, query, alias);
  }

}
