package com.example.marketstructure.GenerateData;

import com.example.marketstructure.Textbook;

import java.util.ArrayList;

public class ListingTextbookData {
    static ArrayList<Textbook> textbooks = new ArrayList<Textbook>();

    static {
        // Add Astrology (ASTR) Textbooks
        textbooks.add(new Textbook("9780521629577", "Accretion Power in Astrophysics", 3, "Juhan Frank, Andrew King, Derek Raine", "textbook9780521629577", 141.95, 2002, 400, "ASTR", "Astrology"));
        textbooks.add(new Textbook("9780521671866", "Galaxies in the Universe", 2, "Linda S. Sparke, John S. Gallagher, III", "textbook9780521671866", 92.95, 2007, 440, "ASTR", "Astrology"));
        textbooks.add(new Textbook("9780198752851", "Astrophysics: A Very Short Introduction", 1, "James Binney", "textbook9780198752851", 24.80, 2016, 144, "ASTR", "Astrology"));
        textbooks.add(new Textbook("9780192804341", "Particle Physics: A Very Short Introduction", 1, "Frank Close", "textbook9780192804341", 24.80, 2004, 160, "ASTR", "Astrology"));
        textbooks.add(new Textbook("9780198718635", "Nuclear Physics: A Very Short Introduction", 1, "Frank Close", "textbook9780198718635", 24.80, 2015, 136, "ASTR", "Astrology"));

        // Add Biology (BIOL) Textbooks
        textbooks.add(new Textbook("9781488626241", "Campbell Biology", 12, "Lisa A. Urry, Noel Meyers, Michael L. Cain, Steven A. Wasserman, Peter V. Minorsky", "textbook9781488626241", 164.95, 2021, 1552, "BIOL", "Biology"));
        textbooks.add(new Textbook("9781319308322", "A Student Handbook for Writing in Biology", 6, "Karin Knisely", "textbook9781319308322", 49.95, 2021, 332, "BIOL", "Biology"));
        textbooks.add(new Textbook("9780199676507", "Genes: A Very Short Introduction", 1, "Jonathan Slack", "textbook9780199676507", 24.80, 2014, 152, "BIOL", "Biology"));
        textbooks.add(new Textbook("9780198723882", "Molecular Biology: A Very Short Introduction", 1, "Aysha Divan, Janice Royds", "textbook9780198723882", 23.25, 2016, 144, "BIOL", "Biology"));
        textbooks.add(new Textbook("9780451529060", "The Origin of Species", 150, "Charles Darwin", "textbook9780451529060", 11.99, 2006, 576, "BIOL", "Biology"));

        //Add Business (BUSN) Textbooks
        textbooks.add(new Textbook("9781488617362", "Accounting", 9, "Tracie Miller-Nobles, Brenda Mattison, Ella Mae Matsumura, Peter Best, David Keene", "textbook9781488617362", 163.75, 2020, 1128, "BUSN", "Business"));
        textbooks.add(new Textbook("9780198743514", "A Dictionary of Accounting: Oxford Quick Reference", 5, "Jonathan Law", "textbook9780198743514", 29.95, 2016, 480, "BUSN", "Business"));
        textbooks.add(new Textbook("9780199683697", "Taxation: A Very Short Introduction", 1, "Stephen Smith", "textbook9780199683697", 24.80, 2015, 144, "BUSN", "Business"));
        textbooks.add(new Textbook("9780199684311", "Accounting A Very Short Introduction", 1, "Christopher Nobes", "textbook9780199684311", 24.80, 2014, 144, "BUSN", "Business"));
        textbooks.add(new Textbook("9781488612640", "Horngren's Cost Accounting: A Managerial Emphasis", 3, "Charles T. Horngren, Srikant M. Datar, Madhav V. Rajan, William Maguire, Rebecca Tan", "textbook9781488612640", 158.50, 2017, 848, "BUSN", "Business"));
        textbooks.add(new Textbook("9780655700326", "Financial Accounting", 9, "David Keene, Tracie Miller-Nobles, Brenda Mattison, Ella Mae Matsumura, Peter Best", "textbook9780655700326", 153.24, 2020, 864, "BUSN", "Business"));

        //Add Chemistry (CHEM) Textbooks
        textbooks.add(new Textbook("9781292408767", "Chemistry: The Central Science in SI Units", 15, "Theodore Brown, H. LeMay, Bruce Bursten, Catherine Murphy, Patrick Woodward", "textbook9781292408767", 139.95, 2021, 1664, "CHEM", "Chemistry"));
        textbooks.add(new Textbook("9780198821816", "Study and Communication Skills for the Chemical Sciences", 3, "Tina Overton, Stuart Johnson, Jon Scott", "textbook9780198821816", 56.95, 2019, 304, "CHEM", "Chemistry"));
        textbooks.add(new Textbook("9780198768128", "Inorganic Chemistry", 7, "Mark Weller, Tina Overton, Jonathan Rourke, Fraser Armstrong", "textbook9780198768128", 120.95, 2018, 912, "CHEM", "Chemistry"));
        textbooks.add(new Textbook("9780199270293", "Organic Chemistry", 2, "Jonathan Clayden, Nick Greeves, Stuart Warren", "textbook9780199270293", 127.95, 2012, 1264, "CHEM", "Chemistry"));
        textbooks.add(new Textbook("9781781319307", "The Periodic Table: A visual guide to the elements", 1, "Tom Jackson", "textbook9781781319307", 24.99, 2020, 224, "CHEM", "Chemistry"));
        textbooks.add(new Textbook("9780199683970", "Chemistry: A Very Short Introduction", 1, "Peter Atkins", "textbook9780199683970", 17.95, 2015, 144, "CHEM", "Chemistry"));

        //Add Computing (COMP) Textbooks
        textbooks.add(new Textbook("9780134494166", "Clean Architecture: A Craftsman's Guide to Software Structure and Design", 1, "Robert Martin", "textbook9780134494166", 50.35, 2017, 432, "COMP", "Computing"));
        textbooks.add(new Textbook("9781492051367", "Introducing Python: Modern Computing in Simple Packages", 2, "Bill Lubanovic", "textbook9781492051367", 95, 2017, 500, "COMP", "Computing"));
        textbooks.add(new Textbook("9780321563842", "The C++ Programming Language", 4, "Bjarne Stroustrup", "textbook9780321563842", 192.25, 2013, 1376, "COMP", "Computing"));
        textbooks.add(new Textbook("9780198733461", "Computer Science: A Very Short Introduction", 1, "Subrata Dasgupta", "textbook9780198733461", 24.80, 2016, 816, "COMP", "Computing"));
        textbooks.add(new Textbook("9781292096131", "Software Engineering", 10, "Ian Sommerville", "textbook9781292096131", 138.55, 2015, 816, "COMP", "Computing"));

        //Add Economics (ECON) Textbooks
        textbooks.add(new Textbook("9781292215761", "Macroeconomics", 6, "Stephen Williamson", "textbook9781292215761", 146.95, 2017, 732, "ECON", "Economics"));
        textbooks.add(new Textbook("9781409376415", "The Economics Book: Big Ideas Simply Explained", 1, "DK", "textbook9781409376415", 42.99, 2012, 352, "ECON", "Economics"));
        textbooks.add(new Textbook("9780718197032", "Economics: The User's Guide: A Pelican Introduction", 1, "Ha-Joon Chang", "textbook9780718197032", 22.99, 2012, 352, "ECON", "Economics"));
        textbooks.add(new Textbook("9780199689378", "Microeconomics: A Very Short Introduction", 1, "Avinash Dixit", "textbook9780199689378", 24.80, 2021, 144, "ECON", "Economics"));
        textbooks.add(new Textbook("9781292411019", "Economics", 3, "Daron Acemoglu, David Laibson, John List", "textbook9781292411019", 22.99, 2014, 528, "ECON", "Economics"));

        //Add Econometrics (EMET) Textbook
        textbooks.add(new Textbook("9781292359281", "Essential Mathematics for Economic Analysis", 6, "Knut Sydsaeter, Peter Hammond, Arne Strom, Andres Carvajal", "textbook9781292359281", 110.20, 2021, 976, "EMET", "Econometrics"));

        //Add Engineering (ENGN) Textbooks
        textbooks.add(new Textbook("9781292089232", "Engineering Mathematics", 14, "Russell Hibbeler", "textbook9781292089232", 133.30, 2016, 720, "ENGN", "Engineering"));
        textbooks.add(new Textbook("9780080982854", "Writing for Science and Engineering: Papers, Presentations and Reports", 2, "Heather Silyn-Roberts", "textbook9780080982854", 61.95, 2012, 208, "ENGN", "Engineering"));
        textbooks.add(new Textbook("9789813144231", "Communicating Science: A Practical Guide For Engineers And Physical Scientists", 1, "Edith S Boxman, Reuven (Raymond) L Boxman", "textbook9789813144231", 53.99, 2017, 288, "ENGN", "Engineering"));
        textbooks.add(new Textbook("9781119285960", "A Guide to Writing as an Engineer", 5, "David F. Beer, David A. McMurrey", "textbook9781119285960", 148.95, 2019, 240, "ENGN", "Engineering"));
        textbooks.add(new Textbook("9781292261041", "Electric Circuits", 11, "James Nilsson, Susan Riedel", "textbook9781292261041", 136.46, 2019, 816, "ENGN", "Engineering"));

        //Add Finance (FINM) Textbooks
        textbooks.add(new Textbook("9781488657689", "Financial Management: Principles and Applications", 8, "Sheridan Titman, Tony Martin, Arthur J. Keown, John D. Martin", "textbook9781488657689", 159.56, 2018, 744, "FINM", "Finance"));
        textbooks.add(new Textbook("9781292304151", "Corporate Finance", 5, "Jonathan Berk, Peter DeMarzo", "textbook9781292304151", 162.69, 2019, 1184, "FINM", "Finance"));
        textbooks.add(new Textbook("9781442532793", "Fundamentals of Futures and Options Markets", 1, "John Hull , Sirimon Treepongkaruna, David Colwell , Richard Heaney , David Pitt", "textbook9781442532793", 158.5, 2013, 576, "FINM", "Finance"));
        textbooks.add(new Textbook("9781292410654", "Options, Futures, and Other Derivatives", 11, "John Hull", "textbook9781292410654", 115.45, 2021, 880, "FINM", "Finance"));
        textbooks.add(new Textbook("9781852334581", "Risk-Neutral Valuation: Pricing and Hedging of Financial Derivatives", 11, "Nicholas H. Bingham, Rudiger Kiesel", "textbook9781852334581", 132.40, 2004, 438, "FINM", "Finance"));
        textbooks.add(new Textbook("9781292270081", "Multinational Business Finance", 15, "David Eiteman, Arthur Stonehill, Michael Moffett", "textbook9781292270081", 138.55, 2020, 640, "FINM", "Finance"));
        textbooks.add(new Textbook("9780199688920", "Banking: A Very Short Introduction", 1, "John Goddard, John O. S. Wilson", "textbook9780199688920", 18.95, 2016, 144, "FINM", "Finance"));

        //Add Law (LAWS) Textbooks
        textbooks.add(new Textbook("9780455241746", "Equity and Trusts: Commentary & Materials", 7, "Gino Dal Pont", "textbook9780455241746", 197, 2018, 1321, "LAWS", "Law"));
        textbooks.add(new Textbook("9780455241111", "Uniform Evidence Law: Commentary and Materials", 6, "Stephen Odgers SC, Miiko Kumar, Elisabeth Peden", "textbook9780455241111", 174, 2018, 1397, "LAWS", "Law"));
        textbooks.add(new Textbook("9780455244709", "Australian Commercial Law", 33, "Clive Turner, John Trone", "textbook9780455244709", 131, 2020, 600, "LAWS", "Law"));
        textbooks.add(new Textbook("9780455240626", "Commercial Law: Commentary and Materials", 4, "Gail Pearson, Elisabeth Peden, GJ Tolhurst, Sheelagh McCracken, Jeannie Paterson", "textbook9780455240626", 185, 2019, 886, "LAWS", "Law"));
        textbooks.add(new Textbook("9780409354119", "Equity and Trusts: LexisNexis Questions and Answers", 5, "Tina Cockburn, Rebecca Wright", "textbook9780409354119", 70, 2021, 394, "LAWS", "Law"));
        textbooks.add(new Textbook("9780409340358", "Equity: LexisNexis Study Guide", 3, "Susan Barkehall Thomas, Vicki Vann", "textbook9780409340358", 66, 2015, 340, "LAWS", "Law"));
        textbooks.add(new Textbook("9780455502700", "Uniform Evidence Law", 17, "Stephen Odgers SC", "textbook9780455502700", 182, 2022, 2021, "LAWS", "Law"));
        textbooks.add(new Textbook("9780190304737", "Australian Law Dictionary", 3, "Trischa Mann", "textbook9780190304737", 89.95, 2017, 1040, "LAWS", "Law"));

        //Add Management (MGMT) Textbooks
        textbooks.add(new Textbook("9781488620683", "Organisational Behaviour", 9, "Stephen Robbins, Timothy A. Judge, Marissa Edwards, Peter Sandiford, Martin Fitzgerald", "textbook9781488620683", 156.40, 2019, 496, "MGMT", "Management"));
        textbooks.add(new Textbook("9781488624308", "Communication for Business", 3, "Deshani Ganegoda, Narelle Panazzolo", "textbook9781488624308", 78.71, 2018, 398, "MGMT", "Management"));
        textbooks.add(new Textbook("9781292304595", "The Business Student's Handbook: Skills for Study and Employment", 7, "Sheila Cameron", "textbook9781292304595", 68.20, 2021, 544, "MGMT", "Management"));

        //Add Marketing (MKTG) Textbooks
        textbooks.add(new Textbook("9781398605978", "Digital Marketing Strategy: An Integrated Approach to Online Marketing", 3, "Simon Kingsnorth", "textbook9781398605978", 66, 2022, 416, "MKTG", "Marketing"));
        textbooks.add(new Textbook("9781398603394", "The Digital Marketing Handbook: Deliver Powerful Digital Campaigns", 1, "Simon Kingsnorth", "textbook9781398603394", 44, 2022, 288, "MKTG", "Marketing"));

        //Add Politics (POLS) Textbooks
        textbooks.add(new Textbook("9780199796182", "Principles of International Political Economy", 1, "Bumba Mukherjee, Mark Hallerberg, Jeffrey Kucik", "textbook9780199796182", 138.95, 2020, 304, "POLS", "Politics"));
        textbooks.add(new Textbook("9781683286776", "Principles of International Law", 3, "Sean D. Murphy", "textbook9781683286776", 133.75, 2018, 699, "POLS", "Politics"));
        textbooks.add(new Textbook("9780199670840", "The Concise Oxford Dictionary of Politics and International Relations: Oxford Quick Reference", 4, "Garrett W Brown, Iain McLean, Alistair McMillan", "textbook9780199670840", 29.95, 2018, 624, "POLS", "Politics"));
        textbooks.add(new Textbook("9780192853882", "Politics: A Very Short Introduction", 1, "Kenneth Minogue", "textbook9780192853882", 24.80, 2000, 128, "POLS", "Politics"));

        //Add Psychology (PSYCH) Textbooks
        textbooks.add(new Textbook("9781292341477", "Social Psychology", 10, "Elliot Aronson, Timothy Wilson, Robin Akert, Samuel Sommers", "textbook9781292341477", 129.10, 2020, 608, "PSYC", "Psychology"));
        textbooks.add(new Textbook("9780199657681", "A Dictionary of Psychology: Oxford Paperback Reference", 4, "Andrew M. Colman", "textbook9780199657681", 30.95, 2015, 896, "PSYC", "Psychology"));
        textbooks.add(new Textbook("9781433832161", "Publication Manual of the American Psychological Association", 7, "American Psychological Association", "textbook9781433832161", 69.99, 2019, 428, "PSYC", "Psychology"));
        textbooks.add(new Textbook("9780198715511", "Social Psychology: A Very Short Introduction", 7, "Richard J. Crisp", "textbook9780198715511", 24.80, 2015, 144, "PSYC", "Psychology"));

        //Add Science Communication (SCOM) Textbooks
        textbooks.add(new Textbook("9781108816045", "Health Promotion", 1, "Merryn McKinnon", "textbook9781108816045", 80.95, 2021, 308, "SCOM", "Science Communication"));
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

    static String[] conditions = {"New", "Used - Good", "Used - Worn"};

    static String[] additionalDetailsNew = {"Textbook is still in original packaging"
            , "Textbook includes ebook code", "N/A", "Textbook ebook code has been used"};

    static String[] additionalDetailsUsedGood = {"Textbook has clear contact cover",
            "Textbook ebook code has been used", "Textbook is in good condition, used for 6 months",
            "Textbook is in good condition, used for 1 year", "N/A"};

    static String[] additionalDetailsUsedWorn = {"Textbook has partial water damage"
            , "A few textbook page corners have been folded to be used as a bookmark",
            "A few textbook page corners have been torn and sticky taped back together", "N/A"};

    static String[] listingStatuses = {"Active - Purchase Now", "Active - Bidding"
            , "Processed - Shipped", "Processed - Delivered", "Complete - Inactive",
            "Fraud Listing/Seller Identified"};
}
