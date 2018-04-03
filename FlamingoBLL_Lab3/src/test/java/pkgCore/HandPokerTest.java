package pkgCore;

import static org.junit.Assert.*;

import org.junit.Test;

import pkgEnum.eRank;
import pkgEnum.eSuit;

public class HandPokerTest {

	@Test
	public void FourOfAKindTest1() {
		System.out.println("Four of a Kind");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS,eRank.TWO));
		hp.AddCard(new Card(eSuit.HEARTS,eRank.TWO));
		hp.AddCard(new Card(eSuit.DIAMONDS,eRank.TWO));
		hp.AddCard(new Card(eSuit.SPADES,eRank.TWO));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.THREE));
		hp.ScoreHand();
		System.out.println("");
		
		assertEquals(hp.isFourOfAKind(),true);
		
		System.out.println("");
	}
	
	@Test
	public void ThreeOfAKindTest1() {
		System.out.println("Three of a Kind");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS,eRank.TWO));
		hp.AddCard(new Card(eSuit.HEARTS,eRank.TWO));
		hp.AddCard(new Card(eSuit.DIAMONDS,eRank.TWO));
		hp.AddCard(new Card(eSuit.SPADES,eRank.FIVE));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.THREE));
		hp.ScoreHand();
		
		assertEquals(hp.isThreeOfAKind(),true);
		
		System.out.println("");
	}
	
	@Test
	public void TwoPairTest1() {
		System.out.println("Two Pair");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS,eRank.TWO));
		hp.AddCard(new Card(eSuit.HEARTS,eRank.TWO));
		hp.AddCard(new Card(eSuit.DIAMONDS,eRank.FIVE));
		hp.AddCard(new Card(eSuit.SPADES,eRank.FIVE));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.THREE));
		hp.ScoreHand();
		System.out.println("");
		
		assertEquals(hp.isTwoPair(),true);
		
		System.out.println("");
	}
	
	@Test
	public void FullHouseTest1() {
		System.out.println("Full House");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS,eRank.TWO));
		hp.AddCard(new Card(eSuit.HEARTS,eRank.TWO));
		hp.AddCard(new Card(eSuit.DIAMONDS,eRank.FIVE));
		hp.AddCard(new Card(eSuit.SPADES,eRank.FIVE));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.FIVE));
		hp.ScoreHand();
		
		assertEquals(hp.isFullHouse(),true);
		
		System.out.println("");
	}
	
	@Test
	public void FlushTest1() {
		System.out.println("Flush");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card (eSuit.CLUBS,eRank.TEN));
		hp.AddCard(new Card (eSuit.CLUBS,eRank.FOUR));
		hp.AddCard(new Card (eSuit.CLUBS,eRank.QUEEN));
		hp.AddCard(new Card (eSuit.CLUBS,eRank.SEVEN));
		hp.AddCard(new Card (eSuit.CLUBS,eRank.TWO));
		hp.ScoreHand();
		
		assertEquals(hp.isFlush(),true);
		
		System.out.println("");
	}
	
	@Test
	public void StraightTest1() {
		System.out.println("Straight");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card (eSuit.SPADES,eRank.FIVE));
		hp.AddCard(new Card (eSuit.HEARTS,eRank.TWO));
		hp.AddCard(new Card (eSuit.DIAMONDS,eRank.FOUR));
		hp.AddCard(new Card (eSuit.CLUBS,eRank.ACE));
		hp.AddCard(new Card (eSuit.HEARTS,eRank.THREE));
		hp.ScoreHand();
		
		assertEquals(hp.isStraight(),true);
		
		System.out.println("");
	}

	@Test
	public void PairTest1() {
		System.out.println("Pair");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card (eSuit.SPADES,eRank.JACK));
		hp.AddCard(new Card (eSuit.HEARTS,eRank.FIVE));
		hp.AddCard(new Card (eSuit.DIAMONDS,eRank.NINE));
		hp.AddCard(new Card (eSuit.CLUBS,eRank.FIVE));
		hp.AddCard(new Card (eSuit.HEARTS,eRank.TEN));
		hp.ScoreHand();
		
		assertEquals(hp.isPair(),true);
		
		System.out.println("");
	}
	
	@Test
	public void StraightFlushTest1() {
		System.out.println("StraightFlush");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card (eSuit.HEARTS,eRank.FIVE));
		hp.AddCard(new Card (eSuit.HEARTS,eRank.TWO));
		hp.AddCard(new Card (eSuit.HEARTS,eRank.FOUR));
		hp.AddCard(new Card (eSuit.HEARTS,eRank.ACE));
		hp.AddCard(new Card (eSuit.HEARTS,eRank.THREE));
		hp.ScoreHand();
		
		assertEquals(hp.isStraightFlush(),true);
		
		System.out.println("");
	}
	
	@Test
	public void RoyalFlushTest1() {
		System.out.println("Royal Flush");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card (eSuit.HEARTS,eRank.KING));
		hp.AddCard(new Card (eSuit.HEARTS,eRank.TEN));
		hp.AddCard(new Card (eSuit.HEARTS,eRank.QUEEN));
		hp.AddCard(new Card (eSuit.HEARTS,eRank.ACE));
		hp.AddCard(new Card (eSuit.HEARTS,eRank.JACK));
		hp.ScoreHand();
		
		assertEquals(hp.isRoyalFlush(),true);
		
		System.out.println("");
	}
	
	@Test
	public void HighCardTest1() {
		System.out.println("High Card");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS,eRank.JACK));
		hp.AddCard(new Card(eSuit.HEARTS,eRank.FIVE));
		hp.AddCard(new Card(eSuit.DIAMONDS,eRank.TWO));
		hp.AddCard(new Card(eSuit.SPADES,eRank.ACE));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.SIX));
		hp.ScoreHand();
		System.out.println("");
		
		assertEquals(hp.isHighCard(),true);
	}
}
