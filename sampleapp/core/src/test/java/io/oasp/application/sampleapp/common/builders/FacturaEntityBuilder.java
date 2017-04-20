package io.oasp.application.sampleapp.common.builders;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;

import io.oasp.application.sampleapp.ordermanagement.dataaccess.api.DetalleFacturaEntity;
import io.oasp.application.sampleapp.ordermanagement.dataaccess.api.FacturaEntity;
import io.oasp.application.sampleapp.ordermanagement.dataaccess.api.PedidoEntity;

public class FacturaEntityBuilder {

  private List<P<FacturaEntity>> parameterToBeApplied;

  public FacturaEntityBuilder() {

    this.parameterToBeApplied = new LinkedList<P<FacturaEntity>>();
    fillMandatoryFields();
    fillMandatoryFields_custom();
  }

  public FacturaEntityBuilder pedido(final PedidoEntity pedido) {

    this.parameterToBeApplied.add(new P<FacturaEntity>() {
      @Override
      public void apply(FacturaEntity target) {

        target.setPedido(pedido);
      }
    });
    return this;
  }

  public FacturaEntityBuilder descripcion(final String descripcion) {

    this.parameterToBeApplied.add(new P<FacturaEntity>() {
      @Override
      public void apply(FacturaEntity target) {

        target.setDescripcion(descripcion);
      }
    });
    return this;
  }

  public FacturaEntityBuilder revision(final Number revision) {

    this.parameterToBeApplied.add(new P<FacturaEntity>() {
      @Override
      public void apply(FacturaEntity target) {

        target.setRevision(revision);
      }
    });
    return this;
  }

  public FacturaEntity createNew() {

    FacturaEntity facturaentity = new FacturaEntity();
    for (P<FacturaEntity> parameter : this.parameterToBeApplied) {
      parameter.apply(facturaentity);
    }
    return facturaentity;
  }

  public FacturaEntity persist(EntityManager em) {

    FacturaEntity facturaentity = createNew();
    em.persist(facturaentity);
    return facturaentity;
  }

  public List<FacturaEntity> persistAndDuplicate(EntityManager em, int quantity) {

    List<FacturaEntity> facturaentityList = new LinkedList<FacturaEntity>();
    for (int i = 0; i < quantity; i++) {
      FacturaEntity facturaentity = createNew();
      // TODO alter at least values with unique key constraints to prevent from exceptions while persisting
      em.persist(facturaentity);
      facturaentityList.add(facturaentity);
    }

    return facturaentityList;
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

  public FacturaEntityBuilder pedidoId(final Long pedidoId) {

    this.parameterToBeApplied.add(new P<FacturaEntity>() {
      @Override
      public void apply(FacturaEntity target) {

        target.setPedidoId(pedidoId);
      }
    });
    return this;
  }

  public FacturaEntityBuilder detallesFactura(final List<DetalleFacturaEntity> detallesFactura) {

    parameterToBeApplied.add(new P<FacturaEntity>() {
      @Override
      public void apply(FacturaEntity target) {

        target.setDetallesFactura(detallesFactura);
      }
    });
    return this;
  }

  public FacturaEntityBuilder detallesFacturaIds(final List detallesFacturaIds) {

    parameterToBeApplied.add(new P<FacturaEntity>() {
      @Override
      public void apply(FacturaEntity target) {

        target.setDetallesFacturaIds(detallesFacturaIds);
      }
    });
    return this;
  }

}
