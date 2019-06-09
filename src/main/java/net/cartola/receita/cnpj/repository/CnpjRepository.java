package net.cartola.receita.cnpj.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import net.cartola.receita.cnpj.model.Cnpj;

public interface CnpjRepository extends CrudRepository<Cnpj, Long> {
	
	public Cnpj findByCnpj(long cnpj);
    public List<Cnpj> findByRazaoSocial(String razaoSocial);
    public List<Cnpj> findByCnae(int cnae);
    public List<Cnpj> findByCep(int cep);
    public List<Cnpj> findByUf(String uf);
    public List<Cnpj> findByCodigoMunicipio(int codigoMunicipio);

}
