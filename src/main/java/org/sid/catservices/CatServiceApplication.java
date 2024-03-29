package org.sid.catservices;

import org.sid.catservices.dao.ProduitRepository;
import org.sid.catservices.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class CatServiceApplication implements CommandLineRunner  {

	@Autowired 
	private ProduitRepository produitRepository;
	
	@Autowired
	private RepositoryRestConfiguration restConfiguration;
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(CatServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		restConfiguration.exposeIdsFor(Produit.class);
		produitRepository.save(new Produit(null,"Ordianteur Lx 45",6700,3));
		produitRepository.save(new Produit(null,"Imprimante HP",1700,3));
		produitRepository.save(new Produit(null,"Smart Phone Samsung S9",8000,13));
        produitRepository.findAll().forEach(
        		p->{System.out.println(p.toString());});
	
	
	}
	
	
	

}
