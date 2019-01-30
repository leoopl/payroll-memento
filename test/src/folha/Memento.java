package folha;

import java.util.List;

public class Memento {
	
	private List<Empregado> status;
	
	public Memento(List<Empregado> status) {
		this.status = status;
	}
	
	public List<Empregado> getStatus() {
		return status;
	}

}
