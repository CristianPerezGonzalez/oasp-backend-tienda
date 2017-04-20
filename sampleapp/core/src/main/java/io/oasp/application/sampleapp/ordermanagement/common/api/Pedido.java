package io.oasp.application.sampleapp.ordermanagement.common.api;

import java.util.List;

import io.oasp.application.sampleapp.general.common.api.ApplicationEntity;
import io.oasp.application.sampleapp.ordermanagement.dataaccess.api.DetalleEntity;
import io.oasp.application.sampleapp.ordermanagement.dataaccess.api.EstadoEntity;

public interface Pedido extends ApplicationEntity {

  public Long getClienteId();

  public void setClienteId(Long clienteId);

  public String getDescripcion();

  public void setDescripcion(String descripcion);

  public EstadoEntity getEstadoId();

  public void setEstadoId(EstadoEntity estadoId);

  public List<DetalleEntity> getDetalleIds();

  public void setDetalleIds(List<DetalleEntity> detalleIds);

}
