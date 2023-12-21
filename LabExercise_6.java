interface Player<T> {
    void play();
    T getPlayerInfo();
}


class Team<T extends Player<?>> {
    private String teamName;
    private T[] players;

    public Team(String teamName, T[] players) {
        this.teamName = teamName;
        this.players = players;
    }

    public void displayTeamInfo() {
        System.out.println("Team: " + teamName);
        System.out.println("Players:");

        for (T player : players) {
            System.out.println(player.getPlayerInfo());
        }
    }
}


class EsportsPlayer implements Player<String> {
    private String playerName;

    public EsportsPlayer(String playerName) {
        this.playerName = playerName;
    }

    @Override
    public void play() {
        System.out.println(playerName + " is playing.");
    }

    @Override
    public String getPlayerInfo() {
        return "Player: " + playerName;
    }
}

public class LabExercise_6 {
    public static void main(String[] args) {

        EsportsPlayer player1 = new EsportsPlayer(" Shawn");
        EsportsPlayer player2 = new EsportsPlayer(" Aadila");

       
        EsportsPlayer[] playersArray = {player1, player2};
        Team<EsportsPlayer> esportsTeam = new Team<>("Esports: Sentinals ", playersArray);

        
        esportsTeam.displayTeamInfo();
    }
}
