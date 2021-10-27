package lab2.dvizeckiObjekti;

import java.util.ArrayList;
import java.util.List;

public class MovablesCollection {
    private final List<Movable> objects;
    public static int X;
    public static int Y;

    public MovablesCollection(int x, int y) {
        X = x;
        Y = y;
        objects = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb
                .append("Collection of movable objects with size ")
                .append(objects.size())
                .append(":\n");

        for (Movable object : objects) {
            sb
                    .append(object.toString())
                    .append("\n");
        }

        return sb.toString();
    }

    private boolean canFit(Movable m) {
        int x = m.getCurrentXPosition();
        int y = m.getCurrentYPosition();
        int r = 0;

        if (m.getType() == TYPE.CIRCLE)
            r = ((MovableCircle) m).getRadius();

        return x - r >= 0 && x + r <= MovablesCollection.X && y - r >= 0 && y + r <= MovablesCollection.Y;
    }

    public void addMovableObject(Movable m) throws MovableObjectNotFittableException {
        if (!canFit(m)) {
            if (m.getType() == TYPE.POINT) {
                throw new MovableObjectNotFittableException(String.format("Movable point with center (%d,%d) can not be fitted into the collection", m.getCurrentXPosition(), m.getCurrentYPosition()));
            } else {
                throw new MovableObjectNotFittableException(String.format("Movable circle with center (%d,%d) and radius %d can not be fitted into the collection", m.getCurrentXPosition(), m.getCurrentYPosition(), ((MovableCircle) m).getRadius()));
            }
        }

        objects.add(m);
    }

    public void moveObjectsFromTypeWithDirection(TYPE type, DIRECTION direction) throws ObjectCanNotBeMovedException {
        for (Movable object : objects) {
            if (object.getType() == type) {
                if (direction == DIRECTION.UP) {
                    object.moveUp();
                } else if (direction == DIRECTION.DOWN) {
                    object.moveDown();
                } else if (direction == DIRECTION.LEFT) {
                    object.moveLeft();
                } else if (direction == DIRECTION.RIGHT) {
                    object.moveRight();
                }
            }
        }
    }

    public static void setxMax(int i) {
        X = i;
    }

    public static void setyMax(int i) {
        Y = i;
    }
}