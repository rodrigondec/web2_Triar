package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import dao.CoordenadorDAO;
import model.Coordenador;
import model.ProcessoSeletivo;

@ManagedBean
@RequestScoped
public class CoordenadorMB {
	private Coordenador coordenador;
	@Inject 
	private CoordenadorDAO coordenadorDAO;
	private List<ProcessoSeletivo> processos;
	
	public CoordenadorMB(){
		setCoordenador(new Coordenador());
		setProcessos(new ArrayList<ProcessoSeletivo>());
	}

	public Coordenador getCoordenador() {
		return coordenador;
	}

	public void setCoordenador(Coordenador coordenador) {
		this.coordenador = coordenador;
	}

	public List<ProcessoSeletivo> getProcessos() {
		return processos;
	}

	public void setProcessos(List<ProcessoSeletivo> processos) {
		this.processos = processos;
	}
}