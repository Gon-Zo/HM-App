package io.gonzo.middleware.web.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class StoreDTO {


    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Base {

        @NotNull
        private String region;

        @NotNull
        private String date;

    }

}
