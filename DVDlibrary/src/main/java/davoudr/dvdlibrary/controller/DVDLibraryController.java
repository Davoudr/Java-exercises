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

package davoudr.dvdlibrary.controller;

import davoudr.dvdlibrary.dao.DVDLibraryDao;
import davoudr.dvdlibrary.dao.DVDLibraryDaoException;
import davoudr.dvdlibrary.dao.DVDLibraryDaoFileImpl;
import davoudr.dvdlibrary.dto.Dvd;
import davoudr.dvdlibrary.ui.DVDLibraryView;
import davoudr.dvdlibrary.ui.UserIO;
import davoudr.dvdlibrary.ui.UserIOConsoleImpl;
import java.util.List;


public class DVDLibraryController {
    
    private DVDLibraryView view = new DVDLibraryView();
    private UserIO io = new UserIOConsoleImpl();
    private DVDLibraryDao dao = new DVDLibraryDaoFileImpl();

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        
        try {
            while (keepGoing) {

                menuSelection = getMenuSelection();

                switch (menuSelection) {
                    case 1:
                        listDvds();
                        break;
                    case 2:
                        createDvd();
                        break;
                    case 3:
                        viewDvd();
                        break;
                    case 4:
                        removeStudent();
                        break;
                    case 5:
                        viewDvd();
                        break;
                    case 6:
                        editDvdInfo();
                        break;
                    case 7:
                        keepGoing = false;
                        break;                    
                    default:
                        unknownCommand();
                }

            }
            exitMessage();
            } catch (DVDLibraryDaoException e) {
        view.displayErrorMessage(e.getMessage());
    }    
                      
            
    }
    
    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }
    
    private void createDvd() throws DVDLibraryDaoException {
        view.displayCreateDvdBanner();
        Dvd newDvd = view.getNewDvdInfo();
        dao.addDVD(newDvd.getDvdTitle(), newDvd);
        view.displayCreateSuccessBanner();
    }
    
    private void listDvds() throws DVDLibraryDaoException {
        view.displayDisplayAllBanner();
        List<Dvd> dvdList = dao.getAllDVDs();
        view.displayDvdList(dvdList);
    }
    
    private void viewDvd() throws DVDLibraryDaoException {
        view.displayDisplayDvdBanner();
        String dvdTitle = view.getDvdChoice();
        Dvd dvd = dao.getDVD(dvdTitle);
        view.displayDvd(dvd);
    }
    
    private void removeStudent() throws DVDLibraryDaoException {
        view.displayRemoveDvdBanner();
        String dvdTitle = view.getDvdChoice();
        io.print(dvdTitle);
        Dvd removedDvd = dao.removeDVD(dvdTitle);
        view.displayRemoveResult(removedDvd);
    }

    
    public void editDvdInfo() throws DVDLibraryDaoException{
        view.displayEditBanner();
        String dvdTitle = view.getDvdChoice();
       
        Dvd dvd = dao.getDVD(dvdTitle);
        view.displayDvd(dvd);
        if (dvd != null) {
            int fieldNumber = view.getEditOptions();
            String editedStr = view.getEditedInfo();
           if( dao.editDVD(dvd, fieldNumber, editedStr)!= null) {
               Dvd newVersion = dao.getDVD(dvdTitle);
               view.printDvdInfo(newVersion);
               view.displaySuccessEditBanner();
           };
        }
    }
    
    
    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
     }
}
