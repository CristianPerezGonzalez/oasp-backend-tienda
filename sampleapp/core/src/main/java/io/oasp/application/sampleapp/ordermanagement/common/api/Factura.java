package io.oasp.application.sampleapp.ordermanagement.common.api;

import java.util.List;

import io.oasp.application.sampleapp.general.common.api.ApplicationEntity;
import io.oasp.application.sampleapp.ordermanagement.dataaccess.api.DetalleFacturaEntity;

public interface Factura extends ApplicationEntity {

  public Long getPedidoId();

  public void setPedidoId(Long pedidoId);

  public String getDescripcion();

  public void setDescripcion(String descripcion);

  public List<DetalleFacturaEntity> getDetallesFacturaIds();

  public void setDetallesFacturaIds(List<DetalleFacturaEntity> detallesFacturaIds);

}
