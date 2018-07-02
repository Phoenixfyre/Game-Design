package edu.virginia.engine.events;

import java.util.ArrayList;
import java.util.List;

public class QuestManager implements IEventListener{
	
	private List <String> quests;
	
	public QuestManager() {
		this.setQuests(new ArrayList<String>());
		// TODO Auto-generated constructor stub
	}

	public List <String> getAllQuests() {
		return quests;
	}
	public String findQuest(String n){
		int x= this.quests.indexOf(n);
		return this.quests.get(x);
	}
	public void addQuest(String n){
		this.quests.add(n);
	}

	public void setQuests(List <String> quests) {
		this.quests = quests;
	}

	@Override
	public void handleEvent(Event event){
		System.out.println("If you are seeing this, this means you have completed your quest and now it is removed from your log");
	}

}
