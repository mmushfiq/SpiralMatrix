package az.mm.spiralmatrix.models;

/**
 *
 * @author MM <mushfiqazeri@gmail.com>
 */
public class Element {
    private int row;
    private int column;

    public Element() {
    }

    public Element(int row, int column) {
        this.row = row;
        this.column = column;
    }
    
    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }
    
}
