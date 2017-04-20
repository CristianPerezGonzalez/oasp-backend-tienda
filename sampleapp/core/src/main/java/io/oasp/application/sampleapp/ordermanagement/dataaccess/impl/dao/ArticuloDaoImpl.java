package io.oasp.application.sampleapp.ordermanagement.dataaccess.impl.dao;

import java.util.List;

import javax.inject.Named;

import com.mysema.query.alias.Alias;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.path.EntityPathBase;

import io.oasp.application.sampleapp.general.dataaccess.base.dao.ApplicationDaoImpl;
import io.oasp.application.sampleapp.ordermanagement.dataaccess.api.ArticuloEntity;
import io.oasp.application.sampleapp.ordermanagement.dataaccess.api.dao.ArticuloDao;
import io.oasp.application.sampleapp.ordermanagement.logic.api.to.ArticuloSearchCriteriaTo;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * This is the implementation of {@link ArticuloDao}.
 */
@Named
public class ArticuloDaoImpl extends ApplicationDaoImpl<ArticuloEntity> implements ArticuloDao {

  /**
   * The constructor.
   */
  public ArticuloDaoImpl() {

    super();
  }

  @Override
  public Class<ArticuloEntity> getEntityClass() {

    return ArticuloEntity.class;
  }

  @Override
  public PaginatedListTo<ArticuloEntity> findArticulos(ArticuloSearchCriteriaTo criteria) {

    ArticuloEntity articulo = Alias.alias(ArticuloEntity.class);
    EntityPathBase<ArticuloEntity> alias = Alias.$(articulo);
    JPAQuery query = new JPAQuery(getEntityManager()).from(alias);

    return findPaginated(criteria, query, alias);
  }

  @Override
  public List<ArticuloEntity> findAllArticulos() {

    return findAll();
  }

}
