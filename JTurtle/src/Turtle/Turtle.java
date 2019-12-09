package Turtle;

import static Turtle.Shapes.SHAPES;
import javafx.scene.Group;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

public class Turtle implements Shapes {

    protected Group shapes;
    private int height = 400;
    private int width = 600;
    private double x = 0, y = 0, angle = 0; //angle defined with the imaginary horizontal axis, counterclockwise direction
    private double X, Y; // Coordinates used for the user, which the center is at the middle of the window
    //PS: The middle of axis which belogs to shapes is at upper left side of the window
    private boolean pen_down = true; //true stands for pen down (writing), false for pen up (not writing)

    public Turtle(Group figures, int width, int height) {
        shapes = figures;
        this.width = width;
        this.height = height;
        x = cord_x(x);
        y = cord_y(y);
    }

    public Turtle() {
        shapes = SHAPES;
        x = cord_x(x);
        y = cord_y(y);
    }

    public Turtle(Group figures) {
        shapes = figures;
        x = cord_x(x);
        y = cord_y(y);
    }

    // Functions wich converts the coordinate to the correct position for shapes
    public double cord_x(double x) {
        X = x;
        return (double) (x + get_width() / 2) % get_width();

    }

    public double cord_y(double y) {
        Y = y;
        return (double) (-y + get_height() / 2) % get_height();
    }

    // Converting degrees to radians
    public static double to_radians(double angle_in_degrees) {
        return angle_in_degrees * Math.PI / 180.0;
    }

    // Coverting radians to degrees
    public static double to_degrees(double angle_in_radians) {
        return angle_in_radians * 180.0 / Math.PI;
    }

    public double get_xcor() {
        return this.x;
    }

    public double get_ycor() {
        return this.y;
    }

    // Function wich converts the coordinate to the correct position for shapes
    public double get_convertedX(double x) {
        int halfWidth = get_width() / 2;
        if (x <= halfWidth) {
            x = Math.abs(x - halfWidth);
            return -x;
        } else {
            x %= halfWidth;
            return x;
        }
    }

    public double get_convertedY(double y) {
        int halfHeigth = get_height() / 2;
        if (y <= halfHeigth) {
            y = Math.abs(y - halfHeigth);
            return y;
        } else {
            y %= halfHeigth;
            return -y;
        }
    }

    public int get_width() {
        return this.width;
    }

    public int get_height() {
        return this.height;
    }

    public double get_angle() {
        return this.angle;
    }

    public double[] get_position() {
        double[] position = {this.x, this.y};
        return position;
    }

    public double getX() {
        return this.X;
    }

    public double getY() {
        return this.Y;
    }

    public void set_xcor(double new_x) {
        X = new_x;
        this.x = cord_x(new_x);
    }

    public void set_ycor(double new_y) {
        Y = new_y;
        this.y = cord_y(new_y);
    }

    public void set_angle(double new_angle) {
        if (new_angle >= 0) {
            this.angle = new_angle % 360;
        } else {
            this.angle = 360 - new_angle % 360;
        }
    }

    public void set_position(double new_x, double new_y) {
        X = new_x;
        Y = new_y;
        this.x = cord_x(new_x);
        this.y = cord_y(new_y);
    }

    public boolean getPenDown() {
        return this.pen_down;
    }

    // Moving turtle forward
    public void forward(double dist) {
        double old_x = get_xcor();
        double old_y = get_ycor();
        this.x += dist * Math.cos(to_radians(this.angle));
        this.y -= dist * Math.sin(to_radians(this.angle));
        X = get_convertedX(x);
        Y = get_convertedY(y);
        if (pen_down) {
            line(old_x, old_y, x, y);
        }

    }

    // // Moving turtle backward
    public void backward(double dist) {
        double old_x = get_xcor();
        double old_y = get_ycor();
        this.x -= dist * Math.cos(to_radians(this.angle));
        this.y += dist * Math.sin(to_radians(this.angle));
        X = get_convertedX(x);
        Y = get_convertedY(y);
        if (pen_down) {
            line(old_x, old_y, x, y);
        }
    }

    // Turning turtle to left
    public void left(double angle) {
        this.angle += angle;
        this.angle %= 360;
    }
    // Turning turtle to right
    public void right(double angle) {
        this.angle -= angle;
        this.angle %= 360;
    }

    public void go_to(double new_x, double new_y) {
        double dy = cord_y(new_y) - this.y;
        double dx = cord_x(new_x) - this.x;
        //turn to the correct angle
        if (dx >= 0) {
            this.set_angle(to_degrees(Math.atan(dy / dx)));
        } else {
            this.set_angle(180 + to_degrees(Math.atan(dy / dx)));
        }
        //walk the correct distance
        double dist = Math.sqrt(dx * dx + dy * dy);
        this.forward(dist);
    }

    // Setting the pen atribute
    public void pen_up() {
        this.pen_down = false;
    }

    public void pen_down() {
        this.pen_down = true;
    }

    // Getting the shapes drawn by turtle
    public Group getShapesTurtle() {
        return this.shapes;
    }

    // Reseting shapes drawn by turtle
    public void resetShapesTurtle() {
        this.shapes = new Group();
        this.x = cord_x(0);
        this.y = cord_y(0);
        this.angle = 0;
        this.pen_down = true;
    }

    // ---------------------Shape fuctions-----------------------------
    // Drawing a line and adding it to shapes
    private void line(double x1, double y1, double x2, double y2) {
        Line line = new Line(x1, y1, x2, y2);
        shapes.getChildren().add(line);
    }

    // Drawing a square
    public void drawSquare(double length) {
        int side = 0;
        while (side < 4) {
            forward(length);
            set_angle(90 + get_angle());
            side++;
        }

    }

    // Drawing a rectangle
    public void drawRectangle(double length1, double length2) {
        int side = 0;
        while (side < 2) {
            forward(length1);
            set_angle(90 + get_angle());
            forward(length2);
            set_angle(90 + get_angle());
            side++;
        }
    }

    // Drawing a circle
    public void drawCircle(double radious) {
        if (pen_down) {
            Circle circle = new Circle();
            circle.setCenterX(get_xcor());
            circle.setCenterY(get_ycor());
            circle.setRadius(radious);
            shapes.getChildren().add(circle);
        }
    }

    // Dreawing a pentagon
    public void drawPentagon(double length) {
        int side = 0;
        while (side < 5) {
            forward(length);
            set_angle(72 + get_angle());
            side++;
        }
    }
}
