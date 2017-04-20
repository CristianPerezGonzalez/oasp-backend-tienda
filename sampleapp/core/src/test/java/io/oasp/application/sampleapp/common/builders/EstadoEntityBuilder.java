package io.oasp.application.sampleapp.common.builders;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;

import io.oasp.application.sampleapp.ordermanagement.dataaccess.api.EstadoEntity;

public class EstadoEntityBuilder {

  private List<P<EstadoEntity>> parameterToBeApplied;

  public EstadoEntityBuilder() {

    parameterToBeApplied = new LinkedList<P<EstadoEntity>>();
    fillMandatoryFields();
    fillMandatoryFields_custom();
  }

  /**
   * Fills all mandatory fields by default. (will be overwritten on re-generation)
   */
  private void fillMandatoryFields() {

  }

  public EstadoEntity persist(EntityManager em) {

    EstadoEntity estadoentity = createNew();
    em.persist(estadoentity);
    return estadoentity;
  }

  public List<EstadoEntity> persistAndDuplicate(EntityManager em, int quantity) {

    List<EstadoEntity> estadoentityList = new LinkedList<EstadoEntity>();
    for (int i = 0; i < quantity; i++) {
      EstadoEntity estadoentity = createNew();
      // TODO alter at least values with unique key constraints to prevent from exceptions while persisting
      em.persist(estadoentity);
      estadoentityList.add(estadoentity);
    }

    return estadoentityList;
  }

  public EstadoEntityBuilder codestado(final String codestado) {

    parameterToBeApplied.add(new P<EstadoEntity>() {
      @Override
      public void apply(EstadoEntity target) {

        target.setCodestado(codestado);
      }
    });
    return this;
  }

  public EstadoEntityBuilder descripcion(final String descripcion) {

    parameterToBeApplied.add(new P<EstadoEntity>() {
      @Override
      public void apply(EstadoEntity target) {

        target.setDescripcion(descripcion);
      }
    });
    return this;
  }

  public EstadoEntityBuilder revision(final Number revision) {

    parameterToBeApplied.add(new P<EstadoEntity>() {
      @Override
      public void apply(EstadoEntity target) {

        target.setRevision(revision);
      }
    });
    return this;
  }

  public EstadoEntity createNew() {

    EstadoEntity estadoentity = new EstadoEntity();
    for (P<EstadoEntity> parameter : parameterToBeApplied) {
      parameter.apply(estadoentity);
    }
    return estadoentity;
  }

  /**
   * Might be enrichted to users needs (will not be overwritten)
   */
  private void fillMandatoryFields_custom() {

  }

}
