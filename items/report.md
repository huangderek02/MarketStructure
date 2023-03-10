# Gorderhuifamda Report

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
| [u7300484] | [Derek Huang] | [Worked on the Observer Design Pattern Package, Worked on the Seller Class, Some methods in DisplayListingDetailsActivity and MarketActivity] |
| [u7366836] | [Huiguang Zhang] | [Worked on chat functions and other methods to connect with firebase] |
| [u7127350] | [Rhonda Luu] | [Worked on creating data files, designing UI to visualise data loaded from Firebase, State Design pattern and Checkout process]
| [u7444134] | [Ratchanont Treevijitpaisan] | [Worked on User activity like LoginActivity, ProfileActivity and RegisterActivity] |

## Summary of Individual Contributions

U7117043, Gordon Lum, Contribution: 20%
* [[BTree](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/java/tokenizer_and_parser/BTree.java)] (Entire Class)
* [[Parser](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/java/tokenizer_and_parser/Parser.java)] (Entire Class)
* [[Tokenizer](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/java/tokenizer_and_parser/Tokenizer.java)](Entire Class)
* [[TextbookSearcher](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/java/tokenizer_and_parser/TextbookSearcher.java)] (Entire Class)
* All test classes in [tokenizer_and_parser](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/tree/main/app/src/test/java/tokenizer_and_parser)
* [[MarketActivity](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/java/com/example/marketstructure/MarketActivity.java)] methods: updateTextbooks(), sortRecycle(), updateRecycle(), sortResults(), [lines 261 onwards](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/java/com/example/marketstructure/MarketActivity.java#L261)
* Filled out parts of the report: Application Description, Data Structure: ArrayList and BTree, UML for [[Application Flow (UI_UML_total), Search_Function_UML and there related images](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/tree/main/items/images)], Data Structures for ArrayList and BTree, Grammar Section, Tokenizer and Parser Section, Bugs for BTree, Testing related to Search function. Helped with presentation creation
<br>
* Helped with presentation creation

U7300484, Derek Huang, Contribution: 20%
* [[ObserverDesignPattern](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/tree/main/app/src/main/java/com/example/marketstructure/ObserverDesignPattern)](Entire Package)
* [[Sellers](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/java/com/example/marketstructure/Sellers.java)] (Created class)
* [[DisplayListingDetailsActivity](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/java/com/example/marketstructure/DisplayListingDetailsActivity.java)](Lines 53 - 72, 79-100)
* [[MarketActivity](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/java/com/example/marketstructure/MarketActivity.java)] (Lines 75-97, Lines 101-108)
* Helped with presentation creation
* <br>

U7366836, Huiguang Zhang, Contribution: 20%
* [[DisplayListingDetailsActivity](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/java/com/example/marketstructure/DisplayListingDetailsActivity.java)] (Lines 0 - 72)
[Msg(https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/java/com/example/marketstructure/Messaging/Msg.java)] (Entire Class)
* [[MsgAdapter](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/java/com/example/marketstructure/Messaging/MsgAdapter.java)] (Entire Class)
* [[ReportSellersActivity](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/java/com/example/marketstructure/ReportSellersActivity.java)] (Entire Class)
* [[ChatActivity](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/java/com/example/marketstructure/ChatActivity.java)] (Entire Class)
* [[MarketActivity](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/java/com/example/marketstructure/MarketActivity.java)] (read data from database and sent the data to recycleViewer to show the list)
* [[RecyclerViewAdapter](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/java/com/example/marketstructure/RecyclerViewAdapter.java)] (read data from recycleViewer and sent the data to DisplayListingDetailsActivity to show the details)]
* Helped with presentation creation
* <br>

