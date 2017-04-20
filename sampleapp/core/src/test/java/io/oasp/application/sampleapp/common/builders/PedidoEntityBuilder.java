package io.oasp.application.sampleapp.common.builders;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;

import io.oasp.application.sampleapp.ordermanagement.dataaccess.api.ClienteEntity;
import io.oasp.application.sampleapp.ordermanagement.dataaccess.api.DetalleEntity;
import io.oasp.application.sampleapp.ordermanagement.dataaccess.api.EstadoEntity;
import io.oasp.application.sampleapp.ordermanagement.dataaccess.api.PedidoEntity;

public class PedidoEntityBuilder {

  private List<P<PedidoEntity>> parameterToBeApplied;

  public PedidoEntityBuilder() {

    this.parameterToBeApplied = new LinkedList<P<PedidoEntity>>();
    fillMandatoryFields();
    fillMandatoryFields_custom();
  }

  /**
   * Might be enrichted to users needs (will not be overwritten)
   */
  private void fillMandatoryFields_custom() {

  }

  public PedidoEntity persist(EntityManager em) {

    PedidoEntity pedidoentity = createNew();
    em.persist(pedidoentity);
    return pedidoentity;
  }

  public List<PedidoEntity> persistAndDuplicate(EntityManager em, int quantity) {

    List<PedidoEntity> pedidoentityList = new LinkedList<PedidoEntity>();
    for (int i = 0; i < quantity; i++) {
      PedidoEntity pedidoentity = createNew();
      // TODO alter at least values with unique key constraints to prevent from exceptions while persisting
      em.persist(pedidoentity);
      pedidoentityList.add(pedidoentity);
    }

    return pedidoentityList;
  }

  /**
   * Fills all mandatory fields by default. (will be overwritten on re-generation)
   */
  private void fillMandatoryFields() {

  }

  public PedidoEntityBuilder descripcion(final String descripcion) {

    this.parameterToBeApplied.add(new P<PedidoEntity>() {
      @Override
      public void apply(PedidoEntity target) {

        target.setDescripcion(descripcion);
      }
    });
    return this;
  }

  public PedidoEntityBuilder cliente(final ClienteEntity cliente) {

    this.parameterToBeApplied.add(new P<PedidoEntity>() {
      @Override
      public void apply(PedidoEntity target) {

        target.setCliente(cliente);
      }
    });
    return this;
  }

  public PedidoEntityBuilder revision(final Number revision) {

    this.parameterToBeApplied.add(new P<PedidoEntity>() {
      @Override
      public void apply(PedidoEntity target) {

        target.setRevision(revision);
      }
    });
    return this;
  }

  public PedidoEntityBuilder clienteId(final Long clienteId) {

    this.parameterToBeApplied.add(new P<PedidoEntity>() {
      @Override
      public void apply(PedidoEntity target) {

        target.setClienteId(clienteId);
      }
    });
    return this;
  }

  public PedidoEntity createNew() {

    PedidoEntity pedidoentity = new PedidoEntity();
    for (P<PedidoEntity> parameter : this.parameterToBeApplied) {
      parameter.apply(pedidoentity);
    }
    return pedidoentity;
  }

  public PedidoEntityBuilder estado(final EstadoEntity estado) {

    this.parameterToBeApplied.add(new P<PedidoEntity>() {
      @Override
      public void apply(PedidoEntity target) {

        target.setEstado(estado);
      }
    });
    return this;
  }

  public PedidoEntityBuilder detalles(final List<DetalleEntity> detalles) {

    this.parameterToBeApplied.add(new P<PedidoEntity>() {
      @Override
      public void apply(PedidoEntity target) {

        target.setDetalles(detalles);
      }
    });
    return this;
  }

  public PedidoEntityBuilder estadoId(final EstadoEntity estadoId) {

    this.parameterToBeApplied.add(new P<PedidoEntity>() {
      @Override
      public void apply(PedidoEntity target) {

        target.setEstadoId(estadoId);
      }
    });
    return this;
  }

}
