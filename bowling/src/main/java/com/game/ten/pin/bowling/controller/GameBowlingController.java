package com.game.ten.pin.bowling.controller;

import com.game.ten.pin.bowling.service.GameBowlingServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Level;
import java.util.logging.Logger;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/game")
public class GameBowlingController {

    Logger logger = Logger.getLogger(GameBowlingController.class.getName());

    @Autowired
    private GameBowlingServiceInterface gameBowlingService;

    @GetMapping("/calculate-global-score")
    public ResponseEntity calculateGameGlobalScore() {
        try {
            return ResponseEntity.ok(gameBowlingService.calculateGlobalScore());
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage());
            return ResponseEntity.badRequest().body("Error while Retrieving Game Score");
        }
    }

    @PostMapping("/calculate-intermediate-score/{frameIndex}")
    public ResponseEntity calculateIntermediateFrameScore(@PathVariable Integer frameIndex,@RequestBody Integer[] game) {
        try {
            return ResponseEntity.ok(gameBowlingService.calculateIntermediateFrameScore(frameIndex, game));
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage());
            return ResponseEntity.badRequest().body("Error while Retrieving Game Score");
        }
    }

    @PostMapping("/play/{hitPins}")
    public ResponseEntity playGame(@PathVariable Integer hitPins) {
        try {
            if (hitPins > 10) {
                return ResponseEntity.badRequest().body("Hit Pins could not exceed 10 Pins");
            }
            return ResponseEntity.ok(gameBowlingService.play(hitPins));
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage());
            return ResponseEntity.badRequest().body("You Have Finished Your Game");
        }
    }
}
