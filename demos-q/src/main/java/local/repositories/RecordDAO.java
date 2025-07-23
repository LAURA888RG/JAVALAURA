package local.repositories;

import java.util.Optional;
import java.util.UUID;

import local.entities.Record;

public class RecordDAO extends AbstractDAO<Record> {

    public RecordDAO() {
        super(Record.class);
       
    }

    public Optional<Record> findById(UUID id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }


    

}
