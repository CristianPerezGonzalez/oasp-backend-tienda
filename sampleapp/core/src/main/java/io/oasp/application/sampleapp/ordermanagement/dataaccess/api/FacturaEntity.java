package io.oasp.application.sampleapp.ordermanagement.dataaccess.api;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import io.oasp.application.sampleapp.ordermanagement.common.api.Factura;
import io.oasp.module.jpa.dataaccess.api.AbstractPersistenceEntity;

/**
 * TODO crperezg This type ...
 *
 * @author crperezg
 * @since 0.0.1
 */
@SuppressWarnings("deprecation")
@Entity
@Table(name = "TFactura")
public class FacturaEntity extends AbstractPersistenceEntity implements Factura {

  /**
   */
  private static final long serialVersionUID = 1L;

  private PedidoEntity pedido;

  private String descripcion;

  private List<DetalleFacturaEntity> detallesFactura = new ArrayList<DetalleFacturaEntity>();

  /**
   * @return pedido
   */
  @ManyToOne
  @JoinColumn(name = "codpedido")
  public PedidoEntity getPedido() {

    return this.pedido;
  }

  /**
   * @param pedido new value of {@link #getpedido}.
   */
  public void setPedido(PedidoEntity pedido) {

    this.pedido = pedido;
  }

  /**
   * @return descripcion
   */
  @Override
  public String getDescripcion() {

    return this.descripcion;
  }

  /**
   * @param descripcion new value of {@link #getdescripcion}.
   */
  @Override
  public void setDescripcion(String descripcion) {

    this.descripcion = descripcion;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  @Transient
  public Long getPedidoId() {

    if (this.pedido == null) {
      return null;
    }
    return this.pedido.getId();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setPedidoId(Long pedidoId) {

    if (pedidoId == null) {
      this.pedido = null;
    } else {
      PedidoEntity pedidoEntity = new PedidoEntity();
      pedidoEntity.setId(pedidoId);
      this.pedido = pedidoEntity;
    }
  }

  /**
   * @return detallesFactura
   */
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "factura", orphanRemoval = true)
  @JsonManagedReference
  public List<DetalleFacturaEntity> getDetallesFactura() {

    return this.detallesFactura;
  }

  /**
   * @param detallesFactura new value of {@link #getdetallesFactura}.
   */
  public void setDetallesFactura(List<DetalleFacturaEntity> detallesFactura) {

    this.detallesFactura = detallesFactura;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  @Transient
  public List<DetalleFacturaEntity> getDetallesFacturaIds() {

    if (this.detallesFactura == null) {
      return null;
    }

    return this.detallesFactura;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setDetallesFacturaIds(List<DetalleFacturaEntity> detallesFacturaIds) {

    if (detallesFacturaIds == null) {
      this.detallesFactura = null;
    } else {

      this.detallesFactura.addAll(detallesFacturaIds);

      this.detallesFactura = detallesFacturaIds;

    }
  }

}
