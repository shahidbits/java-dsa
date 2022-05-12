package company.twilio;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.List;
import java.util.Map;

public class CountryPhoneCode {

    private static final long TIMEOUT = 30;
    private static final String HOST_URL = "https://jsonmock.hackerrank.com";
    private static final String GET_COUNTRY_CODE_API = "api/countries";

    private static final HttpClient httpClient = HttpClient.newBuilder().version(HttpClient.Version.HTTP_1_1)
            .connectTimeout(Duration.ofSeconds(TIMEOUT)).build();

    private static final Gson gson = new Gson();

    public static String getPhoneNumbers(String country, String phoneNumber) {

        try {

            String url = String.format("%s/%s?name=%s", HOST_URL, GET_COUNTRY_CODE_API, java.net.URLEncoder.encode(country, "UTF-8").replace("+", "%20"));
            String response = executeGet(url);
            ResponseDTO responseDTO = gson.fromJson(response, ResponseDTO.class);

            if (responseDTO != null && responseDTO.data != null && responseDTO.data.size() > 0) {
                return generatePhoneNumberWithCode(phoneNumber, responseDTO.data.get(0).callingCodes);
            }

        } catch (Exception ex) {
            System.out.println("Error occurred while getting the country code");
        }

        return "-1";
    }

    private static String generatePhoneNumberWithCode(String phoneNumber, List<String> codes) {

        if (phoneNumber != null && phoneNumber.length() > 0 && codes != null && codes.size() > 0) {

            String prefixCode = "";

            for (String code : codes) {

                if (prefixCode.equals("")) {
                    prefixCode = code;
                    continue;
                }

                if (Integer.parseInt(prefixCode) < Integer.parseInt(code)) {
                    prefixCode = code;
                }
            }

            return String.format("+%s %s", prefixCode, phoneNumber);
        }

        return "-1";
    }

    public static String executeGet(String targetURL) {
        HttpURLConnection connection = null;

        try {
            //Create connection
            URL url = new URL(targetURL);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setUseCaches(false);
            connection.setDoOutput(true);

            //Get Response
            InputStream is = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            StringBuilder response = new StringBuilder(); // or StringBuffer if Java version 5+
            String line;
            while ((line = rd.readLine()) != null) {
                response.append(line);
                response.append('\r');
            }
            rd.close();
            return response.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

    private static String httpGetCall(String url) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(url))
                .setHeader("User-Agent", "My Agent v1.0")
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
//        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    private static class ResponseDTO {

        public String page;
        public String per_page;
        public String total;
        public String total_pages;
        public List<CountryCodeDTO> data;
    }

    private static class CountryCodeDTO {
        public String name;
        public String nativeName;
        public List<String> topLevelDomain;
        public String alpha2Code;
        public String alpha3Code;
        public String numericCode;
        public List<String> currencies;
        public List<String> callingCodes;
        public String capital;
        public List<String> altSpellings;
        public String relevance;
        public String region;
        public String subregion;
        public List<String> language;
        public List<String> languages;
        public Map<String, String> translations;
        public Long population;
        public List<Double> latlng;
        public String demonym;
        public List<String> borders;
        public String area;
        public String gini;
        public List<String> timezones;
    }
}
