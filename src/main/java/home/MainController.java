package home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import home.Maquina;
import home.RepositorioMaquinas;

@Controller
@RequestMapping(path="/demo")
public class MainController {
	@Autowired
	private RepositorioMaquinas Repo;
	
	@GetMapping(path="/add")
	public @ResponseBody String addNewUser (@RequestParam String nombre, @RequestParam String familia) {
		Maquina maq = new Maquina();
		maq.setNombre(nombre);
		maq.setFamilia(familia);
		Repo.save(maq);
		return "Guardado";
	}
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Maquina> getAllMaquinas(){
		return Repo.findAll();
	}
}
