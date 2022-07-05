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

package davoudr.dvdlibrary.dao;

import davoudr.dvdlibrary.dto.Dvd;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class DVDLibraryDaoFileImpl implements DVDLibraryDao {
    
    public static final String DVD_FILE = "dvd.txt";
    public static final String DELIMITER = "::";
    private Map<String, Dvd> dvds = new HashMap<>();
    
    /**
     *
     * @param dvdTitle
     * @param dvd
     * @return
     * @throws DVDLibraryDaoException
     */
    @Override
    public Dvd addDVD(String dvdTitle, Dvd dvd) 
    throws DVDLibraryDaoException {
        loadDvd();
        Dvd newdvd = dvds.put(dvdTitle, dvd);
        writeDvd();
        return newdvd;
    }

    @Override
    public List<Dvd> getAllDVDs() 
    throws DVDLibraryDaoException {
        loadDvd();
        return new ArrayList<Dvd>(dvds.values());
    }

    @Override
    public Dvd getDVD(String dvdTitle) 
    throws DVDLibraryDaoException {
        loadDvd();
        return dvds.get(dvdTitle);
    }

    @Override
    public Dvd removeDVD(String dvdTitle) 
    throws DVDLibraryDaoException {
         loadDvd();
         Dvd removedDvd = dvds.remove(dvdTitle);
         writeDvd();
         return removedDvd;
    }

    @Override
    public Dvd editDVD(Dvd dvd, int fieldNumber, String editedStr) 
    throws DVDLibraryDaoException {
        Dvd temporaryVersionDvd = dvd;
        switch (fieldNumber) {
            case 1:
                temporaryVersionDvd.setReleaseDate(editedStr);
                break;
            case 2:
                temporaryVersionDvd.setMpaaRating(editedStr);
                break;
            case 3:
                temporaryVersionDvd.setDirectorsName(editedStr);
                break;
            case 4:
                temporaryVersionDvd.setStudio(editedStr);
                break;
            case 5:
                temporaryVersionDvd.setComment(editedStr);
                break;
            default:
                break;                
        }
        loadDvd();
        Dvd replacedDvd = dvds.replace(dvd.getDvdTitle(), dvd);
        writeDvd();
        return replacedDvd;
    }
    
    private Dvd unmarshallDvd(String dvdAsText){

        String[] dvdTokens = dvdAsText.split(DELIMITER);

        String title = dvdTokens[0];

        Dvd dvdFromFile = new Dvd(title);

        dvdFromFile.setReleaseDate(dvdTokens[1]);

        dvdFromFile.setMpaaRating(dvdTokens[2]);

        dvdFromFile.setDirectorsName(dvdTokens[3]);
        
        dvdFromFile.setStudio(dvdTokens[4]);

        dvdFromFile.setComment(dvdTokens[5]);

        return dvdFromFile;
    }
    
    
    private void loadDvd() throws DVDLibraryDaoException {
    Scanner scanner;

        try {
            scanner = new Scanner(
                        new BufferedReader(
                            new FileReader(DVD_FILE)));
        } catch (FileNotFoundException e) {
            throw new DVDLibraryDaoException(
                    "-_- Could not load dvd data into memory.", e);
        }
        
        String currentLine;
        Dvd currentDvd;

        while (scanner.hasNextLine()) {
            
            currentLine = scanner.nextLine();
            currentDvd = unmarshallDvd(currentLine);

            dvds.put(currentDvd.getDvdTitle(), currentDvd);
        }
        scanner.close();
    }
    

    private String marshallDvd(Dvd aDvd){

        String dvdAsText = aDvd.getDvdTitle() + DELIMITER;

        dvdAsText += aDvd.getReleaseDate() + DELIMITER;

        dvdAsText += aDvd.getMpaaRatinge() + DELIMITER;

        dvdAsText += aDvd.getDirectorsName() + DELIMITER;

        dvdAsText += aDvd.getStudio() + DELIMITER;

        dvdAsText += aDvd.getComment();

        return dvdAsText;
    }
    
    

    private void writeDvd() throws DVDLibraryDaoException {

        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(DVD_FILE));
        } catch (IOException e) {
            throw new DVDLibraryDaoException(
                    "Could not save dvd data.", e);
        }

        String dvdAsText;
        List<Dvd> dvdList = this.getAllDVDs();
        
        for (Dvd currentDvd : dvdList) {

            dvdAsText = marshallDvd(currentDvd);
 
            out.println(dvdAsText);
            // force PrintWriter to write line to the file
            out.flush();
        }
        out.close();
    }
    
   
    
}
