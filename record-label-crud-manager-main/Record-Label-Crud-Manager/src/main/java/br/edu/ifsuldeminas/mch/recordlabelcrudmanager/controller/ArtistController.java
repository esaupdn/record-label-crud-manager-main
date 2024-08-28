package br.edu.ifsuldeminas.mch.recordlabelcrudmanager.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.ifsuldeminas.mch.recordlabelcrudmanager.model.RecordLabel;
import br.edu.ifsuldeminas.mch.recordlabelcrudmanager.model.Artist;
import br.edu.ifsuldeminas.mch.recordlabelcrudmanager.repo.ArtistRepository;
import br.edu.ifsuldeminas.mch.recordlabelcrudmanager.repo.RecordLabelRepository;
import jakarta.validation.Valid;

@Controller
public class ArtistController {

    @Autowired
    private ArtistRepository artistRepository;

    @Autowired
    private RecordLabelRepository recordlabelRepository;

    @GetMapping("/artists")
    public String listArtists(Model model) {
        List<Artist> artists = artistRepository.findAll();

        model.addAttribute("artists", artists);
        return "artists";
    }

    @GetMapping("/artists/form")
    public String artistForm(@ModelAttribute("artist") Artist artist, Model model) {

        List<RecordLabel> recordlabels = recordlabelRepository.findAll();
        model.addAttribute("recordlabels", recordlabels);

        return "artists_form";
    }

    @PostMapping("/artists/register")
    public String ArtistNew(@Valid @ModelAttribute("artist") Artist artist,
            BindingResult erros, Model model) {

        if (erros.hasErrors()) {
            List<RecordLabel> recordlabels = recordlabelRepository.findAll();
            model.addAttribute("recordlabels", recordlabels);

            return "artists_form";
        }

        artistRepository.save(artist);

        return "redirect:/artists";
    }

    @GetMapping("/artists/update/{id}")
    public String artistUpdate(@PathVariable("id") Integer id,
            Model model) {

        Optional<Artist> artistOpt = artistRepository.findById(id);
        Artist recordlabel = artistOpt.orElse(new Artist());

        List<RecordLabel> recordlabels = recordlabelRepository.findAll();

        model.addAttribute("recordlabels", recordlabels);
        model.addAttribute("artist", recordlabel);

        return "artists_form";
    }

    @GetMapping("/artists/delete/{id}")
    public String artistDelete(@PathVariable("id") Integer id) {

        artistRepository.delete(new Artist(id));

        return "redirect:/artists";
    }
}
