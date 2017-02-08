package example.practise.katas.karate_data_munging;

public class TeamInfo implements Comparable {
    private String teamName;
    private int scored;
    private int againstScored;
    private int scoreSpread;

    public TeamInfo(String teamName, int scored, int againstScored) {
        this.teamName = teamName;
        this.scored = scored;
        this.againstScored = againstScored;
    }

    public String getTeamName() {
        return teamName;
    }

    public int getScored() {
        return scored;
    }

    public int getAgainstScored() {
        return againstScored;
    }

    public int getScoreSpread() {
        return scoreSpread;
    }

    public void setScoreSpread() {
        this.scoreSpread = Math.abs(this.scored - this.againstScored);
    }

    @Override
    public int compareTo(Object o) {
        TeamInfo teamInfo = (TeamInfo) o;
        return scoreSpread < teamInfo.scoreSpread ? 1 : 0;
    }
}
