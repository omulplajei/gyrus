# gyrus
An attempt to create a system that handles messages, notifications, data for users. Much like a rotating ocean current.

# deployment

Heroku - configured to pull content from Github

https://dashboard.heroku.com/apps/gyrus-app/settings

# URLs

Applicatiom URL on Heroku
https://gyrus-app.herokuapp.com/actuator/health

Upload file endpoint
curl -v -F file=@ticket.txt http://localhost:8080/api/upload


# AWS S3 for storage

## General details
accesible from Heroku
Pricing: Standard - Infrequent access

AWS Free Tier - 1 year

Amazon Simple Storage Service (S3) is a “highly durable and available store” that is ideal for storing application content such as media files, static assets, and user uploads.

## File uploads
There are two approaches to processing and storing file uploads from a Heroku app to S3: direct and pass-through.

## AWS S3 details
The object key (or key name) uniquely identifies the object in an Amazon S3 bucket. Object metadata is a set of name-value pairs.
The Amazon S3 data model is a flat structure: You create a bucket, and the bucket store objects. There is no hierarchy of subbuckets or subfolders. However, you can infer logical hierarchy using key name prefixes and delimiters as the Amazon S3 console does.
The Amazon S3 console supports a concept of folders.

You can set object metadata in Amazon S3 at the time you upload the object. After you upload the object, you cannot modify object metadata. The only way to modify object metadata is to make a copy of the object and set the metadata.

You can have an unlimited number of objects in a bucket.

# Logging

## Log DNA

https://app.logdna.com/b4a7f08034/logs/view
