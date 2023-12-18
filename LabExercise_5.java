class Player implements Runnable {
    private String playerName;
    private int totalScore;

    public Player(String playerName) {
        this.playerName = playerName;
        this.totalScore = 0;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void playGame() {
        // Simulate playing a game and updating the score
        int points = (int) (Math.random() * 10);
        totalScore += points;
        System.out.println(playerName + " scored " + points + " points in a game.");
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) { // make the player run 3 games
            playGame();
            try {
                Thread.sleep(1000); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class LabExercise_5 {
    public static void main(String[] args) {

        Player player1 = new Player("Player1");
        Player player2 = new Player("Player2");

        Thread thread1 = new Thread(player1);
        Thread thread2 = new Thread(player2);
        thread1.start();
        thread2.start();

	//so once i have created the threadss, i''ll wait for it to finish its execution state
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // then ill display final scores
        System.out.println("\nFinal Scores:");
        System.out.println(player1.getPlayerName() + ": " + player1.getTotalScore() + " points");
        System.out.println(player2.getPlayerName() + ": " + player2.getTotalScore() + " points");
    }
}
