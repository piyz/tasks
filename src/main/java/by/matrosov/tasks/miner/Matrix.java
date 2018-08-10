package by.matrosov.tasks.miner;

public class Matrix {
    private Type [][] matrix;

    public Matrix(Type type) {
        matrix = new Type[Ranges.getSize().x][Ranges.getSize().y];
        for (Coordinate coordinate : Ranges.getAllCoordinate()) {
            matrix[coordinate.x][coordinate.y] = type;
        }
    }
}