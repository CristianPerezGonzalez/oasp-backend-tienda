package io.oasp.application.sampleapp.ordermanagement.logic.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.oasp.application.sampleapp.general.logic.api.UseCase;
import io.oasp.application.sampleapp.general.logic.base.AbstractComponentFacade;
import io.oasp.application.sampleapp.ordermanagement.dataaccess.api.dao.ArticuloDao;
import io.oasp.application.sampleapp.ordermanagement.dataaccess.api.dao.ClienteDao;
import io.oasp.application.sampleapp.ordermanagement.dataaccess.api.dao.DetalleDao;
import io.oasp.application.sampleapp.ordermanagement.dataaccess.api.dao.FacturaDao;
import io.oasp.application.sampleapp.ordermanagement.dataaccess.api.dao.PedidoDao;
import io.oasp.application.sampleapp.ordermanagement.logic.api.Ordermanagement;
import io.oasp.application.sampleapp.ordermanagement.logic.api.to.ArticuloEto;
import io.oasp.application.sampleapp.ordermanagement.logic.api.to.ArticuloSearchCriteriaTo;
import io.oasp.application.sampleapp.ordermanagement.logic.api.to.ClienteEto;
import io.oasp.application.sampleapp.ordermanagement.logic.api.to.ClienteSearchCriteriaTo;
import io.oasp.application.sampleapp.ordermanagement.logic.api.to.DetalleEto;
import io.oasp.application.sampleapp.ordermanagement.logic.api.to.DetalleFacturaEto;
import io.oasp.application.sampleapp.ordermanagement.logic.api.to.DetalleFacturaSearchCriteriaTo;
import io.oasp.application.sampleapp.ordermanagement.logic.api.to.DetalleSearchCriteriaTo;
import io.oasp.application.sampleapp.ordermanagement.logic.api.to.EstadoEto;
import io.oasp.application.sampleapp.ordermanagement.logic.api.to.EstadoSearchCriteriaTo;
import io.oasp.application.sampleapp.ordermanagement.logic.api.to.FacturaEto;
import io.oasp.application.sampleapp.ordermanagement.logic.api.to.FacturaSearchCriteriaTo;
import io.oasp.application.sampleapp.ordermanagement.logic.api.to.PedidoEto;
import io.oasp.application.sampleapp.ordermanagement.logic.api.to.PedidoSearchCriteriaTo;
import io.oasp.application.sampleapp.ordermanagement.logic.api.usecase.UcFindArticulo;
import io.oasp.application.sampleapp.ordermanagement.logic.api.usecase.UcFindCliente;
import io.oasp.application.sampleapp.ordermanagement.logic.api.usecase.UcFindDetalle;
import io.oasp.application.sampleapp.ordermanagement.logic.api.usecase.UcFindDetalleFactura;
import io.oasp.application.sampleapp.ordermanagement.logic.api.usecase.UcFindEstado;
import io.oasp.application.sampleapp.ordermanagement.logic.api.usecase.UcFindFactura;
import io.oasp.application.sampleapp.ordermanagement.logic.api.usecase.UcFindPedido;
import io.oasp.application.sampleapp.ordermanagement.logic.api.usecase.UcManageArticulo;
import io.oasp.application.sampleapp.ordermanagement.logic.api.usecase.UcManageCliente;
import io.oasp.application.sampleapp.ordermanagement.logic.api.usecase.UcManageDetalle;
import io.oasp.application.sampleapp.ordermanagement.logic.api.usecase.UcManageDetalleFactura;
import io.oasp.application.sampleapp.ordermanagement.logic.api.usecase.UcManageEstado;
import io.oasp.application.sampleapp.ordermanagement.logic.api.usecase.UcManageFactura;
import io.oasp.application.sampleapp.ordermanagement.logic.api.usecase.UcManagePedido;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * Implementation of component interface of ordermanagement
 */
@Named
public class OrdermanagementImpl extends AbstractComponentFacade implements Ordermanagement {

  private UcFindArticulo ucFindArticulo;

  private UcManageArticulo ucManageArticulo;

  private UcFindCliente ucFindCliente;

  private UcManageCliente ucManageCliente;

  private UcFindDetalle ucFindDetalle;

  private UcManageDetalle ucManageDetalle;

  private UcFindPedido ucFindPedido;

  private UcManagePedido ucManagePedido;

