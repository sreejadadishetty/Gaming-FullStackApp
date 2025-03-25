package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import com.example.demo.service.GameService;

@RestController
@RequestMapping("/api/game")
@CrossOrigin("*")  
public class GameController {

    private GameService gameService = new GameService(); 

   
    @GetMapping("/board")
    public String[][] getBoard() {
        return gameService.getBoard();  
    }


    @GetMapping("/currentPlayer")
    public String getCurrentPlayer() {
        return gameService.getCurrentPlayer();  
    }

    
    @PostMapping("/move")
    public boolean makeMove(@RequestParam int row, @RequestParam int col) {
        return gameService.makeMove(row, col); 
    }

   
    @GetMapping("/winner")
    public String checkWinner(@RequestBody String[][] board) {
        return gameService.checkWinner(board);  
    }

    

    
    @PostMapping("/reset")
    public void resetGame() {
        gameService.resetBoard();  
    }
}
