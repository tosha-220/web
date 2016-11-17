package model;

import java.util.Date;
import java.util.List;

public class Organization {
    private List link;
    private List<Period> periods;

    public static class Period {
        private Date startDate;
        private Date endDate;
        private String potision;
        private String content;

        public Period(Date startDate, Date endDate, String potision, String content) {
            this.startDate = startDate;
            this.endDate = endDate;
            this.potision = potision;
            this.content = content;
        }

        public Period() {
        }
    }
}
