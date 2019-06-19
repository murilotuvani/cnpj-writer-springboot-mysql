package net.cartola.receita.cnpj.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import net.cartola.receita.cnpj.model.CnpjDocumento;

public interface CnpjRepository extends CrudRepository<CnpjDocumento, Long> {
	
	public CnpjDocumento findByCnpj(long cnpj);
    public List<CnpjDocumento> findByRazaoSocial(String razaoSocial);
    public List<CnpjDocumento> findByCnae(int cnae);
    public List<CnpjDocumento> findByCep(int cep);
    public List<CnpjDocumento> findByUf(String uf);
    public List<CnpjDocumento> findByCodigoMunicipio(int codigoMunicipio);

}
