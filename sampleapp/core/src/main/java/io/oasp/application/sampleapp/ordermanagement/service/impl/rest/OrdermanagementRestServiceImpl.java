package io.oasp.application.sampleapp.ordermanagement.service.impl.rest;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.transaction.annotation.Transactional;

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
import io.oasp.application.sampleapp.ordermanagement.logic.api.usecase.UcFindDetalle;
import io.oasp.application.sampleapp.ordermanagement.logic.api.usecase.UcFindDetalleFactura;
import io.oasp.application.sampleapp.ordermanagement.logic.api.usecase.UcFindEstado;
import io.oasp.application.sampleapp.ordermanagement.logic.api.usecase.UcFindFactura;
import io.oasp.application.sampleapp.ordermanagement.logic.api.usecase.UcManageDetalleFactura;
import io.oasp.application.sampleapp.ordermanagement.logic.api.usecase.UcManageEstado;
import io.oasp.application.sampleapp.ordermanagement.logic.api.usecase.UcManageFactura;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * The service class for REST calls in order to execute the methods in {@link Ordermanagement}.
 */
@Path("/ordermanagement/v1")
@Named("OrdermanagementRestService")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Transactional
public class OrdermanagementRestServiceImpl {

  private Ordermanagement ordermanagement;

  /**
   * This method sets the field <tt>detallefacturaManagement</tt>.
   *
   * @param detallefacturaManagement the new value of the field detallefacturaManagement
   */
  @Inject
  public void setDetalleFacturaManagement(Ordermanagement detallefacturaManagement) {

    this.ordermanagement = detallefacturaManagement;
  }

  /**
   * Delegates to {@link UcFindDetalleFactura#findDetalleFactura}.
   *
   * @param id the ID of the {@link DetalleFacturaEto}
   * @return the {@link DetalleFacturaEto}
   */
  @GET
  @Path("/detallefactura/{id}/")
  public DetalleFacturaEto getDetalleFactura(@PathParam("id") String id) {

    Long idAsLong;
    if (id == null) {
      throw new BadRequestException("missing id");
    }
    try {
      idAsLong = Long.parseLong(id);
    } catch (NumberFormatException e) {
      throw new BadRequestException("id is not a number");
    } catch (NotFoundException e) {
      throw new BadRequestException("detallefactura not found");
    }
    return this.ordermanagement.findDetalleFactura(idAsLong);
  }

  /**
   * Delegates to {@link UcManageDetalleFactura#createDetalleFactura}.
   *
   * @param detallefactura the {@link DetalleFacturaEto} to be created
   * @return the recently created {@link DetalleFacturaEto}
   */
  @POST
  @Path("/detallefactura/")
  public DetalleFacturaEto saveDetalleFactura(DetalleFacturaEto detallefactura) {

    return this.ordermanagement.saveDetalleFactura(detallefactura);
  }

  /**
   * Delegates to {@link UcManageDetalleFactura#deleteDetalleFactura}.
   *
   * @param id ID of the {@link DetalleFacturaEto} to be deleted
   */
  @DELETE
  @Path("/detallefactura/{id}/")
  public void deleteDetalleFactura(@PathParam("id") String id) {

    Long idAsLong;
    if (id == null) {
      throw new BadRequestException("missing id");
    }
    try {
      idAsLong = Long.parseLong(id);
    } catch (NumberFormatException e) {
      throw new BadRequestException("id is not a number");
    } catch (NotFoundException e) {
      throw new BadRequestException("detallefactura not found");
    }
    this.ordermanagement.deleteDetalleFactura(idAsLong);
  }

  /**
   * Delegates to {@link UcFindDetalleFactura#findDetalleFacturaEtos}.
   *
   * @param searchCriteriaTo the pagination and search criteria to be used for finding detallefacturas.
   * @return the {@link PaginatedListTo list} of matching {@link DetalleFacturaEto}s.
   */
  @Path("/detallefactura/search")
  @POST
  public PaginatedListTo<DetalleFacturaEto> findDetalleFacturasByPost(DetalleFacturaSearchCriteriaTo searchCriteriaTo) {

    return this.ordermanagement.findDetalleFacturaEtos(searchCriteriaTo);
  }

