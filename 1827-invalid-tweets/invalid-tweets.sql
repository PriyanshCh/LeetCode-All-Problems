# Write your MySQL query statement below
SELECT tweet_id 
FROM Tweets
-- WHERE LENGTH(content)>15;
-- IN THE ABOVE LENGTH() returns the length of the string measured in bytes. 
-- CHAR_LENGTH() returns the length of the string measured in characters.
WHERE CHAR_LENGTH(content)>15;