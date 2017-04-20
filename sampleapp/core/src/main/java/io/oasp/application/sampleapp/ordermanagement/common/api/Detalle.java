package io.oasp.application.sampleapp.ordermanagement.common.api;

import io.oasp.application.sampleapp.general.common.api.ApplicationEntity;
import io.oasp.application.sampleapp.ordermanagement.dataaccess.api.EstadoEntity;

public interface Detalle extends ApplicationEntity {

  public Long getPedidoId();

  public void setPedidoId(Long pedidoId);

  public Long getArticuloId();

  public void setArticuloId(Long articuloId);

  public int getUds();

  public void setUds(int uds);

  public int getPrecio();

  public void setPrecio(int precio);

  public EstadoEntity getEstadoId();

  public void setEstadoId(EstadoEntity estadoId);

}