  /**
   * Logger instance.
   */
  private static final Logger LOG = LoggerFactory.getLogger(OrdermanagementImpl.class);

  /**
   * @see #getArticuloDao()
   */
  private ArticuloDao articuloDao;

  /**
   * @see #getClienteDao()
   */
  private ClienteDao clienteDao;

  /**
   * @see #getDetalleDao()
   */
  private DetalleDao detalleDao;

  /**
   * @see #getPedidoDao()
   */
  private PedidoDao pedidoDao;

  private UcFindFactura ucFindFactura;

  private UcManageFactura ucManageFactura;

  /**
   * @see #getFacturaDao()
   */
  private FacturaDao facturaDao;

  private UcFindDetalleFactura ucFindDetalleFactura;

  private UcManageDetalleFactura ucManageDetalleFactura;

  private UcFindEstado ucFindEstado;

  private UcManageEstado ucManageEstado;

  /**
   * The constructor.
   */
  public OrdermanagementImpl() {

    super();
  }

  @Override
  public ArticuloEto findArticulo(Long id) {

    return this.ucFindArticulo.findArticulo(id);
  }

  @Override
  public PaginatedListTo<ArticuloEto> findArticuloEtos(ArticuloSearchCriteriaTo criteria) {

    return this.ucFindArticulo.findArticuloEtos(criteria);
  }

  @Override
  public ArticuloEto saveArticulo(ArticuloEto articulo) {

    return this.ucManageArticulo.saveArticulo(articulo);
  }

  @Override
  public boolean deleteArticulo(Long id) {

    return this.ucManageArticulo.deleteArticulo(id);
  }

  /**
   * Sets the field 'ucFindArticulo'.
   *
   * @param ucFindArticulo New value for ucFindArticulo
   */
  @Inject
  @UseCase
  public void setUcFindArticulo(UcFindArticulo ucFindArticulo) {

    this.ucFindArticulo = ucFindArticulo;
  }

  /**
   * Sets the field 'ucManageArticulo'.
   *
   * @param ucManageArticulo New value for ucManageArticulo
   */
  @Inject
  @UseCase
  public void setUcManageArticulo(UcManageArticulo ucManageArticulo) {

    this.ucManageArticulo = ucManageArticulo;
  }

  @Override
  public List<ArticuloEto> findAllArticulos() {

    return this.ucFindArticulo.findAllArticulos();
  }

  @Override
  public List<ClienteEto> findAllClientes() {

    return this.ucFindCliente.findAllClientes();
  }

  @Override
  public List<FacturaEto> findAllFacturas() {

    return this.ucFindFactura.findAllFacturas();
  }

  @Override
  public List<PedidoEto> findAllPedidos() {

    return this.ucFindPedido.findAllPedidos();
  }

  @Override
  public List<DetalleEto> findAllDetalles() {

    return this.ucFindDetalle.findDetalles();
  }

  @Override
  public ClienteEto findCliente(Long id) {

    return this.ucFindCliente.findCliente(id);
  }

  @Override
  public PaginatedListTo<ClienteEto> findClienteEtos(ClienteSearchCriteriaTo criteria) {

    return this.ucFindCliente.findClienteEtos(criteria);
  }

  @Override
  public ClienteEto saveCliente(ClienteEto cliente) {

    return this.ucManageCliente.saveCliente(cliente);
  }

  @Override
  public boolean deleteCliente(Long id) {

    return this.ucManageCliente.deleteCliente(id);
  }

  /**
   * Sets the field 'ucFindCliente'.
   *
   * @param ucFindCliente New value for ucFindCliente
   */
  @Inject
  @UseCase
  public void setUcFindCliente(UcFindCliente ucFindCliente) {

    this.ucFindCliente = ucFindCliente;
  }

  /**
   * Sets the field 'ucManageCliente'.
   *
   * @param ucManageCliente New value for ucManageCliente
   */
  @Inject
  @UseCase
  public void setUcManageCliente(UcManageCliente ucManageCliente) {

    this.ucManageCliente = ucManageCliente;
  }

  @Override
  public DetalleEto findDetalle(Long id) {

    return this.ucFindDetalle.findDetalle(id);
  }

  @Override
  public PaginatedListTo<DetalleEto> findDetalleEtos(DetalleSearchCriteriaTo criteria) {

    return this.ucFindDetalle.findDetalleEtos(criteria);
  }

