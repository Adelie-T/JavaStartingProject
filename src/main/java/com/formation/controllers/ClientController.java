package com.formation.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.formation.dto.ClientFull;
import com.formation.dto.ClientLight;
import com.formation.exceptions.ClientNotFoundException;
import com.formation.persitance.entities.Client;
import com.formation.services.IClientService;

@RestController
@RequestMapping(path = "/client") //tout ce qu'on écrit dans la classe sera accessible par ce chemin. le chemin doit être unique !! 
public class ClientController {
	
	@Autowired
	ModelMapper mapper;
	
	@Autowired
	IClientService service; //on s'injecte le service car c'est lui communique avec les entités. 
	
	public ClientController() {
		System.out.println("Hello !"); // pas besoin de faire une instance le controller le faire pour nous ! 
	}
	
	// chemin : on précise liste car on veut la liste des clients
	// méthode : on veut récupérer les clients donc on la nomme GET
	@RequestMapping(path = "/list", method = RequestMethod.GET) //on précise le chemin URL et le mode ! 
	public List<ClientLight> getAll(){ //on rend la liste des client accessible depuis un autre PC
		
		return service.getAll()
				.stream()
				.map(c -> mapper.map(c, ClientLight.class))
				.collect(Collectors.toList()) ; //inverse de stream - renvoit sous forme de liste
	}
	
//	@RequestMapping(path="/{identifiant}") //On remplace RequestMapping par Getmapping comme ça on ne précise pas la méthode
//	//on a mis le paramètre dans l'accolade 
//	public Client findOne(@PathVariable(name = "identifiant") Integer id) {
//		return repo.findById(id).get(); //.get permet de voir ce qu'il y a à l'intérieur de repo.findById
//	}
	
	@RequestMapping(path="/{identifiant}", method = RequestMethod.GET )
	public ClientLight findOne(@PathVariable(name = "identifiant") Long id) {
		Optional<Client> opt = service.findById(id); 
		
		if (opt.isEmpty()) {
			throw new ClientNotFoundException("Le client " + id + " non trouvé");
		}
		ClientLight cli = mapper.map(opt.get(), ClientLight.class);
		return cli;
	}
	
//	@DeleteMapping(path="/{identifiant}") //On remplace Getmapping par deleteMapping
//	//on a mis le paramètre dans l'accolade 
//	public Client deleteOne(@PathVariable(name = "identifiant") Integer id) { //on reprécise le nom du paramètre
//		// on veut que ça renvoie un booleen donc on crée notre réponse avec try/catch
//		//		try {
//			repo.deleteById(c); //contrairement à jdbc, s'il ne trouve pas le client lié à l'identifiant et donc qu'il ne l'efface pas, il renvoie un false!
//			return true;
//		} catch (Exception e) {
//			return false;
//		}
//	
//	}
	
	@DeleteMapping(path="/{identifiant}") //On remplace Getmapping par deleteMapping
	//on a mis le paramètre dans l'accolade 
	public void deleteOne(@PathVariable(name = "identifiant") Long id) { //on reprécise le nom du paramètre
		// on peut aussi renvoyer un booleen, on crée alors notre réponse avec try/catch
		ClientLight cli = findOne(id); 
		//on appelle la fonction findOne pour chercher le client et envoyer le message de l'erreur
		try {
			Client client = mapper.map(cli, Client.class);
			service.delete(client.getId()); 
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ClientNotFoundException("Une erreur est servenue, merci de vous rapprocher du support technique");
		}
	
	}
	

	@PostMapping
	public ClientLight save(@RequestBody ClientFull clif) { 
		Client client = mapper.map(clif, Client.class); //on convertit le DTO en entité
		client = service.save(client); //on sauve l'entité dans la bdd et on récupère son Id
										// on utilise service.save() car c'est la méthode "save" du service et non celle du contrôleur! 
		ClientLight clifRevenu = mapper.map(client, ClientLight.class); //on convertit en DTO le client récupèré depuis le service
		return clifRevenu;  
	}
	
//	@PostMapping
//	public Client save(@RequestBody Client client) {  //on récupère un objet client
//		return service.save(client); //on l'enregistre dans la base et on renvoie l'objet qu'on a créé 
//	}
	
}
