package jx.pgz.controller;

import cn.hutool.http.HttpUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("tb")
public class TieBaController {

    @GetMapping("search/{param}")
    public String search(@PathVariable("param") String value) {
        return HttpUtil.get("http://chengqing.cc/ajax.php?username=" + value);
    }


    @GetMapping("checkSpeech/{username}/{page}")
    public String checkSpeech(@PathVariable("username") String username, @PathVariable("page") String page) {
        return HttpUtil.get("http://chengqing.cc/ajax_re.php?username=" + username + "&pn=" + page);

    }

    @GetMapping("checkData/{username}")
    public String checkData(@PathVariable("username") String username) {
        String html = HttpUtil.get("https://82cat.com/tieba/info/" + username);
        Document document = Jsoup.parse(html);
        Elements info = document.getElementsByClass("main");
        return info.outerHtml().contains(username) ? info.outerHtml() : "<h2>暂无" + username + "数据</h1>";
    }


}
