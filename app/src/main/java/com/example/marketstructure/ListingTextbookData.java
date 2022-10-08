package com.example.marketstructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ListingTextbookData {
    static ArrayList<Textbook> textbooks = new ArrayList<Textbook>();

    public static void main(String[] args) {
        textbooks.add(new Textbook("9780521629577", "Accretion Power in Astrophysics", 3, "Juhan Frank, Andrew King, Derek Raine", "textbook_9780521629577.png", 141.95, 2002, 400, "ASTR", "Astrology"));
        textbooks.add(new Textbook("9780521671866", "Galaxies in the Universe", 2, "Linda S. Sparke, John S. Gallagher, III", "textbook_9780521671866.png", 92.95, 2007, 440, "ASTR", "Astrology"));
        textbooks.add(new Textbook("9781488626241", "Campbell Biology", 12, "Lisa A. Urry, Noel Meyers, Michael L. Cain, Steven A. Wasserman, Peter V. Minorsky", "textbook_9781488626241.png", 164.95, 2021, 1552, "BIOL", "Biology"));
        textbooks.add(new Textbook("9781488617362", "Accounting", 9, "Tracie Miller-Nobles, Brenda Mattison, Ella Mae Matsumura, Peter Best, David Keene", "textbook_9781488617362.png", 163.75, 2020, 1128, "BUSN", "Business"));
        textbooks.add(new Textbook("9781488612640", "Horngren's Cost Accounting: A Managerial Emphasis", 3, "Charles T. Horngren, Srikant M. Datar, Madhav V. Rajan, William Maguire, Rebecca Tan", "textbook_9781488612640.png", 158.50, 2017, 848, "BUSN", "Business"));
        textbooks.add(new Textbook("9780655700326", "Financial Accounting", 9, "David Keene, Tracie Miller-Nobles, Brenda Mattison, Ella Mae Matsumura, Peter Best", "textbook_9780655700326.png", 153.24, 2020, 864, "BUSN", "Business"));
        textbooks.add(new Textbook("9781292408767", "Chemistry: The Central Science in SI Units", 15, "Theodore Brown, H. LeMay, Bruce Bursten, Catherine Murphy, Patrick Woodward", "textbook_9781292408767.png", 139.95, 2021, 1664, "CHEM", "Chemistry"));
        textbooks.add(new Textbook("9780198768128", "Inorganic Chemistry", 7, "Mark Weller, Tina Overton, Jonathan Rourke, Fraser Armstrong", "textbook_9780198768128.png", 120.95, 2018, 912, "CHEM", "Chemistry"));
        textbooks.add(new Textbook("9780199270293", "Organic Chemistry", 2, "Jonathan Clayden, Nick Greeves, Stuart Warren", "textbook_9780199270293.png", 127.95, 2012, 1264, "CHEM", "Chemistry"));
        textbooks.add(new Textbook("9780134494166", "Clean Architecture: A Craftsman's Guide to Software Structure and Design", 1, "Robert Martin", "textbook_9780134494166.png", 50.35, 2017, 432, "COMP", "Computing"));
        textbooks.add(new Textbook("9781292096131", "Software Engineering", 10, "Ian Sommerville", "textbook_9781292096131.png", 138.55, 2015, 816, "COMP", "Computing"));
        textbooks.add(new Textbook("9781488620683", "Macroeconomics", 6, "Stephen Williamson", "textbook_9781292215761.png", 146.95, 2017, 732, "ECON", "Economics"));
        textbooks.add(new Textbook("9781488620683", "Organisational Behaviour", 9, "Stephen Robbins, Timothy A. Judge, Marissa Edwards, Peter Sandiford, Martin Fitzgerald", "textbook_9781488620683.png", 156.40, 2019, 496, "MGMT", "Management"));
    }

    static String[] sellerUsernames = {"James Smith", "Robert Johnson", "John Williams", "Michael Brown",
            "David Jones", "William Garcia", "Richard Miller", "Joseph Davis", "Thomas Rodriguez",
            "Charles Martinez",	"Christopher Hernandez", "Daniel Lopez", "Matthew Gonzales",
            "Anthony Wilson", "Mark Anderson", "Donald Taylor", "Steven Moore", "Paul Jackson",
            "Andrew Lee", "Joshua Perez", "Kenneth Thompson", "Kevin White", "Brian Harris",
            "George Sanchez", "Timothy Clark", "Ronald Ramirez", "Edward Lewis", "Jason Robinson",
            "Jeffrey Walker", "Ryan Young",	"Jacob Allen", "Gary King", "Nicholas Wright",
            "Eric Torres", "Jonathan Nguyen", "Stephen Hill", "Larry Flores", "Justin Green",
            "Scott Adams", "Brandon Nelson", "Benjamin Baker", "Samuel Hall", "Gregory Rivera",
            "Alexander Campbell", "Frank Mitchell", "Patrick Carter", "Raymond Roberts", "Jack Gomez",
            "Dennis Phillips", "Jerry Evans", "Tyler Turner", "Aaron Diaz", "Jose Parker", "Adam Cruz",
            "Nathan Edwards", "Henry Collins", "Douglas Reyes", "Zachary Stewart", "Peter Morris",
            "Kyle Morales", "Ethan Murphy", "Walter Cook", "Noah Rogers", "Jeremy Gutierrez",
            "Christian Ortiz", "Keith Morgan", "Roger Cooper", "Terry Peterson", "Gerald Bailey",
            "Harold Reed", "Sean Howard", "Austin Ramos", "Carl Kim", "Arthur Cox",	"Lawrence Ward",
            "Dylan Richardson",	"Jesse Watson",	"Jordan Brooks", "Bryan Chavez", "Billy Wood",
            "Joe Bennet", "Bruce Gray",	"Gabriel Mendoza", "Logan Ruiz", "Albert Hughes",
            "Willie Price",	"Alan Alvarez",	"Juan Castillo", "Wayne Sanders", "Elijah Patel",
            "Randy Myers", "Roy Long", "Vincent Ross", "Ralph Foster", "Eugene Jimenez",
            "Russell Mohamed", "Bobby Ali", "Mason Ahmed", "Philip Ibrahim", "Louis Hassan",
            "Mary Wang", "Patricia Li", "Jennifer Zhang", "Linda Chen",	"Elizabeth Liu",
            "Barbara Martin", "Susan Muller", "Jessica Fernandez", "Sarah Gonzalez", "Karen da Silva",
            "Lisa dos Santos", "Nancy Pereira",	"Betty Ferreira", "Margaret Alves", "Sandra Singh",
            "Ashley Kumar",	"Kimberly Sharma", "Emily Yang", "Donna Devi", "Michelle Cohen",
            "Carol Levi", "Amanda Park", "Dorothy Choi", "Melissa Jeong", "Deborah Kang",
            "Stephanie Jang", "Rebecca Yoon",	"Sharon Lim", "Laura Han", "Cynthia Seo",
            "Kathleen Shin", "Amy Song", "Angela Yoo", "Shirley Fernando", "Anna Dias",
            "Brenda Rodrigio", "Pamela Lin", "Emma Huang", "Nicole Chang", "Helen Wu",
            "Samantha Tran", "Katherine Le", "Christine Phan", "Debra Pham", "Rachel Vu", "Carolyn Vo",
            "Janet Bui", "Catherine Duong", "Maria Doan", "Heather Truong", "Diane Lam", "Ruth Mai",
            "Julie To",	"Olivia Ha", "Joyce Chand", "Virginia Prasad", "Victoria Khan",	"Kelly Lal",
            "Lauren Raj", "Christina Maharaj", "Joan Huber", "Evelyn Bauer", "Judith Gruber",
            "Megan Steiner", "Andrea Moser", "Cheryl Berger", "Hannah Lang", "Jacqueline Fisher",
            "Martha Schmidt", "Gloria Weber", "Teresa Wolf", "Ann Koller", "Sara Schuster",
            "Madison Jacobs", "Frances Lambert", "Kathryn Laurent",	"Janice Dupont", "Jean Nielsen",
            "Abigail Jensen", "Alice Hansen", "Julia Larsen", "Judy Olsen",	"Sophia Bernard",
            "Grace Leroy", "Denise Wagner", "Amber Roux", "Doris Colombo", "Marilyn Moretti",
            "Danielle Conte", "Beverly Orlando", "Isabella Franco", "Theresa Weiss", "Diana Meyers",
            "Natalie Borg",	"Brittany Dimitrov", "Charlotte Markov", "Marie Johannes", "Kayla Silva",
            "Alexis Sokolov", "Lori Volkov",};

    static String[] conditions = {"New", "Used"};

    static String[] additionalDetailsNew = {"Textbook is still in original packaging"
            , "Textbook includes ebook code", "N/A", "Textbook ebook code has been used"};

    static String[] additionalDetailsUsed = {"Textbook has partial water damage"
            , "Textbook has clear contact cover", "Textbook ebook code has been used",
            "A few textbook page corners have been folded to be used as a bookmark",
            "A few textbook page corners have been torn and sticky taped back together",
            "Textbook is in good condition, used for 6 months", "N/A",
            "Textbook is in good condition, used for 1 year"};

    static String[] listingStatuses = {"Active", "Shipped", "Inactive"};
}
