# Coding Challenge for Software Engineer Applicants:
1. Create a REST service with a single endpoint that accepts a json message with two fields.."id" and "message". (example: { "id": "123", "message": "hello world" })

*what to do*
//count keys in json if more than 2 send error

// count words in sting to file


2. The endpoint should return a json document with a single field "count" that contains the total number of words contained in all the messages received to that point.
For example, if the first message contains 3 words it would responsd with count = 3. If the next message contains 5 words it would respond with count = 8.
*what to do*
// save to file both id and count in separate files


3. The service should ignore messages with duplicate ids. (i.e. ids that have already been processed)
*what to do*
//check id file to see if it has been run before



4. Use the programming language of your choice.

5. Upload all code to a public github repo with a readme that explains how to build and run the project