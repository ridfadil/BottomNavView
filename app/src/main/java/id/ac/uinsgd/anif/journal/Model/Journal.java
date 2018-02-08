package id.ac.uinsgd.anif.journal.Model;

/**
 * Created by adam on 2/1/18.
 */

public class Journal {

    private String judul;
    private int coverId;
    private String lastIssue;
    private String issn;

    public Journal(String judul, int coverId, String lastIssue, String issn) {
        this.judul = judul;
        this.coverId = coverId;
        this.lastIssue = lastIssue;
        this.issn = issn;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public int getCoverId() {
        return coverId;
    }

    public void setCoverId(int coverId) {
        this.coverId = coverId;
    }

    public String getLastIssue() {
        return lastIssue;
    }

    public void setLastIssue(String lastIssue) {
        this.lastIssue = lastIssue;
    }

    public String getIssn() {
        return issn;
    }

    public void setIssn(String issn) {
        this.issn = issn;
    }
}
