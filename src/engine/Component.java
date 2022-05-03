package engine;


public abstract class Component {
	
	private ComponentType componentType;
	
	public Component(ComponentType componentType) {
		this.componentType = componentType;
	}
	
	public abstract void update(double timeSinceLastUpdate);
	
	public ComponentType getComponentType() {
		return componentType;
	}
}
