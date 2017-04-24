package az.mm.spiralmatrix.models;

import javax.validation.constraints.Min;

/**
 *
 * @author MM <mushfiqazeri@gmail.com>
 */
public class Matrix {
    
    @Min(2)
    private String row;
    
    @Min(2)
    private String column;
    
    
    public Matrix() {
    }

    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }
    
}
