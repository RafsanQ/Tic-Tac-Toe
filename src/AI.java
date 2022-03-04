import java.util.ArrayList;
import java.util.Collections;

public class AI {
    
    // Makes a Random Move
    Location makeMove(GridTracker virtualGrid){
        ArrayList<Location> possibleMoves = new ArrayList<Location>();
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++) {
                if (!virtualGrid.checkIfOccupied(new Location(i,j)))
                    possibleMoves.add(new Location(i,j));
            }
        }
        Collections.shuffle(possibleMoves);
        return possibleMoves.get(0);
    }
}
