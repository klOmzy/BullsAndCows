package com.game.bullsandcows;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GameControlTest {

    @Test
    void testGetInstance() {
        GameControl instance1 = GameControl.getInstance();
        GameControl instance2 = GameControl.getInstance();
        assertSame(instance1, instance2, "Singleton instance should be the same");
    }
}
