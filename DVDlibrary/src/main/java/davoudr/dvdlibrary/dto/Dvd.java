/**
 * @author: Davoud Ramezani Kermani
 * email:   davoud.rk@gmail.com
 * date:    2022
 * purpose: ""
 */

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package davoudr.dvdlibrary.dto;


public class Dvd {
    private String title;
    private String releaseDate;
    private String mpaaRating;
    private String directorsName;
    private String studio;
    private String comment;


    public Dvd (String dvdTitle) {
        this.title = dvdTitle;
    }

    public String getDvdTitle() {
        return title;
    }
        
    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String dvdReleaseDate) {
        this.releaseDate = dvdReleaseDate;
    }

    
    public String getMpaaRatinge() {
        return mpaaRating;
    }

    public void setMpaaRating(String dvdMpaaRating) {
        this.mpaaRating = dvdMpaaRating;
    }

    
    public String getDirectorsName() {
        return directorsName;
    }
    
    public void setDirectorsName(String dvdDirectorsName) {
        this.directorsName = dvdDirectorsName;
    }
        
    
    public String getStudio() {
        return studio;
    }
    
    public void setStudio(String dvdStudio) {
        this.studio = dvdStudio;
    }
        
    
    public String getComment() {
        return comment;
    }
    
    public void setComment(String dvdComment) {
        this.comment = dvdComment;
    }

   
}
