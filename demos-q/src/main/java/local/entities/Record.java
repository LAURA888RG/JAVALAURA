package local.entities;

import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "records")
public class Record {
    @Column(name = "record_id")
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String content;

    @OneToOne(
        cascade = CascadeType.ALL,
        fetch = FetchType.LAZY
    )

    @JoinColumn(
        name = "meeting_id",
        unique = true)
    private Meeting meeting;

    public Record(String content) {
        this.content = content;
    }

    public Record() {
    }

 

    public void setContent(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setContent'");
    }

    @Override
    public String toString() {
        return "Record [id=" + id + ", content=" + content + ", meeting=" + meeting + "]";
    }

}
