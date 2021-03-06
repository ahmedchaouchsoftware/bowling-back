package com.game.ten.pin.bowling.service;

import com.game.ten.pin.bowling.utils.BowlingGameUtils;
import org.springframework.stereotype.Service;

@Service
public class GameBowlingImplService implements GameBowlingServiceInterface {

    private Integer[] game = new Integer[21];
    private int currentRound = 0;

    @Override
    public Integer[] play(Integer hitPins) {
        game[currentRound++] = hitPins;
        return game;
    }

    @Override
    public Integer calculateGlobalScore() {
        int score = 0;
        int frameIndex = 0;

        for (int frame = 0; frame < 10; frame++) {
            if (BowlingGameUtils.isStrike(frameIndex, game)) {
                score += 10 + BowlingGameUtils.calculateStrikeBonus(frameIndex, game);
                frameIndex++;
            } else if (BowlingGameUtils.isSpare(frameIndex, game)) {
                score += 10 + BowlingGameUtils.calculateSpareBonus(frameIndex, game);
                frameIndex += 2;
            } else {
                score += BowlingGameUtils.calculateFrameScore(frameIndex, game);
                frameIndex += 2;
            }
        }
        return score;
    }

    @Override
    public Integer calculateIntermediateFrameScore(Integer frameIndex, Integer[] game) {
        return BowlingGameUtils.calculateFrameScore(frameIndex,game);
    }
}
