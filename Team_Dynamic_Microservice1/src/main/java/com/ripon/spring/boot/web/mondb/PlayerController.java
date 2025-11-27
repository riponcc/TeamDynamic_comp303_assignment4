package com.ripon.spring.boot.web.mondb;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



import reactor.core.publisher.Mono;

@RequestMapping("/player")
@Controller
public class PlayerController {

	
    private final PlayerService service;

    public PlayerController(PlayerService service) {
        this.service = service;
    }

    @GetMapping(" ")
    public String listPlayers(Model model) {
        model.addAttribute("player", service.getPlayers());
        return "view_player";
    }

    @GetMapping("/new")
    public String newPlayerForm(Model model) {
        model.addAttribute("player", new Player());
        return "new_player";
    }

    @PostMapping
    public Mono<String> createPlayer(@ModelAttribute Player player) {
        return service.addPlayer(player)
                .thenReturn("redirect:/player");
    }

    @GetMapping("/edit/{id}")
    public Mono<String> editPlayerForm(@PathVariable int id, Model model) {
        return service.getPlayer(id)
                .doOnNext(p -> model.addAttribute("player", p))
                .thenReturn("edit_player");
    }

    @PostMapping("/update/{id}")
    public Mono<String> updatePlayer(@PathVariable int id, @ModelAttribute Player player) {
        player.setPlayerId(id);
        return service.updatePlayer(player)
                .thenReturn("redirect:/player");
    }

    @GetMapping("/delete/{id}")
    public Mono<String> deletePlayer(@PathVariable int id) {
        return service.deletePlayer(id)
                .thenReturn("redirect:/player");
    }

    @GetMapping("/{id}")
    public Mono<String> viewPlayer(@PathVariable int id, Model model) {
        return service.getPlayer(id)
                .doOnNext(p -> model.addAttribute("player", p))
                .thenReturn("show_player");
    }
}

