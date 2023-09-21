package boilerplate.pinomaker.common.dto;

public class SwaggerExampleValue {
    public static final String INTERNAL_SERVER_ERROR = "Internal Server Error";
    public static final String UNAUTHORIZED_ERROR = "토큰이 유효하거나 존재하지 않습니다.";
    public static final String TOKEN_REFRESH_RESPONSE = "{\"status\": 201, \"message\": \"토큰 재발급에 성공 하였습니다.\", \"data\": {\"accessToken\": \"eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhYmFzZGFzZGFzZGFzZGFzZCIsImF1dGgiOiJST0xFX1VTRVIiLCJleHAiOjE2ODYwMTY2Nzl9.L9N_3UHh3_Cl-3Y7bQ6iAHfBTdRpiIAsY4cCcFusPjApsqI3KeN4YP8B9mp03WMOAtNC-sQJAZnr96aSMdu2hg\", \"refreshToken\": \"eyJhbGciOiJIUzUxMiJ9.eyJleHAiOjE2ODcxMzk4Nzl9.FZvNhJuD0DoBksj7FE1u0_2Kp1YYWcyaR3-YrtmY9Z79uK6OxoQfNJ87JkYNIty4w9eVZbRUBaDcn6phV9ApDw\"}}";
    public static final String UNAUTHORIZED_ERROR_RESPONSE = "{\"status\":401,\"code\":\"API401001\",\"message\":\"unauthorized error full authentication is required to access this resource\"}";
    public static final String SETTING_FIND_SUCCESS_RESPONSE = "{\"status\": 200, \"message\": \"셋팅을 조회합니다.\", \"data\": {\"id\": 1, \"key\": \"cropsChangeUseYn\", \"value\": \"N\"}}";
    public static final String CROPS_FINDALL_RESPONSE = "{\"status\": 200, \"message\": \"작물 리스트를 조회합니다.\", \"data\": [{\"id\": 1, \"mainImg\": \"https://123.png\", \"name\": \"콜라\", \"type\": \"TOP\"}]}";
    public static final String LOGIN_SUCCESS_RESPONSE = "{\"status\":201,\"message\":\"로그인에 성공하였습니다.\",\"data\":{\"nickname\":\"김인후\",\"accessToken\":\"eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhYmFzZGFzZGFzZGFzZGFzZCIsImF1dGgiOiJST0xFX1VTRVIiLCJleHAiOjE2ODU3NzQxMDB9.BHksTtSBIPpjU0NpD1k-2zwJv24zve-6S8zp_OdX8mKWYW5Su4HRHydYI-jihxYWNN5-_cnE4okh50qf6lFBiw\",\"secretname\":\"놀아나는 강아지1\",\"refreshToken\":\"eyJhbGciOiJIUzUxMiJ9.eyJleHAiOjE2ODY4OTczMDB9.fHIZleX0VVL-Fr6TbFRb0OUpMhV7BuywPH2ZMzTpKJiijePXpkxcaDOGgYLIhWUPC-hN-OyDkxpKof04p7GCcA\"}}";
    public static final String SAVE_NEIGHBOR_RESPONSE = "{\"status\":201,\"message\":\"이웃을 맺습니다.\"}";
    public static final String HIGHFIVE_RESPONSE = "{\"status\":200,\"message\":\"하이파이브를 요청합니다.\"}";
    public static final String HIGHFIVE_RECIVE_RESPONSE = "{\"status\":200,\"message\":\"하이파이브를 응답합니다.\"}";
    public static final String CROPS_HISTORY_RESPONSE = "{\"status\":200,\"message\":\"농작물 수확 히스토리를 조회합니다.\",\"pagination\":{\"totalPages\":1,\"currentPage\":0,\"totalItems\":1},\"data\":[{\"userCropsId\":37,\"cropsName\":\"콜라\",\"imgPath\":\"https://kido-file-dev.s3.ap-northeast-2.amazonaws.com/file/Group+40964+(1).png\",\"startDate\":\"2023-09-11T12:18:34.602276\",\"endDate\":\"2023-09-12T12:21:47.996571\"}]}";
    public static final String CROPS_HISTORY_GROW_RESPONSE = "{\"status\":200,\"message\":\"농작물 키우기 히스토리를 조회합니다.\",\"pagination\":{\"totalPages\":1,\"currentPage\":0,\"totalItems\":1},\"data\":[{\"cropsHistoryId\":37,\"title\":\"콜라\",\"username\":\"펩시콜라\",\"createdDate\":\"2023-09-11T12:18:34.602276\"}]}";
    public static final String USER_MISSION_SAVE_RESPONSE = "{\"status\":201,\"message\":\"이미션을 시작합니다.\"}";
    public static final String USER_MISSION_REWARD_RESPONSE = "{\"status\":200,\"message\":\"미션 보상을 지급합니다.\"}";
    public static final String USER_MISSION_FIND_RESPONSE = "{\"status\":200,\"message\":\"미션 리스트를 조회합니다.\",\"data\":[{\"missionId\":1,\"title\":\"5만원이상 구매하기\",\"time\":30,\"rewardWater\":10,\"rewardSun\":10,\"rewardStrongSun\":0,\"userMissionId\":1,\"modifiedDate\":\"2023-08-30T20:26:22.644063\",\"missionStatus\":\"FINISH\"}]}";
    public static final String DELETE_NEIGHBOR_RESPONSE = "{\"status\":201,\"message\":\"이웃을 삭제합니다.\"}";
    public static final String FIND_MAIN_NEIGHBORLIST_RESPONSE = "{\"status\": 200,\"message\": \"이웃 목록을 조회합니다.\",\"data\": [{\"neighborId\": 1,\"secretname\": \"심심한 하마1\",\"avatarType\": \"ELEPHANT\"}]}";
    public static final String FIND_NEIGHBOR_INFO_RESPONSE = "{\"status\": 200, \"message\": \"이웃의 농장을 조회합니다.\", \"data\": {\"userCropsId\": 5, \"userCropsExp\": 0, \"userCropsLevel\": 1, \"userCropsSunAmount\": 30, \"cropsName1\": \"애기 콜라\", \"cropsName2\": \"어린이 콜라\", \"cropsName3\": \"청소년 콜라\", \"cropsName4\": \"어른 콜라\", \"cropsExp1\": 30, \"cropsExp2\": 50, \"cropsExp3\": 70, \"cropsExp4\": 100, \"sunCount\": 0, \"strongSunCount\": 0, \"waterCount\": 0}}";
    public static final String REGISTER_SUCCESS_RESPONSE = "{\"status\": 201, \"message\": \"회원가입 후, 로그인에 성공하였습니다.\", \"data\": {\"img\": \"TIGER\", \"nickname\": \"해리포터\", \"accessToken\": \"eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxMjMxMjMxMjMiLCJhdXRoIjoiVVNFUiIsImV4cCI6MTY5MTcyMTk4NH0.wsvHVCBz2C1o3HH8BEERaac0qCPIQuWpkM1WLdLN3vMlXQl1DcchhioZXc0VzwuhFzLZaXqGO6TlvkFapbIp3w\", \"secretname\": \"심심한 하마1\", \"refreshToken\": \"eyJhbGciOiJIUzUxMiJ9.eyJleHAiOjE2OTI4NDUxODR9.JrS7ZB3sNfkkx_EW2mv_g0hwXV1ZKnUv_j2OlXN13s66CtFyOVnfDywDgl8V433Ez4QeQh7Vc6K2UEzqYnEimA\"}}";
    public static final String FIND_USER_INFO_RESPONSE = "{\"status\": 200, \"message\": \"메인 정보를 조회합니다.\", \"data\": {\"userCropsId\": 5, \"userCropsExp\": 0, \"userCropsLevel\": 1, \"userCropsSunAmount\": 30, \"cropsName1\": \"애기 콜라\", \"cropsName2\": \"어린이 콜라\", \"cropsName3\": \"청소년 콜라\", \"cropsName4\": \"어른 콜라\", \"cropsExp1\": 30, \"cropsExp2\": 50, \"cropsExp3\": 70, \"cropsExp4\": 100, \"sunCount\": 0, \"strongSunCount\": 0, \"waterCount\": 0}}";
    public static final String UPDATE_USER_INFO_RESPONSE = "{\"status\":200,\"message\":\"유저 정보를 변경했습니다.\"}";
    public static final String GAME_WORM_PLAY_RESPONSE = "{\"status\":200,\"message\":\"벌레 잡기 게임을 플레이 하였습니다.\"}";
    public static final String MESSAGE_FIND_RESPONSE = "{\"status\": 200, \"message\": \"메세지를 조회합니다.\", \"data\": {\"id\": 6, \"messageId\": \"2309151625202186100412\", \"title\": \"DM 도착\", \"text\": \"잠깬구리님이 쪽지를 보냈어요!\", \"type\": \"DM_WATER_THANKS\"}}";
    public static final String GAME_BLOCK_PLAY_RESPONSE = "{\"status\":200,\"message\":\"블럭 게임을 보상을 지급 하였습니다.\"}";
    public static final String NEIGHBOR_USE_ITEM_RESPONSE = "{\"status\":200,\"message\":\"이웃에게 아이템을 사용했습니다.\"}";
    public static final String NEIGHBOR_SEND_GIFT_RESPONSE = "{\"status\":200,\"message\":\"아이템을 선물합니다.\"}";
    public static final String NEIGHBOR_SEND_DM = "{\"status\":200,\"message\":\"이웃에게 DM을 발송합니다.\"}";
    public static final String USE_ITEM_RESPONSE = "{\"status\":200,\"message\":\"아이템을 사용했습니다.\"}";
    public static final String GAME_HEART_UPDATE_RESPONSE = "{\"status\":200,\"message\":\"하트를 수정했습니다.\"}";
    public static final String GAME_FIND_INFO_RESPONSE = "{\"status\": 200, \"message\": \"게임 정보를 조회합니다.\", \"data\": {\"id\": 10, \"heart\": 5, \"heartTime\": null, \"wormTime\": null}}";
    public static final String USER_CROPS_CHANGE_RESPONSE = "{\"status\":200,\"message\":\"작물을 변경하였습니다.\"}";
    public static final String USER_CROPS_SAVE_RESPONSE = "{\"status\":200,\"message\":\"작물을 생성하였습니다.\"}";
    public static final String MISSION_ATTENDANCE_FIND_RESPONSE =  "{\"status\":200,\"message\":\"출석체크 정보를 조회합니다.\",\"data\":{\"attendanceCount\":1,\"lastAttendanceDate\":\"2023-09-14T20:56:25.33742\"}}";
    public static final String MISSION_ATTENDANCE_SAVE_RESPONSE = "{\"status\":200,\"message\":\"출석체크를 했습니다.\"}";

    public static final String INTERNAL_SERVER_ERROR_REPONSE = "{\"status\":500, \"code\": \"API500 \", \"message\":\"Internal Server Error\"}";
}
