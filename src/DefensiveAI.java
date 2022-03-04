public class DefensiveAI extends AI {
    private GridTracker virtualGrid;

    private Location checkRows(){

        // Check each Row
        for(int i=0; i<3; i++){
            int occupiedCount = 0;
            int emptyCount = 0;
            int emptyIndex = 0;

            // Check each column of this row
            for(int j=0; j<3; j++){
                if(virtualGrid.checkIfPlayerOccupied(new Location(i, j)))
                    occupiedCount++;
                else if(!virtualGrid.checkIfOccupied(new Location(i, j))){
                    emptyCount++;
                    emptyIndex = j;     // This is where the AI would have to occupy next if the other two tiles are occupied by the player.
                }
            }
            if(occupiedCount == 2 && emptyCount == 1)       // This would mean 2 tiles are occupied and 1 is empty
                return new Location(i, emptyIndex);
        }

        return null;
    }

    private Location checkColumns(){
        // Check each column
        for(int i=0; i<3; i++){
            int occupiedCount = 0;
            int emptyCount = 0;
            int emptyIndex = 0;

            // Check each row of this column
            for(int j=0; j<3; j++){
                if(virtualGrid.checkIfPlayerOccupied(new Location(j, i)))
                    occupiedCount++;
                else if(!virtualGrid.checkIfOccupied(new Location(j, i))){
                    emptyCount++;
                    emptyIndex = j;     // This is where the AI would have to occupy next if the other two tiles are occupied by the player.
                }
            }
            if(occupiedCount == 2 && emptyCount == 1)   // This would mean 2 tiles are occupied and 1 is empty
                return new Location(emptyIndex, i);
        }

        return null;
    }

    private Location checkDiagonals(){
        int occupiedCount = 0;
        int emptyCount = 0;
        int emptyIndex = 0;

        // Check 1st Diagonal
        for(int i=0; i<3; i++){
            if(virtualGrid.checkIfPlayerOccupied(new Location(i, i)))
                occupiedCount++;
            else if(!virtualGrid.checkIfOccupied(new Location(i, i))){
                emptyCount++;
                emptyIndex = i;
            }

        }
        // This would mean 2 tiles are occupied and 1 is empty
        if(occupiedCount == 2 && emptyCount == 1)
            return new Location(emptyIndex, emptyIndex);

        // Reinitialise
        occupiedCount = 0;
        emptyCount = 0;
        emptyIndex = 0;

        // Check 2nd Diagonal
        for(int i=0; i<3; i++){
            if(virtualGrid.checkIfPlayerOccupied(new Location(i, 2-i)))
                occupiedCount++;
            else if(!virtualGrid.checkIfOccupied(new Location(i, 2-i))){
                emptyCount++;
                emptyIndex = i;
            }
        }

        // This would mean 2 tiles are occupied and 1 is empty
        if(occupiedCount == 2 && emptyCount == 1)
            return new Location(emptyIndex, 2-emptyIndex);

        return null;
    }

    private boolean isNotNull(Location location){
        if(location == null)
            return false;
        return true;
    }

    @Override
    Location makeMove(GridTracker virtualGrid) {
        this.virtualGrid = virtualGrid;
        Location reqMove = checkRows();
        if(isNotNull(reqMove))
            return reqMove;
        reqMove = checkColumns();
        if(isNotNull(reqMove))
            return reqMove;
        reqMove = checkDiagonals();
        if(isNotNull(reqMove))
            return reqMove;

        // If no immediate threat is found, the super is returned which returns a random move
        return super.makeMove(virtualGrid);
    }
}
