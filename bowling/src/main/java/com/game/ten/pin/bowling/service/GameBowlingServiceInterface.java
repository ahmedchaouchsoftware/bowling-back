package com.game.ten.pin.bowling.service;


public interface GameBowlingServiceInterface {

    Integer[] play(Integer hitPins) throws Exception;

    Integer calculateGlobalScore();

    Integer calculateIntermediateFrameScore(Integer frameIndex, Integer[] game);
}
