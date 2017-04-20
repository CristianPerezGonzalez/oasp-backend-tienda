package io.oasp.application.sampleapp.ordermanagement.common.api;

import io.oasp.application.sampleapp.general.common.api.ApplicationEntity;

public interface DetalleFactura extends ApplicationEntity {

  public Long getFacturaId();

  public void setFacturaId(Long facturaId);

  public Long getArticuloId();

  public void setArticuloId(Long articuloId);

  public int getUds();

  public void setUds(int uds);

  public int getPrecio();

  public void setPrecio(int precio);

}
