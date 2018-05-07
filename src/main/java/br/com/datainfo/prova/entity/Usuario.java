package br.com.datainfo.prova.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuario_externo")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "nu_cpf",  nullable = false)
	private String cpf;

	@Column(name = "no_usuario", length = 60, nullable = false)
	private String nomeUsuario;

	@Column(name = "de_email", length = 255, nullable = false)
	private String email;

	@Column(name = "ic_situacao", length = 1, nullable = false)
	private String situacao;
	
	@Column(name = "ic_perfil_acesso", nullable = false)
	private int perfil;
	
	@Column(name = "co_funcao", nullable = false)
	private int funcao;

	@Column(name = "nu_telefone", length = 11, nullable = true)
	private String telefone;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public int getPerfil() {
		return perfil;
	}

	public void setPerfil(int perfil) {
		this.perfil = perfil;
	}

	public int getFuncao() {
		return funcao;
	}

	public void setFuncao(int funcao) {
		this.funcao = funcao;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Usuario [cpf=" + cpf + ", nomeUsuario=" + nomeUsuario + ", email=" + email + ", situacao=" + situacao
				+ ", perfil=" + perfil + ", funcao=" + funcao + ", telefone=" + telefone + "]";
	}

	

}
