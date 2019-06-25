package net.cartola.receita.cnpj;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import net.cartola.receita.cnpj.repository.ResponsavelQualificacaoRepository;
import net.cartola.receita.cnpj.repository.SituacaoCadastralMotivoRepository;

@SpringBootApplication
public class CnpjWriterMysqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(CnpjWriterMysqlApplication.class, args);
	}
	
	@Bean
    CommandLineRunner init(ResponsavelQualificacaoRepository rqr, SituacaoCadastralMotivoRepository scmr) {

		return args -> {
			rqr.findAll();
			
			scmr.findAll();
		};
	}

}
