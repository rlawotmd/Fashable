package com.example.proj;

import org.jsoup.*;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.jsoup.nodes.Document;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Util {
    // ref - https://jsoup.org/

    private static final String url = "https://en.wikipedia.org/wiki/Marmot";

    public static void test() {
        parse(url);
    }

    public static void parse(String url) {
        var conn = Jsoup.connect(url);

        try {
            Document doc = conn.get();

            if (doc.connection().response().statusCode() == 200) {

                // parsing...

            }

            System.out.println();

        } catch (Exception e) {
            e.printStackTrace(); // logging.
        }
    }
}
