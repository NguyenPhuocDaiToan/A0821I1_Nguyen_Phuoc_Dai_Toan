package ss8_Cleancode_Refactoring.BaiTap;

public class TennisGame {

    public static String getScore(String player1Name, String player2Name, int scorePlayer1, int scorePlayer2) {
        String score = "";
        if (scorePlayer1 == scorePlayer2) {
            score = getScorePlayer(scorePlayer1);
            score += "-All";
        }
        else if (scorePlayer1 >= 4 || scorePlayer2 >= 4) {
            if (scorePlayer1 > scorePlayer2) {
                score = "Advantage player1";
            }
            else {
                score = "Advantage player2";
            }
        }
        else {
            score = getScorePlayer(scorePlayer1) + "-" + getScorePlayer(scorePlayer2);
        }
        return score;
    }

    private static String getScorePlayer(int scorePlayer) {
        String score;
        switch (scorePlayer)
        {
            case 0:
                score = "Love";
                break;
            case 1:
                score = "Fifteen";
                break;
            case 2:
                score = "Thirty";
                break;
            case 3:
                score = "Forty";
                break;
            default:
                score = "Deuce";
        }
        return score;
    }
}