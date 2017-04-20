package io.oasp.application.sampleapp.ordermanagement.common.api;

import io.oasp.application.sampleapp.general.common.api.ApplicationEntity;

public interface Articulo extends ApplicationEntity {

  public String getNombre();

  public void setNombre(String nombre);

  public Integer getPrecio();

  public void setPrecio(Integer precio);

}
