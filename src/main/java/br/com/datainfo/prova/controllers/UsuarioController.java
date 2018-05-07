package br.com.datainfo.prova.controllers;

import br.com.datainfo.prova.services.UsuarioService;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.datainfo.prova.entity.Funcao;
import br.com.datainfo.prova.entity.Usuario;

@Path("usuarios")
public class UsuarioController {

	public Integer countUsuarios() {
		UsuarioService usuarioService = new UsuarioService();
		return usuarioService.countUsuarios();
	}


	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/")
	public List<Usuario> listUsuarios() {
		try {
			UsuarioService usuarioService = new UsuarioService();
			return usuarioService.listar();
		} catch (Exception ex) {
			Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{cpf}/")
	public Usuario getUsuario(@PathParam("cpf") String cpf) {
		try {
			UsuarioService usuarioService = new UsuarioService();
			return usuarioService.selecionar(cpf);
		} catch (Exception ex) {
			Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("funcoes/")
	public List<Funcao> listFuncoes() {
		try {
			UsuarioService usuarioService = new UsuarioService();
			return usuarioService.listaFuncoes();
		} catch (Exception ex) {
			Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/")
	public Response create(Usuario usuario) {
		try {
			UsuarioService usuarioService = new UsuarioService();
			usuarioService.inserir(usuario);
			return Response.status(Response.Status.OK).build();
		} catch (Exception ex) {
			Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/")
	public Response update(Usuario usuario) {
		try {
			// usuario.setStatus(Status.PENDENTE);

			UsuarioService usuarioService = new UsuarioService();
			usuarioService.alterar(usuario);
			return Response.status(Response.Status.OK).build();
		} catch (Exception ex) {
			Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}

	@DELETE
	@Path("{cpf}/")
	public Response delete(@PathParam("cpf") String cpf) {
		try {
			UsuarioService usuarioService = new UsuarioService();
			usuarioService.excluir(cpf);
			return Response.status(Response.Status.OK).build();
		} catch (Exception ex) {
			Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}
	
}
