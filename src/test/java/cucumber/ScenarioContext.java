package cucumber;

import java.util.HashMap;
import java.util.Map;

import enums.Context;

public class ScenarioContext {
	private Map <String, Object> scenarioContext;

	public ScenarioContext() {
		scenarioContext = new HashMap<>();
	}
	
	public void setContext(Context key, Object value) {
		System.out.println("ScenarioContext -- setContext.put( "+key.toString() + "  , "  + value.toString());
		scenarioContext.put(key.toString(), value.toString().toUpperCase());
	}
	
	public Object getContext(Context key) {
		System.out.println("ScenarioContext -- getContext.get=" + key);
		return scenarioContext.get(key.toString());
	}
	
	public boolean isContains(Context key) {
		System.out.println("ScenarioContext -- isContains=" + key);
		return scenarioContext.containsKey(key.toString());
	}
	
	
}
