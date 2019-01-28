package com.accolite.mockito;

public class Bowling{
	 private int[] rolls = new int[100];
	    private int currentRoll = 0;

	    public void roll(int pin) {
	        rolls[currentRoll++] = pin;
	    }

	    public int score() {
	        int score = 0;
	        int frameIndex = 0;
	        for (int frame = 0; frame < 10; frame++) {
	            if (isStrike(rolls[frameIndex])) {
	                score += 10 + rolls[frameIndex + 1] + rolls[frameIndex + 2];
	                frameIndex++;
	            } else if (isSpare(frameIndex)) {
	                score += 10 + rolls[frameIndex + 2];
	                frameIndex += 2;
	            } else {
	                score += rolls[frameIndex] + rolls[frameIndex + 1];
	                frameIndex += 2;
	            }
	        }
	        return score;
	    }

	    private boolean isStrike(int roll) {
	        return roll == 10;
	    }

	    private boolean isSpare(int frameIndex) {
	        return isStrike(rolls[frameIndex] + rolls[frameIndex + 1]);
	    }
}