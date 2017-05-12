package dev.chrisrueda.engine.states;

public  class  StateManager {
	
	private  State currentState=null;
	
	public StateManager(){
		
	}

	public  State getCurrentState() {
		return currentState;
	}

	public  void setCurrentState(State currentState) {
		this.currentState = currentState;
	}
	

}
