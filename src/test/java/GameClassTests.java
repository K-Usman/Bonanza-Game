import org.example.Game;

public class GameClassTests {
    @Test
    public void testgPlayerCount() {
        Game gameTests = new Game();
        List<Player> playersList1 = Arrays.asList(
                new Player("Player 1"),
                new Player("Player 2"),
                new Player("Player 3")
        );
        int players = gameTests.countPlayers(playersList1);
        assertEquals(3, players);


    }
}
