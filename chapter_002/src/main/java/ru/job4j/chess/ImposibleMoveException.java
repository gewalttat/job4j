package ru.job4j.chess;

public class ImposibleMoveException extends RuntimeException {

    public ImposibleMoveException(String error) {
        error = "wrong turn";
    }
}