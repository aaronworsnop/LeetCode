class Solution1366 {
  public String rankTeams(String[] votes) {

    // Edge and known cases
    if (votes.length == 0) {
      // No valid ranking
      return "";
    } else if (votes.length == 1) {
      // Only one voter
      return votes[0];
    }

    // Build a representation of each team's ranking
    int[][] teamRankings = determineTeamRankings(votes);

    // Sort representation by our ranking system
    int numberOfTeams = votes[0].length();
    Arrays.sort(
        teamRankings,
        (a, b) -> {
          for (int position = 0; position < numberOfTeams; position++) {
            int team1 = a[position];
            int team2 = b[position];

            if (team1 > team2) {
              return -1;
            }

            if (team1 < team2) {
              return 1;
            }
          }

          return 0;
        });

    // Construct our final ranking
    StringBuilder builder = new StringBuilder();
    for (int team = 0; team < numberOfTeams; team++) {
      char teamAtPosition = (char) (teamRankings[team][numberOfTeams] + 'A');

      builder.append(teamAtPosition);
    }

    return builder.toString();
  }

  private int[][] determineTeamRankings(String[] votes) {
    int numberOfTeams = votes[0].length();
    int numberOfVoters = votes.length;

    // Use an extra column to track of which row represents which team
    int[][] teamRankings = new int[26][numberOfTeams + 1];
    for (int team = 0; team < 26; team++) {
      teamRankings[team][numberOfTeams] = team;
    }

    for (int voter = 0; voter < numberOfVoters; voter++) {
      String currentRanking = votes[voter];

      for (int position = 0; position < numberOfTeams; position++) {
        char currentTeam = currentRanking.charAt(position);
        teamRankings[currentTeam - 'A'][position]++;
      }
    }

    return teamRankings;
  }
}
