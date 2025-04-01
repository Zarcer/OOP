package ru.nsu.zarcer;

import java.util.LinkedList;

/**
 * Model for snake body.
 */
public class Snake {
    private LinkedList<Position> body;
    private Direction direction;

    /**
     * Initializer with coordinates.
     *
     * @param startX first coordinate for pane
     *
     * @param startY second coordinate for pane
     *
     */
    public Snake(int startX, int startY) {
        body = new LinkedList<>();
        body.add(new Position(startX, startY));
        direction = Direction.RIGHT;
    }

    /**
     * Getter for snake body.
     *
     * @return use linked list for convince
     *
     */
    public LinkedList<Position> getBody() {
        return body;
    }

    /**
     *Second handler of user input.
     *
     * @param newDirection enum direction
     *
     */
    public void setDirection(Direction newDirection) {
        if ((direction == Direction.UP && newDirection == Direction.DOWN)
            || (direction == Direction.DOWN && newDirection == Direction.UP)
            || (direction == Direction.LEFT && newDirection == Direction.RIGHT)
            || (direction == Direction.RIGHT && newDirection == Direction.LEFT)) {
            return;
        }
        direction = newDirection;
    }

    /**
     * Getter for direction.
     *
     * @return enum
     *
     */
    public Direction getDirection() {
        return direction;
    }

    /**
     * Getter for head position.
     *
     * @return position type
     *
     */
    public Position getHead() {
        return body.getFirst();
    }

    /**
     * Move method, add head, delete one cell from tail if snake didn't eat.
     *
     * @param ateFood check for not removing cell
     *
     */
    public void move(boolean ateFood) {
        Position newHead = getHead().move(direction);
        body.addFirst(newHead);
        if (!ateFood) {
            body.removeLast();
        }
    }

    /**
     * Method for checking collision with wall or itself.
     *
     * @param pos position what needed to be checked
     *
     * @return boolean answer
     *
     */
    public boolean checkCollision(Position pos) {
        return body.contains(pos);
    }
}


