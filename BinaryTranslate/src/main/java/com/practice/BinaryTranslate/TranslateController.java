package com.practice.BinaryTranslate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TranslateController {

    @Autowired
    private TranslateService translateService;

    @GetMapping("/")
    public String translateForm(Model model) {
        model.addAttribute("translate", new Translate());
        return "index";
    }
    
    @PostMapping("/frombinary")
    public String convertBinaryToText(@ModelAttribute Translate translate, Model model) {
        translate.setContent(translateService.binaryToText(translate.getContent()));
        return "translation";
    }

    @PostMapping("/tobinary")
    public String convertTextToBinary(Translate translate, Model model) {
        translate.setContent(translateService.textToBinary(translate.getContent()));
        return "translation";
    }
    
}
