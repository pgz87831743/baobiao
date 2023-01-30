package jx.pgz.controller;

import jx.pgz.utils.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sec")
public class SecurityController {

    @GetMapping("test1")
    public Result<String> test1() {
        return Result.ok("test1");
    }
}
