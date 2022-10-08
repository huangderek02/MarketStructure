# Gorderhuifamda Team
This following is a very simple team meeting template. You should expand it based on the scope and nature of your discussion.

## Team Meeting 6 - Week 9 - Saturday, 8th October 2022 (3 pm - 4 pm)
**Absent:**
No members were absent.
<br>
**Lead/scribe:** Rhonda

## Agreed Procedure
Stand up Procedure:
- Meet at least once a week 
- Discuss agenda Items
- Task updates on progress and any issues encountered
- Discuss next meeting date and time
- Any questions/concerns?
- Recap of what needs to be done before next meeting

## Agenda Items
| Number | Item |
| :--- | ---: |
| 1 | Individual updates on progress |
| 2 | Determine additional/general features and delegate |
| 3 | Update Project Timeline |
| 4 | Discuss work to complete for Week 10 checkpoint including report |

## Meeting Minutes
**Agenda Item 1: Individual updates on progress**
<br>
**Fame:**
- Has created package for Tree and working on RedBlack Tree implementation
- Will look into creating a BST as a backup
- Continue to work on Login Screen and hopefully finish by next Wednesday
- Look into Design Patterns

**Rhonda:**
- Almost finished creating data instances to load into Firestore, just adding more textbooks and images - hopefully completed by tonight
- Created methods to randomly select sellerUsernames, textbooks, price, condition, additonal details, etc... for a specific listing
- Have split the Textbook and Listing classes
- Plan to load data from Firestore by tomorrow using Derek and Huiguang's buit UI screens
- Create new package for Generate Data suggested by Fame

**Huiguang:**
- Completed UI Screen for textbookDetailViewerActivity
- Working on chat feature, has been able to display chat messages on UI screens
- Research into Firestore implementation
- Unsure how to implement for other user to reply, team suggests to login in to another user acount to implement messaging

**Gordon:**
- Has completed Tokeniser and Parser - just need to edit a few comments and grammar.
- Has pushed as a separate package for now
- Currently working on BTree
- Notes for Rhonda: Suggestion to not make attributes for Textbook private as static, getter and setter functions are redundant. Also add new condition options

**Derek:**
- Completed UI Screen for MarketActivity
- Research into Firestore implementation
<br>

**Agenda Item 2: Determine additional/general features and delegate** 
<br>
**Search-related features:**
- 1. Search functionality can handle partially valid and invalid search queries. (medium) - Gordon
- 2. Sort a list of products returned from a search based on price, popularity, rating, availability, etc.
(easy) - Gordon
- 3. Filter a list of products returned from a search based on their categories (e.g., kids, adults, kitchen,
bedroom, etc.) (easy) - Gordon

**User Interactivity**
- 1. The ability to micro-interact with items in your app (e.g. add to watchlist/add to cart/like an
item/report an item/add reviews (stars)) [stored in-memory]. (easy) - Derek & Rhonda

**Creating Processes**
- 5. Bidding process. Your app may allow users to post an item and set the selling method to 'bidding'.
After bidding starts, other users can bid on the item and users may be notified if their bid has been
beaten. The user (bidder) must be able to set the new price. (easy) - Rhonda
- Suggested Feature. New User Registration (easy) - Fame

**Peer to Peer Messaging**
- 1. Provide users with the ability to message each other directly. (hard) - Huiguang

**Firebase Integration**
- 1. Use Firebase to implement user Authentication/Authorisation. (easy) - Fame
<br>

**Agenda Item 4: Discuss work to complete for Week 10 checkpoint including report:**
- Almost fully complete Part 1 Basic App requirements for the App first and start implementation of additional features by next Thursday
- Start writing report for partially/fully implemented features by next Thursday- Rhonda will create and share word document in group chat
- Discussed deadline for Checkpoint 10 is Friday (Fame and Rhonda's Lab)

**Next meeting date and time: Saturday, 15th October 2022 at 3 pm**

## TODO Items
| Task | Assignee |
| :--- | ---: |
| Part 1 - Basic App Requirement 1 - Login Screen | Fame |
| Part 1 - Basic App Requirement 2 - Create Data Files | Derek, Huiguang and Rhonda |
| Part 1 - Basic App Requirement 3 - Load Data Files | Derek, Huiguang and Rhonda |
| Part 1 - Basic App Requirement 4 - Search Function | Gordon and Fame |
| Part 2 - Additional/General Feature 1 - Search-related Feature - Search functionality can handle partially valid and invalid search queries. (medium) | Gordon |
| Part 2 - Additional/General Feature 2 - Search-related Feature - Sort a list of products returned from a search based on price, popularity, rating, availability, etc. (easy) | Gordon |
| Part 2 - Additional/General Feature 3 - Search-related Feature - Filter a list of products returned from a search based on their categories (e.g., kids, adults, kitchen, bedroom, etc.) (easy) | Gordon |
| Part 2 - Additional/General Feature 4 - User Interactivity - The ability to micro-interact with items in your app (e.g. add to watchlist/add to cart/like an item/report an item/add reviews (stars)) [stored in-memory]. (easy) | Derek & Rhonda |
| Part 2 - Additional/General Feature 5 - Creating Processes - Your app may allow users to post an item and set the selling method to 'bidding'. After bidding starts, other users can bid on the item and users may be notified if their bid has been beaten. The user (bidder) must be able to set the new price. (easy) |  Rhonda |
| Part 2 - Additional/General Feature 6 - Creating Processes - New User Registration (easy) | Fame |
| Part 2 - Additional/General Feature 7 - Peer to Peer Messaging - Provide users with the ability to message each other directly. (hard) | Huiguang |
| Part 2 - Additional/General Feature 8 - Firebase Integration - Use Firebase to implement user Authentication/Authorisation. (easy) | Fame |
| Report | All team members |

## Scribe Rotation
The following dictates who will be scribe in this and the next meeting.
| Name |
| :---: |
| Rhonda - scribe for this meeting |
| Derek - scribe for next meeting 7 |
| Fame - scribe for meeting 8 | 
| Huiguang - scribe for meeting 9 | 
| Gordon - scribe for meeting 10 | 
