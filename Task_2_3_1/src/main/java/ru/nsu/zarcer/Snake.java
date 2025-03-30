package ru.nsu.zarcer;

import java.util.LinkedList;

public class Snake {
    private LinkedList<Position> body;
    private Direction direction;

    public Snake(int startX, int startY) {
        body = new LinkedList<>();
        body.add(new Position(startX, startY));
        direction = Direction.RIGHT;
    }

    public LinkedList<Position> getBody() {
        return body;
    }

    public void setDirection(Direction newDirection) {
        if ((direction == Direction.UP && newDirection == Direction.DOWN) ||
            (direction == Direction.DOWN && newDirection == Direction.UP) ||
            (direction == Direction.LEFT && newDirection == Direction.RIGHT) ||
            (direction == Direction.RIGHT && newDirection == Direction.LEFT)) {
            return;
        }
        direction = newDirection;
    }

    public Direction getDirection() {
        return direction;
    }

    public Position getHead() {
        return body.getFirst();
    }

    public void move(boolean ateFood) {
        Position newHead = getHead().move(direction);
        body.addFirst(newHead);
        if (!ateFood) {
            body.removeLast();
        }
    }

    public boolean checkCollision(Position pos) {
        return body.contains(pos);
    }
}


