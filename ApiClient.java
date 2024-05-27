import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiClient {

    private static final String BASE_URL = "http://your.api.endpoint/";

    public static String getSeats() throws IOException {
        URL url = new URL(BASE_URL + "seats");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        // 응답 처리 코드 추가
        return readResponse(connection);
    }

    public static String reserveSeat(int seatNumber) throws IOException {
        URL url = new URL(BASE_URL + "reserve");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json; utf-8");
        connection.setDoOutput(true);

        String jsonInputString = "{\"seatNumber\": " + seatNumber + "}";
        try(OutputStream os = connection.getOutputStream()) {
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        // 응답 처리 코드 추가
        return readResponse(connection);
    }

    private static String readResponse(HttpURLConnection connection) throws IOException {
        // 응답을 읽고 처리하는 코드 추가
        return "";
    }
}
