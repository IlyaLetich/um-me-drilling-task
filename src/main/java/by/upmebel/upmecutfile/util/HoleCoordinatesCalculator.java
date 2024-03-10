package by.upmebel.upmecutfile.util;

import by.upmebel.upmecutfile.model.Furniture;
import by.upmebel.upmecutfile.model.Hole;

public class HoleCoordinatesCalculator {
    public static void calculateCoordinatesRelativeToFurniture(Furniture furniture, Hole hole, String coordinates) {
        String[] parts = coordinates.split("\\s*\\+\\s*");

        float x = 0;
        float y = 0;
        float z = 0;

        for (String part : parts) {
            String[] values = part.split("\\s*([+*/-])\\s*");
            if (values.length != 3) {
                throw new IllegalArgumentException("Invalid coordinates format");
            }

            float value = Float.parseFloat(values[0]);
            String operator = values[1];
            String dimension = values[2];

            switch (dimension) {
                case "L":
                    x = applyOperator(furniture.getLength(), value, operator);
                    break;
                case "B":
                    y = applyOperator(furniture.getWidth(), value, operator);
                    break;
                case "H":
                    z = applyOperator(furniture.getHeight(), value, operator);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid dimension: " + dimension);
            }
        }

        hole.setX(x);
        hole.setY(y);
        hole.setZ(z);
    }

    private static float applyOperator(float dimensionValue, float value, String operator) {
        switch (operator) {
            case "+":
                return dimensionValue + value;
            case "-":
                return dimensionValue - value;
            case "*":
                return dimensionValue * value;
            case "/":
                return dimensionValue / value;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
}
