package fi.academy.oauthkokeilu;

import java.sql.Date;

public class Viestit {

        private String label;
        private String content;
        private Integer id;
        private Date timestamp;

        public Viestit(String label, String content, Integer id, Date timestamp) {
            this.label = label;
            this.content = content;
            this.id = id;
            this.timestamp = timestamp;
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
    public Date getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
    @Override
    public String toString() {
        return "Viestit{" +
                "label='" + label + '\'' +
                ", content='" + content + '\'' +
                ", id=" + id +
                ", timestamp=" + timestamp +
                '}';
    }
}
