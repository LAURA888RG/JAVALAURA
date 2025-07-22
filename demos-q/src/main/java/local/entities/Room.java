
package local.entities;


import org.hibernate.type.descriptor.sql.internal.CapacityDependentDdlType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "rooms")
public class Room {
    @Column(name = "room_id")
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private CapacityDependentDdlType capacity;

    public Room() {
    }

    public Room(int id, String name, CapacityDependentDdlType capacity) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Room [id=" + id + ", name=" + name + ", date=" + date + "]";
    }

}
