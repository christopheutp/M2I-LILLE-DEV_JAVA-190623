package com.appcellon.coronatracker.services;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.appcellon.coronatracker.models.LocationStats;

@Service
public class DataService {
    private static String DATA_URL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";
    
    private static List<LocationStats> allStats = new ArrayList<>();

    public static List<LocationStats> getAllStats() {
        return allStats;
    }

    public void setAllStats(List<LocationStats> allStats) {
        DataService.allStats = allStats;
    }

    @PostConstruct
    @Scheduled(cron = "* * * 1 * *") // run every day
    public void fetchData() throws IOException, InterruptedException {
        List<LocationStats> newStats = new ArrayList<>();
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(DATA_URL)).build();
        HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());

        Reader in = new StringReader(httpResponse.body());
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(in);
        for (CSVRecord record : records) {
            LocationStats locationStats = new LocationStats();
            locationStats.setProvince(record.get("Province/State"));
            locationStats.setCountry(record.get("Country/Region"));
            locationStats.setLatestCaseTotal(Integer.parseInt(record.get(record.size() - 1)));

            var diff = Integer.parseInt(record.get(record.size() - 1)) - Integer.parseInt(record.get(record.size() - 2));
            locationStats.setPrevDayTotal(diff);

            System.out.println(locationStats);
            newStats.add(locationStats);
        }
        this.setAllStats(newStats);
    }
}
