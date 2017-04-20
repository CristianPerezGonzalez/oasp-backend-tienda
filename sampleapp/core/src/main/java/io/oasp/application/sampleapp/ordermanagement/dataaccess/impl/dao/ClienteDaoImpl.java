package io.oasp.application.sampleapp.ordermanagement.dataaccess.impl.dao;

import java.util.List;

import javax.inject.Named;

import com.mysema.query.alias.Alias;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.path.EntityPathBase;

import io.oasp.application.sampleapp.general.dataaccess.base.dao.ApplicationDaoImpl;
import io.oasp.application.sampleapp.ordermanagement.dataaccess.api.ClienteEntity;
import io.oasp.application.sampleapp.ordermanagement.dataaccess.api.dao.ClienteDao;
import io.oasp.application.sampleapp.ordermanagement.logic.api.to.ClienteSearchCriteriaTo;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * This is the implementation of {@link ClienteDao}.
 */
@Named
public class ClienteDaoImpl extends ApplicationDaoImpl<ClienteEntity> implements ClienteDao {

  /**
   * The constructor.
   */
  public ClienteDaoImpl() {

    super();
  }

  @Override
  public Class<ClienteEntity> getEntityClass() {

    return ClienteEntity.class;
  }

  @Override
  public PaginatedListTo<ClienteEntity> findClientes(ClienteSearchCriteriaTo criteria) {

    ClienteEntity cliente = Alias.alias(ClienteEntity.class);
    EntityPathBase<ClienteEntity> alias = Alias.$(cliente);
    JPAQuery query = new JPAQuery(getEntityManager()).from(alias);

    String dni = criteria.getDni();
    if (dni != null) {
      query.where(Alias.$(cliente.getDni()).eq(dni));
    }

    String nombre = criteria.getNombre();
    if (nombre != null) {
      query.where(Alias.$(cliente.getNombre()).eq(nombre));
    }

    return findPaginated(criteria, query, alias);
  }

  @Override
  public List<ClienteEntity> findAllClientes() {

    return findAll();
  }

}
