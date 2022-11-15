package kodlama.io.Devs.dataAccess.abstracts;

import java.util.List;

import kodlama.io.Devs.entities.concrete.Progs;

public interface ProgsRepository {
	List<Progs> getAll();
	
	void add(Progs progs);
	void update(Progs progs);
	void delete(int id);
	Progs getById(int id);
}