  /**
   * This method sets the field <tt>facturaManagement</tt>.
   *
   * @param facturaManagement the new value of the field facturaManagement
   */
  @Inject
  public void setFacturaManagement(Ordermanagement facturaManagement) {

    this.ordermanagement = facturaManagement;
  }

  /**
   * Delegates to {@link UcFindFactura#findFactura}.
   *
   * @param id the ID of the {@link FacturaEto}
   * @return the {@link FacturaEto}
   */
  @GET
  @Path("/factura/{id}/")
  public FacturaEto getFactura(@PathParam("id") String id) {

    Long idAsLong;
    if (id == null) {
      throw new BadRequestException("missing id");
    }
    try {
      idAsLong = Long.parseLong(id);
    } catch (NumberFormatException e) {
      throw new BadRequestException("id is not a number");
    } catch (NotFoundException e) {
      throw new BadRequestException("factura not found");
    }
    return this.ordermanagement.findFactura(idAsLong);
  }

  /**
   * Delegates to {@link UcManageFactura#createFactura}.
   *
   * @param factura the {@link FacturaEto} to be created
   * @return the recently created {@link FacturaEto}
   */
  @POST
  @Path("/factura/")
  public FacturaEto saveFactura(FacturaEto factura) {

    return this.ordermanagement.saveFactura(factura);
  }

  /**
   * Delegates to {@link UcManageFactura#deleteFactura}.
   *
   * @param id ID of the {@link FacturaEto} to be deleted
   */
  @DELETE
  @Path("/factura/{id}/")
  public void deleteFactura(@PathParam("id") String id) {

    Long idAsLong;
    if (id == null) {
      throw new BadRequestException("missing id");
    }
    try {
      idAsLong = Long.parseLong(id);
    } catch (NumberFormatException e) {
      throw new BadRequestException("id is not a number");
    } catch (NotFoundException e) {
      throw new BadRequestException("factura not found");
    }
    this.ordermanagement.deleteFactura(idAsLong);
  }

  /**
   * Delegates to {@link UcFindFactura#findFacturaEtos}.
   *
   * @param searchCriteriaTo the pagination and search criteria to be used for finding facturas.
   * @return the {@link PaginatedListTo list} of matching {@link FacturaEto}s.
   */
  @Path("/factura/search")
  @POST
  public PaginatedListTo<FacturaEto> findFacturasByPost(FacturaSearchCriteriaTo searchCriteriaTo) {

    return this.ordermanagement.findFacturaEtos(searchCriteriaTo);
  }

  // ----------------

  /**
   * Delegates to {@link Ordermanagement#findPedido}.
   *
   * @param id the ID of the {@link PedidoEto}
   * @return the {@link PedidoEto}
   */
  @GET
  @Path("/pedido/{id}/")
  public PedidoEto getPedido(@PathParam("id") String id) {

    Long idAsLong;
    if (id == null) {
      throw new BadRequestException("missing id");
    }
    try {
      idAsLong = Long.parseLong(id);
    } catch (NumberFormatException e) {
      throw new BadRequestException("id is not a number");
    } catch (NotFoundException e) {
      throw new BadRequestException("pedido not found");
    }
    PedidoEto pedido = this.ordermanagement.findPedido(idAsLong);

    return pedido;
  }

  /**
   * Delegates to {@link Ordermanagement#savePedido}.
   *
   * @param pedido the {@link PedidoEto} to be saved
   * @return the recently created {@link PedidoEto}
   */
  @POST
  @Path("/pedido/")
  public PedidoEto savePedido(PedidoEto pedido) {

    return this.ordermanagement.savePedido(pedido);
  }

  /**
   * Delegates to {@link Ordermanagement#deletePedido}.
   *
   * @param id ID of the {@link PedidoEto} to be deleted
   */
  @DELETE
  @Path("/pedido/{id}/")
  public void deletePedido(@PathParam("id") String id) {

    Long idAsLong;
    if (id == null) {
      throw new BadRequestException("missing id");
    }
    try {
      idAsLong = Long.parseLong(id);
    } catch (NumberFormatException e) {
      throw new BadRequestException("id is not a number");
    } catch (NotFoundException e) {
      throw new BadRequestException("pedido not found");
    }
    this.ordermanagement.deletePedido(idAsLong);
  }

