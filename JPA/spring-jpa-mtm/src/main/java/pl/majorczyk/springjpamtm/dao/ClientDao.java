package pl.majorczyk.springjpamtm.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.majorczyk.springjpamtm.model.Client;

@Repository
@Transactional
public class ClientDao extends GenericDao<Client,Long> {

}
