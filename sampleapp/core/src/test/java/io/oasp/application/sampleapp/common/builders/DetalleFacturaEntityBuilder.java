package io.oasp.application.sampleapp.common.builders;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;

import io.oasp.application.sampleapp.ordermanagement.dataaccess.api.ArticuloEntity;
import io.oasp.application.sampleapp.ordermanagement.dataaccess.api.DetalleFacturaEntity;
import io.oasp.application.sampleapp.ordermanagement.dataaccess.api.FacturaEntity;

public class DetalleFacturaEntityBuilder {

  private List<P<DetalleFacturaEntity>> parameterToBeApplied;

  public DetalleFacturaEntityBuilder() {

    parameterToBeApplied = new LinkedList<P<DetalleFacturaEntity>>();
    fillMandatoryFields();
    fillMandatoryFields_custom();
  }

  public DetalleFacturaEntity persist(EntityManager em) {

    DetalleFacturaEntity detallefacturaentity = createNew();
    em.persist(detallefacturaentity);
    return detallefacturaentity;
  }

  public List<DetalleFacturaEntity> persistAndDuplicate(EntityManager em, int quantity) {

    List<DetalleFacturaEntity> detallefacturaentityList = new LinkedList<DetalleFacturaEntity>();
    for (int i = 0; i < quantity; i++) {
      DetalleFacturaEntity detallefacturaentity = createNew();
      // TODO alter at least values with unique key constraints to prevent from exceptions while persisting
      em.persist(detallefacturaentity);
      detallefacturaentityList.add(detallefacturaentity);
    }

    return detallefacturaentityList;
  }

  public DetalleFacturaEntityBuilder factura(final FacturaEntity factura) {

    parameterToBeApplied.add(new P<DetalleFacturaEntity>() {
      @Override
      public void apply(DetalleFacturaEntity target) {

        target.setFactura(factura);
      }
    });
    return this;
  }

  public DetalleFacturaEntityBuilder articulo(final ArticuloEntity articulo) {

    parameterToBeApplied.add(new P<DetalleFacturaEntity>() {
      @Override
      public void apply(DetalleFacturaEntity target) {

        target.setArticulo(articulo);
      }
    });
    return this;
  }

  public DetalleFacturaEntityBuilder uds(final int uds) {

    parameterToBeApplied.add(new P<DetalleFacturaEntity>() {
      @Override
      public void apply(DetalleFacturaEntity target) {

        target.setUds(uds);
      }
    });
    return this;
  }

  public DetalleFacturaEntityBuilder precio(final int precio) {

    parameterToBeApplied.add(new P<DetalleFacturaEntity>() {
      @Override
      public void apply(DetalleFacturaEntity target) {

        target.setPrecio(precio);
      }
    });
    return this;
  }

  public DetalleFacturaEntityBuilder revision(final Number revision) {

    parameterToBeApplied.add(new P<DetalleFacturaEntity>() {
      @Override
      public void apply(DetalleFacturaEntity target) {

        target.setRevision(revision);
      }
    });
    return this;
  }

  public DetalleFacturaEntity createNew() {

    DetalleFacturaEntity detallefacturaentity = new DetalleFacturaEntity();
    for (P<DetalleFacturaEntity> parameter : parameterToBeApplied) {
      parameter.apply(detallefacturaentity);
    }
    return detallefacturaentity;
  }

  /**
   * Fills all mandatory fields by default. (will be overwritten on re-generation)
   */
  private void fillMandatoryFields() {

  }

  /**
   * Might be enrichted to users needs (will not be overwritten)
   */
  private void fillMandatoryFields_custom() {

  }

}
