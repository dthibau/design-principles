package org.formation.pattern.factory;

public class CreationRequestor {

	private Product product;
	private FactoryIF factory;
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public FactoryIF getFactory() {
		return factory;
	}
	public void setFactory(FactoryIF factory) {
		this.factory = factory;
	}
	
	
}
