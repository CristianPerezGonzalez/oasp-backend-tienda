package io.oasp.application.sampleapp.ordermanagement.common.api;

import io.oasp.application.sampleapp.general.common.api.ApplicationEntity;

public interface Estado extends ApplicationEntity {

  public String getCodestado();

  public void setCodestado(String codestado);

  public String getDescripcion();

  public void setDescripcion(String descripcion);

}
