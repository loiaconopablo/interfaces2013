package plantaszombies;

import java.util.Comparator;

import org.uqbar.commons.utils.ReflectionUtils;

class PropertyComparator implements Comparator<Semilla>{
	
	private String property;

	public int compare(Semilla o1, Semilla o2) {
		Object propertyValue1 = ReflectionUtils.invokeGetter(o1, property);
		Object propertyValue2 = ReflectionUtils.invokeGetter(o2, property);
		try {
			return (Integer) ReflectionUtils.findMethod(propertyValue1.getClass(), "compareTo", true, new Class[]{propertyValue1.getClass()}).invoke(propertyValue1, propertyValue2);
		} catch (Exception e) {
			throw new RuntimeException(e);
	}
				
	}

	public PropertyComparator compareTo(String property) {
		this.property = property;
		return this;
	}
	
}
