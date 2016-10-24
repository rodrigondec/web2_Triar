package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import dao.VagaDAO;
import model.Vaga;

@ManagedBean
@RequestScoped
public class VagaMB {
	private Vaga vaga;
	@SuppressWarnings("unused")
	@Inject 
	private VagaDAO vagaDAO;
	
	public VagaMB(){
		setVaga(new Vaga());
	}

	public Vaga getVaga() {
		return vaga;
	}

	public void setVaga(Vaga vaga) {
		this.vaga = vaga;
	}
	
	public String geturlListar(){
		return "/interna/administrador/listar/vagas.jsf";
	}
}
