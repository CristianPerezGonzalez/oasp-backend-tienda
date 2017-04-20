package io.oasp.application.sampleapp.ordermanagement.logic.api.to;

import io.oasp.module.jpa.common.api.to.SearchCriteriaTo;

/**
 * This is the {@link SearchCriteriaTo search criteria} {@link net.sf.mmm.util.transferobject.api.TransferObject TO}
 * used to find {@link io.oasp.application.sampleapp.ordermanagement.common.api.Cliente}s.
 */
public class ClienteSearchCriteriaTo extends SearchCriteriaTo {

  private static final long serialVersionUID = 1L;

  private Long id;

  private String dni;

  private String nombre;

  private Long codcliente;

  /**
   * The constructor.
   */
  public ClienteSearchCriteriaTo() {

    super();
  }

  public Long getId() {

    return id;
  }

  public void setId(Long id) {

    this.id = id;
  }

  public String getDni() {

    return dni;
  }

  public void setDni(String dni) {

    this.dni = dni;
  }

  public String getNombre() {

    return nombre;
  }

  public void setNombre(String nombre) {

    this.nombre = nombre;
  }

  public Long getCodcliente() {

    return codcliente;
  }

  public void setCodcliente(Long codcliente) {

    this.codcliente = codcliente;
  }

}
