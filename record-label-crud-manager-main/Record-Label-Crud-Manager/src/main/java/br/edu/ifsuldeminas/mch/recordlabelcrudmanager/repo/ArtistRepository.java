package br.edu.ifsuldeminas.mch.recordlabelcrudmanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifsuldeminas.mch.recordlabelcrudmanager.model.Artist;

public interface ArtistRepository extends JpaRepository<Artist, Integer> {

}
