package com.mike.cardchallenge;

import java.util.List;

public class Player {
	private String name;
	private List<Integer> hand;

	public Player() {}
	
	public Player(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Integer> getHand() {
		return hand;
	}

	public void setHand(List<Integer> hand) {
		this.hand = hand;
	}
	
	public int handTotal() {
		int total = 0;
		
		for (int card : hand) {
			total+=card;
		}
		
		return total;
	}
	
	public boolean beats(Player player) {
		return handTotal() > player.handTotal();
	}
}
