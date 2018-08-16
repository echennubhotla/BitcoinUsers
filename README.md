# Project 3
### Who to Trust?

Always view the [most updated version](https://github.com/usfcs245/Project3 "Project 3") if possible.

Make sure to look the the [DEADLINES](#requirements-and-deadline)

## Description
Here is the [reputation rating data](../master/soc-sign-bitcoinotc_notime.csv "Bitcoin file") from Bitcoin OTC. Each line represents one user (source) giving another user (target) a rating at a given time. The rating can go from -10 (absolutely not trustworthy) to 10 (absolutely trustworthy). Bitcoin address is anonymous, so a user may not wish to make a transaction with another user with bad reputation. Your software is going to help users find trustworthy users!

Preview of file:

```
6,2,4
6,5,2
1,15,1
4,3,7
13,16,8
13,10,8
7,5,1
2,21,5
```
> Note: In the first line; 6 is the source, 2 is the target, and 4 is the reputation.

## Requirements and Deadline
Project 3: Part 1|
-----------------|
**Due:** Monday, April 9th|
**Input:** The csv will be given through the command line. The user ID and minimum acceptable rating will be user inputted|
**Output:** The list of users that are reachable from user ID with acceptable trust rating printed to the terminal|
**Algorithm:** (This is a suggestion. If you have a different idea, please run it by the instructor before implementing it.) <br><br> The reputation rating data is a directed graph with annotated edges. Each user is a node, and each edge is an edge from one user to another with the rating info as annotation. For a given user id, your software will need to find what other nodes are reachable from this node, only using edges with ratings greater than or equal to the minimum acceptable rating.|

Project 3: Part 2|
-----------------|
**Due:** Monday, April 16th|
**Input:** The csv will be given through the command line. The source id and target id will be user inputted|
**Output:** The target's average reputation printed to the terminal|
**Algorithm:** (This is a suggestion. If you have a different idea, please run it by the instructor before implementing it.) <br><br> The longer path from source node to target node is, the less trust the source node puts on the ratings on the edges. Imagine your friend's friend's friend's friend's impression on a stranger. Surely it counts less than your friend's. The reputation of the target node is now computed as the sum of all the ratings on the path divided by the length of the path.<br><br> Your software will find all the paths from source node to target node, calculate the reputation of the target on each path, and return the average reputation.|

Make sure to submit your files to GitHub BEFORE the deadline.
