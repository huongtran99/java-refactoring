package com.codegym;

public class TennisGame {

    public static final String LOVE = "Love";
    public static final String FIFTEEN = "Fifteen";
    public static final String THIRTY = "Thirty";
    public static final String FORTY = "Forty";
    public static final String ALL = "-All";

    public static String getScore(int m_score1, int m_score2) {
        String score = "";
        int tempScore = 0;
        boolean m_score1EqualM_score2 = m_score1 == m_score2;
        boolean m_score1M_score2For4 = m_score1 >= 4 || m_score2 >= 4;
        if (m_score1EqualM_score2) {
            switch (m_score1) {
                case 0:
                    score = LOVE + ALL;
                    break;
                case 1:
                    score = FIFTEEN + ALL;
                    break;
                case 2:
                    score = THIRTY + ALL;
                    break;
                case 3:
                    score = FORTY + ALL;
                    break;
                default:
                    score = "Deuce";
                    break;

            }
        } else {
            if (m_score1M_score2For4) {
                score = getString(m_score1, m_score2);
            } else {
                for (int i = 1; i < 3; i++) {
                    if (i == 1) tempScore = m_score1;
                    else {
                        score += "-";
                        tempScore = m_score2;
                    }
                    switch (tempScore) {
                        case 0:
                            score += LOVE;
                            break;
                        case 1:
                            score += FIFTEEN;
                            break;
                        case 2:
                            score += THIRTY;
                            break;
                        case 3:
                            score += FORTY;
                            break;
                    }
                }
            }
        }
        return score;
    }

    private static String getString(int m_score1, int m_score2) {
        String score;
        int minusResult = m_score1 - m_score2;
        if (minusResult == 1) score = "Advantage player1";
        else if (minusResult == -1) score = "Advantage player2";
        else if (minusResult >= 2) score = "Win for player1";
        else score = "Win for player2";
        return score;
    }
}