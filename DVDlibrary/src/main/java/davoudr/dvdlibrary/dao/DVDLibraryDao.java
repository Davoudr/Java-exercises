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
import java.util.List;


public interface DVDLibraryDao {
    
    Dvd addDVD(String dvdTitle, Dvd dvd)throws DVDLibraryDaoException;

    List<Dvd> getAllDVDs()throws DVDLibraryDaoException;

    Dvd getDVD(String dvdTitle)throws DVDLibraryDaoException;

    Dvd removeDVD(String dvdTitle)throws DVDLibraryDaoException;
    
    Dvd editDVD(Dvd dvd, int fieldNumber, String editedStr)throws DVDLibraryDaoException;
}
