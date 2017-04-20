package io.oasp.application.sampleapp.ordermanagement.dataaccess.api;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import io.oasp.application.sampleapp.ordermanagement.common.api.Pedido;
import io.oasp.module.jpa.dataaccess.api.AbstractPersistenceEntity;

/**
 * TODO crperezg This type ...
 *
 * @author crperezg
 * @since 0.0.1
 */
@SuppressWarnings("deprecation")
@Entity
@Table(name = "TPedido")
public class PedidoEntity extends AbstractPersistenceEntity implements Pedido {

  /**
   */
  private static final long serialVersionUID = 1L;

  private ClienteEntity cliente;

  private EstadoEntity estado;

  private String descripcion;

  private List<DetalleEntity> detalles = new ArrayList<>();

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
   * @return cliente
   */
  @ManyToOne
  @JoinColumn(name = "codcliente")
  public ClienteEntity getCliente() {

    return this.cliente;
  }

  /**
   * @param cliente new value of {@link #getcliente}.
   */
  public void setCliente(ClienteEntity cliente) {

    this.cliente = cliente;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  @Transient
  public Long getClienteId() {

    if (this.cliente == null) {
      return null;
    }
    return this.cliente.getId();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setClienteId(Long clienteId) {

    if (clienteId == null) {
      this.cliente = null;
    } else {
      ClienteEntity clienteEntity = new ClienteEntity();
      clienteEntity.setId(clienteId);
      this.cliente = clienteEntity;
    }
  }

  /**
   * @return estado
   */
  @OneToOne
  @JoinColumn(name = "codestado")
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

  /**
   * @return detalles
   */
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "pedido", orphanRemoval = true)
  @JsonManagedReference
  public List<DetalleEntity> getDetalles() {

    return this.detalles;
  }

  /**
   * @param detalles new value of {@link #getdetalles}.
   */
  public void setDetalles(List<DetalleEntity> detalles) {

    this.detalles = detalles;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  @Transient
  public List<DetalleEntity> getDetalleIds() {

    if (this.detalles == null) {
      return null;
    }
    return this.detalles;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setDetalleIds(List<DetalleEntity> detalleIds) {

    if (detalleIds == null) {
      this.detalles = null;
    } else {
      this.detalles = detalleIds;
    }
  }

}
