package kodlama.io.Devs.busines.abstracts;

import java.util.List;

import kodlama.io.Devs.entities.concrete.Progs;

public interface ProgService {
	List<Progs> getAll();
	void add(Progs progs) throws Exception;
	void update(Progs progsy);
	void delete(int id);
	Progs getById(int id);
}
