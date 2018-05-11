package lv.va.sludinajumuportals.resource;

import lv.va.sludinajumuportals.dao.AdvertisementRepository;
import lv.va.sludinajumuportals.domain.Advertisement;
import lv.va.sludinajumuportals.domain.Response;
import lv.va.sludinajumuportals.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

import static java.lang.Long.*;
import lv.va.sludinajumuportals.dao.UserRepository;
import lv.va.sludinajumuportals.domain.User;
import lv.va.sludinajumuportals.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class AdvertisementController {

    @Autowired
    private AdvertisementService advertisementService;

    @Autowired
    AdvertisementRepository advertisementRepository;
    
    @Autowired
    private UserService userService;
    
    @Autowired
    UserRepository userRepository;

    @GetMapping(value = "/")
    @ResponseBody
    public String testEndpoint() {
        return "Hello!";
    }

    @GetMapping(value = "/hey")
    @ResponseBody
    public Response nextTestEndpoint() {
        return new Response("Hey Ya");
    }

    @RequestMapping("/main")
    public String getUI(Map<String, Object> model) {
        model.put("message", "Hello User!");
        model.put("advertisement", advertisementService.getAdvertisement());
        return "main";
    }

    @GetMapping("/advertisements")
    public String getAdvertisement(Map<String, Object> model) {
        model.put("advertisementList", advertisementService.getAdvertisementListReverse());
        return "advertisementui";
    }

    @RequestMapping("/advertisements/{author}")
    public String getAdvertisementsByAuthor(Map<String, Object> model, @PathVariable(value = "author") String author) {
        model.put("advertisementsList", advertisementService.getAdvertisementListByAuthor(author));
       return "advertisementui";
    }

    @RequestMapping("/users/{author}")
    public String getUsersByUserName(Map<String, Object> model, @PathVariable(value = "name") String name, String surename) {
        model.put("userList", userService.getUserListByUserName(name, surename));
        return "userui";
    }
    
    @GetMapping("/createadvertisementform")
    public String advertisementCreationForm(Model model) {
        model.addAttribute("advertisement", new Advertisement());
        return "createform";
    }
    
    @GetMapping("/createuserform")
    public String userCreationForm(Model model) {
        model.addAttribute("user", new User());
        return "createdform";
    }
    
    @GetMapping("/createadvertisementformdb")
    public String advertisementCreationFormdb(Model model) {
        model.addAttribute("advertisement", new Advertisement());
        return "createformdb";
    }

    @GetMapping("/createuserformdb")
    public String userCreationFormdb(Model model) {
        model.addAttribute("user", new User());
        return "createdformdb";
    }
    
    @PostMapping("/advertisementdb")
    public String advertisementSubmitdb(Map<String, Object> model,
                                      @ModelAttribute Advertisement advertisement) {
        advertisementRepository.save(advertisement);
        model.put("advertisement", advertisement);
        return "result";

    }
    @PostMapping("/userdb")
    public String userSubmitdb(Map<String, Object> model,
                                      @ModelAttribute User user) {
        userRepository.save(user);
        model.put("user", user);
        return "results";

    }


    @PostMapping("/advertisement")
    public String advertisementSubmit(Map<String, Object> model,
                                      @ModelAttribute Advertisement advertisement) {
        int nextAdvertisementId =
                advertisementService.hardcodedAdvertisementList.size();
        advertisement.setId(valueOf(nextAdvertisementId + 1));
        advertisementService.hardcodedAdvertisementList
                .add(0, advertisement);
        model.put("advertisement", advertisement);
        return "result";

    }

}    

