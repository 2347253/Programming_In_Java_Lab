class EsportsTeamPlayer {

    private int id;
    private String playerName;
    private int age;
    private String favGame;
    private String teamName;
    int count;

    public EsportsTeamPlayer(int id, String playerName, int age, String favGame) {
        this.id = id;
        this.playerName = playerName;
        this.age = age;
        this.favGame = favGame;
    }

    public EsportsTeamPlayer(String playerName, String teamName) {				//ConstructorOverloading
        this.playerName = playerName;
        this.teamName = teamName;
    }

    public void tournamentParticipation(String playerName) {
        System.out.println(playerName + " has participated in " + count + " tournaments");	//Deafult Constructor and Method Overloading
    }

    public void tournamentParticipation(String playerName, int count) {
        System.out.println(playerName + " has participated in " + count + " tournaments");
    }

    public void tournamentParticipation(String playerName, int count, int winCount) {
        System.out.println(playerName + " has participated in " + count + " tournaments and has won " + winCount + " times.");
    }

    public static void main(String[] args) {

        EsportsTeamPlayer p1 = new EsportsTeamPlayer(1, "TenZ", 22, "Valorant");
        EsportsTeamPlayer p2 = new EsportsTeamPlayer(2, "ShahZam", 22, "Counter-Strike");
        EsportsTeamPlayer p3 = new EsportsTeamPlayer(3, "Dapr", 22, "League-Of-Legends");
        EsportsTeamPlayer t1 = new EsportsTeamPlayer("TenZ", "Sentinels");

        System.out.println(p1.playerName);
        System.out.println(t1.playerName + " is in the team " + t1.teamName);

        p1.tournamentParticipation(p1.playerName);
        p2.tournamentParticipation(p2.playerName, 10);
        p3.tournamentParticipation(p3.playerName, 5, 2);

    }
}
