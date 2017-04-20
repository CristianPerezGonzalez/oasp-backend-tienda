package io.oasp.application.sampleapp.common.builders;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;

import io.oasp.application.sampleapp.ordermanagement.dataaccess.api.ArticuloEntity;

public class ArticuloEntityBuilder {

  private List<P<ArticuloEntity>> parameterToBeApplied;

  public ArticuloEntityBuilder() {

    this.parameterToBeApplied = new LinkedList<P<ArticuloEntity>>();
    fillMandatoryFields();
    fillMandatoryFields_custom();
  }

  /**
   * Might be enrichted to users needs (will not be overwritten)
   */
  private void fillMandatoryFields_custom() {

  }

  /**
   * Fills all mandatory fields by default. (will be overwritten on re-generation)
   */
  private void fillMandatoryFields() {

  }

  public ArticuloEntity persist(EntityManager em) {

    ArticuloEntity articuloentity = createNew();
    em.persist(articuloentity);
    return articuloentity;
  }

  public List<ArticuloEntity> persistAndDuplicate(EntityManager em, int quantity) {

    List<ArticuloEntity> articuloentityList = new LinkedList<ArticuloEntity>();
    for (int i = 0; i < quantity; i++) {
      ArticuloEntity articuloentity = createNew();
      // TODO alter at least values with unique key constraints to prevent from exceptions while persisting
      em.persist(articuloentity);
      articuloentityList.add(articuloentity);
    }

    return articuloentityList;
  }

  public ArticuloEntityBuilder revision(final Number revision) {

    this.parameterToBeApplied.add(new P<ArticuloEntity>() {
      @Override
      public void apply(ArticuloEntity target) {

        target.setRevision(revision);
      }
    });
    return this;
  }

  public ArticuloEntity createNew() {

    ArticuloEntity articuloentity = new ArticuloEntity();
    for (P<ArticuloEntity> parameter : this.parameterToBeApplied) {
      parameter.apply(articuloentity);
    }
    return articuloentity;
  }

  public ArticuloEntityBuilder nombre(final String nombre) {

    parameterToBeApplied.add(new P<ArticuloEntity>() {
      @Override
      public void apply(ArticuloEntity target) {

        target.setNombre(nombre);
      }
    });
    return this;
  }

  public ArticuloEntityBuilder precio(final Integer precio) {

    parameterToBeApplied.add(new P<ArticuloEntity>() {
      @Override
      public void apply(ArticuloEntity target) {

        target.setPrecio(precio);
      }
    });
    return this;
  }

}
