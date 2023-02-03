package jx.pgz.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class DetailInfo {

    private String ssm;
    private Integer user;
    private Integer presenter;
    private String taskname;
    private Bg bg;
    private Integer dealtype;

    @NoArgsConstructor
    @Data
    public static class Bg {
        private String npy;
        private String pic;
        private List<Integer> padd;
        private String path;
        private List<?> actions;
        private Boolean needmerge;
    }
}
