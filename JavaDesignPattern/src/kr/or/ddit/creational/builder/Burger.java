package kr.or.ddit.creational.builder;

public abstract class Burger implements Item {

	public Packing packing() {
		
		return new Wrapper();
	}

	@Override
	abstract public float price();
}
