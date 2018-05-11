package lv.va.sludinajumuportals.resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/status")
public class AvailabilityController {

    public static boolean available;

    @GetMapping
    @ResponseBody
    public void getStatus(HttpServletResponse httpServletResponse) {
        httpServletResponse.setStatus(available ? HttpServletResponse.SC_OK : HttpServletResponse.SC_SERVICE_UNAVAILABLE);
    }


    @PostMapping(value = "/{value}")
    @ResponseBody
    public void setStatus(@PathVariable("value") boolean value) {
        available = value;
    }



}
