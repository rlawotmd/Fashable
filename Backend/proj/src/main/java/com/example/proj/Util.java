package com.example.proj;

import org.jsoup.*;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Util {
    // ref - https://jsoup.org/

    private static final String url = "https://www.busan.go.kr/depart/index";

    public static void test() {
        parse(url);
    }

    public static void parse(String url) {
        var conn = Jsoup.connect(url);

        try {
            Document document = conn.get();

            if (document.connection().response().statusCode() == 200) {
                Elements notices = document.select(".notice-list > li > a"); // 공지사항^Big 이라고 적힌 내용 parse 했음.
                List<String> titles = notices.eachText();

                // hyper link랑 잘 해서 리턴.

                for (var notice : titles) System.out.println(notice);
            }

            System.out.println("done");

        } catch (Exception e) {
            e.printStackTrace(); // logging.
        }
    }
}
