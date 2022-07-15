/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.classroster.dao;

import com.sg.classroster.dto.Student;
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
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author salajrawi
 */
public class ClassRosterDaoFileImpl implements ClassRosterDao{
    
    private final String ROSTER_FILE;
    public static final String DELIMITER = "::";
    private Map<String, Student> students = new HashMap<>();
    
    public ClassRosterDaoFileImpl(){
        ROSTER_FILE = "roster.txt";
    }

    public ClassRosterDaoFileImpl(String rosterTextFile){
        ROSTER_FILE = rosterTextFile;
    }
    
    
     @Override
    public Student addStudent(String studentId, Student student)
            throws ClassRosterPersistenceException {
        loadRoster();
        Student prevStudent = students.put(studentId, student);
        writeRoster();
        return prevStudent;
    }

    @Override
    public List<Student> getAllStudents()
            throws ClassRosterPersistenceException{
        loadRoster();
        return new ArrayList<Student>(students.values());
    }

    @Override
    public Student getStudent(String studentId)
            throws ClassRosterPersistenceException {
        loadRoster();
        return students.get(studentId);
    }

    @Override
    public Student removeStudent(String studentId)
            throws ClassRosterPersistenceException {
        loadRoster();
        Student removedStudent = students.remove(studentId);
        writeRoster();
        return removedStudent;
    }
    
    private Student unmarshallStudent(String studentAsText){

    String[] studentTokens = studentAsText.split(DELIMITER);

    String studentId = studentTokens[0];

    Student studentFromFile = new Student(studentId);

    // Index 1 - FirstName
    studentFromFile.setFirstName(studentTokens[1]);

    // Index 2 - LastName
    studentFromFile.setLastName(studentTokens[2]);

    // Index 3 - Cohort
    studentFromFile.setCohort(studentTokens[3]);

    // We have now created a student! Return it!
    return studentFromFile;
    }
    
    private void loadRoster() throws ClassRosterPersistenceException {
    Scanner scanner;

    try {
        // Create Scanner for reading the file
        scanner = new Scanner(
                new BufferedReader(
                        new FileReader(ROSTER_FILE)));
    } catch (FileNotFoundException e) {
        throw new ClassRosterPersistenceException(
                "-_- Could not load roster data into memory.", e);
    }

    String currentLine;

    Student currentStudent;

    while (scanner.hasNextLine()) {

        currentLine = scanner.nextLine();

        currentStudent = unmarshallStudent(currentLine);

        students.put(currentStudent.getStudentId(), currentStudent);
    }
    scanner.close();
    }
    
    private String marshallStudent(Student aStudent){

    String studentAsText = aStudent.getStudentId() + DELIMITER;

    studentAsText += aStudent.getFirstName() + DELIMITER;

    studentAsText += aStudent.getLastName() + DELIMITER;

    studentAsText += aStudent.getCohort();

    return studentAsText;
    }
    
    /**
 * Writes all students in the roster out to a ROSTER_FILE.  See loadRoster
 * for file format.
 * 
 * @throws ClassRosterPersistenceException if an error occurs writing to the file
 */
    private void writeRoster() throws ClassRosterPersistenceException {

        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(ROSTER_FILE));
        } catch (IOException e) {
            throw new ClassRosterPersistenceException(
                    "Could not save student data.", e);
        }


        String studentAsText;
        List<Student> studentList = this.getAllStudents();
        for (Student currentStudent : studentList) {
            // turn a Student into a String
            studentAsText = marshallStudent(currentStudent);
            // write the Student object to the file
            out.println(studentAsText);
            // force PrintWriter to write line to the file
            out.flush();
        }
        // Clean up
        out.close();
    }

}
