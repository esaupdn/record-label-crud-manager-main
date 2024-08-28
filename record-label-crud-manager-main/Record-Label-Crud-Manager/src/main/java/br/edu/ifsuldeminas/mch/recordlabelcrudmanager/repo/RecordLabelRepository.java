package br.edu.ifsuldeminas.mch.recordlabelcrudmanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifsuldeminas.mch.recordlabelcrudmanager.model.RecordLabel;

public interface RecordLabelRepository extends JpaRepository<RecordLabel, Integer> {

}
