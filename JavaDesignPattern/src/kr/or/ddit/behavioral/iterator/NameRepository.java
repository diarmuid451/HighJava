package kr.or.ddit.behavioral.iterator;

public class NameRepository implements Container {

	public String names[] = {"죠나단","죠셉","죠타로","죠스케","죠르노","죠린","죠니","죠시케"};
	
	@Override
	public Iterator getIterator() {
		
		return new NameIterator();
	}
	
	private class NameIterator implements Iterator {
		
		int index;

		@Override
		public boolean hasNext() {
			if(index < names.length) {
				return true;
			}
			return false;
		}

		@Override
		public Object next() {
			if(this.hasNext()) {
				return names[index++];
			}
			return null;
		}
	}

}
