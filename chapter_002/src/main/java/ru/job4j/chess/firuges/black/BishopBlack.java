package ru.job4j.chess.firuges.black;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.*;

public class BishopBlack implements Figure {
    private final Cell position;
    public BishopBlack(final Cell position) {
        this.position = position;
    }
    @Override
    public Cell position() {
        return this.position;
    }
    @Override
    public Cell[] way(Cell source, Cell dest)throws ImposibleMoveException {
        if (!isDiagonal(source, dest)) {
            throw new ImposibleMoveException("wrong turn");
        }
        Cell[] steps = new Cell[Math.abs(source.x - dest.x)];
        int deltaX = Integer.compare(source.x, dest.x);
        int deltaY = Integer.compare(source.y, dest.y);
        for (int index = 0; index < steps.length; index++) {
            steps[index] = Cell.values()[(8 * (source.x - deltaX)) + (source.y - deltaY)];
            deltaX = deltaX < 0 ? deltaX - 1 : deltaX + 1;
            deltaY = deltaY < 0 ? deltaY - 1 : deltaY + 1;
        }
        return steps;
    }
    public boolean isDiagonal(Cell source, Cell dest) {
        return Math.abs(source.x - dest.x) == Math.abs(source.y - dest.y);
    }
    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
