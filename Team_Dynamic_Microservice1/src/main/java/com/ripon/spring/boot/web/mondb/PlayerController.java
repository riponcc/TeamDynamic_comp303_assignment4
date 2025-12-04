package com.ripon.spring.boot.web.mondb;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Mono;

//@RequestMapping("/player")
//@Controller
//public class PlayerController {
//
//	
//    private final PlayerService service;
//
//    public PlayerController(PlayerService service) {
//        this.service = service;
//    }
//
//    @GetMapping(" ")
//    public String listPlayers(Model model) {
//        model.addAttribute("player", service.getPlayers());
//        return "view_player";
//    }
//
//    @GetMapping("/new")
//    public String newPlayerForm(Model model) {
//        model.addAttribute("player", new Player());
//        return "new_player";
//    }
//
//    @PostMapping
//    public Mono<String> createPlayer(@ModelAttribute Player player) {
//        return service.addPlayer(player)
//                .thenReturn("redirect:/player");
//    }
//
//    @GetMapping("/edit/{id}")
//    public Mono<String> editPlayerForm(@PathVariable int id, Model model) {
//        return service.getPlayer(id)
//                .doOnNext(p -> model.addAttribute("player", p))
//                .thenReturn("edit_player");
//    }
//
//    @PostMapping("/update/{id}")
//    public Mono<String> updatePlayer(@PathVariable int id, @ModelAttribute Player player) {
//        player.setPlayerId(id);
//        return service.updatePlayer(player)
//                .thenReturn("redirect:/player");
//    }
//
//    @GetMapping("/delete/{id}")
//    public Mono<String> deletePlayer(@PathVariable int id) {
//        return service.deletePlayer(id)
//                .thenReturn("redirect:/player");
//    }
//
//    @GetMapping("/{id}")
//    public Mono<String> viewPlayer(@PathVariable int id, Model model) {
//        return service.getPlayer(id)
//                .doOnNext(p -> model.addAttribute("player", p))
//                .thenReturn("show_player");
//    }
//}

@Controller
@RequestMapping("/player")
public class PlayerController {

    private final PlayerService service;

    public PlayerController(PlayerService service) {
        this.service = service;
    }

   //List all players
    @GetMapping
    public Mono<String> listPlayers(Model model) {
        return service.getPlayers()
                .collectList()
                .doOnNext(players -> model.addAttribute("player", players))
                .thenReturn("view_player");
    }

    //Add a new player
    @GetMapping("/new")
    public Mono<String> newPlayerForm(Model model) {
        model.addAttribute("player", new Player());
        return Mono.just("new_player");
    }

     //send new player to player list
    @PostMapping
    public Mono<String> createPlayer(@ModelAttribute Player player) {
        return service.addPlayer(player)
                .thenReturn("redirect:/player");
    }

    //edit player by id
    @GetMapping("/edit/{id}")
    public Mono<String> editPlayerForm(@PathVariable int id, Model model) {
        return service.getPlayer(id)
                .doOnNext(p -> model.addAttribute("player", p))
                .thenReturn("edit_player");
    }

    //update player by id
    @PostMapping("/update/{id}")
    public Mono<String> updatePlayer(@PathVariable int id, @ModelAttribute Player player) {
        player.setPlayerId(id);
        return service.updatePlayer(player)
                .thenReturn("redirect:/player");
    }

    //delete player byn id
    @GetMapping("/delete/{id}")
    public Mono<String> deletePlayer(@PathVariable int id) {
        return service.deletePlayer(id)
                .thenReturn("redirect:/player");
    }

   //view player by id
    @GetMapping("/{id}")
    public Mono<String> viewPlayer(@PathVariable int id, Model model) {
        return service.getPlayer(id)
                .doOnNext(p -> model.addAttribute("player", p))
                .thenReturn("show_player");
    }
}


