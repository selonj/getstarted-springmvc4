package com.selonj.controllers;

import com.selonj.dto.Guest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by L.x on 16-2-18.
 */
@Controller
public class EchoController {
    @RequestMapping(value = "/echo", produces = "text/html")
    @ResponseBody
    public Guest echo(Guest guest) {
        return guest;
    }
}