  /**
   * Delegates to {@link Ordermanagement#findPedidoEtos}.
   *
   * @param searchCriteriaTo the pagination and search criteria to be used for finding pedidos.
   * @return the {@link PaginatedListTo list} of matching {@link PedidoEto}s.
   */
  @Path("/pedido/search")
  @POST
  public PaginatedListTo<PedidoEto> findPedidosByPost(PedidoSearchCriteriaTo searchCriteriaTo) {

    return this.ordermanagement.findPedidoEtos(searchCriteriaTo);
  }

  /**
   * Delegates to {@link Ordermanagement#findArticulo}.
   *
   * @param id the ID of the {@link ArticuloEto}
   * @return the {@link ArticuloEto}
   */
  @GET
  @Path("/articulo/{id}/")
  public ArticuloEto getArticulo(@PathParam("id") String id) {

    Long idAsLong;
    if (id == null) {
      throw new BadRequestException("missing id");
    }
    try {
      idAsLong = Long.parseLong(id);
    } catch (NumberFormatException e) {
      throw new BadRequestException("id is not a number");
    } catch (NotFoundException e) {
      throw new BadRequestException("articulo not found");
    }
    return this.ordermanagement.findArticulo(idAsLong);
  }

  /**
   * Delegates to {@link Ordermanagement#saveArticulo}.
   *
   * @param articulo the {@link ArticuloEto} to be saved
   * @return the recently created {@link ArticuloEto}
   */
  @POST
  @Path("/articulo/")
  public ArticuloEto saveArticulo(ArticuloEto articulo) {

    return this.ordermanagement.saveArticulo(articulo);
  }

  /**
   * Delegates to {@link Ordermanagement#deleteArticulo}.
   *
   * @param id ID of the {@link ArticuloEto} to be deleted
   */
  @DELETE
  @Path("/articulo/{id}/")
  public void deleteArticulo(@PathParam("id") String id) {

    Long idAsLong;
    if (id == null) {
      throw new BadRequestException("missing id");
    }
    try {
      idAsLong = Long.parseLong(id);
    } catch (NumberFormatException e) {
      throw new BadRequestException("id is not a number");
    } catch (NotFoundException e) {
      throw new BadRequestException("articulo not found");
    }
    this.ordermanagement.deleteArticulo(idAsLong);
  }

  /**
   * Delegates to {@link Ordermanagement#findArticuloEtos}.
   *
   * @param searchCriteriaTo the pagination and search criteria to be used for finding articulos.
   * @return the {@link PaginatedListTo list} of matching {@link ArticuloEto}s.
   */
  @Path("/articulo/search")
  @POST
  public PaginatedListTo<ArticuloEto> findArticulosByPost(ArticuloSearchCriteriaTo searchCriteriaTo) {

    return this.ordermanagement.findArticuloEtos(searchCriteriaTo);
  }

  /**
   * Delegates to {@link Ordermanagement#findCliente}.
   *
   * @param id the ID of the {@link ClienteEto}
   * @return the {@link ClienteEto}
   */
  @GET
  @Path("/cliente/{id}/")
  public ClienteEto getCliente(@PathParam("id") String id) {

    Long idAsLong;
    if (id == null) {
      throw new BadRequestException("missing id");
    }
    try {
      idAsLong = Long.parseLong(id);
    } catch (NumberFormatException e) {
      throw new BadRequestException("id is not a number");
    } catch (NotFoundException e) {
      throw new BadRequestException("cliente not found");
    }
    return this.ordermanagement.findCliente(idAsLong);
  }

  /**
   * Delegates to {@link Ordermanagement#saveCliente}.
   *
   * @param cliente the {@link ClienteEto} to be saved
   * @return the recently created {@link ClienteEto}
   */
  @POST
  @Path("/cliente/")
  public ClienteEto saveCliente(ClienteEto cliente) {

    return this.ordermanagement.saveCliente(cliente);
  }

