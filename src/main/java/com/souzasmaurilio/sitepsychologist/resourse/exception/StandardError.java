package com.souzasmaurilio.sitepsychologist.resourse.exception;

import java.io.Serializable;

public class StandardError implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long horaDoErro;
	private Integer starus;
	private String erro;
	private String mensagem;
	private String caminho;
	
	public StandardError() {
		
	}

	public StandardError(Long horaDoErro, Integer starus, String erro, String mensagem, String caminho) {
		this.horaDoErro = horaDoErro;
		this.starus = starus;
		this.erro = erro;
		this.mensagem = mensagem;
		this.caminho = caminho;
	}

	public Long getHoraDoErro() {
		return horaDoErro;
	}

	public void setHoraDoErro(Long horaDoErro) {
		this.horaDoErro = horaDoErro;
	}

	public Integer getStarus() {
		return starus;
	}

	public void setStarus(Integer starus) {
		this.starus = starus;
	}

	public String getErro() {
		return erro;
	}

	public void setErro(String erro) {
		this.erro = erro;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getCaminho() {
		return caminho;
	}

	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}
}
