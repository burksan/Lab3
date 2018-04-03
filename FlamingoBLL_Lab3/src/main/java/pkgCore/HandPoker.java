package pkgCore;

import java.util.ArrayList;
import java.util.Collections;
import pkgConstants.*;
import pkgEnum.eCardNo;
import pkgEnum.eHandStrength;
import pkgEnum.eRank;
import pkgEnum.eSuit;

public class HandPoker extends Hand {

	private ArrayList<CardRankCount> CRC = null;

	public HandPoker() {
		this.setHS(new HandScorePoker());
	}

	protected ArrayList<CardRankCount> getCRC() {
		return CRC;
	}

	@Override
	public HandScore ScoreHand() {
		// TODO : Implement this method... call each of the 'is' methods (isRoyalFlush,
		// etc) until
		// one of the hands is true, then score the hand

		Collections.sort(super.getCards());
		Frequency();

		if (isRoyalFlush()) {
			return null;
		} 
		
		else if (isStraightFlush()) {
			return null;
		}
		
		else if (isFourOfAKind()) {
			return null;
		}
		
		else if (isFullHouse()) {
			return null;
		}

		else if (isFlush()) {
			return null;
		}
		
		else if (isStraight()) {
			return null;
		}
		
		else if (isThreeOfAKind()) {
			return null;
		}
		
		else if (isTwoPair()) {
			return null;
		}
		
		else if (isPair()) {
			return null;
		}
		
		else if (isHighCard()) {
			return null;
		}
		return null;
	}

	public boolean isRoyalFlush() {
		boolean bisRoyalFlush = false;
		if (isStraightFlush() == true) {
			if (this.getCards().get(0).geteRank() == eRank.ACE && this.getCards().get(1).geteRank() == eRank.KING) {
				HandScorePoker HSP = (HandScorePoker) this.getHS();
				HSP.seteHandStrength(eHandStrength.RoyalFlush);
				int iGetCard = this.getCRC().get(0).getiCardPosition();
				HSP.setHiCard(this.getCards().get(iGetCard));
				HSP.setLoCard(null);
				HSP.setKickers(FindTheKickers(this.getCRC()));
				this.setHS(HSP);}
			bisRoyalFlush = true;}
		return bisRoyalFlush;
	}

	public boolean isStraightFlush() {
		boolean bisStraightFlush = true;
		int iCardCnt = super.getCards().size();
		int iSuitCnt = 0;

		for (int a = 0; a<iCardCnt - 1; a++)
		{
			if (super.getCards().get(a).geteRank().getiRankNbr() == super.getCards().get(a+1).geteRank().getiRankNbr() - 1)
			{
				if (a == 1)
				{
					if (super.getCards().get(a).geteRank() == eRank.FIVE && super.getCards().get(a-1).geteRank() == eRank.ACE)
					{
						break;
					}
				}
				bisStraightFlush = false;
				break;
			}
		}
		for (eSuit eSuit : eSuit.values()) {
			for (Card c : super.getCards()) {
				if (eSuit == c.geteSuit()) {
					iSuitCnt++;
				}
			}
			if (iSuitCnt > 0)
				break;
		}

		if (iSuitCnt != iCardCnt)
			bisStraightFlush = false;
		else {
		HandScorePoker HSP = (HandScorePoker) this.getHS();
		HSP.seteHandStrength(eHandStrength.StraightFlush);
		int iGetCard = this.getCRC().get(0).getiCardPosition();
		HSP.setHiCard(this.getCards().get(iGetCard));
		HSP.setLoCard(null);
		HSP.setKickers(FindTheKickers(this.getCRC()));
		this.setHS(HSP);
			return bisStraightFlush;}
		return bisStraightFlush;
	}
	

	public boolean isFourOfAKind() {
		boolean bisFourOfAKind = false;
		if (this.getCRC().size() == 2) {
			if(this.getCRC().get(1).getiCnt() == Constants.FOUR_OF_A_KIND) {
				HandScorePoker HSP = (HandScorePoker) this.getHS();
				HSP.seteHandStrength(eHandStrength.FourOfAKind);
				int iGetCard = this.getCRC().get(0).getiCardPosition();
				HSP.setHiCard(this.getCards().get(iGetCard));
				HSP.setLoCard(null);
				HSP.setKickers(FindTheKickers(this.getCRC()));
				this.setHS(HSP);}
			bisFourOfAKind = true;}
		return bisFourOfAKind;
	}

	
	public boolean isFullHouse() {
		boolean bisFullHouse = true;
			if(this.getCRC().get(0).getiCnt() == Constants.TWO_OF_A_KIND && this.getCRC().get(1).getiCnt() == Constants.THREE_OF_A_KIND) {
				HandScorePoker HSP = (HandScorePoker) this.getHS();
				HSP.seteHandStrength(eHandStrength.FullHouse);
				int iGetCard = this.getCRC().get(0).getiCardPosition();
				HSP.setHiCard(this.getCards().get(iGetCard));
				HSP.setLoCard(null);
				HSP.setKickers(FindTheKickers(this.getCRC()));
				this.setHS(HSP);}
		return bisFullHouse;

	}

	public boolean isFlush() {
		boolean bisFlush = false;

		int iCardCnt = super.getCards().size();
		int iSuitCnt = 0;

		for (eSuit eSuit : eSuit.values()) {
			for (Card c : super.getCards()) {
				if (eSuit == c.geteSuit()) {
					iSuitCnt++;
				}
			}
			if (iSuitCnt > 0)
				break;
		}

		if (iSuitCnt == iCardCnt) {
			HandScorePoker HSP = (HandScorePoker) this.getHS();
			HSP.seteHandStrength(eHandStrength.Flush);
			int iGetCard = this.getCRC().get(0).getiCardPosition();
			HSP.setHiCard(this.getCards().get(iGetCard));
			HSP.setLoCard(null);
			HSP.setKickers(FindTheKickers(this.getCRC()));
			this.setHS(HSP);
		
			bisFlush = true;}
		else
			bisFlush = false;

		return bisFlush;
	}

