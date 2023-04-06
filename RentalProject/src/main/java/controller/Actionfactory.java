package controller;

import controller.Action.Action;
import controller.Action.JoinAction;
import controller.Action.LoginAction;

public class Actionfactory {
	
	private Actionfactory() {}
	private static Actionfactory instance = new Actionfactory();
	
	public static Actionfactory getInstance() {
		return instance;
	}
	
	public Action getAction(String command) {
		Action action = null;
		
		if(command != null ) {
			if(command.equals("join"))
				action = new JoinAction();
			else if(command.equals("login"))
				action = new LoginAction();
//			else if(command.equals("join"))
//				action = new JoinAction();
			
		}
		
		return action;
	}
}