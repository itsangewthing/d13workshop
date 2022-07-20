package sg.edu.nus.iss.d13workshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.nus.iss.d13workshop.models.Contact;
import sg.edu.nus.iss.d13workshop.services.DatabaseService;

@Controller
@RequestMapping(path="/contact")
public class ContactController {
    
    @Autowired
    private DatabaseService dbSvc;

    // produces = data comes back; consumes = i am sending thhis data to you .
    // consumes is here because we're posting data from a form; if consumes isn't inserted, then nothing will be posted

    
// POST & GET METHOD 
    @PostMapping(consumes="application/x-www-form-urlencoded", produces="text/html")
    public String postContact(@RequestBody MultiValueMap<String, String> form, Model model){
        
        Contact c = new Contact();
        c.setName(form.getFirst("name"));
        c.setEmail(form.getFirst("email"));
        c.setPhone(form.getFirst("phone"));

        dbSvc.save(c);
        
        // saving into a model
        model.addAttribute("contact", c);
        return "showContact";
    }


    //  parse in the file id 
    @GetMapping(value="/{id}", produces="text/html")  
    public String getContact(@PathVariable("id") String id, Model model){
        
        Contact c = new Contact();
        c =dbSvc.read(id);
        System.out.printf("> id: %s", c);

        model.addAttribute("contact", c);
        return "showContact";

    }
}
