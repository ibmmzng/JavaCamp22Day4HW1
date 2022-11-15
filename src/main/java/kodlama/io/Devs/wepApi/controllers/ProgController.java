package kodlama.io.Devs.wepApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Devs.busines.abstracts.ProgService;
import kodlama.io.Devs.entities.concrete.Progs;

@RestController
@RequestMapping("/api/progs")

public class ProgController {
	private ProgService progService;
	
	@Autowired
	public ProgController(ProgService progService) {
		this.progService = progService;
	}
	
	@GetMapping("/getAll")
	public List<Progs> getAll(){
		return progService.getAll();		
	}
	@PostMapping("/add")
	public void add(Progs progs) throws Exception {
		progService.add(progs);
	}
	@DeleteMapping("/delete")
	public void delete(int id) {
		progService.delete(id);
	}
	@PutMapping("/update")
	public void update(Progs progs) {
		progService.update(progs);
	}
	
}
