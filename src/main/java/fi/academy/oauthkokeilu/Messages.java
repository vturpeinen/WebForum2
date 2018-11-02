package fi.academy.oauthkokeilu;

import java.sql.Date;

public class Messages {

        private String label;
        private String content;
        private Integer id;
        private Date ttimestamp;
        private String ggroup;
//        private int userid;

        public Messages(String label, String content, Integer id, Date ttimestamp, String ggroup) {
            this.label = label;
            this.content = content;
            this.id = id;
            this.ttimestamp = ttimestamp;
            this.ggroup = ggroup;
//            this.userid = userid;
        }

    public Messages() {
    }


    public String getGgroup() {
        return ggroup;
    }
    public void setGgroup(String ggroup) {
        this.ggroup = ggroup;
    }
    public String getLabel() {
        return label;
    }
    public void setLabel(String label) {
        this.label = label;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Date getTtimestamp() {
        return ttimestamp;
    }
    public void setTtimestamp(Date ttimestamp) {
        this.ttimestamp = ttimestamp;
    }

//    @Override
//    public String toString() {
//        return "Messages{" +
//                "label='" + label + '\'' +
//                ", content='" + content + '\'' +
//                ", id=" + id +
//                ", ttimestamp=" + ttimestamp +
//                ", ggroup='" + ggroup + '\'' +
//                '}';
//    }
}
