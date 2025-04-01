package ru.nsu.zarcer;

import java.util.Objects;

/**
 * Position class, needed for comparing, moving.
 */
public class Position {

    private int firstCoordinate;
    private int secondCoordinate;

    /**
     * Initializer with coordinates.
     *
     * @param firstCoordinate x
     *
     * @param secondCoordinate y
     *
     */
    public Position(int firstCoordinate, int secondCoordinate) {
        this.firstCoordinate = firstCoordinate;
        this.secondCoordinate = secondCoordinate;
    }

    public Position move(Direction direction) {
        switch (direction) {
            case UP:
                return new Position(firstCoordinate, secondCoordinate - 1);
            case DOWN:
                return new Position(firstCoordinate, secondCoordinate + 1);
            case LEFT:
                return new Position(firstCoordinate - 1, secondCoordinate);
            case RIGHT:
                return new Position(firstCoordinate + 1, secondCoordinate);
            default:
                return this;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Position)) {
            return false;
        }
        Position p = (Position) o;
        return this.firstCoordinate == p.firstCoordinate && this.secondCoordinate == p.secondCoordinate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstCoordinate, secondCoordinate);
    }

    public int getX() {
        return firstCoordinate;
    }

    public int getY() {
        return secondCoordinate;
    }
}
