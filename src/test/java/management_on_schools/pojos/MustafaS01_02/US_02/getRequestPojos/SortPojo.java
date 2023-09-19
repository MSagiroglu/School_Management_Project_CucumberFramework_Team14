package management_on_schools.pojos.MustafaS01_02.US_02.getRequestPojos;

import java.io.Serializable;

public class SortPojo implements Serializable {
	public SortPojo() {
	}

	public SortPojo(boolean empty, boolean sorted, boolean unsorted) {
		this.empty = empty;
		this.sorted = sorted;
		this.unsorted = unsorted;
	}

	private boolean empty;
	private boolean sorted;
	private boolean unsorted;

	public void setEmpty(boolean empty){
		this.empty = empty;
	}

	public boolean isEmpty(){
		return empty;
	}

	public void setSorted(boolean sorted){
		this.sorted = sorted;
	}

	public boolean isSorted(){
		return sorted;
	}

	public void setUnsorted(boolean unsorted){
		this.unsorted = unsorted;
	}

	public boolean isUnsorted(){
		return unsorted;
	}

	@Override
 	public String toString(){
		return 
			"SortPojo{" + 
			"empty = '" + empty + '\'' + 
			",sorted = '" + sorted + '\'' + 
			",unsorted = '" + unsorted + '\'' + 
			"}";
		}
}