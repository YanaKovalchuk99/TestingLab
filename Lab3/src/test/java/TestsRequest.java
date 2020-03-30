import io.restassured.RestAssured;
import org.junit.Test;

import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.core.IsEqual.equalTo;

public class TestsRequest {

    public static final String link = "https://ru.wikipedia.org/w/api.php?action=query";
    @Test
    public void TestInfo(){
        when()
                .get(link+"&format=json&titles=Санкт-Петербург&prop=info&inprop=url")
                .then()
                .statusCode(200)
                .body("query.pages.45.title", equalTo("Санкт-Петербург"),
                        "query.pages.45.length", equalTo(325171),
                        "query.pages.45.contentmodel",equalTo("wikitext"),
                        "query.pages.45.pagelanguage",equalTo("ru"),
                        "query.pages.45.pagelanguagedir",equalTo("ltr"),
                        "query.pages.45.pageid",equalTo(45));

    }
    @Test
    public void TestAllimages(){
        when()
                .get(link+"&list=allimages&aifrom=Волгоград&format=json")
                .then()
                .statusCode(200)
                .body("query.allimages.name[0]",equalTo("Волгоград._Мамаев_Курган._Родина-Мать_зовет!_2007.JPG"),
                        "query.allimages.timestamp[0]",equalTo("2016-04-04T17:05:03Z"),
                        "query.allimages.descriptionshorturl[0]", equalTo("https://ru.wikipedia.org/w/index.php?curid=6329015"),
                        "query.allimages.ns[0]", equalTo(6),
                        "query.allimages.title[0]",equalTo("Файл:Волгоград. Мамаев Курган. Родина-Мать зовет! 2007.JPG"));

    }


}
