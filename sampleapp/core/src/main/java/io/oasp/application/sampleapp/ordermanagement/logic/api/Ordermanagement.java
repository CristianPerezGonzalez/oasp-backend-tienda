package io.oasp.application.sampleapp.ordermanagement.logic.api;

import java.util.List;

import io.oasp.application.sampleapp.ordermanagement.logic.api.to.ArticuloEto;
import io.oasp.application.sampleapp.ordermanagement.logic.api.to.ArticuloSearchCriteriaTo;
import io.oasp.application.sampleapp.ordermanagement.logic.api.to.ClienteEto;
import io.oasp.application.sampleapp.ordermanagement.logic.api.to.ClienteSearchCriteriaTo;
import io.oasp.application.sampleapp.ordermanagement.logic.api.to.DetalleEto;
import io.oasp.application.sampleapp.ordermanagement.logic.api.to.DetalleFacturaEto;
import io.oasp.application.sampleapp.ordermanagement.logic.api.to.DetalleSearchCriteriaTo;
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
 * Interface for Ordermanagement component.
 */
public interface Ordermanagement extends UcFindArticulo, UcManageArticulo, UcFindCliente, UcManageCliente,
    UcFindDetalle, UcManageDetalle, UcFindPedido, UcManagePedido, UcFindFactura, UcManageFactura, UcFindDetalleFactura,
    UcManageDetalleFactura, UcFindEstado, UcManageEstado {

  /**
   * Returns a Cliente by its id 'id'.
   *
   * @param id The id 'id' of the Cliente.
   * @return The {@link ClienteEto} with id 'id'
   */
  @Override
  ClienteEto findCliente(Long id);

  /**
   * Returns a paginated list of Clientes matching the search criteria.
   *
   * @param criteria the {@link ClienteSearchCriteriaTo}.
   * @return the {@link List} of matching {@link ClienteEto}s.
   */
  @Override
  PaginatedListTo<ClienteEto> findClienteEtos(ClienteSearchCriteriaTo criteria);

  /**
   * Deletes a cliente from the database by its id 'clienteId'.
   *
   * @param clienteId Id of the cliente to delete
   * @return boolean <code>true</code> if the cliente can be deleted, <code>false</code> otherwise
   */
  @Override
  boolean deleteCliente(Long clienteId);

  /**
   * Saves a cliente and store it in the database.
   *
   * @param cliente the {@link ClienteEto} to create.
   * @return the new {@link ClienteEto} that has been saved with ID and version.
   */
  @Override
  ClienteEto saveCliente(ClienteEto cliente);

  /**
   * Returns a Detalle by its id 'id'.
   *
   * @param id The id 'id' of the Detalle.
   * @return The {@link DetalleEto} with id 'id'
   */
  @Override
  DetalleEto findDetalle(Long id);

  /**
   * Returns a paginated list of Detalles matching the search criteria.
   *
   * @param criteria the {@link DetalleSearchCriteriaTo}.
   * @return the {@link List} of matching {@link DetalleEto}s.
   */
  @Override
  PaginatedListTo<DetalleEto> findDetalleEtos(DetalleSearchCriteriaTo criteria);

  /**
   * Deletes a detalle from the database by its id 'detalleId'.
   *
   * @param detalleId Id of the detalle to delete
   * @return boolean <code>true</code> if the detalle can be deleted, <code>false</code> otherwise
   */
  @Override
  boolean deleteDetalle(Long detalleId);

  /**
   * Saves a detalle and store it in the database.
   *
   * @param detalle the {@link DetalleEto} to create.
   * @return the new {@link DetalleEto} that has been saved with ID and version.
   */
  @Override
  DetalleEto saveDetalle(DetalleEto detalle);

  /**
   * Returns a Pedido by its id 'id'.
   *
   * @param id The id 'id' of the Pedido.
   * @return The {@link PedidoEto} with id 'id'
   */
  @Override
  PedidoEto findPedido(Long id);

  /**
   * Returns a paginated list of Pedidos matching the search criteria.
   *
   * @param criteria the {@link PedidoSearchCriteriaTo}.
   * @return the {@link List} of matching {@link PedidoEto}s.
   */
  @Override
  PaginatedListTo<PedidoEto> findPedidoEtos(PedidoSearchCriteriaTo criteria);

  /**
   * Deletes a pedido from the database by its id 'pedidoId'.
   *
   * @param pedidoId Id of the pedido to delete
   * @return boolean <code>true</code> if the pedido can be deleted, <code>false</code> otherwise
   */
  @Override
  boolean deletePedido(Long pedidoId);

  /**
   * Saves a pedido and store it in the database.
   *
   * @param pedido the {@link PedidoEto} to create.
   * @return the new {@link PedidoEto} that has been saved with ID and version.
   */
  @Override
  PedidoEto savePedido(PedidoEto pedido);

  /**
   * Returns a Articulo by its id 'id'.
   *
   * @param id The id 'id' of the Articulo.
   * @return The {@link ArticuloEto} with id 'id'
   */
  @Override
  ArticuloEto findArticulo(Long id);

  /**
   * Returns a paginated list of Articulos matching the search criteria.
   *
   * @param criteria the {@link ArticuloSearchCriteriaTo}.
   * @return the {@link List} of matching {@link ArticuloEto}s.
   */
  @Override
  PaginatedListTo<ArticuloEto> findArticuloEtos(ArticuloSearchCriteriaTo criteria);

  /**
   * Deletes a articulo from the database by its id 'articuloId'.
   *
   * @param articuloId Id of the articulo to delete
   * @return boolean <code>true</code> if the articulo can be deleted, <code>false</code> otherwise
   */
  @Override
  boolean deleteArticulo(Long articuloId);

  /**
   * Saves a articulo and store it in the database.
   *
   * @param articulo the {@link ArticuloEto} to create.
   * @return the new {@link ArticuloEto} that has been saved with ID and version.
   */
  @Override
  ArticuloEto saveArticulo(ArticuloEto articulo);

  /**
   * @return
   */
  @Override
  List<ClienteEto> findAllClientes();

  /**
   * @return
   */
  @Override
  List<PedidoEto> findAllPedidos();

  /**
   * Returns a Factura by its id 'id'.
   *
   * @param id The id 'id' of the Factura.
   * @return The {@link FacturaEto} with id 'id'
   */
  @Override
  FacturaEto findFactura(Long id);

  /**
   * Returns a paginated list of Facturas matching the search criteria.
   *
   * @param criteria the {@link FacturaSearchCriteriaTo}.
   * @return the {@link List} of matching {@link FacturaEto}s.
   */
  @Override
  PaginatedListTo<FacturaEto> findFacturaEtos(FacturaSearchCriteriaTo criteria);

  /**
   * Deletes a factura from the database by its id 'facturaId'.
   *
   * @param facturaId Id of the factura to delete
   * @return boolean <code>true</code> if the factura can be deleted, <code>false</code> otherwise
   */
  @Override
  boolean deleteFactura(Long facturaId);

  /**
   * Saves a factura and store it in the database.
   *
   * @param factura the {@link FacturaEto} to create.
   * @return the new {@link FacturaEto} that has been saved with ID and version.
   */
  @Override
  FacturaEto saveFactura(FacturaEto factura);

  /**
   * @return
   */
  @Override
  List<FacturaEto> findAllFacturas();

  /**
   * @return
   */
  List<DetalleEto> findAllDetalles();

  /**
   * @param id
   * @return
   */
  @Override
  List<DetalleEto> findDetallesByPedido(Long id);

  /**
   * @return
   */
  @Override
  List<DetalleFacturaEto> findAllDetallesFactura();

}
