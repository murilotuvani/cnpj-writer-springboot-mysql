package net.cartola.receita.cnpj.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="situacao_cadatral_motivo")
public class SituacaoCadastralMotivo implements Serializable {

	private static final long serialVersionUID = 5678020145791595021L;

	private Long id;
	private String descricao;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="situ_cada_moti_id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "SituacaoCadastralMotivo [id=" + id + ", descricao=" + descricao + "]";
	}
	
}