  /**
   * Delegates to {@link Ordermanagement#deleteCliente}.
   *
   * @param id ID of the {@link ClienteEto} to be deleted
   */
  @DELETE
  @Path("/cliente/{id}/")
  public void deleteCliente(@PathParam("id") String id) {

    Long idAsLong;
    if (id == null) {
      throw new BadRequestException("missing id");
    }
    try {
      idAsLong = Long.parseLong(id);
    } catch (NumberFormatException e) {
      throw new BadRequestException("id is not a number");
    } catch (NotFoundException e) {
      throw new BadRequestException("cliente not found");
    }
    this.ordermanagement.deleteCliente(idAsLong);
  }

  /**
   * Delegates to {@link Ordermanagement#findClienteEtos}.
   *
   * @param searchCriteriaTo the pagination and search criteria to be used for finding clientes.
   * @return the {@link PaginatedListTo list} of matching {@link ClienteEto}s.
   */
  @Path("/cliente/search")
  @POST
  public PaginatedListTo<ClienteEto> findClientesByPost(ClienteSearchCriteriaTo searchCriteriaTo) {

    return this.ordermanagement.findClienteEtos(searchCriteriaTo);
  }

  /**
   * Delegates to {@link Ordermanagement#findDetalle}.
   *
   * @param id the ID of the {@link DetalleEto}
   * @return the {@link DetalleEto}
   */
  @GET
  @Path("/detalle/{id}/")
  public DetalleEto getDetalle(@PathParam("id") String id) {

    Long idAsLong;
    if (id == null) {
      throw new BadRequestException("missing id");
    }
    try {
      System.out.println(id);

      idAsLong = Long.parseLong(id);
    } catch (NumberFormatException e) {
      throw new BadRequestException("id is not a number");
    } catch (NotFoundException e) {
      throw new BadRequestException("detalle not found");
    }
    return this.ordermanagement.findDetalle(idAsLong);
  }

  /**
   * Delegates to {@link Ordermanagement#saveDetalle}.
   *
   * @param detalle the {@link DetalleEto} to be saved
   * @return the recently created {@link DetalleEto}
   */
  @POST
  @Path("/detalle/")
  public DetalleEto saveDetalle(DetalleEto detalle) {

    return this.ordermanagement.saveDetalle(detalle);
  }

  /**
   * Delegates to {@link Ordermanagement#deleteDetalle}.
   *
   * @param id ID of the {@link DetalleEto} to be deleted
   */
  @DELETE
  @Path("/detalle/{id}/")
  public void deleteDetalle(@PathParam("id") String id) {

    Long idAsLong;
    if (id == null) {
      throw new BadRequestException("missing id");
    }
    try {
      idAsLong = Long.parseLong(id);
    } catch (NumberFormatException e) {
      throw new BadRequestException("id is not a number");
    } catch (NotFoundException e) {
      throw new BadRequestException("detalle not found");
    }
    this.ordermanagement.deleteDetalle(idAsLong);
  }

  /**
   * Delegates to {@link Ordermanagement#findDetalleEtos}.
   *
   * @param searchCriteriaTo the pagination and search criteria to be used for finding detalles.
   * @return the {@link PaginatedListTo list} of matching {@link DetalleEto}s.
   */
  @Path("/detalle/search")
  @POST
  public PaginatedListTo<DetalleEto> findDetallesByPost(DetalleSearchCriteriaTo searchCriteriaTo) {

    return this.ordermanagement.findDetalleEtos(searchCriteriaTo);
  }

  /**
   * Return list of all articles
   *
   * @return list of articles
   */
  @GET
  @Path("/articulos/")
  public List<ArticuloEto> getArticulos() {

    return this.ordermanagement.findAllArticulos();
  }

  /**
   * Return list of all clients
   *
   * @return list of clients
   */
  @GET
  @Path("/clientes/")
  public List<ClienteEto> getClientes() {

    return this.ordermanagement.findAllClientes();
  }

  /**
   * Return list of all orders
   *
   * @return list of orders
   */
  @GET
  @Path("/pedidos/")
  public List<PedidoEto> getPedidos() {

    return this.ordermanagement.findAllPedidos();
  }

  /**
   * Return list of all orders
   *
   * @return list of orders
   */
  @GET
  @Path("/facturas/")
  public List<FacturaEto> getFacturas() {

    return this.ordermanagement.findAllFacturas();
  }

