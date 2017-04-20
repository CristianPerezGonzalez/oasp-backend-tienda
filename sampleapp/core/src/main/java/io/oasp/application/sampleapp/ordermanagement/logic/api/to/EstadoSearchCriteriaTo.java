package io.oasp.application.sampleapp.ordermanagement.logic.api.to;

import io.oasp.module.jpa.common.api.to.SearchCriteriaTo;

/**
 * This is the {@link SearchCriteriaTo search criteria} {@link net.sf.mmm.util.transferobject.api.TransferObject TO}
 * used to find {@link io.oasp.application.sampleapp.ordermanagement.common.api.Estado}s.
 */
public class EstadoSearchCriteriaTo extends SearchCriteriaTo {

  private static final long serialVersionUID = 1L;

  private String codestado;

  private String descripcion;

  /**
   * The constructor.
   */
  public EstadoSearchCriteriaTo() {

    super();
  }

  public String getCodestado() {

    return codestado;
  }

  public void setCodestado(String codestado) {

    this.codestado = codestado;
  }

  public String getDescripcion() {

    return descripcion;
  }

  public void setDescripcion(String descripcion) {

    this.descripcion = descripcion;
  }

}
