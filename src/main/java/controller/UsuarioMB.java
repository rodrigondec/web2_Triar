package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import dao.UsuarioDAO;
import model.Mensagem;
import model.Usuario;

@ManagedBean
@RequestScoped
public class UsuarioMB {
	private Usuario usuario;
	@Inject 
	private UsuarioDAO usuarioDAO;
	
	private List<Mensagem> listaMensagens;
	
	private List<Usuario> usuarios;
	
	public UsuarioMB(){
		setUsuario(new Usuario());
		setListaMensagens(new ArrayList<Mensagem>()); 
	}
	
	public Usuario getUsuario(){
		return usuario;
	}
	
	public void setUsuario(Usuario usuario){
		this.usuario = usuario;
	}
	
	public List<Mensagem> getListaMensagens() {
		setListaMensagens(usuarioDAO.listarMensagens());
		return listaMensagens;
	}
	
	public String getMenu(){
		try{
			return "menu_" + usuario.getNome_permissao() + ".xhtml";
		 } catch(NullPointerException ex) {
		 
		 }
		return "menu_externo.xhtml";
	}
	
	private void setListaMensagens(List<Mensagem> listaMensagens) {
		this.listaMensagens = listaMensagens;
	}

	public String login(){
		Usuario u = usuarioDAO.buscarEmail(usuario.getEmail());
		if(u!= null){
			if(u.getSenha().equals(usuario.getSenha())) {
				usuario = u;
				return"/interna/home.jsf";
			} else{
				FacesMessage msg = new FacesMessage("Email e/ou senha incorretos");
				msg.setSeverity(FacesMessage.SEVERITY_ERROR);
				FacesContext.getCurrentInstance().addMessage("", msg);
			}
		} else{
			FacesMessage msg = new FacesMessage("Usuario nao encontrado");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage("", msg);
		}
		return null;
	}
	
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<Usuario> getUsuarios(){
		setUsuarios(usuarioDAO.listarUsuarios());
		return usuarios;
	}	
}