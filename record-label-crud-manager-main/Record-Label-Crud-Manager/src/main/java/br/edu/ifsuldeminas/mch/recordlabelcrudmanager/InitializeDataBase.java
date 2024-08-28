package br.edu.ifsuldeminas.mch.recordlabelcrudmanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.edu.ifsuldeminas.mch.recordlabelcrudmanager.model.Artist;
import br.edu.ifsuldeminas.mch.recordlabelcrudmanager.model.RecordLabel;
import br.edu.ifsuldeminas.mch.recordlabelcrudmanager.repo.ArtistRepository;
import br.edu.ifsuldeminas.mch.recordlabelcrudmanager.repo.RecordLabelRepository;
import jakarta.transaction.Transactional;

@Component
@Transactional
public class InitializeDataBase implements CommandLineRunner {

    @Autowired
    private RecordLabelRepository recordlabelRepository;

    @Autowired
    private ArtistRepository artistRepository;

    @Override
    public void run(String... args) throws Exception {

        RecordLabel tde = new RecordLabel();
        tde.setName("Top Dawg Entertainment");
        tde.setAdress("Los Angeles, California - EUA");
        tde.setGenre("HipHop");

        RecordLabel sony = new RecordLabel();
        sony.setName("Sony Music");
        sony.setAdress("New York, New York - EUA");
        sony.setGenre("Todos Gêneros");


        recordlabelRepository.save(tde);
        recordlabelRepository.save(sony);
        recordlabelRepository.flush();

        Artist kdot = new Artist();
        kdot.setName("Kendrick Lamar");
        kdot.setEmail("kendricklamar@tde.com");
        kdot.setGenre("Rapper");
        kdot.setRecordlabel(tde);

        Artist adele = new Artist();
        adele.setName("Adele");
        adele.setEmail("adele@sonymusicgroup.com");
        adele.setGenre("Pop");
        adele.setRecordlabel(sony);

        artistRepository.save(kdot);
        artistRepository.save(adele);

    }

}
