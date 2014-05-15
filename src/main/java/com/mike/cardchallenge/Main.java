package com.mike.cardchallenge;

/**
 * The challenge is to create a bogus card game that is very simple in nature.
 * Establish a deck of 30 cards with numeric face values, deal three cards to a
 * group of players and identify the winner as the player holding the largest
 * sum total of cards. Part of the challenge is to use as few classes as possible,
 * excluding the Main executable class.
 * 
 * In this example, I'm creating three player instances, creating a new game and
 * adding the three players, dealing the cards and determining the winner.
 * 
 * @author Mike Chandler
 *
 */
public class Main {
	
	public static void main(String[] args) {
		Player player1 = new Player("Mike");
		Player player2 = new Player("Jim");
		Player player3 = new Player("Steve");
		
		Game game = new Game(new Player[] {player1, player2, player3});
		
		// deal 3 cards to each player
		for (int i=1; i<=3; i++) {
			game.dealCardToAllPlayers();
		}
		
		// cheat and deal a card to your buddy under the table
		//game.dealCardTo(player1);
		
		for (Player player : game.getPlayers()) {
			System.out.println(player.getName() + " has a total of " + player.handTotal());
			System.out.println(player.getHand());
		}
		
		Player winner = game.findWinner();
		System.out.println(winner.getName() + " is the winner!");
	}
	
}
