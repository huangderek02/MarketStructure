package com.example.marketstructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class TextbookData {
    static ArrayList<Textbook> textbooks = new ArrayList<Textbook>();

    public static void main(String[] args) {
        textbooks.add(new Textbook("9780521629577", "Accretion Power in Astrophysics", 3, "Juhan Frank, Andrew King, Derek Raine", "textbook_9780521629577.png", 141.95, 2002, 400, "ASTR", "Astrology"));
        textbooks.add(new Textbook("9780521671866", "Galaxies in the Universe", 2, "Linda S. Sparke, John S. Gallagher, III", "textbook_9780521671866.png", 92.95, 2007, 440, "ASTR", "Astrology"));
        textbooks.add(new Textbook("9781488617362", "Accounting", 9, "Tracie Miller-Nobles, Brenda Mattison, Ella Mae Matsumura, Peter Best, David Keene", "textbook_9781488617362.png", 163.75, 2020, 1128, "BUSN", "Business"));
        textbooks.add(new Textbook("9781488620683", "Organisational Behaviour", 9, "Stephen Robbins, Timothy A. Judge, Marissa Edwards, Peter Sandiford, Martin Fitzgerald", "textbook_9781488620683.png", 156.40, 2019, 496, "MGMT", "Management"));
        /*
        ArrayList<Textbook> textbookDetailsList = new ArrayList<Textbook>(Arrays.asList(textbook1, textbook2, textbook3, textbook4));
        HashMap<String, ArrayList<String>> textbooksMap = new HashMap<String, ArrayList<String>>();

        for (Textbook t : textbookDetailsList) {
            if (textbooksMap.containsKey(textbook1.isbn)) {
                textbooksMap.get(t.isbn).add(t.title);
                textbooksMap.get(t.isbn).add(String.valueOf(t.edition));
                textbooksMap.get(t.isbn).add(t.authors);
                textbooksMap.get(t.isbn).add(t.textbookImageURL);
                textbooksMap.get(t.isbn).add(String.valueOf(t.price));
                textbooksMap.get(t.isbn).add(String.valueOf(t.yearPublished));
                textbooksMap.get(t.isbn).add(String.valueOf(t.numberOfPages));
                textbooksMap.get(t.isbn).add(t.topicCode);
                textbooksMap.get(t.isbn).add(t.topic);
            } else {
                textbooksMap.put(t.isbn, new ArrayList<String>());
                textbooksMap.get(t.isbn).add(t.title);
                textbooksMap.get(t.isbn).add(String.valueOf(t.edition));
                textbooksMap.get(t.isbn).add(t.authors);
                textbooksMap.get(t.isbn).add(t.textbookImageURL);
                textbooksMap.get(t.isbn).add(String.valueOf(t.price));
                textbooksMap.get(t.isbn).add(String.valueOf(t.yearPublished));
                textbooksMap.get(t.isbn).add(String.valueOf(t.numberOfPages));
                textbooksMap.get(t.isbn).add(t.topicCode);
                textbooksMap.get(t.isbn).add(t.topic);
                }
            }
        System.out.println(textbooksMap);
        }

         */
    }

}
