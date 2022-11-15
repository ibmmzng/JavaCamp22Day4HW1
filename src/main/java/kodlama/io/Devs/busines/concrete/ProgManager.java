package kodlama.io.Devs.busines.concrete;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Devs.busines.abstracts.ProgService;
import kodlama.io.Devs.dataAccess.abstracts.ProgsRepository;
import kodlama.io.Devs.entities.concrete.Progs;

@Service
public class ProgManager implements ProgService {
	
	private ProgsRepository progRepository;
	
	@Autowired
	public ProgManager(ProgsRepository progRepository) {
		this.progRepository = progRepository;
	}

	@Override
	public List<Progs> getAll() {
		return progRepository.getAll();
	}

	@Override
	public void add(Progs progs) throws Exception {
		if(progs.getName().isEmpty())
			throw new Exception("Names can't be null...");
		else if(isValid(progs.getName()))
			throw new Exception("Program name isn't repeateble");
		else
			progRepository.add(progs);
	}


	private boolean isValid(String name) {
		for(Progs prog:progRepository.getAll()) {
			if(prog.getName().equals(name)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void update(Progs progsy) {
		progRepository.update(progsy);
		
	}

	@Override
	public void delete(int id) {
		progRepository.delete(id);
	}

	@Override
	public Progs getById(int id) {
		return progRepository.getById(id);
	}

}
