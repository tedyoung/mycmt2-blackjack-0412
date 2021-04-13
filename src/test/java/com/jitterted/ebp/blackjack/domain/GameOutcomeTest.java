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
    game.dealerTurn();

    assertThat(game.determineOutcome())
        .isEqualByComparingTo(GameOutcome.PLAYER_BEATS_DEALER);
  }

  @Test
  public void playerHitsAndGoesBustAndLoses() throws Exception {
    Deck playerHitsAndBustsDeck = new StubDeck(Rank.QUEEN, Rank.EIGHT,
                                               Rank.TEN, Rank.JACK,
                                               Rank.TWO);
    Game game = new Game(playerHitsAndBustsDeck);
    game.initialDeal();

    game.playerHits();

    assertThat(game.determineOutcome())
        .isEqualByComparingTo(GameOutcome.PLAYER_BUSTS);
  }

}