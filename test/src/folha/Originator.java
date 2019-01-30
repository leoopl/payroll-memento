package folha;

import java.util.ArrayList;
import java.util.List;

public class Originator {
	
	private List<Empregado> status;
	
	public void setStatus(List<Empregado> saveStatus) {
		this.status = new ArrayList<Empregado>();
		this.status.addAll(saveStatus);
				
		//		(List<Empregado>) ((ArrayList) saveStatus).clone();
	}
	
	public List<Empregado> getStatus() {
		return this.status;
	}
	
	public Memento saveMementoStatus() {
		return new Memento(status);
	}
	
	public void restore(List<Empregado> m) {
		status = m;
	}

	@Override
	public String toString() {
		return "Originator [status=" + status + "]";
	}
	
	
}

