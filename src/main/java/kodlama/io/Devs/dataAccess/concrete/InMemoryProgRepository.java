package kodlama.io.Devs.dataAccess.concrete;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import kodlama.io.Devs.dataAccess.abstracts.ProgsRepository;
import kodlama.io.Devs.entities.concrete.Progs;

@Repository
public class InMemoryProgRepository implements ProgsRepository {
	
	List<Progs> progs;
	
	public InMemoryProgRepository() {
		progs=new ArrayList<Progs>();
		progs.add(new Progs(1,"C#"));
		progs.add(new Progs(2,"Java"));
		progs.add(new Progs(3,"Python"));
		
	}

	@Override
	public List<Progs> getAll() {
		return progs;
	}

	@Override
	public void add(Progs progs) {
		this.progs.add(progs);		
	}

	@Override
	public void update(Progs progsy) {
		for(Progs prog:progs) {
			if(prog.getId()==progsy.getId()) {
				prog.setId(progsy.getId());
				prog.setName(progsy.getName());				
			}
				
		}
		
	}

	@Override
	public void delete(int id) {
		for(Progs prog:progs) {
			if(prog.getId()==id)
				progs.remove(id);
		}
		
	}

	@Override
	public Progs getById(int id) {
		for(Progs prog:progs) {
			if(prog.getId()==id)
				return prog;
		}
		return null;
	}

}
