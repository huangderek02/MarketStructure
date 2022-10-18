# Gorderhuifam Report

The following is a report template to help your team successfully provide all the details necessary for your report in a structured and organised manner. Please give a straightforward and concise report that best demonstrates your project. Note that a good report will give a better impression of your project to the reviewers.

*Here are some tips to write a good report:*

* *Try to summarise and list the `bullet points` of your project as many as possible rather than give long, tedious paragraphs that mix up everything together.*

* *Try to create `diagrams` instead of text descriptions, which are more straightforward and explanatory.*

* *Try to make your report `well structured`, which is easier for the reviewers to capture the necessary information.*

*We give instructions enclosed in square brackets [...] and examples for each sections to demonstrate what are expected for your project report.*

*Please remove the instructions or examples in `italic` in your final report.*

## Table of Contents

1. [Team Members and Roles](#team-members-and-roles)
2. [Summary of Individual Contributions](#summary-of-individual-contributions)
3. [Conflict Resolution Protocol](#conflict-resolution-protocol)
4. [Application Description](#application-description)
5. [Application UML](#application-uml)
6. [Application Design and Decisions](#application-design-and-decisions)
7. [Summary of Known Errors and Bugs](#summary-of-known-errors-and-bugs)
8. [Testing Summary](#testing-summary)
9. [Implemented Features](#implemented-features)
10. [Team Meetings](#team-meetings)

## Team Members and Roles

| UID | Name | Role |
| :--- | :----: | ---: |
| [u7117043] | [Gordon Lum] | [Worked on classes related to textbook searcher] |
| [u7300484] | [Derek Huang] | [role] |
| [u7366836] | [Huiguang Zhang] | [role] |
| [u7127350] | [Rhonda Luu] | [role] |

## Summary of Individual Contributions

*[Summarise the contributions made by each member to the project, e.g. code implementation, code design, UI design, report writing, etc.]*

*[Code Implementation. Which features did you implement? Which classes or methods was each member involved in? Provide an approximate proportion in pecentage of the contribution of each member to the whole code implementation, e.g. 30%.]*

*Here is an example:*

U7117043, Gordon Lum, Contribution: X%
* [[BTree](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/java/tokenizer_and_parser/BTree.java)] (Entire Class)
* [[Parser](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/java/tokenizer_and_parser/Parser.java)] (Entire Class)
* [[Tokenizer](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/java/tokenizer_and_parser/Tokenizer.java)](Entire Class)
* [[TextbookSearcher](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/java/tokenizer_and_parser/TextbookSearcher.java)] (Entire Class)
* All test classes in [tokenizer_and_parser](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/tree/main/app/src/test/java/tokenizer_and_parser)


U7300484, Derek Huang, Contribution: X%
* A.class
* B.class: function1(), function2(), ...
* ....


U7366836, Huiguang Zhang, Contribution: X%
* A.class
* B.class: function1(), function2(), ...
* ....


U7444134, Ratchanont Treevijitpaisan, Contribution: X%
* A.class
* B.class: function1(), function2(), ...
* ....


*U7127350 , Rhonda Luu, Contribution: X%
* A.class
* B.class: function1(), function2(), ...
* ....

*you should ALSO provide links to the specified classes and/or functions*

*[Code Design. What design patterns, data structures, did the involved member propose?]*

*[UI Design. Specify what design did the involved member propose? What tools were used for the design?]*

*[Report Writing. Which part of the report did the involved member write?]*

*[Slide preparation. Were you responsible for the slides?]*

*[Miscellaneous contributions. You are welcome to provide anything that you consider as a contribution to the project or team.]*

## Conflict Resolution Protocol

[Sickness or unability to work]

* If a team member is unwell, whoever has completed their delegated task first will help complete the unwell team member's part.
The unwell team member will help the other team member with their other assigned tasks. Key requirements of the assignment will be prioritised.

[Decision making]

* When the group member has issues or needs to make a decision that is open ended, we will reach consensus and solve the issue by majority vote.
The group member who requires a decison to be made should contact the other members in the group chat or next meeting.

[Not meeting expected deadlines]

* If a team member is having difficulties completing a task, they will flag the issue with other team members via the group chat and  we will work through the issue together. If a solution is not reached, further research and help from tutors will be conducted. Any findings or possible solutions reported in group chat or next meeting.

[Other responsibilities]

1. Everyone must use good code documentation to ensure that others can read through the code easily and troublshoot the issue/help complete the task.
2. Time estimates will be set to complete tasks.
3. Updates on our progress on tasks and any issues will be communicated in the group chat and in team meetings, we might use trello (Rhonda will look into this)
5. Ensure that diagrams are clear, large and easier for marker/team members to read


## Application Description

[App name] is a markplace application that is specifically made for university students. It provies a place to search and purchase secondhand textbooks related to their courses. 


**Application Use Cases and or Examples**

Bob is studying for a building degree and is currently enrolled in BUIL1011, BUIL1100 and ENGN1211. He wants to purchase the textbooks for further study but like most university, is poor and doesnt want to be eating 2 minute noodles for the entire semester. 
* Bob needs to buy 3 textbooks
* He creates an account with an email and password on [app name]
* He logs in to his account which takes him to the marketplace
* He searches for his textbook using the search function and filters: "Can I Fix It?, Yes you can!, Engineering for Beginners"
* The application loads the textbooks and he clicks on a second hand one that is in a used condition.
* The application moves to a page where Bob can buy the textbook
* Bob buys the book and it moves back to the marketplace page
* Bob repeats this for the other two books

Target Users: Students studying at university

* User can create an account using an email and password
* User can login to the application using an existing email and password

* User can search for textbooks by title or by ISBN
* User can filter textbooks found by cost, pages, edition, topic, class code
* User can sort textbooks found in ascending or descending order: alphabetically, price, topic, pages
* User can view listings available, there prices and sellers if they exist
* User can purchase an existing textbook

* User can send messages to other users
* User gets warned about potential fraud and scams 


-----------------------------------------------------------------------------------

*[What is your application, what does it do? Include photos or diagrams if necessary]*

*Here is a pet specific application example*

*PetBook is a social media application specifically targetting pet owners... it provides... certified practitioners, such as veterians are indicated by a label next to their profile...*


*[Provide use cases and examples of people using your application. Who are the target users of your application? How do the users use your application?]*

*Here is a pet training application example*

*Molly wants to inquiry about her cat, McPurr's recent troublesome behaviour*
1. *Molly notices that McPurr has been hostile since...*
2. *She makes a post about... with the tag...*
3. *Lachlan, a vet, writes a reply to Molly's post...*
4. ...
5. *Molly gives Lachlan's reply a 'tick' response*

*Here is a map navigation application example*

*Targets Users: Drivers*

* *Users can use it to navigate in order to reach the destinations.*
* *Users can learn the traffic conditions*
* ...

*Target Users: Those who want to find some good restaurants*

* *Users can find nearby restaurants and the application can give recommendations*
* ...

*List all the use cases in text descriptions or create use case diagrams. Please refer to https://www.visual-paradigm.com/guide/uml-unified-modeling-language/what-is-use-case-diagram/ for use case diagram.*

## Application UML

![ClassDiagramExample](./images/ClassDiagramExample.png) <br>
*[Replace the above with a class diagram. You can look at how we have linked an image here as an example of how you can do it too.]*

## Application Design and Decisions

*Please give clear and concise descriptions for each subsections of this part. It would be better to list all the concrete items for each subsection and give no more than `5` concise, crucial reasons of your design. Here is an example for the subsection `Data Structures`:*

*I used the following data structures in my project:*



**Data Structures**

1. ArrayList

   * Objective: It is used for storing BTree keys and children for textbook searcher, Used to return a list of tokens in Tokenizer

   * Locations: line 40 and 41 in BTree.java, line 157 Tokenizer.java

   * Reasons:

     * Provides faster access to elements in the middle of list compared to linkedlist (O(1))

     * Provides methods not available to arrays (contains, indexOf, remove)

     * Size is not fixed. Can keep adding elements

2. ...

3. ...

*[What data structures did your team utilise? Where and why?]*

**Design Patterns**

*[What design patterns did your team utilise? Where and why?]*

**Grammar**

Production Rules:

* Abbreviations:
* - exp = expression
* - id = identifier
* - op = operation/operator
* - int = integer
    
-      <exp> ::= <term>, <exp> | <term>
-      <term> ::= <id> | <op_keyword> | <id_keyword> 
-      <id>	::= (any string non keyword or symbol string)
-      <op_keyword> ::= PAGES <op> <int> | COST <op> <int> | EDITION <op> <int>
-      <op> ::= < | > | =
-      <int> ::= (any positive or 0 integer less than 9999)
-      <id_keyword> ::= TOPIC: <id> | CODE: <id> | ISBN: <isbn>
-      <isbn> ::= (a string that conforms to isbn format, see isbn section below) 

[ISBN]

10 or 13 digit number that can include dashes (like in real isbn).
Only the number string is stored (including leading zeroes)

[CFG Design]

* Non-ambiguous grammar.
* All strings are accepted as a valid grammar due to being apart of a searcher
* A comma is used to separate terms from each other. Comma is an inuitive separator and not common in titles. Titles that have a comma do not start with one allowing for search to occur even if it does.


**Tokenizer and Parser Classes**


The tokenizer class is used to convert a search string into the parts that define the Context Free Grammar and is used by the parser class. The tokenizer developed accepts all strings and does not throw an error due to its use in a searcher. It ignores whitespace between important characters, keywords and terms as they are unimportant to the grammar and could cause errors in the parser. 

The tokenizer can store positive integers (including 0) below 10000 and stores other integers as a string, it stores operators as Characters and it stores important keywords and all other terms as strings. It is noted that this implementation could be improved by using enumerators to help the parser in its decison making by instead checking the type of the tokne rather than if a token is a keyword. 

The tokenizer instantly converts a string into tokens which is a design choice to split the process of searching for a textbook into individual parts. This simplifies the testing of the parser as it is no longer repeatedly calling the tokenizer class when dealing with tokens allowing for easier identification of an error between the tokenizer and parser. Tokens are stored as an Arraylist due to the inbuilt methods in the List interface allowing for quick access and removal of tokens compare to arrays.


The parser class is used to derive information from a string and check if it follows the defined grammar. It is used by the TextbookSearcher class in order to obtain information regarding which textbooks to find. When parsing a string, it is given to the tokenizer which returns an ArrayList of tokens. The parser then traverses through the list checking if each token follows the grammar. Information regarding what the user wants to search is located in a term which is separated from other terms by a comma (see [Production Rules]). 
If a term is valid, information contained in the term is stored in the instance variables which can be accessed by the TextbookSearcher class. If an individual term is invalid, the error is stored in another variable and the term is discarded. This implementation allows for the user's search string to contain syntax errors. In addition, information with regards to filtering is stored separately from the search terms (see [Implemented Features](#implemented-features)).


**Surprise Item**

*[If you implement the surprise item, explain how your solution addresses the surprise task. What decisions do your team make in addressing the problem?]*

**Other**

*[What other design decisions have you made which you feel are relevant? Feel free to separate these into their own subheadings.]*

## Summary of Known Errors and Bugs


1. Search Function Method Bug


Severity/Priority: Medium (Affects major feature. Minor work around required)

Location: [BTree] Class > insert() method: Causes Null Pointer Exception when inserting large number of Textbooks. 

Description: 

[BTreeTest] Class has a test that produces the error. It is believed that the error occurs due to a pointer error where the parent is not correctly assigned and occurs during the split() method. This is because the BTree works as intended if its height is atmost 3 and fails when attempting to split to a height of 4. 

Work around solution:

Instantiate BTree with a larger maxKeys value to avoid. This solution works due to the lower number of textbooks used. In addition a BTree generally does not have a large height but it will be an issue if the app is upscaled to contain much more textbooks. 

-


2. *Bug 2:*
3. ...

*List all the known errors and bugs here. If we find bugs/errors that your team does not know of, it shows that your testing is not thorough.*

## Testing Summary

**Tests for Classes Related to Search Function**

Test classes for BTree, Tokenizer and Parser classes were created to increase confidence in the reliability of the search function. It is noted that a test class for TextbookSearcher is not included but should be if further work beyond the project is done. For the test classes that exist a "high" code coverage in the 90%+ is reached but this is an unreliable value to use when considering what is actually tested. Actual confidence 

**[BTreeTest] testing methods in [BTree]**
 
3 Test Cases:
- Tests textbooks stored in keys of root
- Tests textbooks stored in keys of a nonroot
- Tests inserting lots of textbooks into a BTree
- Tests find() method for getting textbooks

Code coverage: 96% of BTree (88% method coverage)

The focus of the tests is on the values of a BTree's keys as it is where Textbooks will be stored. While the code coverage is large, the actual testing does not check for many methods defined in BTree. The testing approach can be improved as a result but was not completed due to time limitations.


**[ParserTest] testing methods in [Parser]**

8 Test Cases:
- Tests Strings stored in searchTerms
- Tests Strings stored in topichTerms
- Tests Strings stored in codeTerms
- Tests Strings stored in errorTerms
- Tests String stored in ISBN
- Tests Integers stored in pageOperation
- Tests Integers stored in costOperation
- Tests Integers stored in editionOperation

Code Coverage: 90.7% of Parser (100% method coverage)

Unit tests focused on the instance variables of parser. Since a parser uses a grammar to parse a string which involves looping, each method of the parseX methods are linked and thus makes unit testing on a single method redundant due to simplicity or impossible. The tests thus focus on the result of a parse string which is stored in the instance variables. It is noted that an integration test, testing all results, is not included .

**[TokenizerTest] testing methods in [Tokenizer]**

5 Test Cases
- Test for consumeWhiteSpace()
- Test for consumeEndSpace()
- Test for nextIsInteger()
- 2 tests for tokenizeString()

Code Coverage: 98.7% of Tokenizer (100% method coverage)

The test class tests every method in the Tokenizer class. It is noted that each test case could be separated to be a unit test, and as a result be improved, but was not done due to time limitations. Each test attempts to cover every statement condition as it is impossible to cover every case. The tokenizerString() method contains two tests but could be extended as it integrates the other methods. However a randomized test string from a random online string generator was obtained for a complex test. Overall there is decent confidence that the tokenizer works as intended.




*Here is an example:*

- *Number of test cases: ...*

- *Code coverage: ...*

- *Types of tests created: ...*

*Please provide some screenshots of your testing summary, showing the achieved testing coverage. Feel free to provide further details on your tests.*

## Implemented Features

*[What features have you implemented?]*

*Here are some examples:*

Feature Category: Privacy <br>
*Implemented features:*
1. Feature 1: **Users may ... . (easy)**
   * Class X, methods Z, Y, Lines of code: 10-100
   * Class Y, methods K, L, M, Lines of code: 35-150
   * Your description: ...
<br>
2. Feature 2: **A user can only ... . (medium)**
<br>

Feature Category: Firebase Integration <br>
*Implemented features:* <br>
1. **Use Firebase to implement user Authentication/Authorisation. (easy)**
   * Class A: methods A, B, C, lines of code: whole file
   * …

*List all features you have completed in their separate categories with their difficulty classification. If they are features that are suggested and approved, please state this somewhere as well.*

## Team Meetings

Meetings have occured every Saturday at around 3pm with additional meetings as required:

- 04/09/22: [Team Meeting 1](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/items/meeting%20minutes%20-%20team/meeting1.md)  
- 10/09/22: [Team Meeting 2](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/items/meeting%20minutes%20-%20team/meeting2.md)
- 17/09/22: [Team Meeting 3](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/items/meeting%20minutes%20-%20team/meeting3.md)

- 24/09/22: [Team Meeting 4](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/items/meeting%20minutes%20-%20team/meeting4.md)

- 01/10/22: [Team Meeting 5](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/items/meeting%20minutes%20-%20team/meeting5.md)
- 08/10/22: [Team Meeting 6](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/items/meeting%20minutes%20-%20team/meeting6.md)

- 15/10/22: [Team Meeting 7](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/items/meeting%20minutes%20-%20team/meeting7.md)

 