U7444134, Ratchanont Treevijitpaisan, Contribution: 20%
* [[LoginActivity]([[UI design and Firebase Authentication](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/java/com/example/marketstructure/LoginActivity.java)] (Entire Class)
* [[RegisterActivity]([[UI design and Firebase Integration](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/java/com/example/marketstructure/RegisterActivity.java)] (Entire Class)
* [[MainActivity]([[UI design and Firebase Integration](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/java/com/example/marketstructure/MainActivity.java)] (Entire Class)
* [[ProfileActivity]([[UI design and Firebase Integration](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/java/com/example/marketstructure/ProfileActivity.java)] (Entire Class)
* [[UI testing]([[UI testing (basic)](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/tree/main/app/src/androidTest/java/Espresso)] (All classes in Package)
* Helped with presentation creation
<br>

U7127350 , Rhonda Luu, Contribution: 20% <br>
**Part 1: Basic App - Task 2 - Created data file with at least 2,500 valid data instances**<br>
* [[GenerateData](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/tree/main/app/src/main/java/com/example/marketstructure/GenerateData)] (All classes in Package)
* [[Textbook](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/java/com/example/marketstructure/Textbook.java)] (Designed Class with Huiguang and Derek and created Class)
* [[Listing](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/java/com/example/marketstructure/Listing.java)] (Entire Class)
* [[MarketActivity](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/java/com/example/marketstructure/MarketActivity.java#L110-130)] method: [[addListings()](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/java/com/example/marketstructure/MarketActivity.java#L110-130)]
* [[listings collection in Firebase repository](https://console.firebase.google.com/project/marketplace-db-6139c/firestore/data/~2Flistings~2F0)] (Created from [[addListings() method](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/java/com/example/marketstructure/MarketActivity.java#L110-130)] in [[onCreate() method](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/java/com/example/marketstructure/MarketActivity.java#L58)])

**Part 1: Basic App - Task 3 - load data/information (from the data file(s) or Firebase) and visualise it**<br>
**UI Design:**
* [[RecyclerViewAdapter](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/java/com/example/marketstructure/RecyclerViewAdapter.java)] (Created Class and involved in process of attempting to load data into card layout UI to visualise - Huiguang resolved)
* [[MarketActivity](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/java/com/example/marketstructure/MarketActivity.java#L110-130)] methods: [[onCreate()](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/java/com/example/marketstructure/MarketActivity.java#L61-63)] (Created ProgressDialog)
* [[DisplayListingDetailsActivity](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/java/com/example/marketstructure/DisplayListingDetailsActivity.java)] (Created class, contributed to onCreate() method by: 
   - [[retrieving views from UI screen](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/java/com/example/marketstructure/DisplayListingDetailsActivity.java#L29-51)]
   - implementing [[displaying Textbook image on UI screen](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/java/com/example/marketstructure/DisplayListingDetailsActivity.java#L54-56)]
   - [[onClickListener() for Buy Now Button](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/java/com/example/marketstructure/DisplayListingDetailsActivity.java#L102-112)]
* [[card_layout.xml](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/res/layout/card_layout.xml)] (Entire card layout UI)
* [[activity_textbook_detail_viewer.xml](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/res/layout/activity_textbook_detail_viewer.xml)] (Rearranged UI elements created by Huiguang and added in additional TextViews to display each of the fields)
 <br>

**Part 1: Basic App - Design Patterns**<br>
**Code Design:**
* [[State Design Pattern](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/tree/main/app/src/main/java/com/example/marketstructure/StateDesignPattern)] (All classes in Package)
* [[ObserverDesignPattern](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/tree/main/app/src/main/java/com/example/marketstructure/ObserverDesignPattern)] (Contributed to design process and idea to implement for surprise feature for fraudulent sellers and listings)
* [[RecyclerViewAdapter](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/java/com/example/marketstructure/RecyclerViewAdapter.java)] method: [[onBindViewHolder()](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/java/com/example/marketstructure/RecyclerViewAdapter.java#L83-86)] (created instance of OrderStatus to use for State Design Pattern)
<br>

**Part 2: Additional/General features of the App - Creating Processes - Payment Process (listed as number 6 on the assignment sheet)**<br>
**Code Design:**
* [[Checkout Feature (Combines Payment Process with Delivery and Order Confirmation)](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/tree/main/app/src/main/java/com/example/marketstructure/Checkout)] (All classes in Package)

**UI Design:**
- [[activity_checkout_1_delivery_options_menu.xml](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/res/layout/activity_checkout_1_delivery_options_menu.xml)] (Entire UI activity screen)
- [[activity_checkout_2_delivery_details.xml](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/res/layout/activity_checkout_2_delivery_details.xml)] (Entire UI activity screen)
- [[activity_checkout_3_payment_method_menu.xml](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/res/layout/activity_checkout_3_payment_method_menu.xml)] (Entire UI activity screen)
- [[activity_checkout_4_payment_card.xml](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/res/layout/activity_checkout_4_payment_card.xml)] (Entire UI activity screen)
- [[activity_checkout_5_confirm_order.xml](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/res/layout/activity_checkout_5_confirm_order.xml)] (Entire UI activity screen)

**Surprise Feature: Identify fraudulent behaviours/scams**<br>
**UI Design:**
- [[activity_textbook_detail_viewer.xml](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/res/layout/activity_textbook_detail_viewer.xml#L428-481)] (Created a fraudulent warning textView (Lines 206-231) and a report listing button (Lines 470-481))
- [[activity_checkout_4_payment_card.xml](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/res/layout/activity_checkout_4_payment_card.xml#L206-231)] (Created warning sign imageView and fraudulent warning textView)
- [[ListingTextbookData](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/java/com/example/marketstructure/GenerateData/ListingTextbookData.java#L167-168)] (Added "Fraud Listing/Seller Identified" listingStatus)
- Contributed to UI design implementation of adding a report listing button to use with Observer Design Pattern

**Report Writing**<br> 
* Application Design and Decisions: State and Observer Design Patterns
* Surprise Item
* Testing Summary: UI Testing ??? Application Flow, Payment Process and Generate Random Listings
* Helped with presentation creation

**Miscellaneous contributions**<br>
- Final code clean-up to remove redundant code and add missing @author annotations to classes
- Final clean-up of report and powerpoint slides
- Helped with presentation creation
<br>


## Conflict Resolution Protocol

[Sickness or inability to work]

* If a team member is unwell, whoever has completed their delegated task first will help complete the unwell team member's part.
The unwell team member will help the other team member with their other assigned tasks. Key requirements of the assignment will be prioritised.

[Decision making]

* When the group member has issues or needs to make a decision that is open ended, we will reach consensus and solve the issue by majority vote.
The group member who requires a decision to be made should contact the other members in the group chat or next meeting.

[Not meeting expected deadlines]

* If a team member is having difficulties completing a task, they will flag the issue with other team members via the group chat and  we will work through the issue together. If a solution is not reached, further research and help from tutors will be conducted. Any findings or possible solutions reported in group chat or next meeting.

[Other responsibilities]

1. Everyone must use good code documentation to ensure that others can read through the code easily and troubleshoot the issue/help complete the task.
2. Time estimates will be set to complete tasks.
3. Updates on our progress on tasks and any issues will be communicated in the group chat and in team meetings, we might use trello (Rhonda will look into this)
5. Ensure that diagrams are clear, large and easier for marker/team members to read


## Application Description

Textbook Warehouse is a marketplace application that is specifically made for university students. It provies a quick and easy way to obtain cheaper, secondhand textbooks and avoid having to purchase new ones. Clients can create an account using an email and password to be able to access these services, search for textbooks and view available listings with different prices and sellers. 


**Application Use Cases and Examples**

Target Users: Students studying at university

* User can create an account using an email and password
* User can login to the application using an existing email and password
* User can delete their account or change their login details
* User can search for textbooks by title or by ISBN
* User can filter textbooks found by cost, pages, edition, topic, class code
* User can sort textbooks found in ascending or descending order: alphabetically, price, topic, pages
* User can view listings available, there prices and sellers if they exist
* User can purchase an existing textbook
* User can send messages to other users
* User can leave a review on a seller 
* User gets warned about potential fraud and scams 


Bob is studying for a building degree and is currently enrolled in BUIL1011, BUIL1100 and ENGN1211. He wants to purchase the textbooks for further study but like most university, is poor and doesnt want to be eating 2 minute noodles for the entire semester. 
* Bob needs to buy 3 textbooks
* He creates an account with an email and password on [app name]
* He logs in to his account which takes him to the marketplace
* He searches for his textbook using the search function and filters: "Can I Fix It?, Yes you can!, Engineering for Beginners"
* The application loads the textbooks and he clicks on a second hand one that is in a used condition.
* The application moves to a page where Bob can buy the textbook
* Bob buys the book and it moves back to the marketplace page
* Bob repeats this for the other two books




-----------------------------------------------------------------------------------

## Application UML
Click to zoom in.

![Application Diagram](./images/UI_UML_total.png) <br>

MarketActivity Dependency:

![Search Function](./images/Search_Function_UML.png) <br>
## Application Design and Decisions

**Data Structures**

1. ArrayList

 * Objective: It is used for storing BTree keys and children for textbook searcher, Used to return a list of tokens in Tokenizer, Used to store list of symbols, keywords, digits in Tokenizer 

 * Locations: line 40 and 41 in BTree.java, line 41, 43, 45, 157 Tokenizer.java

 * Reasons:

     * Provides faster access to elements in the middle of list compared to linkedlist (O(1))

     * Provides methods not available to arrays or enumerables (contains, indexOf, remove)

     * Size is not fixed. Can keep adding elements



2. B-Tree

 * Objective: It is used to store textbooks/listings in a way that allows for fast searching. 
 
 * Location: [BTree Class](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/java/tokenizer_and_parser/BTree.java)
 
 * Reasons:
 	
 	* Provides a faster way to search for elements than in a list
 	
 	* Provides a way to store much more objects in a single node and completely balanced compared to BST, Red black tree and other tree variants
 	

**Design Patterns**

* State
  - The [State design pattern](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/tree/main/app/src/main/java/com/example/marketstructure/StateDesignPattern) to handle the events for the chain of actions/steps involved in the ordering process from searching for a textbook, selecting a textbook to buy to payment, delivery and confirmation of the order.
  - It was used in the following classes:
    - [MarketActivity](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/java/com/example/marketstructure/RecyclerViewAdapter.java#L83-86)
    - [DisplayListingDetailsActivity](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/java/com/example/marketstructure/DisplayListingDetailsActivity.java#L109-110)
    - [PaymentMethodMenu](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/java/com/example/marketstructure/Checkout/PaymentMethodMenu.java#L51-77) (Lines 51-52, 67-68 and 76-77)
    - [PaymentCardActivity](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/java/com/example/marketstructure/Checkout/PaymentCardActivity.java#L87-99) (Lines 87-88 and 98-99)
    - [DeliveryOptionsMenuActivity](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/java/com/example/marketstructure/Checkout/DeliveryOptionsMenuActivity.java#L49-75) (Lines 49-50, 63-64 and 74-75)
    - [DeliveryDetailsActivity](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/java/com/example/marketstructure/Checkout/DeliveryDetailsActivity.java#L96-97)
    - [ConfirmOrderActivity](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/java/com/example/marketstructure/Checkout/ConfirmOrderActivity.java#L80-81)

* Singleton 
  - The singleton design patter is used in the [Parser Class](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/java/tokenizer_and_parser/Parser.java) to ensure that only a single instance of a Parser exists. A parser instance contains many variables and thus to save memory, a singleton ensures that at most only one instance exists.
  <br>
  
* Observer
- The Observer Design Pattern was attempted to be implemented as we believe that all users should be notified when a fraudulent listing was made. The user can subscribe to the subject so they can stay alert about potential scams on the marketplace.
- However, it was not successfully linked to the following UI elements:
     - A warning sign imageView and fraudulent warning textView in [activity_textbook_detail_viewer.xml](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/res/layout/activity_textbook_detail_viewer.xml#L428-443) and [activity_checkout_4_payment_card.xml](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/res/layout/activity_checkout_4_payment_card.xml#L206-231). 
     - A fraudulent warning textView (Lines 206-231) and a report listing button (Lines 470-481) in [activity_checkout_4_payment_card.xml](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/res/layout/activity_checkout_4_payment_card.xml#L206-481).
     

**Grammar**

Production Rules:

![See CFG.PNG](./images/CFG.PNG) <br>

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
The surprise item was a feature that notifies the user of whether a fraudulent seller or item has been identified. 
It was partially implemented through the creation of UI elements, unfortunately, the code to connect the UI elements and simulate the process was not implemented. These UI elements include a fraudulent warning textView (Lines 206-231) and a report listing button (Lines 470-481) in [activity_checkout_4_payment_card.xml](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/res/layout/activity_checkout_4_payment_card.xml#L206-481) (please note it is currently set invisible) where the user is warned that the user when clicking on a listing of a fraudulent seller.
The report listing button was created with the intention to enable the user to notify us that the listing and associated seller is fraudulent where we would in turn update the [listing status](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/java/com/example/marketstructure/GenerateData/ListingTextbookData.java#L167-168) to "Fraud Listing/Seller Identified." The user is also able to record details of the fraudulent activity for us to look into as it navigates to another screen when the button is pressed.
A warning sign imageView and fraudulent warning textView was also created in [activity_textbook_detail_viewer.xml](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/res/layout/activity_textbook_detail_viewer.xml#L428-443) and [activity_checkout_4_payment_card.xml](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/res/layout/activity_checkout_4_payment_card.xml#L206-231) to warn the user once more before entering their card payment details.
Additionally, the user can click on a button to flag the seller inside the seller's profile. This will update the seller's status and a message pops up saying that the administrators will look into the seller.


## Summary of Known Errors and Bugs


1. Search Function Method Bug


Severity/Priority: Medium (Affects major feature. Minor work around required)

Location: [BTree] Class > insert() method: Causes Null Pointer Exception when inserting large number of Textbooks. 

Description: 

[BTreeTest] Class has a test that produces the error. It is believed that the error occurs due to a pointer error where the parent is not correctly assigned and occurs during the split() method. This is because the BTree works as intended if its height is atmost 3 and fails when attempting to split to a height of 4. 

Work around solution:

Instantiate BTree with a larger maxKeys value to avoid. This solution works due to the lower number of textbooks used. In addition a BTree generally does not have a large height but it will be an issue if the app is upscaled to contain much more textbooks. 



2. *Observer Design Pattern not linked to UI*
Severity/Priority: High (Affects major feature. Minor work around required)

    The plan was to use the Observer Design Pattern to notify users of a fraudulent listing. When the seller makes a fraudulent listing, there is supposed to be an entity acting as a shadow of the seller, who notifies the users when the seller does so. That entity has the same attributes as the seller. However, due to time constraints, it could not be implemented. This was an important part of the suprize feature and this was the third and final design pattern we planned to implement.


Work around solution:
Give the seller the same attributes as what was implemented in the Observer Design Pattern, and learn how to implemented an Observer Design Pattern together with the UI.

3. Firebase Integration issues

Severity/Priority: Medium (Affects major feature. Minor work around required)

Location: https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/tree/main/app/src/main/java/com/example/marketstructure

Description: 
When we create a new account, normally it will linked the account with firebase authentication services and cloudfirestore which editing user details might get some errors. For instance, User update profile, normally user will get update realtime at cloudfirestore. Unfortunately, Firebase authentication services need more implementation to update the user authentication realtime.

Work around solution:
Try to understand the firebase re authentication method to fix these issue


## Testing Summary

**Tests for Classes Related to Search Function**

Test classes for BTree, Tokenizer and Parser classes were created to increase confidence in the reliability of the search function. It is noted that a test class for TextbookSearcher is not included but should be if further work beyond the project is done. However methods were 'tested' in a main method during creation to ensure some indication of correct funtionality. For the test classes that exist a "high" code coverage in the 90%+ is reached but this is an unreliable value to use when considering what is actually tested. Reliability on each class is commented on in descriptions provided. 

![Search Function Coverage](./images/SearchCoverage.PNG) <br>

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


**UI Testing**<br>
**Application Flow**
The application flow of the app was tested by stepping through the different instances and checking if the next activity screen is navigated to as intended.

**Payment Process - Total Order Cost Method**
The [calculateTotalCost()](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/java/com/example/marketstructure/Checkout/ConfirmOrderActivity.java#L86-107) method was testing by stepping through the order process. In the example below, it can be seen that the total cost of the order has been calculated to include the listingPrice and the additional cost of $15 for Express delivery and a 1.5% surcharge of the total cost of the listingPrice and delivery cost combined.<br>
![UI Testing: Payment Process - Total Order Cost Method](./images/PaymentProcess-TotalOrderCostMethodExample.png)<br>

**State Design Pattern Testing**<br>
UI testing by navigating through events in the app and looking at the log output was used to test whether the State design pattern was working as intended. The example below shows the [log](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/java/com/example/marketstructure/DisplayListingDetailsActivity.java#L110) (outlined in orange box) printed when the "Buy Now" button is pressed on the [Detailed viewer of a Listing when a listing is clicked on the recycleViewer](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/res/layout/activity_textbook_detail_viewer.xml) UI screen. When the "Buy Now" button is pressed, the state of OrderStatus changes from WaitingToSelectListingToBuy to WaitingToSelectDeliveryOption as the user is navigated to the [Delivery Options Menu](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/res/layout/activity_checkout_1_delivery_options_menu.xml) .
![Example of State Design Pattern Testing](./images/StateDesignPatternTestingExample.png)<br>
<br>

**Generating Random Listings Firestore Data Testing**<br>
When creating the data instances, various methods used to help generate random data for each of the attributes to a listing in the [addListings() method in MarketActivity](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/java/com/example/marketstructure/MarketActivity.java#L110-130).
These methods were created in [GenerateRandomListings.java](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/java/com/example/marketstructure/GenerateData/GenerateRandomListings.java) and the accuracy of these methods were tested by visually comparing the listing generated in the [Firestore repository](https://console.firebase.google.com/project/marketplace-db-6139c/firestore/data/~2Flistings~2F0).
All listings generated were unique and the random additionalDetails generated matched the condition (outlined in red box) and the listingPrice was adjusted from the originalPrice correctly according to the condition and additional details (outlined in blue box)
![Example of randomly generated listing](./images/GeneratingRandomListingsFirestoreDataListingExample.png)<br>

**Espresso Testing**<br>
The Login and Register UI Login and Register activities were tested with Espresso.

[Login Test](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/androidTest/java/Espresso/LoginTest.java)
| Test Method | Code Test | Result |
| :--- | :----: | ---: |
| emailIsEmpty() | TextUtils.isEmpty(email) | pass |
| passIsEmpty() | TextUtils.isEmpty(password) | pass |
| passIsShort() | password.length() < 6 | pass |
| loginSuccessfully() | loginSuccessfully() | failed |

[Register Test](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/androidTest/java/Espresso/RegisterTest.java)
| Test Method | Code Test | Result |
| :--- | :----: | ---: |
| emailIsEmpty() | TextUtils.isEmpty(email) | pass |
| nameIsEmpty() | TextUtils.isEmpty(name) | pass |
| passIsEmpty() | TextUtils.isEmpty(password) | pass |
| cPassIsEmpty() | TextUtils.isEmpty(cPassword) | pass |
| passNotMatch() | !cPassword.matches(cPassword) | pass |
| passIsShort() | password.length() < 6 | pass |


## Implemented Features

**Part 1: Basic App** <br>
1. Feature 1: Users must be able to log in (not necessarily sign up). (easy)
   * Class: [MainActivity](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/java/com/example/marketstructure/MainActivity.java)
   * Class: [LoginActivity](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/java/com/example/marketstructure/LoginActivity.java)
   * Description: Opening screen contains option for user to sign in and then users can login using the two accounts for markers to access app.

2. Feature 2: Data file(s) with at least 2,500 valid data instances (easy) (listed as number 2 on assignment sheet)
    * Package: [GenerateData](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/tree/main/app/src/main/java/com/example/marketstructure/GenerateData) (includes class for string storage data used to create listings and generating random data methods to use for listings)
    * Class: [Textbook](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/java/com/example/marketstructure/Textbook.java)
    * Class: [Listing](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/java/com/example/marketstructure/Listing.java)
    * Class: [MarketActivity](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/java/com/example/marketstructure/MarketActivity.java#L110-130) method: [addListings()](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/java/com/example/marketstructure/MarketActivity.java#L110-130) (where the data instances are generated)
    * Firebase: [listings collection in Firebase repository](https://console.firebase.google.com/project/marketplace-db-6139c/firestore/data/~2Flistings~2F0) (Created from [addListings() method](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/java/com/example/marketstructure/MarketActivity.java#L110-130) in [onCreate() method](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/java/com/example/marketstructure/MarketActivity.java#L58)
    * Description: 2,500 valid data instances are randomly generated in [MarketActivity](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/java/com/example/marketstructure/MarketActivity.java#L110-130) using pre-defined data in [ListingTextbookData.java](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/java/com/example/marketstructure/GenerateData/ListingTextbookData.java). Random listings were generated using methods in [GenerateRandomListings.java](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/java/com/example/marketstructure/GenerateData/GenerateRandomListings.java)
    * Note: Unfortunately, the data stream was unable to be simulated

3. Feature 3: Users must be able to load data/information (from the data file(s) or Firebase) and visualise it (e.g., a list of products or the last shopping activities of a user). (medium)
    * Class: [DisplayListingDetailsActivity](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/java/com/example/marketstructure/DisplayListingDetailsActivity.java)
    * Class: [MarketActivity](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/java/com/example/marketstructure/MarketActivity.java)
    * Class: [RecyclerViewAdapter](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/java/com/example/marketstructure/RecyclerViewAdapter.java)
    * UI Design: [activity_market.xml](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/res/layout/activity_market.xml)
    * UI Design: [activity_textbook_detail_viewer.xml](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/res/layout/activity_textbook_detail_viewer.xml)
    * Description: Listings data is able to be loaded into a RecycleView to display a list of textbooks for sale and when a listing is clicked, a detailed view of the listing with more information is displayed. 

4. Feature 4: Users must be able to search for information on your app. (medium)
   * Class: [BTree](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/java/tokenizer_and_parser/BTree.java)
   * Class: [Parser](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/java/tokenizer_and_parser/Parser.java)
   * Class: [Tokenizer](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/java/tokenizer_and_parser/Tokenizer.java)
   * Class: [TextbookSearcher](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/java/tokenizer_and_parser/TextbookSearcher.java)
   * Class: All test classes in [tokenizer_and_parser](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/tree/main/app/src/test/java/tokenizer_and_parser)
   * Class: [MarketActivity](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/java/com/example/marketstructure/MarketActivity.java) methods: updateTextbooks(), sortRecycle(), updateRecycle(), sortResults(), [lines 261 onwards](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/java/com/example/marketstructure/MarketActivity.java#L261)
   * Description: The search function accepts any string as input an attempts to return textbooks with a related title or ISBN. Users can filter and sort their search using special keywords with more information in the grammar section. The list of textbooks is updated when the user clicks the search button. In addition they can sort their list in different ways using the sort button.
   * Note: Unfortunately, was not able to fully implement correctly.

**Part 2: Additional/General features of the App** <br>
Feature Category: Voice Your Feature <br>
1. Feature 1: User registration including changing details (easy) (Approved suggested feature)
   * Class: [RegisterActivity](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/java/com/example/marketstructure/RegisterActivity.java), (The class is used to register a new user, all methods) Lines of code: 28-159
   * Class: [ProfileActivity](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/java/com/example/marketstructure/ProfileActivity.java), methods updateProfile(), openEditEmailDialog(), updateEmail(), openEditNameDialog(), openChangePassword() Lines of code: 75-358
   * Description: Users may create an account using an email and password. Password needs to be atleast 6 characters long and user needs to confirm the password. The account can be used to login to the application. A progress bar shows how far the user is from creating a new account. Users can change their password and email or delete their account in their profile page.
<br>

Feature Category: Peer to Peer Messaging <br>
2. Feature 2: Provide users with the ability to message each other directly (hard) (listed as 1 under the category on the assignment sheet)
   * Class: [ChatActivity](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/java/com/example/marketstructure/ChatActivity.java), (The class is to all user to char) (entire class)
   * Class: [Msg](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/java/com/example/marketstructure/Messaging/Msg.java), (Define the message objects)
   * Class: [MsgAdapter](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/java/com/example/marketstructure/Messaging/MsgAdapter.java), (put msg into the viewer)
   * Description: Users may chat with the sellers, to know more details about the book, and decides whether should buy it.
<br>

Feature Category: Firebase Integration <br>
3. Feature 3: Use Firebase to implement user Authentication/Authorisation (easy) (listed as 1 under the category on the assignment sheet)
   * Class [RegisterActivity](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/java/com/example/marketstructure/RegisterActivity.java) Method: createUser, lines: 123 - 60
   * Class [ProfileActivity](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/java/com/example/marketstructure/ProfileActivity.java), methods updateProfile(), openEditEmailDialog(), updateEmail(), openEditNameDialog(), openChangePassword() Lines of code: 75-358
   * Description: Users account are stored on Firebase. Creating an accounting or changing user profile details access Firebase and update these details.

Feature Category: User Interactivity <br>
4. Feature 4: The ability to micro-interact with items in your app (listed as 1 under the category on the assignment sheet)
    * Class: [Sellers](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/java/com/example/marketstructure/Sellers.java)
    * Description: The user can use the rating bar in the activity_seller to give the seller a rating. Although the rating bar have increments of 0.5 from 0 - 5, the rating is rounded down to the nearest whole number e.g. 0.5 goes down to 0. Each time the seller clicks on the rating bar, a Toast message is displayed based on the different cases for the different possible scores. In addition, the rating for each click is stored in an arrayList. The average rating is also recorded in a TextView and is updated every time a rating is added. This is stored in memory as every time the program restarts, the arrayList resets to empty.

Feature Category: Creating Processes <br>
5. Feature 5: Payment process (easy) (listed as number 6 under category on assignment sheet)
   * Package: [Checkout Feature (Combining Payment Process with Delivery and Order Confirmation)](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/tree/main/app/src/main/java/com/example/marketstructure/Checkout)
   * Payment Method Menu - UI Design: [activity_checkout_3_payment_method_menu.xml](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/res/layout/activity_checkout_3_payment_method_menu.xml)
   * Fill out Credit Card Details Form - UI Design: [activity_checkout_4_payment_card.xml](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/res/layout/activity_checkout_4_payment_card.xml)
   * Order Summary - UI Design: [activity_checkout_5_confirm_order.xml](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/res/layout/activity_checkout_5_confirm_order.xml) (Includes total cost of order which includes additional costs such as delivery and card surcharge (if selected))
   * Description: The user is able to choose between two payment methods: Cash or Credit Card. If the user decides to pay by card there is a 1.5% additional surcharge added to the total cost of the order. This feature has been extended to include delivery to add additional costs based on the delivery option selected to the total cost of the order displayed on the order summary confirmation UI screen.

Feature Category: UI Design and Testing <br>
6. Feature 6: UI tests using espresso or similar (hard) (listed as 2 under the category on the assignment sheet)
   * Package: [Espresso Tests](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/tree/main/app/src/androidTest/java/Espresso);
   * Description: Espresso has been used to test Login and Register.

Feature Category: Surprise <br>
6. Feature 7: Fraud Behaviours/Scams
    * Class: [listing status](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/java/com/example/marketstructure/GenerateData/ListingTextbookData.java#L167-168)
    * Class: [Sellers](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/java/com/example/marketstructure/Sellers.java#L87-104)
    * Class: [DisplayListingDetailsActivity](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/java/com/example/marketstructure/DisplayListingDetailsActivity.java#L74-77)
    * Class: [ReportSellersActivity](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/java/com/example/marketstructure/ReportSellersActivity.java)
    * Package: [ObserverDesignPattern](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/tree/main/app/src/main/java/com/example/marketstructure/ObserverDesignPattern)
    * UI Design: [activity_checkout_4_payment_card.xml](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/res/layout/activity_checkout_4_payment_card.xml#L206-481) (fraudulent warning textView (Lines 206-231) and a report listing button (Lines 470-481), please note it is currently set invisible)
    * UI Design: [activity_textbook_detail_viewer.xml](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/res/layout/activity_textbook_detail_viewer.xml#L428-443)
    * UI Design: [activity_report_sellers.xml](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/app/src/main/res/layout/activity_report_sellers.xml)
    * Description: UI elements include a fraudulent warning textView and a warning sign imageView to warn the user when clicking on a listing of a fraudulent seller and before entering their card payment details. The report listing button was created with the intention to enable the user to notify us that the listing and associated seller is fraudulent where we would in turn update the to "Fraud Listing/Seller Identified." The user is also able to record details of the fraudulent activity for us to look into as it navigates to another screen when the button is pressed. The user can click on a button to flag the seller inside the seller's profile. This will update the seller's status and a message pops up saying that the administrators will look into the seller.
    * Note: Unfortunately, this was only partially implemented.

## Team Meetings

Meetings have occurred every Saturday at around 3pm with additional meetings as required:

- 04/09/22: [Team Meeting 1](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/items/meeting%20minutes%20-%20team/meeting1.md)  
- 10/09/22: [Team Meeting 2](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/items/meeting%20minutes%20-%20team/meeting2.md)
- 17/09/22: [Team Meeting 3](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/items/meeting%20minutes%20-%20team/meeting3.md)

- 24/09/22: [Team Meeting 4](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/items/meeting%20minutes%20-%20team/meeting4.md)

- 01/10/22: [Team Meeting 5](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/items/meeting%20minutes%20-%20team/meeting5.md)
- 08/10/22: [Team Meeting 6](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/items/meeting%20minutes%20-%20team/meeting6.md)

- 15/10/22: [Team Meeting 7](https://gitlab.cecs.anu.edu.au/u7127350/ga-22s2-comp2100-6442/-/blob/main/items/meeting%20minutes%20-%20team/meeting7.md)

 
