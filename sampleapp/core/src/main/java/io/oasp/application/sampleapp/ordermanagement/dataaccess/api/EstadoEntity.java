package io.oasp.application.sampleapp.ordermanagement.dataaccess.api;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.oasp.application.sampleapp.ordermanagement.common.api.Estado;
import io.oasp.module.jpa.dataaccess.api.AbstractPersistenceEntity;

/**
 * TODO crperezg This type ...
 *
 * @author crperezg
 * @since 0.0.1
 */
@Entity
@Table(name = "TEstado")
public class EstadoEntity extends AbstractPersistenceEntity implements Estado {

  private String codestado;

  private String descripcion;

  private static final long serialVersionUID = 1L;

  /**
   * @return codestado
   */
  @Override
  @Column(unique = true)
  public String getCodestado() {

    return this.codestado;
  }

  /**
   * @param codestado new value of {@link #getcodestado}.
   */
  @Override
  public void setCodestado(String codestado) {

    this.codestado = codestado;
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

}
