package jx.pgz.controller;

import jx.pgz.model.DetailInfo;
import jx.pgz.utils.Result;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("tb")
public class TieBaController {


    @PostMapping("test")
    public Result<String> test(@RequestParam("item") String item, @RequestParam("info") String info, HttpServletRequest request) {
        return Result.success(null);
    }


    @PostMapping("test2")
    public Result<DetailInfo> test2(@RequestBody DetailInfo detailInfo) {
        return Result.success(detailInfo);
    }
}
