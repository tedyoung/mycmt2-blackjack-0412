package com.jitterted.ebp.blackjack.domain;

public enum GameOutcome {
  PLAYER_BUSTS("You Busted, so you lose.  💸"),
  DEALER_BUSTS("Dealer went BUST, Player wins! Yay for you!! 💵"),
  PLAYER_BEATS_DEALER("You beat the Dealer! 💵"),
  PLAYER_PUSHES("Push: Nobody wins, we'll call it even."),
  PLAYER_LOSES("You lost to the Dealer. 💸"),
  PLAYER_WINS_BLACKJACK("You won Blackjack!");

  private String value;

  public String value() {
    return value;
  }

  GameOutcome(String value) {
    this.value = value;
  }
}