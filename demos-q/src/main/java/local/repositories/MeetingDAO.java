package local.repositories;

import local.entities.Meeting;

public class MeetingDAO extends AbstractDAO<Meeting> {

     MeetingDAO() {
        super(Meeting.class);
     }
}
