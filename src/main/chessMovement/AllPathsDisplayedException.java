package main.chessMovement;

/**
 * @author Agustin Bettati
 * @author Marcos Khabie
 * @version 1.0
 *
 * This class represents the exception found when all of the paths of the horse
 * have been displayed.
 */
public class AllPathsDisplayedException extends RuntimeException {

    public AllPathsDisplayedException(String m) {
        super(m);
    }

    public AllPathsDisplayedException() {
    }
}
