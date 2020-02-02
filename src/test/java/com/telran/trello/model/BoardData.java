package com.telran.trello.model;

public class BoardData {
    private  String boardName;
    String board;

    public String getBoardName() {
        return boardName;
    }

    public BoardData setBoardName (String boardName){
    this.boardName = boardName;
    return this;
    }

    @Override
    public String toString() {
        return "BoardData{" +
                "boardName='" + boardName + '\'' +
                '}';
    }
}




