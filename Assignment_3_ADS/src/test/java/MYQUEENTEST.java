import org.example.Backtracking;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.InvalidAlgorithmParameterException;

public class MYQUEENTEST {

    public Backtracking backtracking;

    @BeforeEach
    public void setUp() throws InvalidAlgorithmParameterException {
        backtracking = new Backtracking(4);
    }

    @Test
    public void canItRun()
    {
        backtracking.tryStep(0);

        backtracking.printBoard();
    }

}
