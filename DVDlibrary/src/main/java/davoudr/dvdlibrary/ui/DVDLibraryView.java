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

package davoudr.dvdlibrary.ui;

import davoudr.dvdlibrary.dto.Dvd;
import java.util.List;


public class DVDLibraryView {

    private UserIO io = new UserIOConsoleImpl();
    
    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. List DVDs");
        io.print("2. Add New DVD");
        io.print("3. View a DVD");
        io.print("4. Remove a DVD");
        io.print("5. Search for a DVD by title");
        io.print("6. Edit DVD info");
        io.print("7. Exit");

        return io.readInt("Please select from the above choices.", 1, 6);
    }
    
    public Dvd getNewDvdInfo() {
        String title = io.readString("Please enter the Title!");
        String releaseDate = io.readString("Please the Release Date!");
        String mpaaRating = io.readString("Please the MPAA Raiting!");
        String directorsName = io.readString("Please enter the Director name!");
        String studio = io.readString("Please enter the Stadio name");
        String comment = io.readString("Please enter Your Comment!");
        Dvd currentStudent = new Dvd(title);
        currentStudent.setReleaseDate(releaseDate);
        currentStudent.setMpaaRating(mpaaRating);
        currentStudent.setDirectorsName(directorsName);
        currentStudent.setStudio(studio );
        currentStudent.setComment(comment);

    return currentStudent;
}
    
    
    public void displayCreateDvdBanner() {
        io.print("===== Add new DVD =====");
}
    
    
    public void displayCreateSuccessBanner() {
        io.readString(
            "DVD successfully added.  Please hit enter to continue");
}
 
    
    public void displayDvdList(List<Dvd> dvdList) {
        
    for (Dvd currentDvd : dvdList) {
        
        printDvdInfo(currentDvd);
        
    }
    io.readString("Please hit enter to continue.");
}
    
    
    public void printDvdInfo(Dvd currentDvd) {
            String dvdInfo = String.format("#%s : Release on: %s | MPAA Rating: %s | Director Name: %s | Studio Name: %s | Your Comment: %s |",
        currentDvd.getDvdTitle(),
        currentDvd.getReleaseDate(),
        currentDvd.getMpaaRatinge(),
        currentDvd.getDirectorsName(),
        currentDvd.getStudio(),
        currentDvd.getComment());
            io.print(dvdInfo);
    }
    
    
    public void displayDisplayAllBanner() {
    io.print("=== Display All DVDs ===");
}
    
    
    public void displayDisplayDvdBanner () {
    io.print("=== Display DVD ===");
}

    public String getDvdChoice() {
        return io.readString("Please enter the DVD title!");
    }

    public void displayDvd(Dvd dvd) {
        if (dvd != null) {
            printDvdInfo(dvd);
        } else {
            io.print("No such DVD.");
        }
        io.readString("Please hit enter to continue.");
    }
    
    public void displayRemoveDvdBanner () {
       io.print("=== Remove DVD ===");
    }

    public void displayRemoveResult(Dvd dvdRecord) {
        if(dvdRecord != null){
            io.print("DVD successfully removed.");
        }else{
           io.print("No such DVD.");
        }
        io.readString("Please hit enter to continue.");
    }
    
    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }
    
    public void displayEditBanner () {
       io.print("=== Edit DVD Info ===");
    }
    
    public int getEditOptions () {
       io.print("What do you want to edit? please insert the number!");
       return io.readInt("1.Release Date   2.MPAA Rating   3.Director Name   4.Studio Name   5.Your Comment",1,5);
    }  
    
    public String getEditedInfo () {
        return io.readString("What is the correction, please?!");
    }  
    
    public void displaySuccessEditBanner () {
        io.print("===DVD successfully edited===.");
    }
    
    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }
}
