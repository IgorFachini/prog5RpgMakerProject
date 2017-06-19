package frojing.rpgmaker.data;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import frojing.rpgmaker.entity.Chronicle;

@Transactional
public interface ChronicleDao extends CrudRepository<Chronicle, Long> {

}
