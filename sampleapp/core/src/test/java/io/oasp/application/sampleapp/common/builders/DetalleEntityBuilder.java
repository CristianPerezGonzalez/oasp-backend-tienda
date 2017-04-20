package io.oasp.application.sampleapp.common.builders;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;

import io.oasp.application.sampleapp.ordermanagement.dataaccess.api.ArticuloEntity;
import io.oasp.application.sampleapp.ordermanagement.dataaccess.api.DetalleEntity;
import io.oasp.application.sampleapp.ordermanagement.dataaccess.api.EstadoEntity;
import io.oasp.application.sampleapp.ordermanagement.dataaccess.api.PedidoEntity;

public class DetalleEntityBuilder {

  private List<P<DetalleEntity>> parameterToBeApplied;

  public DetalleEntityBuilder() {

    this.parameterToBeApplied = new LinkedList<P<DetalleEntity>>();
    fillMandatoryFields();
    fillMandatoryFields_custom();
  }

  /**
   * Might be enrichted to users needs (will not be overwritten)
   */
  private void fillMandatoryFields_custom() {

  }

  public DetalleEntity persist(EntityManager em) {

    DetalleEntity detalleentity = createNew();
    em.persist(detalleentity);
    return detalleentity;
  }

  public List<DetalleEntity> persistAndDuplicate(EntityManager em, int quantity) {

    List<DetalleEntity> detalleentityList = new LinkedList<DetalleEntity>();
    for (int i = 0; i < quantity; i++) {
      DetalleEntity detalleentity = createNew();
      // TODO alter at least values with unique key constraints to prevent from exceptions while persisting
      em.persist(detalleentity);
      detalleentityList.add(detalleentity);
    }

    return detalleentityList;
  }

  /**
   * Fills all mandatory fields by default. (will be overwritten on re-generation)
   */
  private void fillMandatoryFields() {

  }

  public DetalleEntityBuilder uds(final int uds) {

    this.parameterToBeApplied.add(new P<DetalleEntity>() {
      @Override
      public void apply(DetalleEntity target) {

        target.setUds(uds);
      }
    });
    return this;
  }

  public DetalleEntityBuilder articulo(final ArticuloEntity articulo) {

    this.parameterToBeApplied.add(new P<DetalleEntity>() {
      @Override
      public void apply(DetalleEntity target) {

        target.setArticulo(articulo);
      }
    });
    return this;
  }

  public DetalleEntityBuilder pedido(final PedidoEntity pedido) {

    this.parameterToBeApplied.add(new P<DetalleEntity>() {
      @Override
      public void apply(DetalleEntity target) {

        target.setPedido(pedido);
      }
    });
    return this;
  }

  public DetalleEntityBuilder revision(final Number revision) {

    this.parameterToBeApplied.add(new P<DetalleEntity>() {
      @Override
      public void apply(DetalleEntity target) {

        target.setRevision(revision);
      }
    });
    return this;
  }

  public DetalleEntityBuilder pedidoId(final Long pedidoId) {

    this.parameterToBeApplied.add(new P<DetalleEntity>() {
      @Override
      public void apply(DetalleEntity target) {

        target.setPedidoId(pedidoId);
      }
    });
    return this;
  }

  public DetalleEntityBuilder articuloId(final Long articuloId) {

    this.parameterToBeApplied.add(new P<DetalleEntity>() {
      @Override
      public void apply(DetalleEntity target) {

        target.setArticuloId(articuloId);
      }
    });
    return this;
  }

  public DetalleEntity createNew() {

    DetalleEntity detalleentity = new DetalleEntity();
    for (P<DetalleEntity> parameter : this.parameterToBeApplied) {
      parameter.apply(detalleentity);
    }
    return detalleentity;
  }

  public DetalleEntityBuilder precio(final int precio) {

    this.parameterToBeApplied.add(new P<DetalleEntity>() {
      @Override
      public void apply(DetalleEntity target) {

        target.setPrecio(precio);
      }
    });
    return this;
  }

  public DetalleEntityBuilder estado(final EstadoEntity estado) {

    this.parameterToBeApplied.add(new P<DetalleEntity>() {
      @Override
      public void apply(DetalleEntity target) {

        target.setEstado(estado);
      }
    });
    return this;
  }

}
