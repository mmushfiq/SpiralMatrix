package az.mm.spiralmatrix.process;

import az.mm.spiralmatrix.models.Element;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MM <mushfiqazeri@gmail.com>
 */
public class SpiralOrder {
    private final int row;
    private final int column;
    private final List<Element> elementList;

    public SpiralOrder(int row, int column) {
        this.row = row;
        this.column = column;
        elementList = new ArrayList<>();
    }
    
    public List<Element> getSpiralMatrixElementsClockwise() {

        int left = (column%2 == 0) ? (column/2 - 1) : (column/2);
        int right = left + 1;
        int top = (row%2 == 0) ? (row/2 - 1) : (row/2);
        int bottom = top + 1;

        OUTER: while (true) {

            for (int i = left; i < right; i++) {
                if(!printElement(top, i)) break OUTER;
            }
            left--;

            for (int i = top; i < bottom; i++) {
                if(!printElement(i, right)) break OUTER;
            }
            top--;

            for (int i = right; i > left; i--) {
                if(!printElement(bottom, i)) break OUTER;
            }
            right++;

            for (int i = bottom; i > top; i--) {
                if(!printElement(i, left)) break OUTER;
            }
            bottom++;
        }
        
        return elementList;
    }
    
    
    public List<Element> getSpiralMatrixElementsCounterClockwise() {
        
        int right = column/2;
        int left = right - 1;
        int top = (row%2 == 0) ? (row/2 - 1) : (row/2);
        int bottom = top + 1;
        
        OUTER: while (true) {

            for (int i = right; i > left; i--) {
                if(!printElement(top, i)) break OUTER;
            }
            right++;

            for (int i = top; i < bottom; i++) {
                if(!printElement(i, left)) break OUTER;
            }
            top--;

            for (int i = left; i < right; i++) {
                if(!printElement(bottom, i)) break OUTER;
            }
            left--;
           
            for (int i = bottom; i > top; i--) {
                if(!printElement(i, right)) break OUTER;
            }
            bottom++;
        }
        
        return elementList;
    }
    
    
    private boolean printElement(int i, int j) {
        if (i<0 || i>=row || j<0 || j>=column) return false;
        elementList.add(new Element(i, j));
       return true;
    }
}
