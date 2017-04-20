package io.oasp.application.sampleapp.ordermanagement.dataaccess.api;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Formula;

import com.fasterxml.jackson.annotation.JsonBackReference;

import io.oasp.application.sampleapp.ordermanagement.common.api.DetalleFactura;
import io.oasp.module.jpa.dataaccess.api.AbstractPersistenceEntity;

/**
 * TODO crperezg This type ...
 *
 * @author crperezg
 * @since 0.0.1
 */
@SuppressWarnings("deprecation")
@Entity
@Table(name = "TDetalleFactura")
public class DetalleFacturaEntity extends AbstractPersistenceEntity implements DetalleFactura {

  /**
   */
  private static final long serialVersionUID = 1L;

  private FacturaEntity factura;

  private ArticuloEntity articulo;

  private int uds;

  @Formula("uds*10")
  private int precio;

  /**
   * @return factura
   */
  @ManyToOne
  @JoinColumn(name = "codfactura")
  @JsonBackReference
  public FacturaEntity getFactura() {

    return this.factura;
  }

  /**
   * @param factura new value of {@link #getfactura}.
   */
  public void setFactura(FacturaEntity factura) {

    this.factura = factura;
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
   * {@inheritDoc}
   */
  @Override
  @Transient
  public Long getFacturaId() {

    if (this.factura == null) {
      return null;
    }
    return this.factura.getId();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setFacturaId(Long facturaId) {

    if (facturaId == null) {
      this.factura = null;
    } else {
      FacturaEntity facturaEntity = new FacturaEntity();
      facturaEntity.setId(facturaId);
      this.factura = facturaEntity;
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

}
