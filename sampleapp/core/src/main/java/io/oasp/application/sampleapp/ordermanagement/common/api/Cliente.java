package io.oasp.application.sampleapp.ordermanagement.common.api;

import io.oasp.application.sampleapp.general.common.api.ApplicationEntity;

public interface Cliente extends ApplicationEntity {

  @Override
  public Long getId();

  @Override
  public void setId(Long id);

  public String getDni();

  public void setDni(String dni);

  public String getNombre();

  public void setNombre(String nombre);

}
