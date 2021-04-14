package com.jitterted.ebp.blackjack.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class GameOutcomeTest {

  @Test
  public void playerHasHandThatBeatsDealerThenOutcomeIsPlayerBeatsDealer() throws Exception {
    Deck playerBeatsDealerDeck = new StubDeck(Rank.QUEEN, Rank.EIGHT,
                                              Rank.TEN, Rank.JACK);
    Game game = new Game(playerBeatsDealerDeck);
    game.initialDeal();

    game.playerStands();

    assertThat(game.determineOutcome())
        .isEqualByComparingTo(GameOutcome.PLAYER_BEATS_DEALER);
  }

  @Test
  public void playerHitsAndGoesBustAndLoses() throws Exception {
    Deck playerHitsAndBustsDeck = StubDeck.playerHitsAndBustsDeck();
    Game game = new Game(playerHitsAndBustsDeck);
    game.initialDeal();

    game.playerHits();

    assertThat(game.determineOutcome())
        .isEqualByComparingTo(GameOutcome.PLAYER_BUSTS);
  }

  @Test
  public void playerWinsBlackjack() throws Exception {
    Deck playerDealtBlackjackDeck = new StubDeck(Rank.QUEEN, Rank.EIGHT,
                                                 Rank.ACE, Rank.JACK);
    Game game = new Game(playerDealtBlackjackDeck);

    game.initialDeal();

    assertThat(game.determineOutcome())
        .isEqualByComparingTo(GameOutcome.PLAYER_WINS_BLACKJACK);
  }

  @Test
  public void playerStandsResultsInDealerDrawAdditionalCard() throws Exception {
    Deck dealerDrawsCardDeck = new StubDeck(Rank.TEN,  Rank.QUEEN,
                                            Rank.NINE, Rank.FIVE,
                                                       Rank.SIX);
    Game game = new Game(dealerDrawsCardDeck);
    game.initialDeal();

    game.playerStands();

    assertThat(game.dealerHand().cards())
        .hasSize(3);
  }

}