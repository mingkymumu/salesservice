package com.noer.salesservice.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain=true)
@Entity
@Table(name = "sales")
public class Sales implements Serializable {
    private static final long serialVersionUID = 5L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date transactionDate;
    private Long userId;
    private String userName;
    private Double total;
    @OneToMany(
            mappedBy = "sales",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<SalesDetails> details;

    public Double getTotal()
    {
        Double sum = 0d;
        if(this.getDetails().size()>0){
           sum = this.getDetails().stream().map(obj -> obj.getQuantity() * obj.getProductPrice() ).reduce(0d ,(a,b) -> a+b);
        }
        return  sum;
    }
}
