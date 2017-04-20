package io.oasp.application.sampleapp.common.builders;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;

import io.oasp.application.sampleapp.ordermanagement.dataaccess.api.ClienteEntity;

public class ClienteEntityBuilder {

  private List<P<ClienteEntity>> parameterToBeApplied;

  public ClienteEntityBuilder() {

    parameterToBeApplied = new LinkedList<P<ClienteEntity>>();
    fillMandatoryFields();
    fillMandatoryFields_custom();
  }

  /**
   * Fills all mandatory fields by default. (will be overwritten on re-generation)
   */
  private void fillMandatoryFields() {

  }

  public ClienteEntityBuilder dni(final String dni) {

    parameterToBeApplied.add(new P<ClienteEntity>() {
      @Override
      public void apply(ClienteEntity target) {

        target.setDni(dni);
      }
    });
    return this;
  }

  public ClienteEntityBuilder nombre(final String nombre) {

    parameterToBeApplied.add(new P<ClienteEntity>() {
      @Override
      public void apply(ClienteEntity target) {

        target.setNombre(nombre);
      }
    });
    return this;
  }

  public ClienteEntityBuilder revision(final Number revision) {

    parameterToBeApplied.add(new P<ClienteEntity>() {
      @Override
      public void apply(ClienteEntity target) {

        target.setRevision(revision);
      }
    });
    return this;
  }

  public ClienteEntity createNew() {

    ClienteEntity clienteentity = new ClienteEntity();
    for (P<ClienteEntity> parameter : parameterToBeApplied) {
      parameter.apply(clienteentity);
    }
    return clienteentity;
  }

  public ClienteEntity persist(EntityManager em) {

    ClienteEntity clienteentity = createNew();
    em.persist(clienteentity);
    return clienteentity;
  }

  public List<ClienteEntity> persistAndDuplicate(EntityManager em, int quantity) {

    List<ClienteEntity> clienteentityList = new LinkedList<ClienteEntity>();
    for (int i = 0; i < quantity; i++) {
      ClienteEntity clienteentity = createNew();
      // TODO alter at least values with unique key constraints to prevent from exceptions while persisting
      em.persist(clienteentity);
      clienteentityList.add(clienteentity);
    }

    return clienteentityList;
  }

  /**
   * Might be enrichted to users needs (will not be overwritten)
   */
  private void fillMandatoryFields_custom() {

  }

}
