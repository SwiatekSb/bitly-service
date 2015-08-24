package com.swiatowski.bitly.rest.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Piotrek on 8/24/2015.
 */
@Controller
public class MainController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public void applicationIndex(HttpServletResponse httpServletResponse) throws IOException {
        httpServletResponse.sendRedirect("/web/index.html");
    }
}
