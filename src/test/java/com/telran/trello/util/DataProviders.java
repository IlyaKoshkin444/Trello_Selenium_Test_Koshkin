package com.telran.trello.util;

import com.telran.trello.model.BoardData;
import com.telran.trello.model.TeamData;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {
    @DataProvider
    public Iterator<Object[]> validBoards() {
        List<Object[]> list =new ArrayList<>();
        list.add(new Object[]{"nameBoard1"});
        list.add(new Object[]{"Bn"});
        list.add(new Object[]{"BoardNameWithDataProvider2"});
        return list.iterator();
    }
    @DataProvider
    public Iterator<Object[]> validBoardsCSV() throws IOException {
        List<Object[]> list =new ArrayList<>();
        BufferedReader reader= new BufferedReader(new FileReader(new File("src/test/resources/boardsPositiveCSV.csv")));
        String line = reader.readLine();
        while (line!=null){
            String[]split = line.split(",");
            list.add(new Object[]{new BoardData().setBoardName(split[0])});
            line = reader.readLine();
        }
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> validTeams() {
        List<Object[]> list =new ArrayList<>();
        list.add(new Object[]{"name DP","description DP"});
        list.add(new Object[]{"DPn",""});

        return list.iterator();
    }
    @DataProvider
    public Iterator<Object[]> validTeamsCSV() throws IOException {
        List<Object[]> list =new ArrayList<>();
        BufferedReader reader= new BufferedReader(new FileReader(new File("src/test/resources/teamsPositiveCSV.csv")));
        String line = reader.readLine();
        while (line!=null){
            String[]split = line.split(",");
            list.add(new Object[]{new TeamData().setName(split[0]).setDescription(split[1])});
            line = reader.readLine();
        }
        return list.iterator();
    }
}