  @Override
  public DetalleEto saveDetalle(DetalleEto detalle) {

    return this.ucManageDetalle.saveDetalle(detalle);
  }

  @Override
  public boolean deleteDetalle(Long id) {

    return this.ucManageDetalle.deleteDetalle(id);
  }

  /**
   * Sets the field 'ucFindDetalle'.
   *
   * @param ucFindDetalle New value for ucFindDetalle
   */
  @Inject
  @UseCase
  public void setUcFindDetalle(UcFindDetalle ucFindDetalle) {

    this.ucFindDetalle = ucFindDetalle;
  }

  /**
   * Sets the field 'ucManageDetalle'.
   *
   * @param ucManageDetalle New value for ucManageDetalle
   */
  @Inject
  @UseCase
  public void setUcManageDetalle(UcManageDetalle ucManageDetalle) {

    this.ucManageDetalle = ucManageDetalle;
  }

  @Override
  public PedidoEto findPedido(Long id) {

    return this.ucFindPedido.findPedido(id);
  }

  @Override
  public PaginatedListTo<PedidoEto> findPedidoEtos(PedidoSearchCriteriaTo criteria) {

    return this.ucFindPedido.findPedidoEtos(criteria);
  }

  @Override
  public PedidoEto savePedido(PedidoEto pedido) {

    return this.ucManagePedido.savePedido(pedido);
  }

  @Override
  public boolean deletePedido(Long id) {

    return this.ucManagePedido.deletePedido(id);
  }

  /**
   * Sets the field 'ucFindPedido'.
   *
   * @param ucFindPedido New value for ucFindPedido
   */
  @Inject
  @UseCase
  public void setUcFindPedido(UcFindPedido ucFindPedido) {

    this.ucFindPedido = ucFindPedido;
  }

  /**
   * Sets the field 'ucManagePedido'.
   *
   * @param ucManagePedido New value for ucManagePedido
   */
  @Inject
  @UseCase
  public void setUcManagePedido(UcManagePedido ucManagePedido) {

    this.ucManagePedido = ucManagePedido;
  }

  /**
   * Returns the field 'articuloDao'.
   *
   * @return the {@link ArticuloDao} instance.
   */
  public ArticuloDao getArticuloDao() {

    return this.articuloDao;
  }

  /**
   * Sets the field 'articuloDao'.
   *
   * @param articuloDao New value for articuloDao
   */
  @Inject
  public void setArticuloDao(ArticuloDao articuloDao) {

    this.articuloDao = articuloDao;
  }

  /**
   * Returns the field 'clienteDao'.
   *
   * @return the {@link ClienteDao} instance.
   */
  public ClienteDao getClienteDao() {

    return this.clienteDao;
  }

  /**
   * Sets the field 'clienteDao'.
   *
   * @param clienteDao New value for clienteDao
   */
  @Inject
  public void setClienteDao(ClienteDao clienteDao) {

    this.clienteDao = clienteDao;
  }

  /**
   * Returns the field 'detalleDao'.
   *
   * @return the {@link DetalleDao} instance.
   */
  public DetalleDao getDetalleDao() {

    return this.detalleDao;
  }

  /**
   * Sets the field 'detalleDao'.
   *
   * @param detalleDao New value for detalleDao
   */
  @Inject
  public void setDetalleDao(DetalleDao detalleDao) {

    this.detalleDao = detalleDao;
  }

  /**
   * Returns the field 'pedidoDao'.
   *
   * @return the {@link PedidoDao} instance.
   */
  public PedidoDao getPedidoDao() {

    return this.pedidoDao;
  }

  /**
   * Sets the field 'pedidoDao'.
   *
   * @param pedidoDao New value for pedidoDao
   */
  @Inject
  public void setPedidoDao(PedidoDao pedidoDao) {

    this.pedidoDao = pedidoDao;
  }

  @Override
  public FacturaEto findFactura(Long id) {

    return this.ucFindFactura.findFactura(id);
  }

  @Override
  public PaginatedListTo<FacturaEto> findFacturaEtos(FacturaSearchCriteriaTo criteria) {

    return this.ucFindFactura.findFacturaEtos(criteria);
  }

  @Override
  public FacturaEto saveFactura(FacturaEto factura) {

    return this.ucManageFactura.saveFactura(factura);
  }

