package lk.ijse.Entity;

import lombok.*;
@AllArgsConstructor
@NoArgsConstructor
@Getter    // @Data
@Setter     //@Data
@ToString //@Data

public class Item {

        private String Name;
        private String Id;
        private int Qty;
        private double Price;

    }
