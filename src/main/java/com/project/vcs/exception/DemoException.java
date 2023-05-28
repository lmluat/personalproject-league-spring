package com.project.vcs.exception;
import org.springframework.http.HttpStatus;
public class DemoException {
    private static final String PLAYER_NOT_FOUND_MSG_KEY = "TeamNotExisted";
    private static final String PLAYER_NOT_FOUND_MSG = "Team Not Found";
    private static final String CASTER_NOT_FOUND_MSG_KEY = "CasterNotExisted";
    private static final String CASTER_NOT_FOUND_MSG = "Caster Not Found";

    private static final String COACH_NOT_FOUND_MSG_KEY = "CoachNotExisted";
    private static final String COACH_NOT_FOUND_MSG = "Coach Not Found";

    private static final String MATCH_DETAIL_NOT_FOUND_MSG_KEY = "MatchDetailNotExisted";
    private static final String MATCH_DETAIL_NOT_FOUND_MSG = "Match Detail Not Found";

    private static final String PLAYER_DETAIL_NOT_FOUND_MSG_KEY = "PlayerDetailNotExisted";
    private static final String PLAYER_DETAIL_NOT_FOUND_MSG = "Player Detail Not Found";

    private static final String TEAM_NOT_FOUND_MSG_KEY = "TeamNotExisted";
    private static final String TEAM_NOT_FOUND_MSG = "Team Not Found";

    private static final String TEAM_DETAIL_NOT_FOUND_MSG_KEY = "TeamDetailNotExisted";
    private static final String TEAM_DETAIL_NOT_FOUND_MSG = "Team Detail Not Found";

    private static final String TOURNAMENT_NOT_FOUND_MSG_KEY = "TournamentNotExisted";
    private static final String TOURNAMENT_NOT_FOUND_MSG = "Tournament Not Found";
    private static final String MATCH_NOT_FOUND_MSG_KEY = "MatchNotExisted";
    private static final String MATCH_NOT_FOUND_MSG = "Match Not Found";


    public static ResponseException notFound(String messageKey, String message) {
        return new ResponseException(messageKey, message, HttpStatus.NOT_FOUND);
    }
    public static ResponseException badRequest(String messageKey, String message) {
        return new ResponseException(messageKey, message, HttpStatus.BAD_REQUEST);
    }

    public static ResponseException internalServerError(String messageKey, String message) {
        return new ResponseException(messageKey, message, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    public static ResponseException TournamentNotFound(){
        return notFound(TOURNAMENT_NOT_FOUND_MSG_KEY, TOURNAMENT_NOT_FOUND_MSG);
    }
    public static ResponseException PlayerNotFound() {
        return notFound(PLAYER_NOT_FOUND_MSG_KEY, PLAYER_NOT_FOUND_MSG);
    }
    public static ResponseException CasterNotFound() {
        return notFound(CASTER_NOT_FOUND_MSG_KEY, CASTER_NOT_FOUND_MSG);
    }
    public static ResponseException CoachNotFound() {
        return notFound(COACH_NOT_FOUND_MSG_KEY, COACH_NOT_FOUND_MSG);
    }
    public static ResponseException PlayerDetailNotFound() {
        return notFound(PLAYER_DETAIL_NOT_FOUND_MSG_KEY, PLAYER_DETAIL_NOT_FOUND_MSG);
    }
    public static ResponseException TeamDetailNotFound() {
        return notFound(TEAM_DETAIL_NOT_FOUND_MSG_KEY, TEAM_DETAIL_NOT_FOUND_MSG);
    }
    public static ResponseException MatchNotFound() {
        return notFound(MATCH_NOT_FOUND_MSG_KEY, MATCH_NOT_FOUND_MSG);
    }
    public static ResponseException MatchDetailNotFound() {
        return notFound(MATCH_DETAIL_NOT_FOUND_MSG_KEY, MATCH_DETAIL_NOT_FOUND_MSG);
    }

    public static ResponseException TeamNotFound() {
        return notFound(TEAM_NOT_FOUND_MSG_KEY, TEAM_NOT_FOUND_MSG);
    }

}