  @Override
  public boolean deleteFactura(Long id) {

    return this.ucManageFactura.deleteFactura(id);
  }

  /**
   * Sets the field 'ucFindFactura'.
   *
   * @param ucFindFactura New value for ucFindFactura
   */
  @Inject
  @UseCase
  public void setUcFindFactura(UcFindFactura ucFindFactura) {

    this.ucFindFactura = ucFindFactura;
  }

  /**
   * Sets the field 'ucManageFactura'.
   *
   * @param ucManageFactura New value for ucManageFactura
   */
  @Inject
  @UseCase
  public void setUcManageFactura(UcManageFactura ucManageFactura) {

    this.ucManageFactura = ucManageFactura;
  }

  /**
   * Returns the field 'facturaDao'.
   *
   * @return the {@link FacturaDao} instance.
   */
  public FacturaDao getFacturaDao() {

    return this.facturaDao;
  }

  /**
   * Sets the field 'facturaDao'.
   *
   * @param facturaDao New value for facturaDao
   */
  @Inject
  public void setFacturaDao(FacturaDao facturaDao) {

    this.facturaDao = facturaDao;
  }

  @Override
  public List<DetalleEto> findDetalles() {

    return this.ucFindDetalle.findDetalles();
  }

  @Override
  public List<DetalleEto> findDetallesByPedido(Long id) {

    return this.ucFindDetalle.findDetallesByPedido(id);
  }

  @Override
  public DetalleFacturaEto findDetalleFactura(Long id) {

    return this.ucFindDetalleFactura.findDetalleFactura(id);
  }

  @Override
  public PaginatedListTo<DetalleFacturaEto> findDetalleFacturaEtos(DetalleFacturaSearchCriteriaTo criteria) {

    return this.ucFindDetalleFactura.findDetalleFacturaEtos(criteria);
  }

  @Override
  public DetalleFacturaEto saveDetalleFactura(DetalleFacturaEto detallefactura) {

    return this.ucManageDetalleFactura.saveDetalleFactura(detallefactura);
  }

  @Override
  public boolean deleteDetalleFactura(Long id) {

    return this.ucManageDetalleFactura.deleteDetalleFactura(id);
  }

  /**
   * Sets the field 'ucFindDetalleFactura'.
   *
   * @param ucFindDetalleFactura New value for ucFindDetalleFactura
   */
  @Inject
  @UseCase
  public void setUcFindDetalleFactura(UcFindDetalleFactura ucFindDetalleFactura) {

    this.ucFindDetalleFactura = ucFindDetalleFactura;
  }

  /**
   * Sets the field 'ucManageDetalleFactura'.
   *
   * @param ucManageDetalleFactura New value for ucManageDetalleFactura
   */
  @Inject
  @UseCase
  public void setUcManageDetalleFactura(UcManageDetalleFactura ucManageDetalleFactura) {

    this.ucManageDetalleFactura = ucManageDetalleFactura;
  }

  @Override
  public List<DetalleFacturaEto> findAllDetallesFactura() {

    return this.ucFindDetalleFactura.findAllDetallesFactura();
  }

  @Override
  public EstadoEto findEstado(Long id) {

    return this.ucFindEstado.findEstado(id);
  }

  @Override
  public PaginatedListTo<EstadoEto> findEstadoEtos(EstadoSearchCriteriaTo criteria) {

    return this.ucFindEstado.findEstadoEtos(criteria);
  }

  @Override
  public EstadoEto saveEstado(EstadoEto estado) {

    return this.ucManageEstado.saveEstado(estado);
  }

  @Override
  public boolean deleteEstado(Long id) {

    return this.ucManageEstado.deleteEstado(id);
  }

  /**
   * Sets the field 'ucFindEstado'.
   *
   * @param ucFindEstado New value for ucFindEstado
   */
  @Inject
  @UseCase
  public void setUcFindEstado(UcFindEstado ucFindEstado) {

    this.ucFindEstado = ucFindEstado;
  }

  /**
   * Sets the field 'ucManageEstado'.
   *
   * @param ucManageEstado New value for ucManageEstado
   */
  @Inject
  @UseCase
  public void setUcManageEstado(UcManageEstado ucManageEstado) {

    this.ucManageEstado = ucManageEstado;
  }

}
