package designpatterns.factory.pizzaStore.dishes;

public abstract class Pizza implements Cloneable {
	
	public abstract void prepare();

	public void bake() {
		System.out.println("baking " + this);
	}

	public void box() {
		System.out.println("cutting and boxing " + this);
	}

	/**
	 * override protected method defined in class Object to make it public
	 */
	@Override
	public Pizza clone() {
		try {
			return (Pizza) super.clone();
		} catch (CloneNotSupportedException ex) {
			throw new InternalError(ex.getMessage());
		}
	}
}
