package spring.graph.demo.entity;

import com.sun.source.doctree.SerialDataTree;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * @Author: apple
 * @created on 31/07/2020
 * @Project is SpringGraphql
 */

@Data
@EqualsAndHashCode
@Entity
public class Vehicle implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "model_code", nullable = false)
    private String modelCode;

    @Column(name = "brand_name")
    private String brandName;

    @Column(name = "launch_date")
    private LocalDate launchDate;

    private transient String formattedDate;

    // Getter and Setter

    public String getFormattedDate() {
        return getLaunchDate().toString();
    }



}
