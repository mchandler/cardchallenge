package com.mike.cardchallenge;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
	
	private List<Integer> deck;
	private List<Player> players;
	
	public Game() {
		newGame();
	}
	
	public Game(Player[] players) {
		newGame();
		
		for (int i = 0; i < players.length; i++) {
			addPlayer(players[i]);
		}	
	}
	
	public List<Player> getPlayers() {
		return players;
	}
	
	public void newGame() {
		players = new ArrayList<Player>();
		System.out.println("Clearing the game table...");
		shuffleCards();
	}
	
	public void shuffleCards() {
		deck = new ArrayList<Integer>();
		
		for (int i=1; i <= 30; i++) {
			deck.add(i);
		}
		
		System.out.println("Shuffling the cards..." + deck.size() + " total in the deck.");
	}
	
	public void addPlayer(Player player) {
		player.setHand(new ArrayList<Integer>());
		players.add(player);
		System.out.println("Adding player " + player.getName());
	}
	
	public void dealCardToAllPlayers() {
		for (Player player : players) {
			dealCardTo(player);
		}
	}
	
	public void dealCardTo(Player player) {
		ArrayList<Integer> hand = (ArrayList<Integer>) player.getHand();
		int card = getRandomCard();
		hand.add(card);
	}
	
	private int getRandomCard() {
		Random random = new Random();
		int pos = random.nextInt(deck.size()); //between 0 and size of deck, inclusive
		int card = deck.get(pos);
		deck.remove(pos);
		return card;
	}
	
	public Player findWinner() {
		Player currentWinner = null;
		
		for (Player player : players) {
			if (currentWinner == null) {
				currentWinner = player;
				continue;
			}
			
			if (player.beats(currentWinner)) {
				currentWinner = player;
			}
		}
		
		return currentWinner;
	}
	
}