  /**
   * Return list of all orders
   *
   * @return list of orders
   */
  @GET
  @Path("/detallesFactura/")
  public List<DetalleFacturaEto> getDetallesFactura() {

    return this.ordermanagement.findAllDetallesFactura();
  }

  /**
   * Return list of all orders
   *
   * @return list of orders
   */
  @GET
  @Path("/detalles/")
  public List<DetalleEto> getDetalles() {

    return this.ordermanagement.findAllDetalles();
  }

  /**
   * Delegates to {@link UcFindDetalle#findDetalle}.
   *
   * @param id the ID of the {@link DetalleEto}
   * @return the {@link DetalleEto}
   */
  @GET
  @Path("/detallesByPedido/")
  public List<DetalleEto> getDetallesByPedido(@PathParam("id") String id) {

    Long idAsLong;
    if (id == null) {
      throw new BadRequestException("missing id");
    }
    try {
      idAsLong = Long.parseLong(id);
    } catch (NumberFormatException e) {
      throw new BadRequestException("id is not a number");
    } catch (NotFoundException e) {
      throw new BadRequestException("factura not found");
    }

    return this.ordermanagement.findDetallesByPedido(idAsLong);
  }

  /**
   * Delegates to {@link UcFindDetalle#findDetalle}.
   *
   * @param id the ID of the {@link DetalleEto}
   * @return the {@link DetalleEto}
   */
  @GET
  @Path("/facturaByPedido/{id}/")
  public FacturaEto getFacturaByPedido(@PathParam("id") String id) {

    PedidoEto pedido = getPedido(id);

    // return getFactura(pedido.getDetalleId() + "");
    return null;
  }

  // ---------------estado

  /**
   * This method sets the field <tt>estadoManagement</tt>.
   *
   * @param estadoManagement the new value of the field estadoManagement
   */
  @Inject
  public void setEstadoManagement(Ordermanagement estadoManagement) {

    this.ordermanagement = estadoManagement;
  }

  /**
   * Delegates to {@link UcFindEstado#findEstado}.
   *
   * @param id the ID of the {@link EstadoEto}
   * @return the {@link EstadoEto}
   */
  @GET
  @Path("/estado/{id}/")
  public EstadoEto getEstado(@PathParam("id") String id) {

    Long idAsLong;
    if (id == null) {
      throw new BadRequestException("missing id");
    }
    try {
      idAsLong = Long.parseLong(id);
    } catch (NumberFormatException e) {
      throw new BadRequestException("id is not a number");
    } catch (NotFoundException e) {
      throw new BadRequestException("estado not found");
    }
    return this.ordermanagement.findEstado(idAsLong);
  }

  /**
   * Delegates to {@link UcManageEstado#createEstado}.
   *
   * @param estado the {@link EstadoEto} to be created
   * @return the recently created {@link EstadoEto}
   */
  @POST
  @Path("/estado/")
  public EstadoEto saveEstado(EstadoEto estado) {

    return this.ordermanagement.saveEstado(estado);
  }

  /**
   * Delegates to {@link UcManageEstado#deleteEstado}.
   *
   * @param id ID of the {@link EstadoEto} to be deleted
   */
  @DELETE
  @Path("/estado/{id}/")
  public void deleteEstado(@PathParam("id") String id) {

    Long idAsLong;
    if (id == null) {
      throw new BadRequestException("missing id");
    }
    try {
      idAsLong = Long.parseLong(id);
    } catch (NumberFormatException e) {
      throw new BadRequestException("id is not a number");
    } catch (NotFoundException e) {
      throw new BadRequestException("estado not found");
    }
    this.ordermanagement.deleteEstado(idAsLong);
  }

  /**
   * Delegates to {@link UcFindEstado#findEstadoEtos}.
   *
   * @param searchCriteriaTo the pagination and search criteria to be used for finding estados.
   * @return the {@link PaginatedListTo list} of matching {@link EstadoEto}s.
   */
  @Path("/estado/search")
  @POST
  public PaginatedListTo<EstadoEto> findEstadosByPost(EstadoSearchCriteriaTo searchCriteriaTo) {

    return this.ordermanagement.findEstadoEtos(searchCriteriaTo);
  }

}
