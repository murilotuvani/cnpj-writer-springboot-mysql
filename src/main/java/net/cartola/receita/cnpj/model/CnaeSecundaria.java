package net.cartola.receita.cnpj.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class CnaeSecundaria implements Serializable {

	private static final long serialVersionUID = 3522164548737116198L;

	public Long id;
	private CnpjDocumento cnpjDocumento;
	private long cnpjEmpresa;
    private int cnaeSecundaria;

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cnae_id")
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name="cnpj_id")
	public CnpjDocumento getCnpjDocumento() {
		return cnpjDocumento;
	}

	/**
	 * @param cnpj
	 */
	public void setCnpjDocumento(CnpjDocumento cnpj) {
		this.cnpjDocumento = cnpj;
	}

	public long getCnpjEmpresa() {
        return cnpjEmpresa;
    }

    public void setCnpjEmpresa(long cnpjEmpresa) {
        this.cnpjEmpresa = cnpjEmpresa;
    }

    public int getCnaeSecundaria() {
        return cnaeSecundaria;
    }

    public void setCnaeSecundaria(int cnaeSecundaria) {
        this.cnaeSecundaria = cnaeSecundaria;
    }

    @Override
    public String toString() {
        return "CnaeSecundaria{cnpjEmpresa=" + cnpjEmpresa + ", cnaeSecundaria=" + cnaeSecundaria + '}';
    }
}
