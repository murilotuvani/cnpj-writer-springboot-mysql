package net.cartola.receita.cnpj.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.cartola.receita.cnpj.model.Cnpj;
import net.cartola.receita.cnpj.repository.CnpjRepository;

@RestController
@RequestMapping("/api/cnpj")
public class CnpjRestController {

	private static final Logger LOG = LoggerFactory.getLogger(CnpjRestController.class);

	@Autowired
	CnpjRepository cnpjRepository;

	@GetMapping("/clear")
	public ResponseEntity<Cnpj> clear() {
		cnpjRepository.deleteAll();
		LOG.info("Limpando os registros");
		return new ResponseEntity<Cnpj>(HttpStatus.NOT_FOUND);
	}

	@GetMapping("/{cnpj}")
	public ResponseEntity<Cnpj> getByCnpj(@PathVariable("cnpj") Long cnpj) {
		Cnpj cnpjEncontrado = cnpjRepository.findByCnpj(cnpj);
		if (cnpjEncontrado != null) {
			LOG.info("Para a pesquisa {}, retornado : {}", new Object[] { cnpj, cnpjEncontrado });
			return new ResponseEntity<Cnpj>(cnpjEncontrado, HttpStatus.OK);
		} else {
			LOG.info("Para a pesquisa {}, nao foi encontrado registro", new Object[] { cnpj });
			return new ResponseEntity<Cnpj>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping
	public ResponseEntity<List<Cnpj>> list() {
		List<Cnpj> l = new ArrayList<>();
		cnpjRepository.findAll().forEach(c -> l.add(c));
		return new ResponseEntity<List<Cnpj>>(l, HttpStatus.OK);

	}

	@PutMapping
	public ResponseEntity<Cnpj> putCnpj(@RequestBody Cnpj cnpj) {
		cnpj = cnpjRepository.save(cnpj);
		LOG.info("Salvou o registro {}", new Object[] { cnpj });
		return new ResponseEntity<Cnpj>(cnpj, HttpStatus.OK);
	}

	@PutMapping("/list")
	public ResponseEntity<List<Cnpj>> putCnpj(@RequestBody List<Cnpj> cnpjs) {
		List<Cnpj> l = new ArrayList<>();
		cnpjRepository.saveAll(cnpjs).forEach(c -> l.add(c));
		l.forEach(s -> {
			LOG.info("Salvou o registro {}", new Object[] { s });
		});
		return new ResponseEntity<List<Cnpj>>(l, HttpStatus.OK);
	}

}
