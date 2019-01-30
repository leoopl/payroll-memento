package folha;

import java.util.ArrayList;
import java.util.List;

public class CareTaker {
	
	private List<Memento> mementoList = new ArrayList<Memento>();
	
	public void add(Memento status) {
		mementoList.add(status);
	}
	
	public List<Empregado> getLastElement() {
		int lastIndex = mementoList.size() - 1;
	
		if(lastIndex < 0) {
			return new ArrayList<Empregado>();
		}
		
		Memento m = mementoList.get(lastIndex);
		mementoList.remove(lastIndex);
		return m.getStatus();
	}

}
