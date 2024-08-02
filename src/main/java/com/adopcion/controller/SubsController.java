package com.adopcion.controller;

import com.adopcion.domain.Subs;
import com.adopcion.service.SubsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/subscriptions")
public class SubsController {

    @Autowired
    private SubsService subsService;

    @PostMapping
    @ResponseBody
    public String createSubscription(@RequestParam("plan") String plan) {
        Subs subs = new Subs(plan);
        subsService.createSubs(subs);
        return "success";
    }

    @PostMapping("/cancel")
    @ResponseBody
    public String cancelSubscription(@RequestParam("id") Long id) {
        subsService.updateSubsStatus(id, "Cancelada");
        return "success";
    }

    @GetMapping("/history")
    public String showSubscriptionHistory(Model model) {
        List<Subs> history = subsService.getSubsHistory();
        model.addAttribute("history", history);
        return "historialSubs";
    }

    @GetMapping("/create")
    public String showCreateSubscriptionForm(Model model) {
        model.addAttribute("subs", new Subs());
        return "crearSubs";
    }

    @GetMapping("/confirm")
    public String confirmSubscription(@RequestParam("plan") String plan, Model model) {
        model.addAttribute("subscriptionPlan", plan);
        return "redirect:/index?plan=" + plan;
    }

    @GetMapping("/index")
    public String showIndexPage(@RequestParam(value = "plan", required = false) String plan, Model model) {
        if (plan != null) {
            model.addAttribute("subscriptionPlan", plan);
        }
        return "index";
    }
}
