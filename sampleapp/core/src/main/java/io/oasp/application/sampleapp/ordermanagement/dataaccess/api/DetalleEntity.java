package io.oasp.application.sampleapp.ordermanagement.dataaccess.api;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Formula;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.oasp.application.sampleapp.ordermanagement.common.api.Detalle;
import io.oasp.module.jpa.dataaccess.api.AbstractPersistenceEntity;

/**
 * TODO crperezg This type ...
 *
 * @author crperezg
 * @since 0.0.1
 */
@SuppressWarnings("deprecation")
@Entity
@Table(name = "TDetalle")
@JsonIgnoreProperties(ignoreUnknown = true)
public class DetalleEntity extends AbstractPersistenceEntity implements Detalle {

  /**
   */
  private static final long serialVersionUID = 1L;

  private PedidoEntity pedido;

  private ArticuloEntity articulo;

  private int uds;

  private EstadoEntity estado;

  @Formula("uds*10")
  private int precio;

  /**
   * @return uds
   */
  @Override
  public int getUds() {

    return this.uds;
  }

  /**
   * @param uds new value of {@link #getuds}.
   */
  @Override
  public void setUds(int uds) {

    this.uds = uds;
  }

  /**
   * @return articulo
   */
  @ManyToOne
  @JoinColumn(name = "codarticulo")
  public ArticuloEntity getArticulo() {

    return this.articulo;
  }

  /**
   * @param articulo new value of {@link #getarticulo}.
   */
  public void setArticulo(ArticuloEntity articulo) {

    this.articulo = articulo;
  }

  /**
   * @return pedido
   */
  @ManyToOne
  @JoinColumn(name = "pedidoid")
  @JsonBackReference
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
   * {@inheritDoc}
   */
  @Override
  @Transient
  public Long getArticuloId() {

    if (this.articulo == null) {
      return null;
    }
    return this.articulo.getId();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setArticuloId(Long articuloId) {

    if (articuloId == null) {
      this.articulo = null;
    } else {
      ArticuloEntity articuloEntity = new ArticuloEntity();
      articuloEntity.setId(articuloId);
      this.articulo = articuloEntity;
    }
  }

  /**
   * @return precio
   */
  @Override
  public int getPrecio() {

    return this.precio;
  }

  /**
   * @param precio new value of {@link #getprecio}.
   */
  @Override
  public void setPrecio(int precio) {

    this.precio = precio;
  }

  /**
   * @return estado
   */
  @OneToOne
  // @JoinColumns({ @JoinColumn(name = "codestado", insertable = false, updatable = false),
  @JoinColumn(name = "codestado") // })
  public EstadoEntity getEstado() {

    return this.estado;
  }

  /**
   * @param estado new value of {@link #getestado}.
   */
  public void setEstado(EstadoEntity estado) {

    this.estado = estado;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  @Transient
  public EstadoEntity getEstadoId() {

    if (this.estado == null) {
      return null;
    }
    return this.estado;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setEstadoId(EstadoEntity estadoId) {

    if (estadoId == null) {
      this.estado = null;
    } else {

      this.estado = estadoId;
    }
  }

}
