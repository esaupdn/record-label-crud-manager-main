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

import jakarta.validation.Valid;
import br.edu.ifsuldeminas.mch.recordlabelcrudmanager.model.RecordLabel;
import br.edu.ifsuldeminas.mch.recordlabelcrudmanager.repo.RecordLabelRepository;

@Controller
public class RecordLabelController {

	@Autowired
	private RecordLabelRepository recordlabelRepository;

	@GetMapping("/recordlabels")
	public String listEvents(Model model) {
		List<RecordLabel> recordlabels = recordlabelRepository.findAll();

		model.addAttribute("recordlabels", recordlabels);
		return "recordlabels";
	}

	@GetMapping("/recordlabels/form")
	public String recordlabelForm(@ModelAttribute("recordlabel") RecordLabel recordlabel) {
		return "recordlabel_form";
	}

	@PostMapping("/recordlabels/register")
	public String eventNew(@Valid @ModelAttribute("recordlabel") RecordLabel recordlabel,
			BindingResult erros) {

		if (erros.hasErrors()) {
			return "recordlabel_form";
		}

		recordlabelRepository.save(recordlabel);

		return "redirect:/recordlabels";
	}

	@GetMapping("/recordlabels/update/{id}")
	public String recordlabelUpdate(@PathVariable("id") Integer id,
			Model model) {

		Optional<RecordLabel> recordlabelOpt = recordlabelRepository.findById(id);
		RecordLabel recordlabel =  recordlabelOpt.orElse(new RecordLabel());


		model.addAttribute("recordlabel", recordlabel);

		return "recordlabel_form";
	}

	@GetMapping("/recordlabels/delete/{id}")
	public String recordlabelDelete(@PathVariable("id") Integer id) {

		recordlabelRepository.delete(new RecordLabel(id));

		return "redirect:/recordlabels";
	}
}