	public boolean isStraight() {
		boolean bisStraight = true;
		HandScorePoker HSP = (HandScorePoker) this.getHS();
		HSP.seteHandStrength(eHandStrength.Straight);
		int iGetCard = this.getCRC().get(0).getiCardPosition();
		HSP.setHiCard(this.getCards().get(iGetCard));
		HSP.setLoCard(null);
		HSP.setKickers(FindTheKickers(this.getCRC()));
		this.setHS(HSP);
		int iCardCnt = super.getCards().size();

		
		for (int a = 0; a<iCardCnt - 1; a++)
		{
			if (super.getCards().get(a).geteRank().getiRankNbr() == super.getCards().get(a+1).geteRank().getiRankNbr() - 1)
			{
				if (a == 1)
				{
					if (super.getCards().get(a).geteRank() == eRank.FIVE && super.getCards().get(a-1).geteRank() == eRank.ACE)
					{
						break;
					}
				}
				bisStraight = false;
				break;
			}
		}
		
		return bisStraight;

	}

	// This is how to implement one of the 'counting' hand types. Testing to see if
	// there are three of the same rank.
	public boolean isThreeOfAKind() {
		boolean bisThreeOfAKind = false;
		if (this.getCRC().size() == 3) {
			if (this.getCRC().get(2).getiCnt() == Constants.THREE_OF_A_KIND) {
				HandScorePoker HSP = (HandScorePoker) this.getHS();
				HSP.seteHandStrength(eHandStrength.ThreeOfAKind);
				int iGetCard = this.getCRC().get(0).getiCardPosition();
				HSP.setHiCard(this.getCards().get(iGetCard));
				HSP.setLoCard(null);
				HSP.setKickers(FindTheKickers(this.getCRC()));
				this.setHS(HSP);}
			bisThreeOfAKind = true;}
		return bisThreeOfAKind;
	}

	public boolean isTwoPair() {
		boolean bisTwoPair = false;
		if(this.getCRC().size() == 3) {
			if(this.getCRC().get(0).getiCnt() == Constants.TWO_OF_A_KIND && this.getCRC().get(1).getiCnt() == Constants.TWO_OF_A_KIND) {
				HandScorePoker HSP = (HandScorePoker) this.getHS();
				HSP.seteHandStrength(eHandStrength.TwoPair);
				int iGetCard = this.getCRC().get(0).getiCardPosition();
				HSP.setHiCard(this.getCards().get(iGetCard));
				HSP.setLoCard(null);
				HSP.setKickers(FindTheKickers(this.getCRC()));
				this.setHS(HSP);}
			bisTwoPair = true;}
		return bisTwoPair;
	}

	public boolean isPair() {
		boolean bisPair = false;
		if(this.getCRC().size() == 4) {
			if(this.getCRC().get(0).getiCnt() == Constants.TWO_OF_A_KIND) {
				HandScorePoker HSP = (HandScorePoker) this.getHS();
				HSP.seteHandStrength(eHandStrength.Pair);
				int iGetCard = this.getCRC().get(0).getiCardPosition();
				HSP.setHiCard(this.getCards().get(iGetCard));
				HSP.setLoCard(null);
				HSP.setKickers(FindTheKickers(this.getCRC()));
				this.setHS(HSP);
				bisPair = true;
				}
			}
		return bisPair;
	}

	public boolean isHighCard() {
		boolean bisHighCard = true;
		HandScorePoker HSP = (HandScorePoker) this.getHS();
		HSP.seteHandStrength(eHandStrength.Pair);
		int iGetCard = this.getCRC().get(0).getiCardPosition();
		HSP.setHiCard(this.getCards().get(iGetCard));
		HSP.setLoCard(null);
		HSP.setKickers(FindTheKickers(this.getCRC()));
		this.setHS(HSP);
		if (isRoyalFlush() != false && isStraightFlush() != false && isFourOfAKind() != false && isThreeOfAKind() != false && 
				isFullHouse() != false && isFlush() != false && isStraight() != false && isTwoPair() != false &&
				isPair() != false) {
			bisHighCard = false;
		}
		return bisHighCard;
	}

	private ArrayList<Card> FindTheKickers(ArrayList<CardRankCount> CRC) {
		ArrayList<Card> kickers = new ArrayList<Card>();

		for (CardRankCount crcCheck : CRC) {
			if (crcCheck.getiCnt() == 1) {
				kickers.add(this.getCards().get(crcCheck.getiCardPosition()));
			}
		}

		return kickers;
	}

	private void Frequency() {
		CRC = new ArrayList<CardRankCount>();
		int iCnt = 0;
		int iPos = 0;
		for (eRank eRank : eRank.values()) {
			iCnt = (CountRank(eRank));
			if (iCnt > 0) {
				iPos = FindCardRank(eRank);
				CRC.add(new CardRankCount(eRank, iCnt, iPos));
			}
		}
		Collections.sort(CRC);
	}

	private int CountRank(eRank eRank) {
		int iCnt = 0;
		for (Card c : super.getCards()) {
			if (c.geteRank() == eRank) {
				iCnt++;
			}
		}
		return iCnt;
	}

	private int FindCardRank(eRank eRank) {
		int iPos = 0;

		for (iPos = 0; iPos < super.getCards().size(); iPos++) {
			if (super.getCards().get(iPos).geteRank() == eRank) {
				break;
			}
		}
		return iPos;
	}

}
